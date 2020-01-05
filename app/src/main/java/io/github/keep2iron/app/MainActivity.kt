package io.github.keep2iron.app

import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableString
import android.text.style.ImageSpan
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)
    val textView = findViewById<TextView>(R.id.textView)

    val spannedString = SpannableString("自营商品")
    val draw = GradientDrawable()
    draw.setColor(Color.parseColor("#FFCCCCCC"))
    draw.shape = GradientDrawable.RECTANGLE
//    ImageSpan(
//      Peach()
//        .rectangle().complete().solidColor(Color.parseColor("#FFCCCCCC")).complete()
//        .build(), DynamicDrawableSpan.ALIGN_BASELINE
//    )
    val drawable = getResources().getDrawable(R.mipmap.ic_launcher)
    val imageSpan = ImageSpan(drawable, ImageSpan.ALIGN_BASELINE)
    spannedString.setSpan(
      imageSpan,0, 2, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
    )


    textView.text = spannedString
//    textView.background = Peach()
//      .rectangle()
//      .complete()
//      .solidColor(ContextCompat.getColor(applicationContext, R.color.colorPrimary))
//      .complete()
//      .cornerRadius(10)
//      .complete()
//      .solidColorPressed(ContextCompat.getColor(applicationContext, R.color.colorAccent))
//      .complete()
//      .ripple(true)
//      .complete()
//      .build()
  }

}
