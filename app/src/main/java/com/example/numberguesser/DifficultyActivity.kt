package com.example.numberguesser

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView


class DifficultyActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_difficulty)

        if(Settings.noBackground){
            findViewById<ImageView>(R.id.background).alpha = 0f
        }else{
            findViewById<ImageView>(R.id.background).alpha = 1f
        }

        val easyButton: Button = findViewById(R.id.bt_easy)
        easyButton.setOnClickListener {
            DifficultyChanger.dText = "Guess a number from 1 to 10"
            DifficultyChanger.ans = (1..10).random()
            val intent = Intent(this, GameActivity::class.java)
            startActivity(intent)
            finish()
        }
        val medButton: Button = findViewById(R.id.bt_medium)
        medButton.setOnClickListener{
            DifficultyChanger.dText = "Guess a number from 1 to 100"
            DifficultyChanger.ans = (1..100).random()
            val intent = Intent(this,GameActivity::class.java)
            startActivity(intent)
            finish()
        }
        val hardButton: Button = findViewById(R.id.bt_hard)
        hardButton.setOnClickListener{
            DifficultyChanger.dText = "Guess a number from 1 to 1000"
            DifficultyChanger.ans = (1..1000).random()
            val intent = Intent(this, GameActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}