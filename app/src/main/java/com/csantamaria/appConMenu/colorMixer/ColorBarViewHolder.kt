package com.csantamaria.appConMenu.colorMixer

import android.graphics.Color
import android.view.View
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.appmensajeria.R

class ColorBarViewHolder (view: View) : RecyclerView.ViewHolder(view) {

    private val cvContainer: CardView = view.findViewById(R.id.cvContainer)
    private val tvBarName: TextView = view.findViewById(R.id.tvBarName)

    fun render (colorBar: ColorBar) {

        when (colorBar.idCV) {
            "V1" -> {
                cvContainer.setBackgroundColor(colorBar.color)
                tvBarName.text = "V1 " + "(" + colorBar.alpha + "%)"
            }
            "V2" -> {
                cvContainer.setBackgroundColor(colorBar.color)
                tvBarName.text = "V2 " + "(" + colorBar.alpha + "%)"
            }
            "V3" -> {
                cvContainer.setBackgroundColor(colorBar.color)
                tvBarName.text = "V3 " + "(" + colorBar.alpha + "%)"
            }
            "V4" -> {
                cvContainer.setBackgroundColor(colorBar.color)
                tvBarName.text = "V4 " + "(" + colorBar.alpha + "%)"
            }
            "V5" -> {
                cvContainer.setBackgroundColor(colorBar.color)
                tvBarName.text = "V5 " + "(" + colorBar.alpha + "%)"
            }
        }

    }

}
