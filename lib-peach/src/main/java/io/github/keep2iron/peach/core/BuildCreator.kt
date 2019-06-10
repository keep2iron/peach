package io.github.keep2iron.peach.core

import android.graphics.drawable.Drawable

interface BuildCreator<T : Drawable> {

    fun build(): T

}