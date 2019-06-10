package io.github.keep2iron.peach.core

import android.content.res.ColorStateList
import io.github.keep2iron.peach.DrawableCreator

interface RippleCreator {

    fun ripple(boolean: Boolean = true): RippleCreator

    fun rippleColor(color: Int): DrawableCreator
    fun rippleColorStateList(colorStateList: ColorStateList): DrawableCreator
    fun rippleRadius(radius: Int): DrawableCreator
    fun setup(): AbstractCreator
}