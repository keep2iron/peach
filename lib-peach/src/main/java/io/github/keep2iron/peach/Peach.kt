package io.github.keep2iron.peach

import android.content.res.ColorStateList
import android.graphics.drawable.Drawable
import android.graphics.drawable.GradientDrawable
import android.os.Build
import android.util.StateSet
import io.github.keep2iron.peach.core.AbstractCreator
import io.github.keep2iron.peach.core.ShapeCreator
import io.github.keep2iron.peach.creator.FlipAbstractCreator
import io.github.keep2iron.peach.creator.RippleAbstractCreator
import io.github.keep2iron.peach.creator.RotateAbstractCreator
import io.github.keep2iron.peach.creator.ScaleAbstractCreator
import io.github.keep2iron.peach.creator.StateListAbstractCreator
import io.github.keep2iron.peach.drawable.FlipDrawable
import io.github.keep2iron.peach.drawable.WrapperGradientDrawable
import java.util.TreeMap
import java.util.concurrent.atomic.AtomicInteger

class Peach : AbstractCreator {
  private var properties = DrawableProperties()
  private var order: AtomicInteger = AtomicInteger(1)
  private var transformsMap = TreeMap<Int, (Drawable) -> Drawable>()
  private var baseDrawable: Drawable? = null

  override fun batch(properties: DrawableProperties) = apply { this.properties = properties.copy() }

  override fun baseDrawable(drawable: Drawable) = apply { baseDrawable = drawable }

  override fun complete(): AbstractCreator = this

  // <shape>
  override fun shape(@Shape shape: Int): ShapeCreator = apply { properties.shape = shape }

  override fun rectangle(): ShapeCreator = apply { shape(GradientDrawable.RECTANGLE) }
  override fun oval(): ShapeCreator = apply { shape(GradientDrawable.OVAL) }
  override fun line(): ShapeCreator = apply { shape(GradientDrawable.LINE) }
  override fun ring(): ShapeCreator = apply { shape(GradientDrawable.RING) }
  override fun innerRadius(innerRadius: Int): ShapeCreator =
    apply { properties.innerRadius = innerRadius }

  override fun innerRadiusRatio(innerRadiusRatio: Float): ShapeCreator =
    apply { properties.innerRadiusRatio = innerRadiusRatio }

  override fun thickness(thickness: Int): ShapeCreator = apply { properties.thickness = thickness }
  override fun thicknessRatio(thicknessRatio: Float): ShapeCreator =
    apply { properties.thicknessRatio = thicknessRatio }

  override fun useLevelForRing(use: Boolean): ShapeCreator =
    apply { properties.useLevelForRing = use }

  // <corner>
  override fun cornerRadius(cornerRadius: Int) = apply { properties.cornerRadius = cornerRadius }

  override fun topLeftRadius(topLeftRadius: Int) =
    apply { properties.topLeftRadius = topLeftRadius }

  override fun topRightRadius(topRightRadius: Int) =
    apply { properties.topRightRadius = topRightRadius }

  override fun bottomRightRadius(bottomRightRadius: Int) =
    apply { properties.bottomRightRadius = bottomRightRadius }

  override fun bottomLeftRadius(bottomLeftRadius: Int) =
    apply { properties.bottomLeftRadius = bottomLeftRadius }

  override fun rounded() = apply { cornerRadius(Int.MAX_VALUE) }
  override fun cornerRadii(
    topLeftRadius: Int,
    topRightRadius: Int,
    bottomRightRadius: Int,
    bottomLeftRadius: Int
  ) = apply {
    topLeftRadius(topLeftRadius); topRightRadius(topRightRadius); bottomRightRadius(
    bottomRightRadius
  ); bottomLeftRadius(bottomLeftRadius)
  }

  // <gradient>
  override fun gradient() = apply { properties.useGradient = true }

  override fun gradientType(type: Int) = apply { properties.type = type }
  override fun linearGradient() = apply { gradientType(GradientDrawable.LINEAR_GRADIENT) }
  override fun radialGradient() = apply { gradientType(GradientDrawable.RADIAL_GRADIENT) }
  override fun sweepGradient() = apply { gradientType(GradientDrawable.SWEEP_GRADIENT) }
  override fun angle(angle: Int) = apply { properties.angle = angle }
  override fun centerX(centerX: Float) = apply { properties.centerX = centerX }
  override fun centerY(centerY: Float) = apply { properties.centerY = centerY }
  override fun center(centerX: Float, centerY: Float) = apply { centerX(centerX); centerY(centerY) }

  override fun startColor(startColor: Int) = apply { properties.startColor = startColor }
  override fun centerColor(centerColor: Int) = apply {
    properties.centerColor = centerColor
  }

  override fun endColor(endColor: Int) = apply { properties.endColor = endColor }
  override fun gradientColors(startColor: Int, endColor: Int, centerColor: Int?) = apply {
    startColor(startColor); endColor(endColor)
    centerColor?.let {
      centerColor(it)
    }
  }

  override fun gradientRadiusType(gradientRadiusType: Int) =
    apply { properties.gradientRadiusType = gradientRadiusType }

  override fun gradientRadius(gradientRadius: Float) =
    apply { properties.gradientRadius = gradientRadius }

  override fun gradientRadius(radius: Float, type: Int) =
    apply { gradientRadius(radius); gradientRadiusType(type) }

  override fun gradientRadiusInPixel(radius: Float) =
    apply { gradientRadius(radius); gradientRadiusType(DrawableProperties.RADIUS_TYPE_PIXELS) }

  override fun gradientRadiusInFraction(radius: Float) =
    apply { gradientRadius(radius); gradientRadiusType(DrawableProperties.RADIUS_TYPE_FRACTION) }

  override fun useLevelForGradient(use: Boolean) = apply { properties.useLevelForGradient = use }
  override fun useLevelForGradient() = apply { useLevelForGradient(true) }

  // <size>
  override fun width(width: Int) = apply { properties.width = width }

  override fun height(height: Int) = apply { properties.height = height }
  override fun size(width: Int, height: Int) = apply { width(width); height(height) }
  override fun size(size: Int) = apply { width(size).height(size) }

  // <solid>
  override fun solidColor(solidColor: Int) = apply { properties.solidColor = solidColor }

  private var solidColorPressed: Int? = null
  override fun solidColorPressed(color: Int?) = apply { solidColorPressed = color }
  private var solidColorPressedWhenRippleUnsupported: Int? = null
  override fun solidColorPressedWhenRippleUnsupported(color: Int?) =
    apply { solidColorPressedWhenRippleUnsupported = color }

  private var solidColorDisabled: Int? = null
  override fun solidColorDisabled(color: Int?) = apply { solidColorDisabled = color }
  private var solidColorSelected: Int? = null
  override fun solidColorSelected(color: Int?) = apply { solidColorSelected = color }
  override fun solidColorStateList(colorStateList: ColorStateList) =
    apply { properties.solidColorStateList = colorStateList }

  // <stroke>
  override fun strokeWidth(strokeWidth: Int) = apply { properties.strokeWidth = strokeWidth }

  override fun strokeColor(strokeColor: Int) = apply { properties.strokeColor = strokeColor }
  private var strokeColorPressed: Int? = null
  override fun strokeColorPressed(color: Int) = apply { strokeColorPressed = color }
  private var strokeColorDisabled: Int? = null
  override fun strokeColorDisabled(color: Int) = apply { strokeColorDisabled = color }
  private var strokeColorSelected: Int? = null
  override fun strokeColorSelected(color: Int) = apply { strokeColorSelected = color }
  override fun strokeColorStateList(colorStateList: ColorStateList) =
    apply { properties.strokeColorStateList = colorStateList }

  override fun dashWidth(dashWidth: Int) = apply { properties.dashWidth = dashWidth }
  override fun dashGap(dashGap: Int) = apply { properties.dashGap = dashGap }
  override fun hairlineBordered() = apply { strokeWidth(1) }
  override fun shortDashed() = apply { dashWidth(12).dashGap(12) }
  override fun mediumDashed() = apply { dashWidth(24).dashGap(24) }
  override fun longDashed() = apply { dashWidth(36).dashGap(36) }
  override fun dashed() = apply { mediumDashed() }

  // <rotate>
  private var rotateOrder = 0

  override fun rotate() = apply {
    properties.useRotate = true
    rotateOrder = if (properties.useRotate) {
      order.getAndIncrement()
    } else {
      0
    }
  }

  override fun pivotX(pivotX: Float) = apply { properties.pivotX = pivotX }
  override fun pivotY(pivotY: Float) = apply { properties.pivotY = pivotY }
  override fun pivot(pivotX: Float, pivotY: Float) = apply { pivotX(pivotX).pivotY(pivotY) }
  override fun fromDegrees(degrees: Float) = apply { properties.fromDegrees = degrees }
  override fun toDegrees(degrees: Float) = apply { properties.toDegrees = degrees }
  override fun degrees(fromDegrees: Float, toDegrees: Float) =
    apply { fromDegrees(fromDegrees).toDegrees(toDegrees) }

  override fun degrees(degrees: Float) = apply { fromDegrees(degrees).toDegrees(degrees) }
  override fun rotate(fromDegrees: Float, toDegrees: Float) =
    apply { rotate().fromDegrees(fromDegrees).toDegrees(toDegrees) }

  override fun rotate(degrees: Float) = apply { rotate().degrees(degrees) }

  // <scale>
  private var scaleOrder = 0

  override fun scale() = apply {
    properties.useScale = true
    scaleOrder = if (properties.useScale) {
      order.getAndIncrement()
    } else {
      0
    }
  }

  override fun scaleLevel(level: Int) = apply { properties.scaleLevel = level }
  override fun scaleGravity(gravity: Int) = apply { properties.scaleGravity = gravity }
  override fun scaleWidth(scale: Float) = apply { properties.scaleWidth = scale }
  override fun scaleHeight(scale: Float) = apply { properties.scaleHeight = scale }
  override fun scale(scale: Float) = apply { scale().scaleWidth(scale).scaleHeight(scale) }
  override fun scale(scaleWidth: Float, scaleHeight: Float) =
    apply { scale().scaleWidth(scaleWidth).scaleHeight(scaleHeight) }

  // flip
  override fun flip(boolean: Boolean) = apply { properties.useFlip = boolean }

  override fun orientation(orientation: Int) = apply { properties.orientation = orientation }
  override fun flipVertical() = apply { flip().orientation(FlipDrawable.ORIENTATION_VERTICAL) }

  // <ripple>
  override fun ripple(boolean: Boolean) = apply { properties.useRipple = boolean }

  override fun rippleColor(color: Int) = apply { properties.rippleColor = color }
  override fun rippleColorStateList(colorStateList: ColorStateList) =
    apply { properties.rippleColorStateList = colorStateList }

  override fun rippleRadius(radius: Int) = apply { properties.rippleRadius = radius }

  override fun build(): Drawable {
    if (baseDrawable != null) {
      return wrap(baseDrawable!!)
    }

    var drawable: Drawable

    // fall back when ripple is unavailable on devices with API < 21
    if (shouldFallbackRipple()) {
      if (solidColorPressedWhenRippleUnsupported != null) {
        solidColorPressed(solidColorPressedWhenRippleUnsupported)
      } else {
        solidColorPressed(properties.rippleColor)
      }
    }

    if (needStateListDrawable()) {
      drawable = StateListAbstractCreator()
        .pressed(buildPressedDrawable())
        .disabled(buildDisabledDrawable())
        .selected(buildSelectedDrawable())
        .normal(buildNormalDrawable())
        .build()
    } else {
      drawable = WrapperGradientDrawable()
      setupGradientDrawable(drawable)
    }
    drawable = wrap(drawable)
    return drawable
  }

  private fun shouldFallbackRipple(): Boolean {
    return properties.useRipple && !isRippleSupported()
  }

  private fun isRippleSupported(): Boolean {
    return Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP
  }

  private fun needRotateDrawable(): Boolean {
    return properties.useRotate &&
        !(properties.pivotX == 0.5f && properties.pivotY == 0.5f
            && properties.fromDegrees == 0f && properties.toDegrees == 0f)
  }

  private fun needStateListDrawable(): Boolean {
    return Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP
        && (hasStrokeColorStateList() || (!properties.useGradient && hasSolidColorStateList()))
  }

  private fun hasStrokeColorStateList(): Boolean {
    return strokeColorPressed != null || strokeColorDisabled != null || strokeColorSelected != null
  }

  private fun hasSolidColorStateList(): Boolean {
    return solidColorPressed != null || solidColorDisabled != null || solidColorSelected != null
  }

  private fun buildPressedDrawable(): Drawable? {
    if (solidColorPressed == null && strokeColorPressed == null) return null

    val pressedDrawable = GradientDrawable()
    setupGradientDrawable(pressedDrawable)
    solidColorPressed?.let {
      pressedDrawable.setColor(it)
    }
    strokeColorPressed?.let {
      setStrokeColor(pressedDrawable, it)
    }
    return pressedDrawable
  }

  private fun buildDisabledDrawable(): Drawable? {
    if (solidColorDisabled == null && strokeColorDisabled == null) return null

    val disabledDrawable = GradientDrawable()
    setupGradientDrawable(disabledDrawable)
    solidColorDisabled?.let {
      disabledDrawable.setColor(it)
    }
    strokeColorDisabled?.let {
      setStrokeColor(disabledDrawable, it)
    }
    return disabledDrawable
  }

  private fun buildSelectedDrawable(): Drawable? {
    if (solidColorSelected == null && strokeColorSelected == null) return null

    val selectedDrawable = GradientDrawable()
    setupGradientDrawable(selectedDrawable)
    solidColorSelected?.let {
      selectedDrawable.setColor(it)
    }
    strokeColorSelected?.let {
      setStrokeColor(selectedDrawable, it)
    }
    return selectedDrawable
  }

  private fun buildNormalDrawable(): Drawable {
    val pressedDrawable = GradientDrawable()
    setupGradientDrawable(pressedDrawable)
    return pressedDrawable
  }

  private fun wrap(drawable: Drawable): Drawable {
    var wrappedDrawable = drawable

    if (rotateOrder > 0) {
      transformsMap[rotateOrder] = ::wrapRotateIfNeeded
    }
    if (scaleOrder > 0) {
      transformsMap[scaleOrder] = ::wrapScaleIfNeeded
    }

    for (action in transformsMap.values) {
      wrappedDrawable = action.invoke(wrappedDrawable)
    }

    if (properties.useFlip) {
      wrappedDrawable = FlipAbstractCreator(wrappedDrawable)
        .orientation(properties.orientation)
        .build()
    }

    if (isRippleSupported() && properties.useRipple) {
      wrappedDrawable = RippleAbstractCreator(wrappedDrawable)
        .color(properties.rippleColor)
        .colorStateList(properties.rippleColorStateList)
        .radius(properties.rippleRadius)
        .build()
    }

    return wrappedDrawable
  }

  private fun setupGradientDrawable(drawable: GradientDrawable) {
    properties.apply {
      drawable.shape = shape
      if (shape == GradientDrawable.RING) {
        setInnerRadius(drawable, innerRadius)
        setInnerRadiusRatio(drawable, innerRadiusRatio)
        setThickness(drawable, thickness)
        setThicknessRatio(drawable, thicknessRatio)
        setUseLevelForShape(drawable, useLevelForRing)
      }
      drawable.cornerRadii = getCornerRadii()
      if (useGradient) {
        drawable.gradientType = type
        setGradientRadiusType(drawable, gradientRadiusType)
        setGradientRadius(drawable, gradientRadius)
        drawable.setGradientCenter(centerX, centerY)
        setOrientation(drawable, getOrientation())
        setColors(drawable, getColors())
        drawable.useLevel = useLevelForGradient
      } else {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
          drawable.color = getSolidColorStateList()
        } else {
          drawable.setColor(solidColor)
        }
      }
      drawable.setSize(width, height)
      if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
        drawable.setStroke(
          strokeWidth,
          getStrokeColorStateList(),
          dashWidth.toFloat(),
          dashGap.toFloat()
        )
      } else {
        drawable.setStroke(strokeWidth, strokeColor, dashWidth.toFloat(), dashGap.toFloat())
      }
    }
  }

  private fun getSolidColorStateList(): ColorStateList {
    if (properties.solidColorStateList != null) {
      return properties.solidColorStateList!!
    }

    val states = mutableListOf<IntArray>()
    val colors = mutableListOf<Int>()

    solidColorPressed?.let {
      states.add(intArrayOf(android.R.attr.state_pressed))
      colors.add(it)
    }
    solidColorDisabled?.let {
      states.add(intArrayOf(-android.R.attr.state_enabled))
      colors.add(it)
    }
    solidColorSelected?.let {
      states.add(intArrayOf(android.R.attr.state_selected))
      colors.add(it)
    }
    states.add(StateSet.WILD_CARD)
    colors.add(properties.solidColor)

    return ColorStateList(states.toTypedArray(), colors.toIntArray())
  }

  private fun getStrokeColorStateList(): ColorStateList {
    if (properties.strokeColorStateList != null) {
      return properties.strokeColorStateList!!
    }

    val states = mutableListOf<IntArray>()
    val colors = mutableListOf<Int>()

    strokeColorPressed?.let {
      states.add(intArrayOf(android.R.attr.state_pressed))
      colors.add(it)
    }
    strokeColorDisabled?.let {
      states.add(intArrayOf(android.R.attr.state_enabled))
      colors.add(it)
    }
    strokeColorSelected?.let {
      states.add(intArrayOf(android.R.attr.state_selected))
      colors.add(it)
    }
    states.add(StateSet.WILD_CARD)
    colors.add(properties.strokeColor)

    return ColorStateList(states.toTypedArray(), colors.toIntArray())
  }

  private fun wrapRotateIfNeeded(drawable: Drawable): Drawable {
    if (!needRotateDrawable()) return drawable

    with(properties) {
      return RotateAbstractCreator(drawable)
        .pivotX(pivotX)
        .pivotY(pivotY)
        .fromDegrees(fromDegrees)
        .toDegrees(toDegrees)
        .build()
    }
  }

  private fun wrapScaleIfNeeded(drawable: Drawable): Drawable {
    if (!needScaleDrawable()) return drawable

    with(properties) {
      return ScaleAbstractCreator(drawable)
        .level(scaleLevel)
        .scaleGravity(scaleGravity)
        .scaleWidth(scaleWidth)
        .scaleHeight(scaleHeight)
        .build()
    }
  }

  private fun needScaleDrawable(): Boolean {
    return properties.useScale
  }
}