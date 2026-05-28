package com.example.neveranother

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import com.example.neveranother.classes.viewModel.ProfilViewModel
import com.example.neveranother.pages.LoginScreen
import com.example.neveranother.pages.ProfileStartScreen
import org.junit.Test
import com.example.neveranother.classes.viewModel.MeasureViewModel
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue


import org.junit.Assert.*

class Profileunittest {
    //Jonas Mørk Nielsen
    @Test
    fun isLoginOptionOnScreen() {
        val composeTestRule = createComposeRule()
        composeTestRule.setContent {
            ProfileStartScreen(
                navController = rememberNavController(),
                viewModel = ProfilViewModel()
            )
        }
        composeTestRule.onNodeWithText("Login").assertIsDisplayed()
    }


    @Test
    fun isInputAdgangskodeOnScreen() {
        val composeTestRule = createComposeRule()
        composeTestRule.setContent {
            LoginScreen(
                navController = rememberNavController(),
                viewModel = ProfilViewModel()
            )
        }
        composeTestRule.onNodeWithText("Adgangskode").assertIsDisplayed()
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