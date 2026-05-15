package com.example.miequipofifa

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class JugadorRelAdapter(
    private val lista: List<Jugador>
) : RecyclerView.Adapter<JugadorRelAdapter.SimilarViewHolder>() {

    inner class SimilarViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val img: ImageView = itemView.findViewById(R.id.jugadorRel)
        val tvNombre: TextView = itemView.findViewById(R.id.nombreRel)
        val tvPosicion: TextView = itemView.findViewById(R.id.posicionRel)
        val tvValoracion: TextView = itemView.findViewById(R.id.valoracionRel)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SimilarViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_jugador_relacionado, parent, false)
        return SimilarViewHolder(view)
    }

    override fun onBindViewHolder(holder: SimilarViewHolder, position: Int) {
        val jugador = lista[position]
        holder.img.setImageResource(jugador.imagenRes)
        holder.tvNombre.text = jugador.nombre
        holder.tvPosicion.text = jugador.posicion
        holder.tvValoracion.text = jugador.valoracion.toString()

        // Click navega al detalle del jugador similar
        holder.itemView.setOnClickListener {
            val intent = Intent(it.context, DetalleJugadorActivity::class.java)
            intent.putExtra("jugador", jugador)
            it.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int = lista.size
}