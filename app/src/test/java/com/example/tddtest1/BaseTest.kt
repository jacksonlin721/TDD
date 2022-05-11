package com.example.tddtest1

import org.junit.*
import org.junit.Assert.*

class BaseTest {
    companion object {
        @BeforeClass
        @JvmStatic
        fun beforeClass() {
            println("code execute before the first test method")
        }

        @AfterClass
        @JvmStatic
        fun afterClass() {
            println("code execute after the last test method")
        }
    }

    @Before
    fun setUp() {

    }

    @Test
    fun test_main() {
        val testMain = TestMain()
        val expect = 3
        val actual = testMain.add(1, 2)
        assertEquals(expect, actual)
    }

    @Test
    fun test() {
        val a = 1
        val b = 1
        val c = 1f
        val temp = null
        val array1 = Array(1){"1"}
        val array2 = Array(1){"1"}

        assertEquals(a, b)
        assertNotEquals(a, c)
        assertTrue(a == b)
        assertNull(temp)
        assertArrayEquals(array1, array2)
    }

    @After
    fun tearDown() {
        println("code execute after each test")
    }

}