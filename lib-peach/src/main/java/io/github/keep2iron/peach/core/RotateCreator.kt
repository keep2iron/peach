package io.github.keep2iron.peach.core

import io.github.keep2iron.peach.DrawableCreator

interface RotateCreator {
    fun rotate(): DrawableCreator
    fun pivotX(pivotX: Float): DrawableCreator
    fun pivotY(pivotY: Float): DrawableCreator
    fun pivot(pivotX: Float, pivotY: Float): DrawableCreator
    fun fromDegrees(degrees: Float): DrawableCreator
    fun toDegrees(degrees: Float): DrawableCreator
    fun degrees(fromDegrees: Float, toDegrees: Float): DrawableCreator
    fun degrees(degrees: Float): DrawableCreator
    fun rotate(fromDegrees: Float, toDegrees: Float): DrawableCreator
    fun rotate(degrees: Float): DrawableCreator
    fun setup(): AbstractCreator
}