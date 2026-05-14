package com.example.miequipofifa

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton

class CompararJugadoresActivity : AppCompatActivity() {

    private var listaCompleta = DataSource.getTodosLosJugadores()
    private var listaFiltrada1 = listaCompleta.toMutableList()
    private var listaFiltrada2 = listaCompleta.toMutableList()

    private lateinit var spinner1: Spinner
    private lateinit var spinner2: Spinner
    private lateinit var editBuscar1: EditText
    private lateinit var editBuscar2: EditText
    private lateinit var switchPremier: Switch
    private lateinit var switchLaLiga: Switch

    private var actualizando1 = false
    private var actualizando2 = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_comparar_jugadores)

        spinner1 = findViewById(R.id.spinner1)
        spinner2 = findViewById(R.id.spinner2)
        editBuscar1 = findViewById(R.id.editBuscar1)
        editBuscar2 = findViewById(R.id.editBuscar2)
        switchPremier = findViewById(R.id.switchLiga)
        switchLaLiga = findViewById(R.id.switchLiga1)

        actualizarSpinner(spinner1, listaFiltrada1)
        actualizarSpinner(spinner2, listaFiltrada2)

        // Switch Premier League
        switchPremier.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) switchLaLiga.isChecked = false
            aplicarFiltros()
        }

        // Switch LaLiga
        switchLaLiga.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) switchPremier.isChecked = false
            aplicarFiltros()
        }

        // Buscar jugador 1
        editBuscar1.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                if (actualizando1) return
                val texto = s.toString().lowercase()
                val filtrados = listaFiltrada1.filter {
                    it.nombre.lowercase().contains(texto)
                }
                actualizarSpinner(spinner1, filtrados)
            }
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
        })

        // Buscar jugador 2
        editBuscar2.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                if (actualizando2) return
                val texto = s.toString().lowercase()
                val filtrados = listaFiltrada2.filter {
                    it.nombre.lowercase().contains(texto)
                }
                actualizarSpinner(spinner2, filtrados)
            }
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
        })

        spinner1.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View?, position: Int, id: Long) {
                val jugador = parent.getItemAtPosition(position) as? Jugador
                jugador?.let {
                    actualizando1 = true
                    editBuscar1.setText(it.nombre)
                    actualizando1 = false
                }
            }
            override fun onNothingSelected(parent: AdapterView<*>) {}
        }

        spinner2.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View?, position: Int, id: Long) {
                val jugador = parent.getItemAtPosition(position) as? Jugador
                jugador?.let {
                    actualizando2 = true
                    editBuscar2.setText(it.nombre)
                    actualizando2 = false
                }
            }
            override fun onNothingSelected(parent: AdapterView<*>) {}
        }

        // Botón comparar
        findViewById<MaterialButton>(R.id.btnComparar).setOnClickListener {
            val jugador1 = spinner1.selectedItem as? Jugador
            val jugador2 = spinner2.selectedItem as? Jugador

            if (jugador1 == null || jugador2 == null) {
                Toast.makeText(this, "Selecciona dos jugadores", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (jugador1.id == jugador2.id) {
                Toast.makeText(this, "Selecciona dos jugadores distintos", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            mostrarResultado(jugador1, jugador2)
        }
    }

    private fun aplicarFiltros() {
        listaFiltrada1 = when {
            switchPremier.isChecked -> listaCompleta.filter { it.liga == "Premier League" }.toMutableList()
            switchLaLiga.isChecked -> listaCompleta.filter { it.liga == "LaLiga" }.toMutableList()
            else -> listaCompleta.toMutableList()
        }
        listaFiltrada2 = listaFiltrada1.toMutableList()
        actualizarSpinner(spinner1, listaFiltrada1)
        actualizarSpinner(spinner2, listaFiltrada2)
        editBuscar1.setText("")
        editBuscar2.setText("")
    }

    private fun actualizarSpinner(spinner: Spinner, lista: List<Jugador>) {
        val adapter = object : ArrayAdapter<Jugador>(this,
            android.R.layout.simple_spinner_item, lista) {
            override fun toString(): String = ""
            override fun getView(position: Int, convertView: View?, parent: android.view.ViewGroup): View {
                val view = super.getView(position, convertView, parent)
                (view as TextView).text = lista[position].nombre
                view.setTextColor(resources.getColor(R.color.verde_fondo, null))
                return view
            }
            override fun getDropDownView(position: Int, convertView: View?,
                                         parent: android.view.ViewGroup): View {
                val view = super.getDropDownView(position, convertView, parent)
                (view as TextView).text = lista[position].nombre
                view.setBackgroundColor(resources.getColor(R.color.verde_card, null))
                view.setTextColor(resources.getColor(R.color.dorado, null))
                return view
            }
        }
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = adapter
    }

    private fun mostrarResultado(j1: Jugador, j2: Jugador) {
        val card = findViewById<View>(R.id.cardResultado)
        card.visibility = View.VISIBLE

        findViewById<TextView>(R.id.tvNombre1).text = j1.nombre
        findViewById<TextView>(R.id.tvNombre2).text = j2.nombre

        // Estadísticas con color ganador
        setStats(R.id.tvRit1, R.id.tvRit2, j1.ritmo, j2.ritmo)
        setStats(R.id.tvTir1, R.id.tvTir2, j1.tiro, j2.tiro)
        setStats(R.id.tvPas1, R.id.tvPas2, j1.pase, j2.pase)
        setStats(R.id.tvReg1, R.id.tvReg2, j1.regate, j2.regate)
        setStats(R.id.tvDef1, R.id.tvDef2, j1.defensa, j2.defensa)
        setStats(R.id.tvFis1, R.id.tvFis2, j1.fisico, j2.fisico)

        // Ganador por valoración total
        val total1 = j1.ritmo + j1.tiro + j1.pase + j1.regate + j1.defensa + j1.fisico
        val total2 = j2.ritmo + j2.tiro + j2.pase + j2.regate + j2.defensa + j2.fisico

        val tvGanador = findViewById<TextView>(R.id.tvGanador)
        tvGanador.text = when {
            total1 > total2 -> "Ganador: ${j1.nombre}"
            total2 > total1 -> "Ganador: ${j2.nombre}"
            else -> "- Empate -"
        }
    }

    private fun setStats(id1: Int, id2: Int, val1: Int, val2: Int) {
        val tv1 = findViewById<TextView>(id1)
        val tv2 = findViewById<TextView>(id2)
        tv1.text = val1.toString()
        tv2.text = val2.toString()

        // El mayor en verde claro, el menor en rojo
        when {
            val1 > val2 -> {
                tv1.setTextColor(resources.getColor(R.color.verde_claro, null))
                tv2.setTextColor(resources.getColor(R.color.rojo, null))
            }
            val2 > val1 -> {
                tv1.setTextColor(resources.getColor(R.color.rojo, null))
                tv2.setTextColor(resources.getColor(R.color.verde_claro, null))
            }
            else -> {
                tv1.setTextColor(resources.getColor(R.color.dorado, null))
                tv2.setTextColor(resources.getColor(R.color.dorado, null))
            }
        }
    }
}