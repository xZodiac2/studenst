package com.ilya.learning

sealed class Grade(
    val gradeRange: IntRange
) {
    
    object Bad : Grade(0..3)
    object Normal : Grade(4..6)
    object Nice : Grade(7..9)
    object Excellent : Grade(10..10)
    
}
