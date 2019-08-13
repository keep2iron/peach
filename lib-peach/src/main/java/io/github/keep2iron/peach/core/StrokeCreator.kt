package io.github.keep2iron.peach.core

import android.content.res.ColorStateList
import io.github.keep2iron.peach.DrawableCreator

interface StrokeCreator {
  fun strokeWidth(strokeWidth: Int): DrawableCreator
  fun strokeColor(strokeColor: Int): DrawableCreator
  fun strokeColorPressed(color: Int): DrawableCreator
  fun strokeColorDisabled(color: Int): DrawableCreator
  fun strokeColorSelected(color: Int): DrawableCreator
  fun strokeColorStateList(colorStateList: ColorStateList): DrawableCreator
  fun dashWidth(dashWidth: Int): DrawableCreator
  fun dashGap(dashGap: Int): DrawableCreator
  fun hairlineBordered(): DrawableCreator
  fun shortDashed(): DrawableCreator
  fun mediumDashed(): DrawableCreator
  fun longDashed(): DrawableCreator
  fun dashed(): DrawableCreator
  fun complete(): AbstractCreator
}