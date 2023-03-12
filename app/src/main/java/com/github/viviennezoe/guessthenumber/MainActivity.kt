package com.github.viviennezoe.guessthenumber

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText

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
        val guessText = edtNumber.text.toString()
        val guess = guessText.toIntOrNull()
        if (guess != null) {
            Log.i(TAG, "guess = $guess")
        }
    }
}