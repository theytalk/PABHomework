package com.example.hw03.task2

open class SmartDevice(val name: String) {
    var status: String = "off"

    open fun turnOn() {
        status = "on"
        println("$name is ON")
    }

    open fun turnOff() {
        status = "off"
        println("$name is OFF")
    }
}

class SmartTvDevice(name: String) : SmartDevice(name) {
    // Bonus (+5 points): Custom setter enforcing 0..100 with private set
    var speakerVolume: Int = 5
        private set(value) {
            if (value in 0..100) {
                field = value
            }
        }

    var channelNumber: Int = 1
        private set

    override fun turnOn() {
        super.turnOn()
        println("TV: display on")
    }

    fun increaseVolume() {
        speakerVolume++
        println("Volume: $speakerVolume")
    }

    fun nextChannel() {
        channelNumber++
        println("Channel: $channelNumber")
    }
}

fun main() {
    val tv = SmartTvDevice("Living Room TV")

    tv.turnOn()
    tv.nextChannel()
    tv.increaseVolume()
    tv.turnOff()

    // Bonus check: Demonstrating private set encapsulation
    // tv.speakerVolume = 50 // Compilation error: Cannot assign to 'speakerVolume': the setter is private
}
