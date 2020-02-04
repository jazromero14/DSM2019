package sv.edu.udb.ejemplos

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.RadioButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_form.*
import sv.edu.udb.ejemplos.database.Pet

class FormActivity : AppCompatActivity() {

    private lateinit var raza: String
    private lateinit var genero: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form)

        MainActivity.getConnexion(this)
        dueno.text = MainActivity.getConnexion(this).sessionDAO().getSession(0).userName

        ArrayAdapter.createFromResource(
            this,
            R.array.breeds_array,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            razas.adapter = adapter
        }

        razas.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {
            }

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                raza = parent!!.getItemAtPosition(position).toString()
            }

        }



        agregar.setOnClickListener {
            val pet = Pet(
                0,
                mascota.text.toString().trim(),
                MainActivity.getConnexion(this).sessionDAO().getSession(0).userName,
                raza,
                addPetToDatabase(it),
                descripcion.text.toString().trim()
            )
            if (pet != null) {
                MainActivity.getConnexion(this)
                    .petDAO()
                    .insertPet(pet)

                finish()
            } else {
                Toast.makeText(this, "Data incorrecta", Toast.LENGTH_SHORT).show()
            }
        }
    }

    fun addPetToDatabase(view: View): String {

        if (view is RadioButton) {
            val checked = view.isChecked
            when (view.getId()) {
                R.id.genero_uno ->
                    if (checked) {
                        genero = "Masculino"
                    }
                R.id.genero_dos ->
                    if (checked) {
                        genero = "Femenino"

                    }
            }
        }
        return genero
    }

}
