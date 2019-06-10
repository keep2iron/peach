package io.github.keep2iron.peach.core

import io.github.keep2iron.peach.DrawableCreator

interface FlipCreator {
    fun flip(boolean: Boolean = true):FlipCreator
    fun orientation(orientation: Int): FlipCreator
    fun flipVertical(): FlipCreator
    fun setup(): AbstractCreator
}