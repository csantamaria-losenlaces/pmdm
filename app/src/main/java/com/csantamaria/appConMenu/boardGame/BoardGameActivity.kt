package com.csantamaria.appConMenu.boardGame

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.csantamaria.appConMenu.boardGame.GameCategory.*
import com.example.appmensajeria.R
import com.google.android.material.floatingactionbutton.FloatingActionButton

class BoardGameActivity : AppCompatActivity() {

    private lateinit var rvCategories: RecyclerView
    private lateinit var rvGames: RecyclerView
    private lateinit var fabAddGame: FloatingActionButton

    private lateinit var categoriesAdapter: CategoriesAdapter
    private lateinit var gamesAdapter: GamesAdapter

    private val categories = listOf(
        Cooperative,
        Deckbuilding,
        Euro,
        LCG,
        Legacy
    )

    private var games = mutableListOf(
        Game("Frostpunk", Cooperative),
        Game("Hero Realm", Deckbuilding),
        Game("Agrícola", Euro),
        Game("Arkham Horror", LCG),
        Game("Gloomhaven", Legacy)
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_board_game)

        initComponents()
        initUI()
        initListeners()
    }

    private fun initComponents() {
        rvCategories = findViewById(R.id.rvCategories)
        rvGames = findViewById(R.id.rvGames)
        fabAddGame = findViewById(R.id.fabAddGame)
    }

    private fun initUI() {
        categoriesAdapter = CategoriesAdapter(categories) {position -> onCategorySelected(position)}
        gamesAdapter = GamesAdapter(games) {position -> onGameSelected(position)} // Le estamos pasando dos parámetros

        rvCategories.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        rvCategories.adapter = categoriesAdapter

        rvGames.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        rvGames.adapter = gamesAdapter
    }

    private fun initListeners() {
        fabAddGame.setOnClickListener { showDialog() }
    }

    private fun showDialog() {
        val dialog = Dialog(this)
        dialog.setContentView(R.layout.dialog_game)

        val btnAddGame: Button = dialog.findViewById(R.id.btnAddGame)
        val etGame: EditText = dialog.findViewById(R.id.etGame)
        val rgCategories: RadioGroup = dialog.findViewById(R.id.rgCategories)

        btnAddGame.setOnClickListener {
            val currentGame = etGame.text.toString()
            if (currentGame.isNotEmpty()) {
                val selectedId = rgCategories.checkedRadioButtonId
                val selectedRadioButton: RadioButton = rgCategories.findViewById(selectedId)
                val currentCategory: GameCategory = when (selectedRadioButton.text) {
                    getString(R.string.cooperatives) -> Cooperative
                    getString(R.string.deckbuilding) -> Deckbuilding
                    getString(R.string.eurogames) -> Euro
                    getString(R.string.living_card_games) -> LCG
                    else -> Legacy
                }
                games.add(Game(currentGame, currentCategory))
                updateGames()
                dialog.hide()
            }
        }

        dialog.show()
    }

    private fun updateGames() {
        val selectedCategories: List<GameCategory> = categories.filter { it.isSelected }
        val newGames = games.filter { selectedCategories.contains(it.category) }

        gamesAdapter.games = newGames
        gamesAdapter.notifyDataSetChanged()
    }

    private fun onGameSelected(position: Int) {
        games[position].isSelected = !games[position].isSelected
        updateGames()
    }

    private fun onCategorySelected(position: Int) {
        categories[position].isSelected = !categories[position].isSelected
        categoriesAdapter.notifyItemChanged(position)
        updateGames()
    }

}