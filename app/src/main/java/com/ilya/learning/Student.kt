package com.ilya.learning

data class Student(
    val name: String,
    val grade: Int
) {
    
    val status by lazy { defineStatus() }
    
    private fun defineStatus(): Status {
        return when (grade) {
            in Grade.Bad.gradeRange -> Status.Bad
            in Grade.Normal.gradeRange -> Status.Normal
            in Grade.Nice.gradeRange -> Status.Nice
            Grade.Excellent.grade -> Status.Excellent
            else -> Status.WithoutStatus
        }
    }
}