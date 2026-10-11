package com.example.hw03.task3

fun testStudent(studentName: String?) {

    println("Length: ${studentName?.length}")

    println("Name: ${studentName ?: "Unknown"}")

    studentName?.let {
        println("Hello, $it!")
    }
}

fun main() {

    var studentName: String? = null
    testStudent(studentName)

    studentName = "Ayu"
    testStudent(studentName)
}
