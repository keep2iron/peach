package io.github.keep2iron.peach

import android.graphics.drawable.GradientDrawable
import androidx.annotation.IntDef

@MustBeDocumented // 表示开启Doc文档
@IntDef(
  GradientDrawable.LINE,
  GradientDrawable.OVAL,
  GradientDrawable.RECTANGLE,
  GradientDrawable.RING
) //限定为MAN,WOMEN
@Target(
  AnnotationTarget.VALUE_PARAMETER,
  AnnotationTarget.FIELD,
  AnnotationTarget.FUNCTION,
  AnnotationTarget.PROPERTY_GETTER,
  AnnotationTarget.PROPERTY_SETTER
) //表示注解作用范围，参数注解，成员注解，方法注解
@Retention(AnnotationRetention.SOURCE) //表示注解所存活的时间,在运行时,而不会存在 .class 文件中
annotation class Shape//接口，定义新的注解类型