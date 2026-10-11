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
}
