package io.github.keep2iron.peach.core

import io.github.keep2iron.peach.Peach

interface ScaleCreator {

  fun scale(): Peach
  fun scaleLevel(level: Int): Peach
  fun scaleGravity(gravity: Int): Peach
  fun scaleWidth(scale: Float): Peach
  fun scaleHeight(scale: Float): Peach
  fun scale(scale: Float): Peach
  fun scale(scaleWidth: Float, scaleHeight: Float): Peach
  fun complete(): AbstractCreator
}