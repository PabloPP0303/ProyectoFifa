package com.example.miequipofifa

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MiEquipoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mi_equipo)

        val rv = findViewById<RecyclerView>(R.id.listaMiEquipo)


        rv.layoutManager = GridLayoutManager(this, 2)


        actualizarContador(0)
    }

    private fun actualizarContador(size: Int) {
        val contadorJg = findViewById<TextView>(R.id.contadorJg)
        contadorJg.text = "Jugadores: $size/11"
    }
}