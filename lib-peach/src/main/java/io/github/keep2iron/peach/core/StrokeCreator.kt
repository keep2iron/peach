package io.github.keep2iron.peach.core

import android.content.res.ColorStateList
import io.github.keep2iron.peach.Peach

interface StrokeCreator {
  fun strokeWidth(strokeWidth: Int): Peach
  fun strokeColor(strokeColor: Int): Peach
  fun strokeColorPressed(color: Int): Peach
  fun strokeColorDisabled(color: Int): Peach
  fun strokeColorSelected(color: Int): Peach
  fun strokeColorStateList(colorStateList: ColorStateList): Peach
  fun dashWidth(dashWidth: Int): Peach
  fun dashGap(dashGap: Int): Peach
  fun hairlineBordered(): Peach
  fun shortDashed(): Peach
  fun mediumDashed(): Peach
  fun longDashed(): Peach
  fun dashed(): Peach
  fun complete(): AbstractCreator
}