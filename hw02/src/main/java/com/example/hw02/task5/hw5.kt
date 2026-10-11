package com.example.hw02.task5

fun main() {
    print("Assignment score: ")
    val assignment = readln().toInt()

    print("Exam score: ")
    val exam = readln().toInt()

    // Calculate average using floating-point divisor to avoid truncation
    val average: Double = (assignment + exam) / 2.0

    // Evaluate status using if as an expression
    val status = if (average >= 60.0) "Pass" else "Needs improvement"

    println("Average: $average")
    println("Status: $status")
}
