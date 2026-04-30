package com.example.miequipofifa

object AdministrarMiEquipo {
    enum class ResultadoAdd {
        OK,
        YA_EXISTE,
        LLENO
    }

    private val listaJugadores = mutableListOf<Jugador>()

    fun añadirJugador(jugador: Jugador): ResultadoAdd {
        return when {
            listaJugadores.size >= 11 -> ResultadoAdd.LLENO
            listaJugadores.any { it.id == jugador.id } -> ResultadoAdd.YA_EXISTE
            else -> {
                listaJugadores.add(jugador)
                ResultadoAdd.OK
            }
        }
    }

    fun eliminarJugador(jugador: Jugador) {
        listaJugadores.remove(jugador)
    }

    fun getJugadores(): List<Jugador> = listaJugadores.toList()

    fun getSize(): Int = listaJugadores.size
}