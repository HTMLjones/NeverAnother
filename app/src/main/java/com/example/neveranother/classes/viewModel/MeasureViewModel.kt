package com.example.neveranother.classes.viewModel

import androidx.compose.runtime.mutableStateMapOf
import androidx.lifecycle.ViewModel
import com.example.neveranother.R
import com.example.neveranother.classes.BhMeasurements

class MeasureViewModel : ViewModel() {

    // Gemmer brugerens input per måling (nøgle = measurementId)
    val measurementValues = mutableStateMapOf<Int, String>()

    val measurements = listOf<BhMeasurements>(
        BhMeasurements(
            measurementId = 1,
            measurementName = "Omfang Over Brystet",
            measurementDescription = "Mål dit omfang over den fyldigste del af brystet.",
            image = R.drawable.homeicon
        ),
        BhMeasurements(
            measurementId = 2,
            measurementName = "Omfang Under Brystet",
            measurementDescription = "Mål dit omfang lige under brystet.",
            image = R.drawable.carticon
        ),
        BhMeasurements(
            measurementId = 3,
            measurementName = "Bryst Volumen Type",
            measurementDescription = "Vælg den type som passer bedst til din brystform.",
            image = R.drawable.personicon
        ),
        BhMeasurements(
            measurementId = 4,
            measurementName = "Bryst Bredde",
            measurementDescription = "Mål vandret over brystets fyldigste punkt.",
            image = R.drawable.homeicon
        ),
        BhMeasurements(
            measurementId = 5,
            measurementName = "Bryst Højde",
            measurementDescription = "Mål lodret over brystets naturlige kurve.",
            image = R.drawable.carticon
        ),
        BhMeasurements(
            measurementId = 6,
            measurementName = "Brug for hjælp?",
            measurementDescription = "Det er ikke meningen vi skal se dette, her skal vi videre til guide.",
            image = R.drawable.personicon
        )
    )
}
