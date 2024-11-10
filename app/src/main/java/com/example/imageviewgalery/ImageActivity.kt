package com.example.imageviewgalery

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ImageActivity : AppCompatActivity() {

    private lateinit var imageIV: ImageView
    private lateinit var nextBTN: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_image)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        imageIV = findViewById(R.id.imageIV)
        nextBTN = findViewById(R.id.nextBTN)

        imageIV.setImageResource(R.drawable.image_01)
        var count = 1
        nextBTN.setOnClickListener{view ->
            count++
            when(count) {
                2 -> imageIV.setImageResource(R.drawable.image_02)
                3 -> imageIV.setImageResource(R.drawable.image_03)
                4 -> imageIV.setImageResource(R.drawable.image_04)
                5 -> imageIV.setImageResource(R.drawable.image_05)
                else -> {
                    val intent = Intent(this, FinishActivity::class.java)
                    startActivity(intent)
                    finish()
                }
            }
        }


    }
}