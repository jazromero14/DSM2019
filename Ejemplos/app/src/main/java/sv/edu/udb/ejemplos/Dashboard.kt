package sv.edu.udb.ejemplos

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.TextView

class Dashboard : AppCompatActivity() {

    private lateinit var usernameText: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        val extras = intent.extras
        if (!extras!!.isEmpty) {
            usernameText.text = extras.getString("Usuario", "Usuario Invitado")
        }
    }
}
