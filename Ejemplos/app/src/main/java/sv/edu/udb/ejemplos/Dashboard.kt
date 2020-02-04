package sv.edu.udb.ejemplos

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Typeface
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_dashboard.*
import sv.edu.udb.ejemplos.database.Pet

class Dashboard : AppCompatActivity() {


    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager

    @SuppressLint("DefaultLocale")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        MainActivity.getConnexion(this)

        val mutableList: MutableList<Pet> = MainActivity.getConnexion(this).petDAO().getAllPets()
        viewManager = LinearLayoutManager(this)
        viewAdapter = MyAdapter(mutableList, this)

        recycler.apply {
            setHasFixedSize(true)
            viewAdapter = MyAdapter(mutableList, this@Dashboard)
            layoutManager = viewManager
            adapter = viewAdapter
            viewAdapter.notifyDataSetChanged()
        }

        val extras = intent!!.extras
        if (!extras!!.isEmpty) {
            val typeface = Typeface.createFromAsset(assets, "admin_font.ttf")
            text_username.typeface = typeface
            text_username.text = extras.getString("Usuario", "Usuario Invitado").capitalize()
        }

        create.setOnClickListener { startActivity(Intent(this, FormActivity::class.java)) }
    }


    override fun onResume() {
        super.onResume()
        val mutableList: MutableList<Pet> = MainActivity.getConnexion(this).petDAO().getAllPets()
        viewManager = LinearLayoutManager(this)
        viewAdapter = MyAdapter(mutableList, this)

        recycler.apply {
            setHasFixedSize(true)
            layoutManager = viewManager
            adapter = viewAdapter
        }
    }
}
