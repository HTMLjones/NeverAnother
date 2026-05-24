package com.example.neveranother.classes

import androidx.compose.runtime.MutableState

//Simon
data class BhMeasurements(
    val measurementId: Int,
    val measurementName: String,
    val measurementDescription: String,
    val image: Int,
    var measurementValue: MutableState<String>? = null
) {
    fun getMeasurementValue(): String {
        return measurementValue?.value.orEmpty()
    }
    
    fun setMeasurementValue(value: String) {
        measurementValue?.value = value
    }
}
