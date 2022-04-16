package com.example.sampleproject

import java.util.*

object Dates {
    private var dates: Vector<String>?= null

    fun setDates(dates: Vector<String>){
        this.dates = dates
    }
    fun getDates(): Vector<String>?{
        return this.dates
    }
}