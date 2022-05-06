package com.example.tddtest1

import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.*
import org.mockito.MockitoAnnotations

class TestMainTest {

    @Mock
    lateinit var mockWeather: IWeather
    @Mock
    lateinit var mockEmailUtil : IEmailUtil

    @Before
    fun setUp() {
        MockitoAnnotations.openMocks(this)
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

    @Test
    fun test_totalPriceSunny_with_Mockito() {
        val umbrella = Umbrella()
        // use mock annotation need to comment this
//        val mockWeather = mock(IWeather::class.java)
        `when`(mockWeather.isSunny()).thenReturn(true)

        val actual = umbrella.totalPrice(mockWeather, 1, 600)
        val expect = 540
        println("[test_totalPriceSunny_with_Mockito] actual= $actual")
        Assert.assertEquals(expect, actual)
    }

    @Test
    fun test_insertOrder() {
        val order = Order()
        val userEmail = "xxx@gmail.com"
        val mockEmailUtil = MockEmailUtil()

        order.insertOrder(userEmail, 1, 600, mockEmailUtil)

        Assert.assertEquals(userEmail, mockEmailUtil.receiveEmail)
    }

    @Test
    fun test_insertOrder_with_Mockito() {
        val order = Order()
        val userEmail = "xxx@gmail.com"
        // use mock annotation need to comment this
//        val mockEmailUtil = mock(IEmailUtil::class.java)

        order.insertOrder(userEmail, 1, 600, mockEmailUtil)

        verify(mockEmailUtil).sendCustomer(userEmail)
    }
}