package com.ilya.learning

sealed class Status(
    val meaning: String
) {
    private object Bad : Status("плохой ученик")
    private object Normal : Status("нормальный ученик")
    private object Nice : Status("хороший ученик")
    private object Excellent : Status("отличный ученик")
    private object WithoutStatus : Status("без статуса")
    
    companion object {
        fun defineStudentStatus(student: Student): Status {
            return when (student.grade) {
                in Grade.Bad.gradeRange -> Bad
                in Grade.Normal.gradeRange -> Normal
                in Grade.Nice.gradeRange -> Nice
                in Grade.Excellent.gradeRange -> Excellent
                else -> WithoutStatus
            }
        }
    
    }
}