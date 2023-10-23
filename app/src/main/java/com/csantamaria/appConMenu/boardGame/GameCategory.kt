package com.csantamaria.appConMenu.boardGame

sealed class GameCategory (var isSelected: Boolean = true) {

    data object Deckbuilding : GameCategory()
    data object Euro : GameCategory()
    data object LCG : GameCategory()
    data object Cooperative : GameCategory()
    data object Legacy : GameCategory()

}