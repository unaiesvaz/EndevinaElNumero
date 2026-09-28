package com.example.endevinaelnumero

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import kotlin.reflect.KProperty

class MainActivity : AppCompatActivity() {

    var num_random = (1..100).random()
    var puntuacion = 0
    var intentos = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val b = findViewById<Button>(R.id.button)
        val campo = findViewById<EditText>(R.id.campoNum)
        val texto_scroll = findViewById<TextView>(R.id.textView)
        val num_intentos = findViewById<TextView>(R.id.textView2)

        val text_toast_mayor: CharSequence = "El numero es mas grande"
        val text_toast_menor: CharSequence = "El numero es menor"
        val text_toast_correcto: CharSequence = "El numero es correcto"
        val duration = Toast.LENGTH_SHORT

        val campoUsuario = EditText(this)

        num_intentos.setText("Numero de intentos: " + intentos.toString() + "Num" + num_random)
        texto_scroll.setText("");


        b.setOnClickListener {

            val num_introducido = campo.text.toString().toInt()

            num_intentos.setText("Numero de intentos: " + intentos.toString())

            intentos++



            if (num_introducido == num_random) {

                texto_scroll.append("N Try: " + intentos + ". (" + num_introducido + ") Has introducido el numero correcto!\n")
                val toast = Toast.makeText(this, text_toast_correcto, duration)
                toast.show()
                // AL acertar, se hara una nueva partida, por lo tanto se creara un nuevo numero y se reiniciaran los intentos:
                num_random = (1..100).random()
                intentos = 0
                puntuacion = 100 - (intentos -1) * 5
                // Parte del alertDialog
                val builder: AlertDialog.Builder = AlertDialog.Builder(this)
                builder
                    .setMessage("Quieres aparecer en el ranking?")
                    .setTitle("Has acertado!")
                    .setView(campoUsuario)
                    .setPositiveButton("Aceptar") { dialog, which -> //Al aceptar, empezamos la nueva activity
                        // Parte de la nueva actividad
                        val intent = Intent(this, RankingActivity::class.java)

                        intent.putExtra("puntuacion", puntuacion)
                        intent.putExtra("username", campoUsuario.text.toString())

                        startActivity(intent) //Iniciamos la nueva activity Ranking
                    }
                    .setNegativeButton("Cancelar") { dialog, which ->
                        val intent = Intent(this, MainActivity::class.java)
                    }

                val dialog: AlertDialog = builder.create()
                dialog.show()






            } else if (num_introducido > num_random) {
                texto_scroll.append("N Try: " + intentos + ". (" + num_introducido + ") Incorrecto, introduce un numero mas pequeno\n")
                val toast = Toast.makeText(this, text_toast_menor, duration)
                toast.show()

            } else {

                texto_scroll.append("N Try: " + intentos + ". (" + num_introducido + ") Incorrecto, introduce un numero mas grande\n")
                val toast = Toast.makeText(this, text_toast_mayor, duration)
                toast.show()
            }
            campo.setText("") //Para que al introducir el numero se borre


        }

    }
    companion object {
        val ranking = mutableListOf<Jugador>() // Lista vacia de la clase jugador
    }
}

data class Jugador(
    val username: String,
    val puntuacion: Int
)
