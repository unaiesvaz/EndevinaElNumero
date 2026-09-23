package com.example.endevinaelnumero

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    val num_random = (1..100).random()
    val puntuacion = 0
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

        num_intentos.setText("Numero de intentos: " + intentos.toString())
        texto_scroll.setText("");


        b.setOnClickListener {

            val num_introducido = campo.text.toString().toInt()

            num_intentos.setText("Numero de intentos: " + intentos.toString())

            intentos++



            if (num_introducido == num_random) {

                texto_scroll.append("N Try: " + intentos + ". Has introducido el numero correcto\n")
                val toast = Toast.makeText(this, text_toast_correcto, duration)
                toast.show()


            } else if (num_introducido > num_random) {
                texto_scroll.append("N Try: " + intentos + ". Incorrecto, introduce un numero mas pequeno\n")
                val toast = Toast.makeText(this, text_toast_menor, duration)
                toast.show()

            } else {

                texto_scroll.append("N Try: " + intentos + ". Incorrecto, introduce un numero mas grande\n")
                val toast = Toast.makeText(this, text_toast_mayor, duration)
                toast.show()
            }

        }

    }
}