package com.example.miequipofifa

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MiEquipoActivity : AppCompatActivity() {

    private lateinit var adapter: MiEquipoAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mi_equipo)

        val rv = findViewById<RecyclerView>(R.id.listaMiEquipo)

        adapter = MiEquipoAdapter(AdministrarMiEquipo.getJugadores().toMutableList()) { jugador ->
            AdministrarMiEquipo.eliminarJugador(jugador)
            actualizarContador()
        }

        rv.layoutManager = GridLayoutManager(this, 2)
        rv.adapter = adapter


        actualizarContador()
    }

    override fun onResume() {
        super.onResume()
        actualizarContador()
    }

    private fun actualizarContador() {
        val contadorJg = findViewById<TextView>(R.id.contadorJg)
        contadorJg.text = "Jugadores: ${AdministrarMiEquipo.getSize()}/11"
        adapter.actualizarLista(AdministrarMiEquipo.getJugadores().toMutableList())
    }
}