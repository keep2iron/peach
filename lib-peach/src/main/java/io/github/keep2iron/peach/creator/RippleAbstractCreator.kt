package io.github.keep2iron.peach.creator

import android.annotation.TargetApi
import android.content.res.ColorStateList
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.graphics.drawable.Drawable
import android.graphics.drawable.DrawableContainer
import android.graphics.drawable.GradientDrawable
import android.graphics.drawable.RippleDrawable
import android.graphics.drawable.ShapeDrawable
import android.os.Build
import android.util.StateSet
import androidx.annotation.RequiresApi
import io.github.keep2iron.peach.Constants
import io.github.keep2iron.peach.core.BuildCreator
import io.github.keep2iron.peach.resolveMethod

class RippleAbstractCreator(var drawable: Drawable) : BuildCreator<Drawable> {

  private var color: Int = Constants.DEFAULT_COLOR
  private var colorStateList: ColorStateList? = null
  private var radius: Int = -1

  fun color(color: Int) = apply { this.color = color }
  fun colorStateList(colorStateList: ColorStateList?) =
    apply { this.colorStateList = colorStateList }

  fun radius(radius: Int) = apply { this.radius = radius }

  override fun build(): Drawable {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
      val colorStateList = this.colorStateList ?: ColorStateList(
        arrayOf(StateSet.WILD_CARD),
        intArrayOf(color)
      )

      var mask = if (drawable is DrawableContainer) drawable.getCurrent() else drawable
      if (mask is ShapeDrawable) {
        val state = mask.getConstantState()
        if (state != null) {
          val temp = state.newDrawable().mutate() as ShapeDrawable
          temp.paint.color = Color.BLACK
          mask = temp
        }
      } else if (mask is GradientDrawable) {
        val state = mask.getConstantState()
        if (state != null) {
          val temp = state.newDrawable().mutate() as GradientDrawable
          temp.setColor(Color.BLACK)
          mask = temp
        }
      } else {
        mask = ColorDrawable(Color.BLACK)
      }

      val rippleDrawable = RippleDrawable(colorStateList, drawable, mask)
      setRadius(rippleDrawable, radius)
      rippleDrawable.invalidateSelf()
      drawable = rippleDrawable
    }
    return drawable
  }

  inline fun build(block: RippleAbstractCreator.() -> Unit) {
    block()
    build()
  }

  @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
  @TargetApi(Build.VERSION_CODES.LOLLIPOP)
  fun setRadius(rippleDrawable: RippleDrawable, value: Int) {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
      rippleDrawable.radius = value
    } else {
      try {
        val setRadiusMethod =
          resolveMethod(RippleDrawable::class.java, "setMaxRadius", Int::class.java)
        setRadiusMethod.invoke(rippleDrawable, value)
      } catch (e: NoSuchFieldException) {
        e.printStackTrace()
      } catch (e: IllegalAccessException) {
        e.printStackTrace()
      }
    }
  }
}