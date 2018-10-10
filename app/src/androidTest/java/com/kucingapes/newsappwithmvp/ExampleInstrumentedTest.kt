/*
 * ExampleInstrumentedTest.kt on NewsAppwithMVP
 * Developed by Muhammad Utsman on 10/10/18 12:22 PM
 * Last modified 10/10/18 9:50 AM
 * Copyright (c) 2018 kucingapes
 */

package com.kucingapes.newsappwithmvp

import androidx.test.InstrumentationRegistry
import androidx.test.runner.AndroidJUnit4

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {
    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getTargetContext()
        assertEquals("com.kucingapes.newsappwithmvp", appContext.packageName)
    }
}
