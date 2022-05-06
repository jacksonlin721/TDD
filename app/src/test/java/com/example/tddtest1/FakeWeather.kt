package com.example.tddtest1

class FakeWeather : IWeather {
    override var sunny = false

    override fun isSunny(): Boolean {
        return sunny
    }
}