package com.csantamaria.appConMenu.colorMixer

import android.app.Dialog
import android.os.Bundle
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

        horizontalBars[0].setCardBackgroundColor(ContextCompat.getColor(this, R.color.cm_blue_20))
        horizontalBars[1].setCardBackgroundColor(ContextCompat.getColor(this, R.color.cm_purple_50))
        horizontalBars[2].setCardBackgroundColor(ContextCompat.getColor(this, R.color.cm_black_80))

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
        when (selectedBar) {
            "H1 (20%)" -> when (selectedColor) {
                "Blanco" -> horizontalBars[0].setCardBackgroundColor(ContextCompat.getColor(this, R.color.cm_white_20))
                "Rojo" -> horizontalBars[0].setCardBackgroundColor(ContextCompat.getColor(this, R.color.cm_red_20))
                "Naranja" -> horizontalBars[0].setCardBackgroundColor(ContextCompat.getColor(this, R.color.cm_orange_20))
                "Amarillo" -> horizontalBars[0].setCardBackgroundColor(ContextCompat.getColor(this, R.color.cm_yellow_20))
                "Verde" -> horizontalBars[0].setCardBackgroundColor(ContextCompat.getColor(this, R.color.cm_green_20))
                "Cián" -> horizontalBars[0].setCardBackgroundColor(ContextCompat.getColor(this, R.color.cm_cyan_20))
                "Azul" -> horizontalBars[0].setCardBackgroundColor(ContextCompat.getColor(this, R.color.cm_blue_20))
                "Morado" -> horizontalBars[0].setCardBackgroundColor(ContextCompat.getColor(this, R.color.cm_purple_20))
                "Negro" -> horizontalBars[0].setCardBackgroundColor(ContextCompat.getColor(this, R.color.cm_black_20))
            }
            "H2 (50%)" -> when (selectedColor) {
                "Blanco" -> horizontalBars[1].setCardBackgroundColor(ContextCompat.getColor(this, R.color.cm_white_50))
                "Rojo" -> horizontalBars[1].setCardBackgroundColor(ContextCompat.getColor(this, R.color.cm_red_50))
                "Naranja" -> horizontalBars[1].setCardBackgroundColor(ContextCompat.getColor(this, R.color.cm_orange_50))
                "Amarillo" -> horizontalBars[1].setCardBackgroundColor(ContextCompat.getColor(this, R.color.cm_yellow_50))
                "Verde" -> horizontalBars[1].setCardBackgroundColor(ContextCompat.getColor(this, R.color.cm_green_50))
                "Cián" -> horizontalBars[1].setCardBackgroundColor(ContextCompat.getColor(this, R.color.cm_cyan_50))
                "Azul" -> horizontalBars[1].setCardBackgroundColor(ContextCompat.getColor(this, R.color.cm_blue_50))
                "Morado" -> horizontalBars[1].setCardBackgroundColor(ContextCompat.getColor(this, R.color.cm_purple_50))
                "Negro" -> horizontalBars[1].setCardBackgroundColor(ContextCompat.getColor(this, R.color.cm_black_50))
            }
            "H3 (80%)" -> when (selectedColor) {
                "Blanco" -> horizontalBars[2].setCardBackgroundColor(ContextCompat.getColor(this, R.color.cm_white_80))
                "Rojo" -> horizontalBars[2].setCardBackgroundColor(ContextCompat.getColor(this, R.color.cm_red_80))
                "Naranja" -> horizontalBars[2].setCardBackgroundColor(ContextCompat.getColor(this, R.color.cm_orange_80))
                "Amarillo" -> horizontalBars[2].setCardBackgroundColor(ContextCompat.getColor(this, R.color.cm_yellow_80))
                "Verde" -> horizontalBars[2].setCardBackgroundColor(ContextCompat.getColor(this, R.color.cm_green_80))
                "Cián" -> horizontalBars[2].setCardBackgroundColor(ContextCompat.getColor(this, R.color.cm_cyan_80))
                "Azul" -> horizontalBars[2].setCardBackgroundColor(ContextCompat.getColor(this, R.color.cm_blue_80))
                "Morado" -> horizontalBars[2].setCardBackgroundColor(ContextCompat.getColor(this, R.color.cm_purple_80))
                "Negro" -> horizontalBars[2].setCardBackgroundColor(ContextCompat.getColor(this, R.color.cm_black_80))
            }
            "V1 (20%)" -> when (selectedColor) {
                "Blanco" -> verticalBars[0].color = ContextCompat.getColor(this, R.color.cm_white_20)
                "Rojo" -> verticalBars[0].color = ContextCompat.getColor(this, R.color.cm_red_20)
                "Naranja" -> verticalBars[0].color = ContextCompat.getColor(this, R.color.cm_orange_20)
                "Amarillo" -> verticalBars[0].color = ContextCompat.getColor(this, R.color.cm_yellow_20)
                "Verde" -> verticalBars[0].color = ContextCompat.getColor(this, R.color.cm_green_20)
                "Cián" -> verticalBars[0].color = ContextCompat.getColor(this, R.color.cm_cyan_20)
                "Azul" -> verticalBars[0].color = ContextCompat.getColor(this, R.color.cm_blue_20)
                "Morado" -> verticalBars[0].color = ContextCompat.getColor(this, R.color.cm_purple_20)
                "Negro" -> verticalBars[0].color = ContextCompat.getColor(this, R.color.cm_black_20)
            }
            "V2 (35%)" -> when (selectedColor) {
                "Blanco" -> verticalBars[1].color = ContextCompat.getColor(this, R.color.cm_white_35)
                "Rojo" -> verticalBars[1].color = ContextCompat.getColor(this, R.color.cm_red_35)
                "Naranja" -> verticalBars[1].color = ContextCompat.getColor(this, R.color.cm_orange_35)
                "Amarillo" -> verticalBars[1].color = ContextCompat.getColor(this, R.color.cm_yellow_35)
                "Verde" -> verticalBars[1].color = ContextCompat.getColor(this, R.color.cm_green_35)
                "Cián" -> verticalBars[1].color = ContextCompat.getColor(this, R.color.cm_cyan_35)
                "Azul" -> verticalBars[1].color = ContextCompat.getColor(this, R.color.cm_blue_35)
                "Morado" -> verticalBars[1].color = ContextCompat.getColor(this, R.color.cm_purple_35)
                "Negro" -> verticalBars[1].color = ContextCompat.getColor(this, R.color.cm_black_35)
            }
            "V3 (50%)" -> when (selectedColor) {
                "Blanco" -> verticalBars[2].color = ContextCompat.getColor(this, R.color.cm_white_50)
                "Rojo" -> verticalBars[2].color = ContextCompat.getColor(this, R.color.cm_red_50)
                "Naranja" -> verticalBars[2].color = ContextCompat.getColor(this, R.color.cm_orange_50)
                "Amarillo" -> verticalBars[2].color = ContextCompat.getColor(this, R.color.cm_yellow_50)
                "Verde" -> verticalBars[2].color = ContextCompat.getColor(this, R.color.cm_green_50)
                "Cián" -> verticalBars[2].color = ContextCompat.getColor(this, R.color.cm_cyan_50)
                "Azul" -> verticalBars[2].color = ContextCompat.getColor(this, R.color.cm_blue_50)
                "Morado" -> verticalBars[2].color = ContextCompat.getColor(this, R.color.cm_purple_50)
                "Negro" -> verticalBars[2].color = ContextCompat.getColor(this, R.color.cm_black_50)
            }
            "V4 (65%)" -> when (selectedColor) {
                "Blanco" -> verticalBars[3].color = ContextCompat.getColor(this, R.color.cm_white_65)
                "Rojo" -> verticalBars[3].color = ContextCompat.getColor(this, R.color.cm_red_65)
                "Naranja" -> verticalBars[3].color = ContextCompat.getColor(this, R.color.cm_orange_65)
                "Amarillo" -> verticalBars[3].color = ContextCompat.getColor(this, R.color.cm_yellow_65)
                "Verde" -> verticalBars[3].color = ContextCompat.getColor(this, R.color.cm_green_65)
                "Cián" -> verticalBars[3].color = ContextCompat.getColor(this, R.color.cm_cyan_65)
                "Azul" -> verticalBars[3].color = ContextCompat.getColor(this, R.color.cm_blue_65)
                "Morado" -> verticalBars[3].color = ContextCompat.getColor(this, R.color.cm_purple_65)
                "Negro" -> verticalBars[3].color = ContextCompat.getColor(this, R.color.cm_black_65)
            }
            "V5 (80%)" -> when (selectedColor) {
                "Blanco" -> verticalBars[4].color = ContextCompat.getColor(this, R.color.cm_white_80)
                "Rojo" -> verticalBars[4].color = ContextCompat.getColor(this, R.color.cm_red_80)
                "Naranja" -> verticalBars[4].color = ContextCompat.getColor(this, R.color.cm_orange_80)
                "Amarillo" -> verticalBars[4].color = ContextCompat.getColor(this, R.color.cm_yellow_80)
                "Verde" -> verticalBars[4].color = ContextCompat.getColor(this, R.color.cm_green_80)
                "Cián" -> verticalBars[4].color = ContextCompat.getColor(this, R.color.cm_cyan_80)
                "Azul" -> verticalBars[4].color = ContextCompat.getColor(this, R.color.cm_blue_80)
                "Morado" -> verticalBars[4].color = ContextCompat.getColor(this, R.color.cm_purple_80)
                "Negro" -> verticalBars[4].color = ContextCompat.getColor(this, R.color.cm_black_80)
            }
        }
        rvColors.adapter?.notifyDataSetChanged()
    }

}