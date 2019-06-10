package io.github.keep2iron.peach.core

interface CornerCreator {

    fun cornerRadius(cornerRadius: Int): CornerCreator
    fun topLeftRadius(topLeftRadius: Int): CornerCreator
    fun topRightRadius(topRightRadius: Int): CornerCreator
    fun bottomRightRadius(bottomRightRadius: Int): CornerCreator
    fun bottomLeftRadius(bottomLeftRadius: Int): CornerCreator
    fun rounded(): CornerCreator
    fun cornerRadii(topLeftRadius: Int, topRightRadius: Int, bottomRightRadius: Int, bottomLeftRadius: Int): CornerCreator
    fun setup(): AbstractCreator
}