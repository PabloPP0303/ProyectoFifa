package com.example.miequipofifa

import java.io.Serializable

data class Jugador(
    val id: Int,
    val nombre: String,
    val club: String,
    val liga: String,
    val posicion: String,
    val valoracion: Int,
    val ritmo: Int,
    val tiro: Int,
    val pase: Int,
    val regate: Int,
    val defensa: Int,
    val fisico: Int,
    val imagenRes: Int
) : Serializable
