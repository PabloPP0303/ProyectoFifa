package com.example.miequipofifa

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.button.MaterialButton

class MiEquipoAdapter(
    private var listaJugadores: MutableList<Jugador>,
    private val onEliminar: (Jugador) -> Unit
) : RecyclerView.Adapter<MiEquipoAdapter.MiEquipoViewHolder>() {

    inner class MiEquipoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgJugador: ImageView = itemView.findViewById(R.id.imgJugadorEquipo)
        val tvNombre: TextView = itemView.findViewById(R.id.nombreEquipo)
        val tvPosicion: TextView = itemView.findViewById(R.id.posicionEquipo)
        val tvValoracion: TextView = itemView.findViewById(R.id.valoracionEquipo)
        val btnEliminar: MaterialButton = itemView.findViewById(R.id.btnEliminar)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MiEquipoViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_mi_equipo, parent, false)
        return MiEquipoViewHolder(view)
    }

    override fun onBindViewHolder(holder: MiEquipoViewHolder, position: Int) {
        val jugador = listaJugadores[position]

        holder.tvNombre.text = jugador.nombre
        holder.tvPosicion.text = jugador.posicion
        holder.tvValoracion.text = jugador.valoracion.toString()
        holder.imgJugador.setImageResource(jugador.imagenRes)

        holder.btnEliminar.setOnClickListener {
            onEliminar(jugador)
        }
    }

    override fun getItemCount(): Int = listaJugadores.size

    // actualizar la lista cuando se filtra
    fun actualizarLista(nuevaLista: MutableList<Jugador>) {
        listaJugadores = nuevaLista
        notifyDataSetChanged()
    }
}