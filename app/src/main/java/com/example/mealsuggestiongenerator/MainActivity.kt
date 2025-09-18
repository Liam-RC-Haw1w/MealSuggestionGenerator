package com.example.mealsuggestiongenerator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
// imports needed for the code
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent { // Variable created for timeofday is what the user will input
            var timeOfDay by remember {
                mutableStateOf(value = "")
            }
                   // Variable created for the meal suggestions
            var mealSuggestion by remember {
                mutableStateOf(value = "")
            }

            Column(modifier = Modifier.padding(all= 16.dp)) {
                Text(text = "Meal Generator")
                OutlinedTextField(
                    value = timeOfDay,
                    onValueChange = { text ->
                        timeOfDay = text
                    },
                    label = { // A label so that the user has an example of what to input
                        Text(text ="Enter the time of day currently (Example:Morning")
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp)
                )

                // Buttons style to be next to each other
                // Outcome when a user inputs time of day
                // Generate button created
                Row(
                    modifier = Modifier.padding(vertical = 8.dp),
                    horizontalArrangement = Arrangement.spacedBy(space =8.dp)
                ) {
                    Button(
                        onClick = {
                            mealSuggestion = when (timeOfDay.trim().lowercase()) {
                                "morning" -> "Pancakes or Smoothie"
                                "mid-morning snack" -> "Fruit and yoghurt"
                                "afternoon" -> "Sandwich or Salad"
                                "afternoon snack" -> "Cookies and milk"
                                "dinner" -> "Pasta or Stir Fry"
                                "after dinner snack" -> "Ice cream or Fruit salad"
                                else -> "Please enter the following options: Morning, Mid-morning snack, "+
                                         "Afternoon, Afternoon Snack, Dinner, After Dinner Snack"
                            }
                        }
                    ) { // Button name to get a suggestion
                        Text(text = "Get Suggestion")
                    }
                    // Button created for resetting the text
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

                // Displays the suggestion based on the user input
                Text(text = "Suggestion: $mealSuggestion")
            }
        }
    }
}
