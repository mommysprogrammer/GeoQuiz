package com.example.geoquiz

import androidx.lifecycle.ViewModel
class QuizViewModel : ViewModel() {
    var currentIndex = 0
    var correctAnswersCount = 0

    private val questionBank = listOf(
        Question(R.string.question_australia, true),
        Question(R.string.question_oceans, true),
        Question(R.string.question_mideast, false),
        Question(R.string.question_africa, false),
        Question(R.string.question_americas, true),
        Question(R.string.question_asia, true)
    )

    val currentQuestionAnswer: Boolean
        get() = questionBank[currentIndex].answer

    val currentQuestionText: Int
        get() = questionBank[currentIndex].textResId

    fun moveToPrevious() {
        currentIndex = if (currentIndex != 0) {
            (currentIndex - 1)
        } else questionBank.size - 1
    }

    fun moveToNext() {
        currentIndex = (currentIndex + 1) % questionBank.size
    }

    fun correctAnswersRateCalculator(correctAnswersCount: Int): Int {
        return (correctAnswersCount * 100) / questionBank.size
    }
}

