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

    private var badStudents = mutableListOf<Student>()
    private var normalStudents = mutableListOf<Student>()
    private var niceStudents = mutableListOf<Student>()
    private var excellentStudents = mutableListOf<Student>()
    private var undefinedStudents = mutableListOf<Student>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        
        fillStudentArrays()
        printAllStudents()
    }
    
    private fun fillStudentArrays() {
        fillArray(badStudents, Status.Bad)
        fillArray(normalStudents, Status.Normal)
        fillArray(niceStudents, Status.Nice)
        fillArray(excellentStudents, Status.Excellent)
        fillArray(undefinedStudents, Status.WithoutStatus)
    }
    
    private fun fillArray(studentsArrayWithGivenStatus: MutableList<Student>, givenStatus: Status) {
        students.forEach  { student ->
            if (student.status == givenStatus) studentsArrayWithGivenStatus.add(student)
        }
    }
    
    private fun printAllStudents() {
        printStudents(badStudents)
        printStudents(normalStudents)
        printStudents(niceStudents)
        printStudents(excellentStudents)
        printStudents(undefinedStudents)
    }
    
    private fun printStudents(students: MutableList<Student>) {
        students.forEach { studentInfo ->
            Log.d("msg", "${studentInfo.name} ${studentInfo.status.meaning}: оценка ${studentInfo.grade}")
        }
    }

}