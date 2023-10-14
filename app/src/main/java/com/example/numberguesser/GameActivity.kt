package com.example.numberguesser

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView

class GameActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)

        if(Settings.noBackground){
            findViewById<ImageView>(R.id.imageView).alpha = 0f
        }else{
            findViewById<ImageView>(R.id.imageView).alpha = 1f
        }

        game()
    }
    private fun game(){
        val guessButton: Button = findViewById(R.id.bt_guess) //the button
        val guess:EditText = findViewById(R.id.txt_prompt) //for entering text input
        val tryPrompt:TextView = findViewById(R.id.tries)  //shows no of tries left
        val response:TextView = findViewById(R.id.txt_response) //shows whether input is correct or not
        var tries = 10 //no of tries
        val ans = DifficultyChanger.ans  //choose the answer
        var gameEnd = false
        findViewById<TextView>(R.id.textView3).text = DifficultyChanger.dText

        //runs when user clicks button
        guessButton.setOnClickListener {
            guessButton.isClickable = false
            try {
                val s = guess.text.toString().trim().toInt()
                guess.getText().clear()
                tries--
                if (s == ans) {
                    //game won
                    gameEnd = true
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
                    gameEnd = true
                    guessButton.alpha = 0f
                    response.alpha = 0f
                    guess.alpha = 0f
                    lose(ans)
                }

            } catch (e: Exception) {
                response.text = "Invalid input, please try again"
            }
            if(gameEnd) {
                // Get a reference to the InputMethodManager
                val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager

                // Hide the soft keyboard
                imm.hideSoftInputFromWindow(guess.windowToken, 0)
                guess.isFocusable = false
                guess.isClickable = false
                guess.isEnabled = false
                guess.isCursorVisible = false
                        
            }else{
                guessButton.isClickable = true
            }
            tryPrompt.text = "Tries left: " + tries.toString()
        }
    }
    private fun win(ans:Int,tries:Int){
        findViewById<TextView>(R.id.textView3).text = "You Won!"
        findViewById<TextView>(R.id.txt_gameend).text = "You guessed " + ans.toString() + " in " + tries.toString() + " attempts"
        findViewById<ImageView>(R.id.img_gameend).alpha = 1f
        menuTime()
    }
    private fun lose(ans:Int){
        findViewById<TextView>(R.id.textView3).text = "You Lost!"
        findViewById<TextView>(R.id.txt_gameend).text = "The number was " + ans.toString()
        findViewById<ImageView>(R.id.img_gamelose).alpha = 1f
        menuTime()
    }
    private fun menuTime(){
        val btBack:Button = findViewById(R.id.menu)
        btBack.isClickable = true
        btBack.alpha = 1f
        btBack.setOnClickListener{
            finish()
        }
    }
}
class DifficultyChanger(){
    companion object{
        //work in progress
        var dText:String = "Guess a number from 1 to 100"
        var ans:Int = (1..100).random()
    }
}