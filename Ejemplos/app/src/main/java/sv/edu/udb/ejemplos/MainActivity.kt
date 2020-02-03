package sv.edu.udb.ejemplos

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.EditText
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var usuario: EditText
    private lateinit var contrasena: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        usuario = findViewById(R.id.editUsuario)
        contrasena = findViewById(R.id.editContraseña)

        process()
    }

    private fun process() {

        ingresarButton.setOnClickListener {
            val y = usuario.text.toString().trim()
            val x = contrasena.text.toString().trim()
            if (y.isEmpty()) {
                usuario.error = "El usuario es requerida"
                if (x.isEmpty()) {
                    contrasena.error = "La contraseña es requerida"
                }
            }else{
                val intent = Intent(this@MainActivity, Dashboard::class.java)
                Toast.makeText(this,"Espere unos segundos", Toast.LENGTH_SHORT).show()
                intent.putExtra("Usuario", y)
                startActivity(intent)
            }

        }



    }
}
