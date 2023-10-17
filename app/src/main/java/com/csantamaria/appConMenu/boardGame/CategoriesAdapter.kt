package com.csantamaria.appConMenu.boardGame

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.appmensajeria.R

class CategoriesAdapter (private val categories: List<GameCategory>) :
    RecyclerView.Adapter<CategoriesViewHolder>() {

    override fun onCreateViewHolder (parent: ViewGroup, viewType: Int): CategoriesViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_game_category, parent, false)
        return CategoriesViewHolder(view)
    }

    override fun getItemCount(): Int {
        return categories.size
    // Es posible simplificar este método poniendo:
    // override fun getItemCount() =  categories.size
    }

    override fun onBindViewHolder (holder: CategoriesViewHolder, position: Int) {
        holder.render(categories[position])
    }

}