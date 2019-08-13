package io.github.keep2iron.peach.creator

import android.graphics.drawable.Drawable
import android.graphics.drawable.StateListDrawable
import android.util.StateSet
import io.github.keep2iron.peach.core.BuildCreator

class StateListAbstractCreator() : BuildCreator<StateListDrawable> {

  private var pressed: Drawable? = null
  private var disabled: Drawable? = null
  private var selected: Drawable? = null
  private var normal: Drawable? = null

  fun pressed(pressed: Drawable?) = apply { this.pressed = pressed }
  fun disabled(disabled: Drawable?) = apply { this.disabled = disabled }
  fun selected(selected: Drawable?) = apply { this.selected = selected }
  fun normal(normal: Drawable) = apply { this.normal = normal }

  override fun build(): StateListDrawable {
    val stateListDrawable = StateListDrawable()
    setupStateListDrawable(stateListDrawable)
    return stateListDrawable
  }

  inline fun build(block: StateListAbstractCreator.() -> Unit) {
    block()
    build()
  }

  private fun setupStateListDrawable(stateListDrawable: StateListDrawable) {
    pressed?.let {
      stateListDrawable.addState(intArrayOf(android.R.attr.state_pressed), it)
    }
    disabled?.let {
      stateListDrawable.addState(intArrayOf(-android.R.attr.state_enabled), it)
    }
    selected?.let {
      stateListDrawable.addState(intArrayOf(android.R.attr.state_selected), it)
    }
    stateListDrawable.addState(StateSet.WILD_CARD, normal)
  }

}