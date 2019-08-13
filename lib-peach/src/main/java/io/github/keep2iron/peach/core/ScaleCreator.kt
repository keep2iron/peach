package io.github.keep2iron.peach.core

import io.github.keep2iron.peach.DrawableCreator

interface ScaleCreator {

  fun scale(): DrawableCreator
  fun scaleLevel(level: Int): DrawableCreator
  fun scaleGravity(gravity: Int): DrawableCreator
  fun scaleWidth(scale: Float): DrawableCreator
  fun scaleHeight(scale: Float): DrawableCreator
  fun scale(scale: Float): DrawableCreator
  fun scale(scaleWidth: Float, scaleHeight: Float): DrawableCreator
  fun complete(): AbstractCreator
}