package com.example.lab2

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import android.widget.TextView
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.util.Log


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun onButtonClick(view: View) {
        val textResult = findViewById<TextView>(R.id.TextResult)
        val buttonPressText = getString(R.string.buttonPress_text)

        val buttonText = when (view.id) {
            R.id.button1 -> getString(R.string.button1_text)
            R.id.button2 -> getString(R.string.button2_text)
            R.id.button3 -> getString(R.string.button3_text)
            R.id.button4 -> getString(R.string.button4_text)
            R.id.button5 -> getString(R.string.button5_text)
            R.id.button6 -> getString(R.string.button6_text)
            R.id.button7 -> getString(R.string.button7_text)
            R.id.button8 -> getString(R.string.button8_text)
            R.id.button9 -> getString(R.string.button9_text)
            R.id.button10 -> getString(R.string.button10_text)
            R.id.button11 -> getString(R.string.button11_text)
            R.id.button12 -> getString(R.string.button12_text)
            R.id.button13 -> getString(R.string.button13_text)
            R.id.button14 -> getString(R.string.button14_text)
            R.id.button15 -> getString(R.string.button15_text)
            R.id.button16 -> getString(R.string.button16_text)
            R.id.button17 -> getString(R.string.button17_text)
            R.id.button18 -> getString(R.string.button18_text)
            R.id.button19 -> getString(R.string.button19_text)
            R.id.button20 -> getString(R.string.button20_text)
            R.id.buttonback -> getString(R.string.buttonBack_text)
            else -> ""
        }


        if (buttonText.isNotEmpty()) {
            if (buttonText == getString(R.string.buttonBack_text)) {
                finish()
            } else {
                textResult.text = "$buttonPressText $buttonText"
                Log.d("ButtonClick", "$buttonPressText $buttonText")
            }
        }
    }

}