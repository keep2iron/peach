package io.github.keep2iron.app

import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import io.github.keep2iron.peach.DrawableCreator

class MainActivity : AppCompatActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)
    val textView = findViewById<TextView>(R.id.textView)

    textView.background = DrawableCreator()
      .rectangle()
      .complete()
      .solidColor(ContextCompat.getColor(applicationContext, R.color.colorPrimary))
      .complete()
      .cornerRadius(10)
      .complete()
      .solidColorPressed(ContextCompat.getColor(applicationContext, R.color.colorAccent))
      .complete()
      .ripple(true)
      .complete()
      .build()
    textView.setOnClickListener {
      Toast.makeText(applicationContext, "click", Toast.LENGTH_SHORT).show()
    }
  }

}
