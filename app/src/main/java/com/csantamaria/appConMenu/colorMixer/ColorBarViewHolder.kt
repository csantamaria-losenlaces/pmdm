package com.csantamaria.appConMenu.colorMixer

import android.graphics.Color
import android.util.Log
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
                //cvContainer.setBackgroundColor(Color.parseColor("#" + colorBar.alpha + Integer.toHexString(colorBar.color)))
                cvContainer.setBackgroundColor(Color.parseColor(String.format("#%02X%06X", colorBar.alpha, colorBar.color)))
                tvBarName.text = "V1 " + "(" + colorBar.alpha + "%)"
            }
            "V2" -> {
                val v2Color: String = "#" + Integer.toHexString(colorBar.alpha) + colorBar.color
                cvContainer.setBackgroundColor(Color.parseColor(v2Color))
                tvBarName.text = "V2 " + "(" + colorBar.alpha + "%)"
            }
            "V3" -> {
                val v3Color: String = "#" + Integer.toHexString(colorBar.alpha) + colorBar.color
                cvContainer.setBackgroundColor(Color.parseColor(v3Color))
                tvBarName.text = "V3 " + "(" + colorBar.alpha + "%)"
            }
            "V4" -> {
                val v4Color: String = "#" + Integer.toHexString(colorBar.alpha) + colorBar.color
                cvContainer.setBackgroundColor(Color.parseColor(v4Color))
                tvBarName.text = "V4 " + "(" + colorBar.alpha + "%)"
            }
            "V5" -> {
                val v5Color: String = "#" + Integer.toHexString(colorBar.alpha) + colorBar.color
                cvContainer.setBackgroundColor(Color.parseColor(v5Color))
                tvBarName.text = "V5 " + "(" + colorBar.alpha + "%)"
            }
        }

    }

}
