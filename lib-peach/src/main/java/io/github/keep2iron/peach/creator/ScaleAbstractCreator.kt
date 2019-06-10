package io.github.keep2iron.peach.creator

import android.graphics.drawable.Drawable
import android.graphics.drawable.ScaleDrawable
import android.view.Gravity
import io.github.keep2iron.peach.core.BuildCreator

class ScaleAbstractCreator(val drawable: Drawable) : BuildCreator<ScaleDrawable> {

    private var level: Int = 10000
    private var scaleGravity = Gravity.CENTER
    private var scaleWidth: Float = 0f
    private var scaleHeight: Float = 0f

    fun level(level: Int) = apply { this.level = level }
    fun scaleGravity(gravity: Int) = apply { this.scaleGravity = gravity }
    fun scaleWidth(scale: Float) = apply { this.scaleWidth = scale }
    fun scaleHeight(scale: Float) = apply { this.scaleHeight = scale }

    override fun build(): ScaleDrawable {
        val scaleDrawable = ScaleDrawable(drawable, scaleGravity, scaleWidth, scaleHeight)
        scaleDrawable.level = level
        return scaleDrawable
    }

    inline fun build(block: ScaleAbstractCreator.() -> Unit) {
        block()
        build()
    }
}