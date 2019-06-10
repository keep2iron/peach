package io.github.keep2iron.peach.creator

import android.graphics.drawable.Drawable
import android.graphics.drawable.RotateDrawable
import android.os.Build
import io.github.keep2iron.peach.*
import io.github.keep2iron.peach.core.BuildCreator


class RotateAbstractCreator(val drawable: Drawable) : BuildCreator<RotateDrawable> {

    companion object {
        private val rotateState: Class<*>

        init {
            rotateState = resolveRotateState()
        }

        private fun resolveRotateState(): Class<*> {
            val classes = RotateDrawable::class.java.declaredClasses
            for (singleClass in classes) {
                if (singleClass.simpleName == "RotateState") return singleClass
            }
            throw RuntimeException("RotateState could not be found in current RotateDrawable implementation")
        }
    }

    fun pivotX(x: Float) = apply { pivotX = x }
    fun pivotY(y: Float) = apply { pivotY = y }
    fun fromDegrees(degree: Float) = apply { fromDegrees = degree }
    fun toDegrees(degree: Float) = apply { toDegrees = degree }

    private var pivotX: Float = 0.5f
    private var pivotY: Float = 0.5f
    private var fromDegrees: Float = 0f
    private var toDegrees: Float = 360f

    override fun build(): RotateDrawable {
        val rotateDrawable = RotateDrawable()
        setDrawable(rotateDrawable, drawable)
        setPivotX(rotateDrawable, pivotX)
        setPivotY(rotateDrawable, pivotY)
        setFromDegrees(rotateDrawable, fromDegrees)
        setToDegrees(rotateDrawable, toDegrees)
        return rotateDrawable
    }

    inline fun build(block: RotateAbstractCreator.() -> Unit): RotateDrawable {
        block()
        return build()
    }

    fun setDrawable(rotateDrawable: RotateDrawable, drawable: Drawable) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            rotateDrawable.drawable = drawable
        } else {
            try {
                val drawableField = resolveField(rotateState, "mDrawable")
                drawableField.set(rotateDrawable.constantState, drawable)
            } catch (e: NoSuchFieldException) {
                e.printStackTrace()
            } catch (e: IllegalAccessException) {
                e.printStackTrace()
            }
        }
    }

    fun setPivotX(rotateDrawable: RotateDrawable, value: Float) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            rotateDrawable.pivotX = value
        } else {
            try {
                val pivotXField = resolveField(rotateState, "mPivotX")
                pivotXField.setFloat(rotateDrawable.constantState, value)
                val pivotXRelField = resolveField(rotateState, "mPivotXRel")
                pivotXRelField.setBoolean(rotateDrawable.constantState, true)
            } catch (e: NoSuchFieldException) {
                e.printStackTrace()
            } catch (e: IllegalAccessException) {
                e.printStackTrace()
            }
        }
    }

    fun setPivotY(rotateDrawable: RotateDrawable, value: Float) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            rotateDrawable.pivotY = value
        } else {
            try {
                val pivotYField = resolveField(rotateState, "mPivotY")
                pivotYField.setFloat(rotateDrawable.constantState, value)
                val pivotYRelField = resolveField(rotateState, "mPivotYRel")
                pivotYRelField.setBoolean(rotateDrawable.constantState, true)
            } catch (e: NoSuchFieldException) {
                e.printStackTrace()
            } catch (e: IllegalAccessException) {
                e.printStackTrace()
            }
        }
    }

    fun setFromDegrees(rotateDrawable: RotateDrawable, value: Float) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            rotateDrawable.fromDegrees = value
        } else {
            try {
                val fromDegreesField = resolveField(rotateState, "mFromDegrees")
                fromDegreesField.setFloat(rotateDrawable.constantState, value)
            } catch (e: NoSuchFieldException) {
                e.printStackTrace()
            } catch (e: IllegalAccessException) {
                e.printStackTrace()
            }
        }
    }

    fun setToDegrees(rotateDrawable: RotateDrawable, value: Float) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            rotateDrawable.toDegrees = value
        } else {
            try {
                val toDegreesField = resolveField(rotateState, "mToDegrees")
                toDegreesField.setFloat(rotateDrawable.constantState, value)
            } catch (e: NoSuchFieldException) {
                e.printStackTrace()
            } catch (e: IllegalAccessException) {
                e.printStackTrace()
            }
        }
    }

}