package io.github.keep2iron.peach.core

import android.content.res.ColorStateList
import io.github.keep2iron.peach.Peach

interface RippleCreator {

  fun ripple(boolean: Boolean = true): RippleCreator

  fun rippleColor(color: Int): Peach
  fun rippleColorStateList(colorStateList: ColorStateList): Peach
  fun rippleRadius(radius: Int): Peach
  fun complete(): AbstractCreator
}