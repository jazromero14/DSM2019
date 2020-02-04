package sv.edu.udb.ejemplos

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.room.Room
import kotlinx.android.synthetic.main.activity_main.*
import sv.edu.udb.ejemplos.database.AppDatabase
import sv.edu.udb.ejemplos.database.Session

@Suppress("SENSELESS_COMPARISON")
class MainActivity : AppCompatActivity() {

    private lateinit var usuario: EditText
    private lateinit var contrasena: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getConnexion(this)
        getConnexion(this).sessionDAO()
            .insertSession(Session(0, "Jazmín Romero", "123456"))

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
            } else {
                if (getConnexion(this).sessionDAO().getSession(0).userName == y && getConnexion(
                        this
                    ).sessionDAO().getSession(0).password == x
                ) {
                    val intent = Intent(this@MainActivity, Dashboard::class.java)
                    Toast.makeText(this, "Espere unos segundos", Toast.LENGTH_SHORT).show()
                    intent.putExtra("Usuario", y)
                    startActivity(intent)
                    finish()
                } else {
                    Toast.makeText(
                        this,
                        "Credenciales incorrectas, contacte a soporte",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }

        }


    }

    companion object {
        fun getConnexion(context: Context): AppDatabase {
            return Room.databaseBuilder(context, AppDatabase::class.java, "Exercises_db")
                .fallbackToDestructiveMigration().allowMainThreadQueries()
                .build()
        }
    }


}
