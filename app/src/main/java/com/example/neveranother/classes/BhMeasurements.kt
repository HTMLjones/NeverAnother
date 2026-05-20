package com.example.neveranother.classes

data class BhMeasurements(
    val measurementId: Int,
    val measurementName: String,
    val measurementDescription: String,
    val image: Int,
    var measurementValue: Double? = null
)
