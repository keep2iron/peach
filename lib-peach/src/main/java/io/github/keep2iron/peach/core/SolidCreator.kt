package io.github.keep2iron.peach.core

import android.content.res.ColorStateList

interface SolidCreator {
    fun solidColor(solidColor: Int): SolidCreator
    fun solidColorPressed(color: Int?): SolidCreator
    fun solidColorPressedWhenRippleUnsupported(color: Int?): SolidCreator
    fun solidColorDisabled(color: Int?): SolidCreator
    fun solidColorSelected(color: Int?): SolidCreator
    fun solidColorStateList(colorStateList: ColorStateList): SolidCreator
    fun setup(): AbstractCreator
}