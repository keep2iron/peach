package io.github.keep2iron.peach.core

interface GradientCreator {
  fun gradient(): GradientCreator
  fun gradientType(type: Int): GradientCreator
  fun linearGradient(): GradientCreator
  fun radialGradient(): GradientCreator
  fun sweepGradient(): GradientCreator
  fun angle(angle: Int): GradientCreator
  fun centerX(centerX: Float): GradientCreator
  fun centerY(centerY: Float): GradientCreator
  fun center(centerX: Float, centerY: Float): GradientCreator
  fun startColor(startColor: Int): GradientCreator
  fun centerColor(centerColor: Int): GradientCreator
  fun endColor(endColor: Int): GradientCreator
  fun gradientColors(startColor: Int, endColor: Int, centerColor: Int?): GradientCreator
  fun gradientRadiusType(gradientRadiusType: Int): GradientCreator
  fun gradientRadius(gradientRadius: Float): GradientCreator
  fun gradientRadius(radius: Float, type: Int): GradientCreator
  fun gradientRadiusInPixel(radius: Float): GradientCreator
  fun gradientRadiusInFraction(radius: Float): GradientCreator
  fun useLevelForGradient(use: Boolean): GradientCreator
  fun useLevelForGradient(): GradientCreator
  fun complete(): AbstractCreator
}