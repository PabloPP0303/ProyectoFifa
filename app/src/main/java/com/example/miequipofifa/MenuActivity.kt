package com.example.miequipofifa

import android.os.Bundle
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import com.google.android.material.button.MaterialButton
import kotlin.jvm.java

class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        val cardLaLiga = findViewById<CardView>(R.id.cardLaLiga)
        val cardPremier = findViewById<CardView>(R.id.cardPremier)
        val btnMiEquipo = findViewById<MaterialButton>(R.id.btnMiEquipo)

        cardLaLiga.setOnClickListener {
            val intent = Intent(this, ListaJugadoresActivity::class.java)
            intent.putExtra("liga", "LaLiga")
            startActivity(intent)
        }

        cardPremier.setOnClickListener {
            val intent = Intent(this, ListaJugadoresActivity::class.java)
            intent.putExtra("liga", "Premier League")
            startActivity(intent)
        }

        btnMiEquipo.setOnClickListener {
            val intent = Intent(this, MiEquipoActivity::class.java)
            startActivity(intent)
        }
    }
}