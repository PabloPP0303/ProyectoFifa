package com.example.miequipofifa

import android.os.Bundle
import android.widget.RadioGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.miequipofifa.R

class ListaJugadoresActivity : AppCompatActivity() {

    private lateinit var adapter: JugadorAdapter
    private var listaCompleta: List<Jugador> = emptyList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_jugadores)

        val liga = intent.getStringExtra("liga") ?: "Liga"

        val tituloLiga = findViewById<TextView>(R.id.nombreLiga)
        tituloLiga.text = "Jugadores de $liga"


        listaCompleta = DataSource.getJugadoresPorLiga(liga)

        // Configurar RecyclerView
        val recycler = findViewById<RecyclerView>(R.id.recyclerJugadores)
        adapter = JugadorAdapter(listaCompleta)
        recycler.layoutManager = LinearLayoutManager(this)
        recycler.adapter = adapter

        // Filtros RadioButton
        val radioGroup = findViewById<RadioGroup>(R.id.radioGroupFiltros)
        radioGroup.setOnCheckedChangeListener { _, checkedId ->
            val listaFiltrada = when (checkedId) {
                R.id.radioPOR -> listaCompleta.filter { it.posicion == "POR" }
                R.id.radioDEF -> listaCompleta.filter {
                    it.posicion in listOf("DFC", "LD", "LI")
                }
                R.id.radioMC -> listaCompleta.filter {
                    it.posicion in listOf("MC", "MCO", "MCD")
                }
                R.id.radioATQ -> listaCompleta.filter {
                    it.posicion in listOf("DC", "EI", "ED")
                }
                else -> listaCompleta
            }
            adapter.actualizarLista(listaFiltrada)
        }
    }
}