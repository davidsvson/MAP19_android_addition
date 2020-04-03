package com.example.lektion2android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    //lateinit för vi inte vill att den ska kunna inehålla null
    // men vi kan inte redan nu ge den ett värde
    lateinit var questionView : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        questionView = findViewById(R.id.questionText)

        val firstNumber = (1..10).random()
        val secondNumber = (1..10).random()

        questionView.text = "$firstNumber + $secondNumber ="
    }


}
