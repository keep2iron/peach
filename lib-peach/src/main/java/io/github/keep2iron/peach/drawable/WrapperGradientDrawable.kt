package io.github.keep2iron.peach.drawable

import android.graphics.Rect
import android.graphics.drawable.GradientDrawable
import kotlin.math.min

class WrapperGradientDrawable : GradientDrawable() {

    var radiusAdjustBounds: Boolean = false

    override fun onBoundsChange(r: Rect) {
        super.onBoundsChange(r)
        if (radiusAdjustBounds) { // 修改圆角为短边的一半
            cornerRadius = min(r.width(), r.height()) / 2.toFloat()
        }
    }

}