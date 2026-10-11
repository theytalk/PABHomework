package com.example.hw03.task4

import com.example.hw03.task1.SmartDevice

fun showInfo(data: Any) {
    when (data) {
        is String -> println(data.length)
        is Int -> println(data * 2)
        is SmartDevice -> println(data.name)
        else -> println("Unknown")
    }
}

fun main() {
    showInfo("Kotlin")
    showInfo(10)
    showInfo(3.14)
}
