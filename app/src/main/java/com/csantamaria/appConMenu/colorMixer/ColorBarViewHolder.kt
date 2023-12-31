package com.csantamaria.appConMenu.colorMixer

import android.view.View
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.appmensajeria.R

class ColorBarViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val tvBarName: TextView = view.findViewById(R.id.tvBarName)
    private val cvContainer: CardView = view.findViewById(R.id.cvContainer)

    fun render(colorBar: ColorBar) {

        tvBarName.text = colorBar.nombre
        cvContainer.setBackgroundColor(colorBar.color)

    }

}