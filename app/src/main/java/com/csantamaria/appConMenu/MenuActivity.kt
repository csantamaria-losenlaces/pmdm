package com.csantamaria.appConMenu

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.csantamaria.appConMenu.helloApp.EscribirTexto
import com.csantamaria.appConMenu.imcApp.ImcCalculator
import com.csantamaria.appConMenu.messageApp.EnviarMensaje
import com.example.appmensajeria.R

class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        val btnHelloApp = findViewById<Button>(R.id.btnHelloApp)
        btnHelloApp.setOnClickListener { navigateToHelloApp() }

        val btnMensajeria = findViewById<Button>(R.id.btnMensajeria)
        btnMensajeria.setOnClickListener { navigateToMensajeria() }

        val btnImcCalculator = findViewById<Button>(R.id.btnImc)
        btnImcCalculator.setOnClickListener { (navigateToImcCalculator()) }
    }

    private fun navigateToHelloApp() {
        val intent = Intent(this, EscribirTexto::class.java)
        startActivity(intent)
    }

    private fun navigateToMensajeria() {
        val intent = Intent(this, EnviarMensaje::class.java)
        startActivity(intent)
    }

    private fun navigateToImcCalculator() {
        val intent = Intent(this, ImcCalculator::class.java)
        startActivity(intent)
    }
}