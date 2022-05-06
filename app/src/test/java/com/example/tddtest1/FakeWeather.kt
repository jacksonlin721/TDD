package com.example.tddtest1

class FakeWeather : IWeather {
    var sunny = false

    override fun isSunny(): Boolean {
        return sunny
    }
}