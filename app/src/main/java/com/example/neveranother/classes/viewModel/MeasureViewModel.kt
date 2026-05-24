package com.example.neveranother.classes.viewModel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.neveranother.R
import com.example.neveranother.classes.BhMeasurements

//Simon
class MeasureViewModel : ViewModel() {

    val measurements = listOf<BhMeasurements>(
        BhMeasurements(
            measurementId = 1,
            measurementName = "Omfang Over Brystet",
            measurementDescription = "Mål dit omfang over den fyldigste del af brystet.",
            image = R.drawable.uppercircumference,
            measurementValue = mutableStateOf("")
        ), BhMeasurements(
            measurementId = 2,
            measurementName = "Omfang Under Brystet",
            measurementDescription = "Mål dit omfang lige under brystet.",
            image = R.drawable.lowercircumference,
            measurementValue = mutableStateOf("")
        ), BhMeasurements(
            measurementId = 3,
            measurementName = "Bryst Volumen Type",
            measurementDescription = "Vælg den type som passer bedst til din brystform.",
            image = R.drawable.volumetyperesized,
            measurementValue = mutableStateOf("")
        ), BhMeasurements(
            measurementId = 4,
            measurementName = "Bryst Bredde",
            measurementDescription = "Mål vandret over brystets fyldigste punkt.",
            image = R.drawable.breastspan,
            measurementValue = mutableStateOf("")
        ), BhMeasurements(
            measurementId = 5,
            measurementName = "Bryst Højde",
            measurementDescription = "Mål lodret over brystets naturlige kurve.",
            image = R.drawable.breastheight,
            measurementValue = mutableStateOf("")
        ), BhMeasurements(
            measurementId = 6,
            measurementName = "Brug for hjælp?",
            measurementDescription = "Det er ikke meningen vi skal se dette, her skal vi videre til guide.",
            image = R.drawable.personicon,
            measurementValue = mutableStateOf("")
        )
    )

}
