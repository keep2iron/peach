package io.github.keep2iron.peach.creator

import android.graphics.drawable.Drawable
import io.github.keep2iron.peach.core.BuildCreator
import io.github.keep2iron.peach.drawable.FlipDrawable

class FlipAbstractCreator(val drawable: Drawable) : BuildCreator<FlipDrawable> {

  private var orientation: Int = FlipDrawable.ORIENTATION_HORIZONTAL

  fun orientation(orientation: Int) = apply { this.orientation = orientation }

  override fun build(): FlipDrawable {
    return FlipDrawable(this.drawable, orientation)
  }

  inline fun build(block: FlipAbstractCreator.() -> Unit) {
    block()
    build()
  }
}