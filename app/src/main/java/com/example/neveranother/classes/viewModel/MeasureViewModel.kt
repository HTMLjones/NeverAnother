package com.example.neveranother.classes.viewModel

import androidx.lifecycle.ViewModel
import com.example.neveranother.R
import com.example.neveranother.classes.BhMeasurements

class MeasureViewModel : ViewModel() {

    val measurements = listOf<BhMeasurements>(
        BhMeasurements(1, "Omfang Over Brystet"),
        BhMeasurements(2, "Omfang Under Brystet"),
        BhMeasurements(3, "Bryst Volumen Type"),
        BhMeasurements(4, "Bryst Bredde"),
        BhMeasurements(5, "Bryst Højde"),
        BhMeasurements(0, "Brug for hjælp?")
    )
}
