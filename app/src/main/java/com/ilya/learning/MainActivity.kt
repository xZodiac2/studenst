package com.ilya.learning

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private val students = listOf(
        Student("Антон", 4),
        Student("Егор", 7),
        Student("Маша", 3),
        Student("Светлана", 6),
        Student("Юля", 10),
        Student("Семён", 2),
        Student("Почему", -1)
    )

    private val ratedStudents = mutableMapOf<Student, Status>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    
        students.forEach { student ->
            ratedStudents[student] = Status.defineStudentStatus(student)
        }
        
        ratedStudents.forEach { student, status ->
            Log.d("msg", "${student.name} ${status.meaning}: оценка ${student.grade}")
        }
    }

}