package com.example.endevinaelnumero

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity


class RankingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_ranking)

        val b = findViewById<Button>(R.id.buttonNewGame)
        val textoRanking = findViewById<TextView>(R.id.textViewRanking)

        val puntuacionPlayer = intent.getIntExtra("puntuacion",0)
        val usernamePlayer = intent.getStringExtra("username")




        textoRanking.setText(usernamePlayer + "----" + puntuacionPlayer)

        b.setOnClickListener { //Al pulsar el boton, empezamos una nueva partida
            val intent = Intent(this, MainActivity::class.java)
        }





    }
}