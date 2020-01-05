package io.github.keep2iron.peach.core

import io.github.keep2iron.peach.Peach

interface RotateCreator {
  fun rotate(): Peach
  fun pivotX(pivotX: Float): Peach
  fun pivotY(pivotY: Float): Peach
  fun pivot(pivotX: Float, pivotY: Float): Peach
  fun fromDegrees(degrees: Float): Peach
  fun toDegrees(degrees: Float): Peach
  fun degrees(fromDegrees: Float, toDegrees: Float): Peach
  fun degrees(degrees: Float): Peach
  fun rotate(fromDegrees: Float, toDegrees: Float): Peach
  fun rotate(degrees: Float): Peach
  fun complete(): AbstractCreator
}