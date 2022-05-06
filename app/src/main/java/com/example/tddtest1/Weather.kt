package com.example.tddtest1

class Weather : IWeather {
    override var sunny: Boolean
        get() = true
        set(value) {}

    override fun isSunny(): Boolean {
        return sunny
    }

}
