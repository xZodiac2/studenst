package com.ilya.learning

sealed class Grade() {
    lateinit var gradeRange: IntRange
    var grade: Int = -1

    constructor(_gradeRange: IntRange) : this() {
        gradeRange = _gradeRange
    }

    constructor(_grade: Int): this() {
        grade = _grade
    }


    object Bad : Grade(0..3)
    object Normal : Grade(4..6)
    object Nice : Grade(7..9)
    object Excellent : Grade(10)
}