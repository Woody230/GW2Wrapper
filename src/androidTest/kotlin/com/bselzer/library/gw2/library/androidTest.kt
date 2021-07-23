package com.bselzer.library.gw2.library

import org.junit.Assert.assertTrue
import org.junit.Test

class AndroidGreetingTest {

    @Test
    fun testExample() {
        assertTrue("Check Android is mentioned", Greeting().greeting().contains("Android"))
    }
}