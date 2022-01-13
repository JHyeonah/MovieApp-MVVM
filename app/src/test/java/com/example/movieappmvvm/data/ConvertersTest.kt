package com.example.movieappmvvm.data

import org.junit.Assert.assertEquals
import org.junit.Test

class ConvertersTest {

    private val list = arrayListOf("one", "two", "three")
    private val json = "[\"one\",\"two\",\"three\"]"

    @Test fun stringToList() {
        assertEquals(list, MovieConverters().stringToList(json))
    }

    @Test fun listToJson() {
        assertEquals(json, MovieConverters().listToJson(list))
    }
}