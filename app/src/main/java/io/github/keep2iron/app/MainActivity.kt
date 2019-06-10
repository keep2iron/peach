package io.github.keep2iron.app

import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity
import android.widget.TextView
import android.widget.Toast
import io.github.keep2iron.peach.DrawableCreator

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val textView = findViewById<TextView>(R.id.textView)

        textView.background = DrawableCreator()
                .rectangle().setup()
                .solidColor(ContextCompat.getColor(applicationContext, R.color.colorPrimary)).setup()
                .cornerRadius(10).setup()
                .solidColorPressed(ContextCompat.getColor(applicationContext, R.color.colorAccent)).setup()
                .ripple(true).setup()
                .build()
        textView.setOnClickListener {
            Toast.makeText(applicationContext, "click", Toast.LENGTH_SHORT).show()
        }
    }

}
