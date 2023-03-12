package com.github.viviennezoe.guessthenumber

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView

const val TAG = "MainActivity"

class MainActivity : AppCompatActivity() {

    var theNumber: Int = -1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (theNumber < 0) {
            theNumber = (1..100).random()
            Log.i(TAG, "theNumber = $theNumber")
        }
    }

    fun onGuessNumber(view: View) {
        val edtNumber: EditText = findViewById(R.id.editTextNumber)
        val iconCorrect: ImageView = findViewById(R.id.iconCorrect)
        val iconWrong: ImageView = findViewById(R.id.iconWrong)
        val tip: TextView = findViewById(R.id.tip)
        val guessText = edtNumber.text.toString()
        val guess = guessText.toIntOrNull()
        if (guess != null) {
            Log.i(TAG, "guess = $guess")
            if (guess == theNumber) {
                iconCorrect.visibility = View.VISIBLE
                iconWrong.visibility = View.INVISIBLE
                tip.text = ""
            } else {
                iconCorrect.visibility = View.INVISIBLE
                iconWrong.visibility = View.VISIBLE
                if (guess < theNumber) {
                    tip.text = "$guess ist zu klein"
                } else {
                    tip.text = "$guess ist zu gross"
                }
                edtNumber.text.clear()
            }
        }
    }
}