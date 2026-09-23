package com.example.endevinaelnumero

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

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
        val texto = findViewById<TextView>(R.id.textView)
        val num_intentos = findViewById<TextView>(R.id.textView2)

        b.setOnClickListener {

            val num_introducido = campo.text.toString().toInt()

            num_intentos.setText("Numero de intentos: " + intentos.toString())

            intentos++

            if (num_introducido == num_random) {

                texto.setText("Has introducido el numero correcto")

            } else if (num_introducido > num_random) {

                texto.setText("Incorrecto, introduce un numero mas pequeno")

            } else {

                texto.setText("Incorrecto, introduce un numero mas grande")
            }
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->

            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())

            v.setPadding(
                systemBars.left,
                systemBars.top,
                systemBars.right,
                systemBars.bottom
            )

            insets
        }
    }
}