package com.csantamaria.appConMenu.colorMixer

import android.app.Dialog
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.appmensajeria.R


class ColorMixerActivity : AppCompatActivity() {

    // Declaración de variables globales
    private lateinit var rvColors: RecyclerView
    private lateinit var btnChangeColor: Button

    private lateinit var colorBarAdapter: ColorBarAdapter

    private lateinit var coloredBars: List<ColorBar>

    // Método que se ejecuta al lanzar la aplicación
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_color_mixer)

        // Parámetros: ID del CardView (String) y color (int)
        coloredBars = listOf(
            ColorBar("V1 (20%)", -871890688),
            ColorBar("V2 (35%)", -1509921024),
            ColorBar("V3 (50%)", -1131230976),
            ColorBar("V4 (65%)", -1509883935),
            ColorBar("V5 (80%)", -858717953)
        )

        initComponents()
        initUI()
        initListeners()
    }

    // Inicialización de los componentes de la aplicación
    private fun initComponents() {
        rvColors = findViewById(R.id.rvVertical)
        btnChangeColor = findViewById(R.id.btnChangeColor)
    }

    // Inicialización de la interfaz de usuario
    private fun initUI() {
        colorBarAdapter = ColorBarAdapter(coloredBars)
        rvColors.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        rvColors.adapter = colorBarAdapter
    }

    // Inicialización de los métodos de detección de eventos
    private fun initListeners() {
        btnChangeColor.setOnClickListener { showDialog() }
    }

    private fun showDialog() {
        val dialog = Dialog(this)
        dialog.setContentView(R.layout.dialog_color)

        val btnApplyColor: Button = dialog.findViewById(R.id.btnApplyColor)
        val rgBars: RadioGroup = dialog.findViewById(R.id.rgBars)
        val rgColors: RadioGroup = dialog.findViewById(R.id.rgColors)

        btnApplyColor.setOnClickListener {
            val rbSelectedBarId: Int = rgBars.checkedRadioButtonId
            val rbSelectedBar: RadioButton = rgBars.findViewById(rbSelectedBarId)
            val rbSelectedBarText: String = rbSelectedBar.text.toString()

            val rbSelectedColorId: Int = rgColors.checkedRadioButtonId
            val rbSelectedColor: RadioButton = rgColors.findViewById(rbSelectedColorId)
            val rbSelectedColorText: String = rbSelectedColor.text.toString()

            updateColors(rbSelectedBarText, rbSelectedColorText)
            dialog.hide()
        }

        dialog.show()
    }

    private fun updateColors(selectedBar: String, selectedColor: String) {
        Log.i("Solicitud cambio color", "Se quiere cambiar " + selectedBar + " a " + selectedColor)
    }

}