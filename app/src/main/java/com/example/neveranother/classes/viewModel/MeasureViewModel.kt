package com.example.neveranother.classes.viewModel

import androidx.lifecycle.ViewModel
import com.example.neveranother.R
import com.example.neveranother.classes.BhMeasurements

class MeasureViewModel : ViewModel() {

    val measurements = listOf<BhMeasurements>(
        BhMeasurements(1, "Omfang Over Brystet", "Mål dit omfang over den fyldigste del af brystet\n"),
        BhMeasurements(2, "Omfang Under Brystet", "Mål dit omfang lige under brystet."),
        BhMeasurements(3, "Bryst Volumen Type", "Hvilken type bryst er dit bryst"),
        BhMeasurements(4, "Bryst Bredde", "Mål din bryst bredde vandret over brystets fyldigste punkt."),
        BhMeasurements(5, "Bryst Højde", "Mål din brysthøjde lodret over brystets kurve."),
        BhMeasurements(0, "Brug for hjælp?", "Det er ikke meningen man skal kunne læse dette, vi skal videre herfra til anden screen")
    )
}
