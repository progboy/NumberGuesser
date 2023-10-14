package com.example.numberguesser

import android.os.Bundle
import android.content.Intent
import android.widget.Button
import android.widget.ImageView
import android.widget.Switch
import androidx.appcompat.app.AppCompatActivity
import androidx.core.graphics.alpha


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
            val intent = Intent(this,DifficultyActivity::class.java)
            startActivity(intent)
        }
        val noBackgroundSwitch:Switch = findViewById(R.id.switch_background)
        noBackgroundSwitch.setOnCheckedChangeListener { _, isChecked ->
            Settings.bgSwitch(isChecked)
            if (isChecked) {
                findViewById<ImageView>(R.id.mm_background).alpha = 0f
            } else {
                findViewById<ImageView>(R.id.mm_background).alpha = 1f
            }
        }
    }
}
class Settings{
    companion object{
        var noBackground = false
        fun bgSwitch(isChecked:Boolean){
            noBackground = isChecked
        }
    }
}