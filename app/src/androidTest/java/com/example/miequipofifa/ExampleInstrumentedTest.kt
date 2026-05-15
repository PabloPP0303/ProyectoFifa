package com.example.miequipofifa

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {

    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    // Test 1 - La MainActivity arranca y espera 2.5s antes de ir al menú
    @Test
    fun mainActivity_splash_navegaAlMenu() {
        Thread.sleep(3000)
        onView(withId(R.id.tituloMenu))
            .check(matches(isDisplayed()))
    }

    // Test 2 - El menú muestra las dos cards de liga
    @Test
    fun menuActivity_seMuestranLasCards() {
        Thread.sleep(3000)
        onView(withId(R.id.cardLaLiga))
            .check(matches(isDisplayed()))
        onView(withId(R.id.cardPremier))
            .check(matches(isDisplayed()))
    }

    // Test 3 - Al pulsar LaLiga navega a la lista de jugadores
    @Test
    fun menuActivity_pulsarLaLiga_navegaALista() {
        Thread.sleep(3000)
        onView(withId(R.id.cardLaLiga)).perform(click())
        onView(withId(R.id.recyclerJugadores))
            .check(matches(isDisplayed()))
    }

    // Test 4 - Al pulsar Premier navega a la lista de jugadores
    @Test
    fun menuActivity_pulsarPremier_navegaALista() {
        Thread.sleep(3000)
        onView(withId(R.id.cardPremier)).perform(click())
        onView(withId(R.id.recyclerJugadores))
            .check(matches(isDisplayed()))
    }

    // Test 5 - El botón Mi Equipo navega a MiEquipoActivity
    @Test
    fun menuActivity_pulsarMiEquipo_navegaAMiEquipo() {
        Thread.sleep(3000)
        onView(withId(R.id.btnMiEquipo)).perform(click())
        onView(withId(R.id.listaMiEquipo))
            .check(matches(isDisplayed()))
    }

    // Test 6 - El botón Comparar navega a CompararJugadoresActivity
    @Test
    fun menuActivity_pulsarComparar_navegaAComparar() {
        Thread.sleep(3000)
        onView(withId(R.id.btnComparar)).perform(click())
        onView(withId(R.id.spinner1))
            .check(matches(isDisplayed()))
    }

    // Test 7 - En la lista de jugadores el filtro DEF funciona

    @Test
    fun listaJugadores_filtroDEF_funciona() {
        Thread.sleep(3000)
        onView(withId(R.id.cardLaLiga)).perform(click())
        onView(withId(R.id.radioDEF)).perform(click())
        onView(withId(R.id.recyclerJugadores))
            .check(matches(isDisplayed()))
    }

    // Test 7.1 - En la lista de jugadores el filtro MC funciona


    @Test
    fun listaJugadores_filtroMC_funciona() {
        Thread.sleep(3000)
        onView(withId(R.id.cardLaLiga)).perform(click())
        onView(withId(R.id.radioMC)).perform(click())
        onView(withId(R.id.recyclerJugadores))
            .check(matches(isDisplayed()))
    }

    // Test 7.2 - En la lista de jugadores el filtro ATQ funciona

    @Test
    fun listaJugadores_filtroATQ_funciona() {
        Thread.sleep(3000)
        onView(withId(R.id.cardLaLiga)).perform(click())
        onView(withId(R.id.radioATQ)).perform(click())
        onView(withId(R.id.recyclerJugadores))
            .check(matches(isDisplayed()))
    }

    // Test 7.3 - En la lista de jugadores el filtro POR funciona

    @Test
    fun listaJugadores_filtroPOR_funciona() {
        Thread.sleep(3000)
        onView(withId(R.id.cardLaLiga)).perform(click())
        onView(withId(R.id.radioPOR)).perform(click())
        onView(withId(R.id.recyclerJugadores))
            .check(matches(isDisplayed()))
    }

    // Test 8 - En comparar jugadores el buscador funciona
    @Test
    fun compararJugadores_buscarJugador_funciona() {
        Thread.sleep(3000)
        onView(withId(R.id.btnComparar)).perform(click())
        onView(withId(R.id.editBuscar1))
            .perform(typeText("Raphinha"))
        onView(withId(R.id.spinner1))
            .check(matches(isDisplayed()))
    }
}