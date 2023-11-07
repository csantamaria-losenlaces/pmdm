package com.csantamaria.appConMenu.colorMixer

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.csantamaria.appConMenu.boardGame.CategoriesViewHolder
import com.example.appmensajeria.R

class ColorAdapter(private val coloredBars: List<ColorBar>) :
    RecyclerView.Adapter<ColorBarViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):
            ColorBarViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.vertical_bar, parent, false)
        return CategoriesViewHolder(view)
    }

    override fun onBindViewHolder(holder: ColorBarViewHolder, position: Int) {
        holder.render(coloredBars[position])
    }

    override fun getItemCount(): Int {
        return coloredBars.size
    }

}