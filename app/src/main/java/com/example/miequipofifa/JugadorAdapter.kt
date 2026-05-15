package com.example.miequipofifa

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class JugadorAdapter(
    private var listaJugadores: List<Jugador>
) : RecyclerView.Adapter<JugadorAdapter.JugadorViewHolder>() {

    //Guarda los datos de las vistas de cada tarjeta
    inner class JugadorViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgJugador: ImageView = itemView.findViewById(R.id.imgJugador)
        val tvNombre: TextView = itemView.findViewById(R.id.nombreJugador)
        val tvClub: TextView = itemView.findViewById(R.id.clubJugador)
        val tvPosicion: TextView = itemView.findViewById(R.id.posicionJugador)
        val tvValoracion: TextView = itemView.findViewById(R.id.valoracionJugador)
    }

    // Convierte el layout

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): JugadorViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_jugador, parent, false)
        return JugadorViewHolder(view)
    }

    //Rellena la tarjeta con los datos del jugador correspondiente

    override fun onBindViewHolder(holder: JugadorViewHolder, position: Int) {
        val jugador = listaJugadores[position]

        holder.tvNombre.text = jugador.nombre
        holder.tvClub.text = jugador.club
        holder.tvPosicion.text = jugador.posicion
        holder.tvValoracion.text = jugador.valoracion.toString()
        holder.imgJugador.setImageResource(jugador.imagenRes)

        // abrir el detalle del jugador
        holder.itemView.setOnClickListener {
            val intent = Intent(it.context, DetalleJugadorActivity::class.java)
            intent.putExtra("jugador", jugador)
            it.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int = listaJugadores.size

    // actualizar la lista cuando se filtra
    fun actualizarLista(nuevaLista: List<Jugador>) {
        listaJugadores = nuevaLista
        notifyDataSetChanged()
    }
}