package com.ilya.learning

sealed class Status(
    val meaning: String
) {
    object Bad : Status("плохой ученик")
    object Normal : Status("нормальный ученик")
    object Nice : Status("хороший ученик")
    object Excellent : Status("отличный ученик")
    object WithoutStatus : Status("без статуса")
}