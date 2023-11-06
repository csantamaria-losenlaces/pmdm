package com.csantamaria.appConMenu.colorMixer

import android.graphics.Color

sealed class ColorsVerticalCV (var isSelected:Boolean = true) {
    object ColorCV1 : Color()
    object ColorCV2 : Color()
    object ColorCV3 : Color()
    object ColorCV4 : Color()
    object ColorCV5 : Color()
}