package com.example.numberguesser

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView

class AboutActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)

        if(Settings.noBackground){
            findViewById<ImageView>(R.id.abt_background).alpha = 0f
        }else{
            findViewById<ImageView>(R.id.abt_background).alpha = 1f
        }

        val backButton: Button = findViewById(R.id.bt_back)
        backButton.setOnClickListener{
            finish()
        }
    }
}