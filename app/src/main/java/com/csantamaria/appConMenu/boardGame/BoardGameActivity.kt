package com.csantamaria.appConMenu.boardGame

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import com.csantamaria.appConMenu.boardGame.GameCategory.*
import com.example.appmensajeria.R

class BoardGameActivity : AppCompatActivity() {

    private lateinit var rvCategories: RecyclerView
    private lateinit var rvGames: RecyclerView

    private lateinit var categoriesAdapter: CategoriesAdapter
    // private lateinit var gamesAdapter: GamesAdapter

    private val categories = listOf(
        Cooperative,
        Deckbuilding,
        Euro,
        LCG,
        Legacy
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_board_game)

        initcomponents()
        initUI()
    }

    private fun initcomponents() {
        rvCategories = findViewById<RecyclerView>(R.id.rvCategories)
        rvGames = findViewById<RecyclerView>(R.id.rvGames)
    }

    private fun initUI() {
        categoriesAdapter = CategoriesAdapter(categories)
        // gamesAdapter = GamesAdapter(games)
    }

}