package com.csantamaria.appConMenu.helloApp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.example.appmensajeria.R

class EscribirTexto : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.escribir_texto)

        val btnSend = findViewById<Button>(R.id.btnSend)
        val userText = findViewById<EditText>(R.id.etName)

        btnSend.setOnClickListener {
            val name = userText.text.toString()
            if (name.isNotEmpty()) {
                val textIntent = Intent(this, MostrarTexto::class.java)
                textIntent.putExtra("extra_name", name)
                startActivity(textIntent)
            }
        }
    }
}