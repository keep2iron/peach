package io.github.keep2iron.peach.core

import android.graphics.drawable.Drawable
import io.github.keep2iron.peach.Peach
import io.github.keep2iron.peach.DrawableProperties

interface AbstractCreator : BuildCreator<Drawable>, ShapeCreator, CornerCreator, GradientCreator,
  SizeCreator, SolidCreator, StrokeCreator, RotateCreator, ScaleCreator, FlipCreator,
  RippleCreator {
  fun batch(properties: DrawableProperties): Peach
  fun baseDrawable(drawable: Drawable): Peach
}