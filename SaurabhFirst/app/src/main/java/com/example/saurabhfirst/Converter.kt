package com.example.saurabhfirst

object Converter {

    fun convertMeterToKm(meters:Double):Double{
        return meters/1000
    }

    fun convertKmToMeter(km:Double):Double{
        return km*1000
    }

    fun convertMeterToCm(meter:Double):Double{
        return meter*100
    }
}