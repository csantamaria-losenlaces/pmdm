package com.csantamaria.appConMenu

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.csantamaria.appConMenu.boardGame.BoardGameActivity
import com.csantamaria.appConMenu.colorMixer.ColorMixerActivity
import com.csantamaria.appConMenu.helloApp.EscribirTexto
import com.csantamaria.appConMenu.imcApp.ImcCalculator
import com.csantamaria.appConMenu.messageApp.EnviarMensaje
import com.csantamaria.appConMenu.settings.SettingsActivity
import com.csantamaria.appConMenu.superhero.SuperheroListActivity
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

        val btnBoardGame = findViewById<Button>(R.id.btnBoardGame)
        btnBoardGame.setOnClickListener { (navigateToBoardGame()) }

        val btnColorMixer = findViewById<Button>(R.id.btnColorMixer)
        btnColorMixer.setOnClickListener { (navigateToColorMixer()) }

        val btnSuperhero = findViewById<Button>(R.id.btnSuperhero)
        btnSuperhero.setOnClickListener { (navigateToSuperhero()) }

        val btnSettings = findViewById<Button>(R.id.btnSettings)
        btnSettings.setOnClickListener { (navigateToSettings()) }

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

    private fun navigateToBoardGame() {
        val intent = Intent(this, BoardGameActivity::class.java)
        startActivity(intent)
    }

    private fun navigateToColorMixer() {
        val intent = Intent(this, ColorMixerActivity::class.java)
        startActivity(intent)
    }

    private fun navigateToSuperhero() {
        val intent = Intent(this, SuperheroListActivity::class.java)
        startActivity(intent)
    }

    private fun navigateToSettings() {
        val intent = Intent(this, SettingsActivity::class.java)
        startActivity(intent)
    }

}