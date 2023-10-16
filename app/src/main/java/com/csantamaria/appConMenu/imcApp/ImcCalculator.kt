package com.csantamaria.appConMenu.imcApp

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import com.example.appmensajeria.R
import com.google.android.material.slider.RangeSlider
import java.text.DecimalFormat
import java.text.DecimalFormatSymbols
import kotlin.math.pow

class ImcCalculator : AppCompatActivity() {

    private var isMaleSelected: Boolean = true
    private var isFemaleSelected: Boolean = false
    private var currentWeight: Int = 70
    private var currentAge: Int = 30
    private var currentHeight: Int = 120

    private lateinit var viewMale: CardView
    private lateinit var viewFemale: CardView

    private lateinit var tvHeight: TextView
    private lateinit var rsHeight: RangeSlider

    private lateinit var tvWeight: TextView
    private lateinit var btnSubtractWeight: Button
    private lateinit var btnAddWeight: Button

    private lateinit var tvAge: TextView
    private lateinit var btnSubtractAge: Button
    private lateinit var btnAddAge: Button

    private lateinit var btnCalculate: com.google.android.material.button.MaterialButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_imc_calculator)

        initComponents()
        initListeners()
        setWeight()
        setAge()
    }

    private fun initComponents() {
        viewMale = findViewById(R.id.viewMale)
        viewFemale = findViewById(R.id.viewFemale)

        tvHeight = findViewById(R.id.tvHeight)
        rsHeight = findViewById(R.id.rsHeight)

        tvWeight = findViewById(R.id.tvWeight)
        btnSubtractWeight = findViewById(R.id.subtractWeight)
        btnAddWeight = findViewById(R.id.addWeight)

        tvAge = findViewById(R.id.tvAge)
        btnSubtractAge = findViewById(R.id.subtractAge)
        btnAddAge = findViewById(R.id.addAge)

        btnCalculate = findViewById(R.id.btnCalcular)
    }

    private fun initListeners() {
        viewMale.setOnClickListener { setComponentColorMale() }
        viewFemale.setOnClickListener { setComponentColorFemale() }

        rsHeight.addOnChangeListener { _, value, _ ->
            val df = DecimalFormat("#")
            currentHeight = df.format(value).toInt()
            tvHeight.text = "$currentHeight cm"
        }

        btnSubtractWeight.setOnClickListener {
            if (currentWeight >= 1) currentWeight -= 1
            setWeight()
        }
        btnAddWeight.setOnClickListener {
            currentWeight += 1
            setWeight()
        }

        btnSubtractAge.setOnClickListener {
            if (currentAge >= 1) currentAge -= 1
            setAge()
        }
        btnAddAge.setOnClickListener {
            currentAge += 1
            setAge()
        }

        btnCalculate.setOnClickListener {
            val result = calculateIMC()
            Log.i("IMC", "El IMC es $result")
            navigateToResult(result)
        }

    }

    private fun setComponentColorMale() {
        if (!isMaleSelected) {
            viewMale.setCardBackgroundColor(getColor(R.color.background_component_selected))
            viewFemale.setCardBackgroundColor(getColor(R.color.background_component))
            isMaleSelected = true
            isFemaleSelected = false
        }
    }

    private fun setComponentColorFemale() {
        if (!isFemaleSelected) {
            viewFemale.setCardBackgroundColor(getColor(R.color.background_component_selected))
            viewMale.setCardBackgroundColor(getColor(R.color.background_component))
            isFemaleSelected = true
            isMaleSelected = false
        }
    }

    private fun setWeight() { tvWeight.text = currentWeight.toString() }

    private fun setAge() { tvAge.text = currentAge.toString() }

    private fun calculateIMC():Double {
        val dfs = DecimalFormatSymbols()
        dfs.decimalSeparator = '.'

        val df = DecimalFormat("#.##")
        df.decimalFormatSymbols = dfs
        val imc = currentWeight / (currentHeight.toDouble() / 100).pow(2.0)

        return df.format(imc).toDouble()
    }

    private fun navigateToResult(result: Double) {
        val imcIntent = Intent(this, ResultActivity::class.java)
        imcIntent.putExtra("extra_result", result)
        startActivity(imcIntent)
    }

}