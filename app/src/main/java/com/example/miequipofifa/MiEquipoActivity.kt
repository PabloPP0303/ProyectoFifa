package com.example.miequipofifa

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
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
        findViewById<ImageButton>(R.id.btnCompartirEquipo).setOnClickListener {
            val jugadores = AdministrarMiEquipo.getJugadores()

            if (jugadores.isEmpty()) {
                Toast.makeText(this, "Tu equipo está vacío", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val sb = StringBuilder()
            sb.append("⚽ MI ONCE IDEAL ⚽\n\n")
            jugadores.forEachIndexed { index, jugador ->
                sb.append("${index + 1}. ${jugador.nombre} | ${jugador.posicion} | ${jugador.club} | ${jugador.valoracion}\n")
            }
            sb.append("\n📱 Creado con MiEquipoFIFA")

            val intent = Intent(Intent.ACTION_SEND)
            intent.type = "text/plain"
            intent.putExtra(Intent.EXTRA_TEXT, sb.toString())
            startActivity(Intent.createChooser(intent, "Compartir Mi Equipo"))
        }
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