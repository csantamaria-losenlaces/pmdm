package com.csantamaria.appConMenu.colorMixer

import android.app.Dialog
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.appmensajeria.R


class ColorMixerActivity : AppCompatActivity() {

    // Declaración de variables globales
    private lateinit var rvColors: RecyclerView
    private lateinit var btnChangeColor: Button

    private lateinit var colorBarAdapter: ColorBarAdapter

    private lateinit var verticalBars: List<ColorBar>
    private lateinit var horizontalBars: List<CardView>

    // Método que se ejecuta al lanzar la aplicación
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_color_mixer)

        // Declaración del array de barras verticales
        verticalBars = listOf(
            ColorBar("V1 (20%)", ContextCompat.getColor(this, R.color.cm_red_20)),
            ColorBar("V2 (35%)", ContextCompat.getColor(this, R.color.cm_orange_35)),
            ColorBar("V3 (50%)", ContextCompat.getColor(this, R.color.cm_yellow_50)),
            ColorBar("V4 (65%)", ContextCompat.getColor(this, R.color.cm_green_65)),
            ColorBar("V5 (80%)", ContextCompat.getColor(this, R.color.cm_cyan_80))
        )

        // Declaración del array de barras horizontales
        horizontalBars = listOf(
            findViewById(R.id.cvH1),
            findViewById(R.id.cvH2),
            findViewById(R.id.cvH3)
        )

        horizontalBars[0].setBackgroundColor(ContextCompat.getColor(this, R.color.cm_blue_20))
        horizontalBars[1].setBackgroundColor(ContextCompat.getColor(this, R.color.cm_purple_50))
        horizontalBars[2].setBackgroundColor(ContextCompat.getColor(this, R.color.cm_black_80))

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
        colorBarAdapter = ColorBarAdapter(verticalBars)
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