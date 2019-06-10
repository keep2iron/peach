package io.github.keep2iron.peach.core

import io.github.keep2iron.peach.DrawableCreator

interface SizeCreator {
    fun width(width: Int): DrawableCreator
    fun height(height: Int): DrawableCreator
    fun size(width: Int, height: Int): DrawableCreator
    fun size(size: Int): DrawableCreator
    fun setup(): AbstractCreator
}