package com.example.miequipofifa

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.button.MaterialButton

class DetalleJugadorActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalle_jugador)

        val jugador = intent.getSerializableExtra("jugador") as? Jugador

        if (jugador == null) {
            finish()
            return
        }

        // datos que se veran en MiEquipo
        findViewById<ImageView>(R.id.imgDetalleJugador).setImageResource(jugador.imagenRes)
        findViewById<TextView>(R.id.detalleNombre).text = jugador.nombre
        findViewById<TextView>(R.id.detalleClub).text = "${jugador.club} · ${jugador.liga}"
        findViewById<TextView>(R.id.detallePosicion).text = jugador.posicion
        findViewById<TextView>(R.id.detalleValoracion).text = jugador.valoracion.toString()

        // estadisticas del jugador
        findViewById<TextView>(R.id.ritmo).text = jugador.ritmo.toString()
        findViewById<TextView>(R.id.tiro).text = jugador.tiro.toString()
        findViewById<TextView>(R.id.pase).text = jugador.pase.toString()
        findViewById<TextView>(R.id.regate).text = jugador.regate.toString()
        findViewById<TextView>(R.id.defensa).text = jugador.defensa.toString()
        findViewById<TextView>(R.id.fisico).text = jugador.fisico.toString()

        // boton añadir a MiEquipo
        findViewById<MaterialButton>(R.id.btnAnadirEquipo).setOnClickListener {
            when (AdministrarMiEquipo.añadirJugador(jugador)) {
                AdministrarMiEquipo.ResultadoAdd.OK ->
                    Toast.makeText(this, "${jugador.nombre} añadido al equipo", Toast.LENGTH_SHORT).show()
                AdministrarMiEquipo.ResultadoAdd.YA_EXISTE ->
                    Toast.makeText(this, "${jugador.nombre} ya está en tu equipo", Toast.LENGTH_SHORT).show()
                AdministrarMiEquipo.ResultadoAdd.LLENO ->
                    Toast.makeText(this, "Tu equipo ya tiene 11 jugadores", Toast.LENGTH_SHORT).show()
            }
        }

        val relacionados = DataSource.getTodosLosJugadores().filter {
            (it.posicion == jugador.posicion || it.club == jugador.club) && it.id != jugador.id
        }.sortedByDescending { it.posicion == jugador.posicion }

        val recyclerRelacionados = findViewById<RecyclerView>(R.id.recyclerRelacionados)
        recyclerRelacionados.layoutManager = LinearLayoutManager(
            this, LinearLayoutManager.HORIZONTAL, false
        )
        recyclerRelacionados.adapter = JugadorRelAdapter(relacionados)

    }
}