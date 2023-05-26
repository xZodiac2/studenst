package com.ilya.learning

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private val studentsArray = listOf(
        Student("Антон", 4),
        Student("Егор", 7),
        Student("Маша", 3),
        Student("Светлана", 6),
        Student("Юля", 10),
        Student("Семён", 2),
        Student("Почему", -1)
    )

    private var badStudents = mutableListOf<Student>()
    private var normalStudents = mutableListOf<Student>()
    private var niceStudents = mutableListOf<Student>()
    private var excellentStudents = mutableListOf<Student>()
    private var undefinedStudents = mutableListOf<Student>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        studentsArray.forEach { student ->
            when (student.grade) {
                in Grade.Bad.gradeRange -> student.status = Status.Bad
                in Grade.Normal.gradeRange -> student.status = Status.Normal
                in Grade.Nice.gradeRange -> student.status = Status.Nice
                Grade.Excellent.grade -> student.status = Status.Excellent
                else -> student.status = Status.NullStatus
            }
        }

        fillArray(badStudents, Status.Bad)
        fillArray(normalStudents, Status.Normal)
        fillArray(niceStudents, Status.Nice)
        fillArray(excellentStudents, Status.Excellent)
        fillArray(undefinedStudents, Status.NullStatus)


        printStudents(badStudents)
        printStudents(normalStudents)
        printStudents(niceStudents)
        printStudents(excellentStudents)
        printStudents(undefinedStudents)

    }

    private fun fillArray(studentsArrayWithStatus: MutableList<Student>, necessaryStatus: Status) {
        studentsArray.forEach  { student ->
            if (student.status.meaning == necessaryStatus.meaning) studentsArrayWithStatus.add(student)
        }
    }

    private fun printStudents(students: MutableList<Student>) {
        students.forEach { studentInfo ->
            Log.d("msg", "${studentInfo.name} ${studentInfo.status.meaning}: оценка ${studentInfo.grade}")
        }
    }

}