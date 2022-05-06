package com.example.tddtest1

class TestMain {

    fun totalPrice() {
        val umbrella = Umbrella()
        val totalPrice = umbrella.totalPrice(weather = Weather(), 1, 600)
        println("totalPrice:$totalPrice")
    }
}