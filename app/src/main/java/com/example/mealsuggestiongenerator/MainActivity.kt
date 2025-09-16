package com.example.mealsuggestiongenerator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.mealsuggestiongenerator.ui.theme.MealSuggestionGeneratorTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            var timeOfDay by remember {
                mutableStateOf(value ="")
            }

            var mealSuggestion by remember {
                mutableStateOf(value = "")
            }

            Column {
                Text(text="Meal Generator")
                OutlinedTextField(
                    value = timeOfDay,
                    onValueChange = { text ->
                        timeOfDay = text
                    },
                    label = {
                        Text(text ="Enter the time of day currently (Example:Morning")
                    }
                )

                // This button is the generating button to bring an outcome based on the time of
                // day that was picked
                Button(
                    onClick = {
                        mealSuggestion = when (timeOfDay.trim().lowercase()) {
                            "morning" -> "Pancakes or Smoothie"
                            "mid-morning snack" -> "Fruit and yoghurt"
                            "afternoon" -> "Sandwich or Salad"
                            "afternoon snack" -> "Cookies and milk"
                            "dinner" -> "Pasta or Stir Fry"
                            "after dinner snack" -> "Ice cream or Fruit salad"
                            else -> "No suggestion available"
                        }
                    }
                ) {
                    Text(text = "Get Suggestion")
                }

                // Button for resetting the text
                // Followed on arc video
                Button(
                    onClick = {
                        timeOfDay = ""
                        mealSuggestion = ""
                    }
                ) {
                    Text(text = "Reset")
                }
            }
        }
    }
}

