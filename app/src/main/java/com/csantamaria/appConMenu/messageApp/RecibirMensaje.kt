package com.csantamaria.appConMenu.messageApp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.appmensajeria.R

class RecibirMensaje : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_segunda_pantalla)

        val chat = findViewById<TextView>(R.id.tvMensajes)
        val nuevoMensaje: String = intent.extras?.getString("nuevo_mensaje").orEmpty()
        chat.text = nuevoMensaje

        val btnEnviar = findViewById<Button>(R.id.btnEnviar)
        val textoIntroducido = findViewById<EditText>(R.id.etMensaje)

        btnEnviar.setOnClickListener {
            val mensaje = textoIntroducido.text.toString()
            if (mensaje.isNotEmpty()) {
                val textIntent = Intent(
                    this,
                    EnviarMensaje::class.java
                ).addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
                textIntent.putExtra("nuevo_mensaje", mensaje)
                startActivity(textIntent)
            } else {
                Toast.makeText(
                    applicationContext,
                    "No se ha introducido ningún mensaje",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }
}