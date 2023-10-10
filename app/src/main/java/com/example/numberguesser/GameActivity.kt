package com.example.numberguesser

import android.content.Intent
import android.graphics.Color
import android.graphics.PorterDuff
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class GameActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)

        game()
    }
    private fun game(){
        val guessButton: Button = findViewById(R.id.bt_guess) //the button
        val guess:EditText = findViewById(R.id.txt_prompt) //for entering text input
        val tryPrompt:TextView = findViewById(R.id.tries)  //shows no of tries left
        val response:TextView = findViewById(R.id.txt_response) //shows whether input is correct or not
        var tries = 10 //no of tries
        val ans = (1..100).random()  //choose the answer

        //runs when user clicks button
        guessButton.setOnClickListener {
            guessButton.isClickable = false
            try {
                var s = guess.text.toString().trim().toInt()
                tries--
                if (s == ans) {
                    //game won
                    guessButton.alpha = 0f
                    response.alpha = 0f
                    guess.alpha = 0f
                    win(ans, 10 - tries)
                } else if (s > ans) {
                    response.text = s.toString().trim() + " is higher than the number."
                } else {
                    response.text = s.toString().trim() + " is lower than the number."
                }
                if (tries <= 0 && s != ans) {
                    guessButton.alpha = 0f
                    response.alpha = 0f
                    guess.alpha = 0f
                    lose(ans)
                }

            } catch (e: Exception) {
                response.text = "Invalid input, please try again"
            }
            guessButton.isClickable = true
            tryPrompt.text = "Tries left: " + tries.toString()
        }
    }
    private fun win(ans:Int,tries:Int){
        findViewById<TextView>(R.id.textView3).text = "You Won!"
        findViewById<TextView>(R.id.txt_gameend).text = "You guessed " + ans.toString() + " in " + tries.toString() + " attempts"
        menuTime()
    }
    private fun lose(ans:Int){
        findViewById<TextView>(R.id.textView3).text = "You Lost!"
        findViewById<TextView>(R.id.txt_gameend).text = "The number was " + ans.toString()
        menuTime()
    }
    private fun menuTime(){
        val bt_back:Button = findViewById(R.id.menu)
        bt_back.isClickable = true
        bt_back.alpha = 1f
        bt_back.setOnClickListener{
            finish()
        }
    }
}