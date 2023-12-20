package com.example.myapplication

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.SeekBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private lateinit var firstNameInput: EditText
    private lateinit var lastNameInput: EditText
    private lateinit var politenessSlider: SeekBar
    private lateinit var greetingOutput: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        firstNameInput = findViewById(R.id.firstNameInput)
        lastNameInput = findViewById(R.id.lastNameInput)
        politenessSlider = findViewById(R.id.politenessSlider)
        greetingOutput = findViewById(R.id.greetingOutput)

        findViewById<Button>(R.id.generateButton).setOnClickListener {
            generateGreeting()
        }
    }

    private fun generateGreeting() {
        val firstName = firstNameInput.text.toString()
        val lastName = lastNameInput.text.toString()
        val politenessLevel = politenessSlider.progress
        val greeting = when (politenessLevel) {
            0 -> listOf("Hallo", "Moin","Hey", "Hi").random()
            1  -> listOf("Guten Tag", "Herzlich Willkommen","Willkommen").random()
            2 -> "Sehr geehrte(r)"
            else -> "Hochachtungsvoll angesprochene(r)"
        }
        greetingOutput.text = "$greeting, \n $firstName $lastName!"
    }
}
