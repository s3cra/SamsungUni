package com.example.ilearncomposehere

import androidx.activity.ComponentActivity
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*
import org.junit.Rule

//Задание 9
@RunWith(AndroidJUnit4::class)
class UITest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<ComponentActivity>()

    @Test
    fun buttonAddsLiquid() {
        composeTestRule.setContent {
            WaterTracker()
        }

        composeTestRule.onNodeWithText("+250 мл").assertExists()
        composeTestRule.onNodeWithText("+250 мл").performClick().performClick()
        composeTestRule.onNodeWithText("500 мл").assertExists()
    }

    @Test
    fun buttonFinishesDay() {
        composeTestRule.setContent {
            WaterTracker()
        }
        composeTestRule.onNodeWithText("+250 мл").performClick().performClick()
        composeTestRule.onNodeWithText("Завершить день").performClick()
        composeTestRule.onNodeWithText("0 мл").assertExists()
    }

    @Test
    fun daysCount() {
        composeTestRule.setContent {
            WaterTracker()
        }
        repeat(6){
            composeTestRule.onNodeWithText("+250 мл").performClick()
        }
        composeTestRule.onNodeWithText("Завершить день").performClick()
        composeTestRule.onNodeWithText("1 день").assertExists()
        repeat(6){
            composeTestRule.onNodeWithText("+250 мл").performClick()
        }
        composeTestRule.onNodeWithText("Завершить день").performClick()
        composeTestRule.onNodeWithText("2 дня").assertExists()
        composeTestRule.onNodeWithText("Завершить день").performClick()
        composeTestRule.onNodeWithText("0 дней").assertExists()
    }
}