package com.example.neveranother

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.neveranother.pages.Homescreen
import com.example.neveranother.viewModel.neverAnotherViewModel
import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }
    @Test
    fun isBuyOnScreen() {
        val composeTestRule = createComposeRule()
        composeTestRule.setContent {
            Homescreen(navController = rememberNavController(), viewModel = neverAnotherViewModel())
        }
        composeTestRule.onNodeWithText("Buy").assertIsDisplayed()
    }
}