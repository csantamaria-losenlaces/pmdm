package com.csantamaria.appConMenu.helloApp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.appmensajeria.R

class MostrarTexto : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.mostrar_texto)

        val textoHola = findViewById<TextView>(R.id.helloText)

        val nombre: String = intent.extras?.getString("extra_name").orEmpty()

        textoHola.text = "Hola $nombre"
    }
}