package com.example.hw02.task2

fun checkDeadlineStatus(daysRemaining: Int) {
    if (daysRemaining < 0) {
        println("Overdue")
    } else if (daysRemaining == 0) {
        println("Due today")
    } else {
        println("Upcoming")
    }
}

fun printMonthName(month: Int) {
    val monthName = when (month) {
        1 -> "January"
        2 -> "February"
        3 -> "March"
        4 -> "April"
        5 -> "May"
        6 -> "June"
        7 -> "July"
        8 -> "August"
        9 -> "September"
        10 -> "October"
        11 -> "November"
        12 -> "December"
        else -> "Invalid month"
    }
    println("Month $month: $monthName")
}

fun main() {
    // --- Part A: Deadline Status ---
    // Test cases: -1, 0, 2
    checkDeadlineStatus(-1)
    checkDeadlineStatus(0)
    checkDeadlineStatus(2)

    // --- Part B: Month Name via when ---
    // Test cases: 9 and 13
    printMonthName(9)
    printMonthName(13)
}
