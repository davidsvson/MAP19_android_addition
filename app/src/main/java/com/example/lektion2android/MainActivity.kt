package com.example.lektion2android

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

const val EXTRA_MESSAGE = "com.example.lektion2android.MESSAGE"

class MainActivity : AppCompatActivity() {

    //lateinit för vi inte vill att den ska kunna inehålla null
    // men vi kan inte redan nu ge den ett värde
    lateinit var questionView : TextView
    var firstNumber = 0
    var secondNumber = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        questionView = findViewById(R.id.questionText)
        randomizeQuestion()

        val button = findViewById<Button>(R.id.button)

        button.setOnClickListener {
            startAnswerActivity()
        }
    }

    override fun onRestart() {
        super.onRestart()

        randomizeQuestion()
    }


    fun checkAnswer() : Boolean {
        val answerText = findViewById<EditText>(R.id.answerText)
        val answer = answerText.text.toString()
        val answerInt = answer.toIntOrNull()

        return firstNumber + secondNumber == answerInt
    }

    fun startAnswerActivity() {
        val rightAnswer = checkAnswer()

        //intent:et innehåller vilken activity vi är i och vilken activity vi ska till

        val intent = Intent(this, AnswerActivity::class.java).apply {
            putExtra(EXTRA_MESSAGE, rightAnswer)
        }

        // i stället för att at det indent vi just skapa och göra .putextra
        // så gör vi som ovanstående kör .apply och läg där inne
        // det som vi vill ska aplliceras på det just skapade objektet
        // intent.putExtra(EXTRA_MESSAGE, rightAnswer )

        //skicka med vårt intent till startactivity metoden
        startActivity(intent)
    }

    fun randomizeQuestion() {
        firstNumber = (1..10).random()
        secondNumber = (1..10).random()

        questionView.text = "$firstNumber + $secondNumber ="
    }


}
