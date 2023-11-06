package com.csantamaria.appConMenu.colorMixer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.appmensajeria.R

class ColorMixerActivity : AppCompatActivity() {

    // Declaración de variables globales
    private lateinit var rvColors: RecyclerView
    private lateinit var btnChangeColor: Button

    private lateinit var colorAdapter: ColorAdapter

    // Parámetros: ID del CardView, Color y Alpha (transparencia)
    private val coloredBars listOf(
        Color("V1", "White", 20),
        Color("V2", "Red", 35),
        Color("V3", "Orange", 50),
        Color("V4", "Yellow", 65),
        Color("V5", "Green", 80)
    )

    // Método que se ejecuta al lanzar la aplicación
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_color_mixer)

        initComponents()
        initUI()
        initListeners()
    }

    // Inicialización de los componentes de la aplicación
    private fun initComponents() {
        rvColors = findViewById<RecyclerView>(R.id.rvVertical)
        btnChangeColor = findViewById<Button>(R.id.btnChangeColor)
    }

    // Inicialización de la interfaz de usuario
    private fun initUI() {
        colorAdapter = ColorAdapter(coloredBars) { position -> onColorSelected(position)}

        rvColors.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        rvColors.adapter = colorAdapter
    }

    // Inicialización de los métodos de detección de eventos
    private fun initListeners() {
        btnChangeColor.setOnClickListener { showDialog() }
    }

    private fun showDialog() {
        TODO("Pendiente de implementar")
    }

    private fun updateColors() {
        TODO("Pendiente de implementar")
    }


}