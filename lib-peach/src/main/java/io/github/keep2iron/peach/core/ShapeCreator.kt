package io.github.keep2iron.peach.core

interface ShapeCreator {

  fun shape(shape: Int): ShapeCreator

  fun rectangle(): ShapeCreator

  fun oval(): ShapeCreator

  fun line(): ShapeCreator
  fun ring(): ShapeCreator
  fun innerRadius(innerRadius: Int): ShapeCreator
  fun innerRadiusRatio(innerRadiusRatio: Float): ShapeCreator
  fun thickness(thickness: Int): ShapeCreator
  fun thicknessRatio(thicknessRatio: Float): ShapeCreator

  fun useLevelForRing(use: Boolean = true): ShapeCreator

  fun complete(): AbstractCreator

}