package com.example.miequipofifa

import com.example.miequipofifa.R

object DataSource {
    fun getJugadoresPorLiga(liga: String): List<Jugador> {
        return getTodosLosJugadores().filter { it.liga == liga }
    }

    fun getTodosLosJugadores(): List<Jugador> {
        return listOf<Jugador>(
            Jugador(1, "Raphinha", "FC Barcelona", "LaLiga", "EI", 89, 91, 84, 85, 87, 53, 75, R.drawable.jg_raphinha),
            Jugador(2, "Lamine Yamal", "FC Barcelona", "LaLiga", "ED", 89, 85, 81, 86, 90, 23, 53, R.drawable.jg_lamine),
            Jugador(3, "Pedri", "FC Barcelona", "LaLiga", "MC", 89, 77, 73, 85, 91, 78, 77, R.drawable.jg_pedri),
            Jugador(4, "Lewandowski", "FC Barcelona", "LaLiga", "DC", 88, 74, 89, 79, 85, 44, 84, R.drawable.jg_lewan),
            Jugador(5, "Frenkie de Jong", "FC Barcelona", "LaLiga", "MC", 87, 82, 71, 85, 87, 78, 77, R.drawable.jg_dejong),
            Jugador(6, "Jules Koundé", "FC Barcelona", "LaLiga", "LD", 87, 84, 47, 74, 79, 86, 84, R.drawable.jg_kounde),
            Jugador(7, "Ter Stegen", "FC Barcelona", "LaLiga", "POR", 86, 84, 84, 89, 85, 47, 84, R.drawable.jg_terstegen),
            Jugador(8, "Dani Olmo", "FC Barcelona", "LaLiga", "MCO", 85, 73, 79, 83, 87, 50, 56, R.drawable.jg_olmo),
            Jugador(9, "Szczęsny", "FC Barcelona", "LaLiga", "POR", 84, 82, 83, 75, 84, 48, 84, R.drawable.jg_szczesny),
            Jugador(10, "João Cancelo", "FC Barcelona", "LaLiga", "LD", 84, 83, 73, 84, 84, 78, 74, R.drawable.jg_cancelo),
            Jugador(11, "Ronald Araujo", "FC Barcelona", "LaLiga", "DFC", 83, 80, 53, 63, 61, 81, 83, R.drawable.jg_araujo),
            Jugador(12, "Pau Cubarsí", "FC Barcelona", "LaLiga", "DFC", 82, 70, 42, 66, 77, 84, 76, R.drawable.jg_cubarsi),
            Jugador(13, "Alejandro Balde", "FC Barcelona", "LaLiga", "LI", 83, 91, 50, 75, 79, 78, 67, R.drawable.jg_balde),
            Jugador(14, "Kylian Mbappé", "Real Madrid", "LaLiga", "DC", 91, 97, 90, 81, 92, 37, 76, R.drawable.jg_mbappe),
            Jugador(15, "Jude Bellingham", "Real Madrid", "LaLiga", "MCO", 90, 80, 86, 83, 90, 78, 85, R.drawable.jg_jude),
            Jugador(16, "Thibaut Courtois", "Real Madrid", "LaLiga", "POR", 89, 85, 89, 76, 90, 46, 88, R.drawable.jg_tibhaut),
            Jugador(17, "Vinícius Jr.", "Real Madrid", "LaLiga", "EI", 89, 95, 84, 81, 91, 29, 69, R.drawable.jg_vini),
            Jugador(18, "Fede Valverde", "Real Madrid", "LaLiga", "MC", 89, 88, 84, 84, 84, 83, 85, R.drawable.jg_valverde),
            Jugador(19, "Antonio Rüdiger", "Real Madrid", "LaLiga", "DFC", 86, 79, 55, 72, 70, 84, 86, R.drawable.jg_rudiger),
            Jugador(20, "Alexander-Arnold", "Real Madrid", "LaLiga", "LD", 86, 76, 72, 89, 80, 80, 74, R.drawable.jg_arnold),
            Jugador(21, "Dani Carvajal", "Real Madrid", "LaLiga", "LD", 85, 80, 58, 79, 81, 81, 79, R.drawable.jg_carvajal),
            Jugador(22, "Rodrygo Goes", "Real Madrid", "LaLiga", "ED", 85, 88, 80, 79, 87, 31, 64, R.drawable.jg_rodrygo),
            Jugador(23, "Éder Militão", "Real Madrid", "LaLiga", "DFC", 84, 82, 50, 69, 71, 85, 82, R.drawable.jg_militao),
            Jugador(24, "Ferland Mendy", "Real Madrid", "LaLiga", "LI", 81, 85, 64, 74, 75, 78, 84, R.drawable.jg_mendy),
            Jugador(25, "Álvaro Carreras", "Real Madrid", "LaLiga", "LI", 80, 85, 65, 75, 79, 73, 80, R.drawable.jg_carreras),
            Jugador(26, "Rodri", "Manchester City", "Premier League", "MCD", 90, 65, 80, 86, 84, 86, 85, R.drawable.jg_rodri),
            Jugador(27, "Erling Haaland", "Manchester City", "Premier League", "DC", 90, 86, 91, 70, 80, 45, 88, R.drawable.jg_haaland),
            Jugador(28, "Donnarumma", "Manchester City", "Premier League", "POR", 89, 90, 83, 70, 90, 52, 87, R.drawable.jg_donnarumma),
            Jugador(29, "Rúben Dias", "Manchester City", "Premier League", "DFC", 86, 59, 39, 69, 69, 86, 84, R.drawable.jg_ruben),
            Jugador(30, "Tijjani Reijnders", "Manchester City", "Premier League", "MC", 86, 79, 79, 82, 85, 77, 77, R.drawable.jg_reijnders),
            Jugador(31, "Phil Foden", "Manchester City", "Premier League", "ED", 85, 81, 81, 82, 89, 57, 57, R.drawable.jg_foden),
            Jugador(32, "Ederson", "Manchester City", "Premier League", "POR", 85, 83, 82, 91, 83, 64, 83, R.drawable.jg_ederson),
            Jugador(33, "Bernardo Silva", "Manchester City", "Premier League", "MC", 84, 61, 78, 83, 89, 71, 65, R.drawable.jg_bernardo),
            Jugador(34, "Joško Gvardiol", "Manchester City", "Premier League", "LI", 84, 78, 71, 75, 78, 84, 82, R.drawable.jg_gvardiol),
            Jugador(35, "Bukayo Saka", "Arsenal", "Premier League", "ED", 88, 84, 82, 85, 88, 60, 73, R.drawable.jg_saka),
            Jugador(36, "Gabriel Magalhães", "Arsenal", "Premier League", "DFC", 88, 64, 44, 64, 65, 88, 84, R.drawable.jg_gabriel),
            Jugador(37, "Declan Rice", "Arsenal", "Premier League", "MCD", 87, 72, 73, 84, 80, 83, 83, R.drawable.jg_rice),
            Jugador(38, "William Saliba", "Arsenal", "Premier League", "DFC", 87, 77, 39, 68, 72, 87, 83, R.drawable.jg_saliba),
            Jugador(39, "Martin Ødegaard", "Arsenal", "Premier League", "MCO", 87, 68, 79, 88, 87, 67, 65, R.drawable.jg_odegar),
            Jugador(40, "Ben White", "Arsenal", "Premier League", "LD", 83, 70, 35, 75, 75, 83, 78, R.drawable.jg_ben),
            Jugador(41, "Leandro Trossard", "Arsenal", "Premier League", "EI", 83, 80, 81, 80, 85, 30, 60, R.drawable.jg_trossard),
            Jugador(42, "Eberechi Eze", "Arsenal", "Premier League", "MCO", 83, 74, 80, 81, 87, 50, 68, R.drawable.jg_eze)

        )
    }
}