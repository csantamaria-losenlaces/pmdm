package com.csantamaria.appConMenu.colorMixer

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.appmensajeria.R

class ColorMixerActivity : AppCompatActivity() {

    // Declaración de variables globales
    private lateinit var rvColors: RecyclerView
    private lateinit var btnChangeColor: Button

    private lateinit var colorAdapter: ColorAdapter

    private lateinit var coloredBars: List<ColorBar>

    // Método que se ejecuta al lanzar la aplicación
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_color_mixer)

        // Parámetros: ID del CardView, Color y Alpha (transparencia)
        coloredBars = listOf(
            //ColorBar("V1", Integer.toHexString(ContextCompat.getColor(this, R.color.cm_red)), 20),
            ColorBar("V1", ContextCompat.getColor(this, R.color.cm_red), 20)
            /*ColorBar("V2", "5E35B1", 35),
            ColorBar("V3", "D81B21", 50),
            ColorBar("V4", "FDD835", 65),
            ColorBar("V5", "00897B", 80)*/
        )

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
        colorAdapter = ColorAdapter(coloredBars)
        rvColors.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
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