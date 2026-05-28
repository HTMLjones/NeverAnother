package com.example.neveranother

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.neveranother.classes.viewModel.ProfilViewModel
import com.example.neveranother.pages.LoginScreen
import com.example.neveranother.pages.ProfileStartScreen
import org.junit.Test
import com.example.neveranother.classes.viewModel.MeasureViewModel
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue


import org.junit.Assert.*
import org.junit.Rule
//Jonas Mørk Nielsen
class ProfileUnitTest {

    @Test
    fun isEmailOnScreen() {
        val viewModel = ProfilViewModel()
        viewModel.email = "email@gmail.com"
        assertEquals("email@gmail.com", viewModel.email)
    }

    @Test
    fun profilViewModel_adgangskodeStarterSomTomt() {
        val viewModel = ProfilViewModel()
        viewModel.adgangskode = "adgangskode123"
        assertEquals("adgangskode123", viewModel.adgangskode)
    }
}

//Jannik

class MeasureUnitTest {

    @Test
    fun measureViewModelcontains6measurements() {

        val viewModel = MeasureViewModel()

        val amount = viewModel.measurements.size

        assertEquals(6, amount)
    }


    @Test
    fun firstmeasurementisOmfangOverBrystet() {

        val viewModel = MeasureViewModel()

        val firstMeasurement =
            viewModel.measurements.first().measurementName

        assertEquals(
            "Omfang Over Brystet",
            firstMeasurement
        )
    }


    @Test
    fun measurementvaluesstartempty() {

        val viewModel = MeasureViewModel()

        val empty =
            viewModel.measurements.all {
                it.measurementValue?.value!!.isEmpty()
            }

        assertEquals(true, empty)
    }


    @Test
    fun Measurementlistisnotempty() {

        val viewModel = MeasureViewModel()

        val hasMeasurements =
            viewModel.measurements.isNotEmpty()

        assertTrue(hasMeasurements)
    }
}