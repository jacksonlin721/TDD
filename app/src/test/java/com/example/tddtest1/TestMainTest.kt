package com.example.tddtest1

import org.junit.Assert
import org.junit.Before
import org.junit.Test
import kotlin.math.exp

class TestMainTest {

    @Before
    fun setUp() {

    }

    @Test
    fun test_totalPriceSunny() {
        val umbrella = Umbrella()
        val fakeWeather = FakeWeather()
        fakeWeather.sunny = true

        val actual = umbrella.totalPrice(fakeWeather, 1, 600)
        val expect = 540
        println("[test_totalPriceSunny] actual= $actual")
        Assert.assertEquals(expect, actual)
    }
}