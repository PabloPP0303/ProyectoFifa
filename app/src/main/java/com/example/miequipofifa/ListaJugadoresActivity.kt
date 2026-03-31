package com.example.miequipofifa

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ListaJugadoresActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_jugadores)

        val liga = intent.getStringExtra("liga") ?: "Liga"

        val tituloLiga = findViewById<TextView>(R.id.nombreLiga)
        tituloLiga.text = "Jugadores de $liga"
    }
}