package com.example.numberguesser

import android.os.Bundle
import android.content.Intent
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val aboutButton:Button = findViewById(R.id.bt_about)
        aboutButton.setOnClickListener{
            val intent = Intent(this,AboutActivity::class.java)
            startActivity(intent)
        }
        val gameButton:Button = findViewById(R.id.bt_start)
        gameButton.setOnClickListener{
            val intent = Intent(this,GameActivity::class.java)
            startActivity(intent)
        }
    }
}