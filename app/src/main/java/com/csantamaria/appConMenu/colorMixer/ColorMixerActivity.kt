package com.csantamaria.appConMenu.colorMixer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import com.example.appmensajeria.R

class ColorMixerActivity : AppCompatActivity() {

    private lateinit var rvVertical: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_color_mixer)

        initComponents()
        initUI()
    }

    private fun initComponents() {
        rvVertical = findViewById<RecyclerView>(R.id.rvVertical)
    }

    private fun initUI() {
        colorsAdapter = ColorsAdapter(colors)
    }

}