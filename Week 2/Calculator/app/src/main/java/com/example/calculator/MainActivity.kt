@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.calculator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.calculator.ui.theme.CalculatorTheme
import kotlin.math.sqrt

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CalculatorTheme {
//                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
//                    Greeting(
//                        name = "Android",
//                        modifier = Modifier.padding(innerPadding)
//                    )
//                }
            }
        }
    }
}

@Composable
fun Calculator(modifier: Modifier = Modifier) {
    var input1 by remember { mutableStateOf("") }
    var input2 by remember { mutableStateOf("0") }
    var operation by remember { mutableStateOf("")}
    var output by remember { mutableStateOf("") }

    Column (
        modifier = modifier
            .fillMaxSize()
            .padding(horizontal = 24.dp, vertical = 12.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        Text(
            text = output,
            modifier = modifier
                .padding(bottom = 8.dp),
            textAlign = TextAlign.Center,
            color = Color(0xff023e8a),
            fontSize = MaterialTheme.typography.titleLarge.fontSize,
            fontWeight = FontWeight.Bold
        )

        OutlinedTextField(
            value = input2,
            onValueChange = {input2 = it},
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier
                .fillMaxWidth(),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Color.White,
                unfocusedBorderColor = Color.White,
                cursorColor = Color.White,
            ),
            label = {
                Text(
                    text = "$input1$operation",
                    color = Color(0xff023e8a),
                    textAlign = TextAlign.Right
                )
            }
        )
        //row one of the calc
        Row (
            modifier = modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalAlignment = Alignment.Top,
        ) {
            Button(
                onClick = {
                    input2 = if (input2 == "0") "1" else input2 + "1"
                },
                modifier = Modifier.weight(1f),
                shape = RoundedCornerShape(4.dp),
                contentPadding = PaddingValues(8.dp),
            ) {
                Text(
                    text = "1",
                    modifier = Modifier.fillMaxWidth(),
                    color = Color.White,
                    fontSize = MaterialTheme.typography.titleLarge.fontSize,
                    textAlign = TextAlign.Center,
                )
            }
            Button(
                onClick = {
                    input2 = if (input2 == "0") "2" else input2 + "2"
                },
                modifier = Modifier.weight(1f),
                shape = RoundedCornerShape(4.dp),
                contentPadding = PaddingValues(8.dp),
            ) {
                Text(
                    text = "2",
                    modifier = Modifier.fillMaxWidth(),
                    color = Color.White,
                    fontSize = MaterialTheme.typography.titleLarge.fontSize,
                    textAlign = TextAlign.Center,
                )
            }
            Button(
                onClick = {
                    input2 = if (input2 == "0") "3" else input2 + "3"
                },
                modifier = Modifier.weight(1f),
                shape = RoundedCornerShape(4.dp),
                contentPadding = PaddingValues(8.dp),
            ) {
                Text(
                    text = "3",
                    modifier = Modifier.fillMaxWidth(),
                    color = Color.White,
                    fontSize = MaterialTheme.typography.titleLarge.fontSize,
                    textAlign = TextAlign.Center,
                )
            }
            Button(
                onClick = {
                    if (input1.isEmpty()) {
                        input1 = input2
                        input2 = "0"
                        operation = " +"
                    }
                },
                modifier = Modifier.weight(1f),
                shape = RoundedCornerShape(4.dp),
                contentPadding = PaddingValues(8.dp),
            ) {
                Text(
                text = "+",
                modifier = Modifier.fillMaxWidth(),
                color = Color.White,
                fontSize = MaterialTheme.typography.titleLarge.fontSize,
                textAlign = TextAlign.Center,
            )}
            Button(
                onClick = {
                    if (input1.isEmpty()) {
                        input1 = input2
                        input2 = "0"
                        operation = " ×"
                    }
                },
                modifier = Modifier.weight(1f),
                shape = RoundedCornerShape(4.dp),
                contentPadding = PaddingValues(8.dp),
            ) {
                Text(
                    text = "×",
                    modifier = Modifier.fillMaxWidth(),
                    color = Color.White,
                    fontSize = MaterialTheme.typography.titleLarge.fontSize,
                    textAlign = TextAlign.Center,
                )
            }

        }
        // row two of the calc
        Row (
            modifier = modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalAlignment = Alignment.Top,
        ) {
            Button(
                onClick = {
                    input2 = if (input2 == "0") "4" else input2 + "4"
                },
                modifier = Modifier.weight(1f),
                shape = RoundedCornerShape(4.dp),
                contentPadding = PaddingValues(8.dp),
            ) {
                Text(
                text = "4",
                modifier = Modifier.fillMaxWidth(),
                color = Color.White,
                fontSize = MaterialTheme.typography.titleLarge.fontSize,
                textAlign = TextAlign.Center,
            ) }
            Button(
                onClick = {
                    input2 = if (input2 == "0") "5" else input2 + "5"
                },
                modifier = Modifier.weight(1f),
                shape = RoundedCornerShape(4.dp),
                contentPadding = PaddingValues(8.dp),
            ) {
                Text(
                    text = "5",
                    modifier = Modifier.fillMaxWidth(),
                    color = Color.White,
                    fontSize = MaterialTheme.typography.titleLarge.fontSize,
                    textAlign = TextAlign.Center,
                )
            }
            Button(
                onClick = {
                    input2 = if (input2 == "0") "6" else input2 + "6"
                },
                modifier = Modifier.weight(1f),
                shape = RoundedCornerShape(4.dp),
                contentPadding = PaddingValues(8.dp),
            ) {
                Text(
                    text = "6",
                    modifier = Modifier.fillMaxWidth(),
                    color = Color.White,
                    fontSize = MaterialTheme.typography.titleLarge.fontSize,
                    textAlign = TextAlign.Center,
                )
            }
            Button(
                onClick = {
                    if (input1.isEmpty()) {
                        input1 = input2
                        input2 = "0"
                        operation = " -"
                    }
                },
                modifier = Modifier.weight(1f),
                shape = RoundedCornerShape(4.dp),
                contentPadding = PaddingValues(8.dp),
            ) {
                Text(
                    text = "-",
                    modifier = Modifier.fillMaxWidth(),
                    color = Color.White,
                    fontSize = MaterialTheme.typography.titleLarge.fontSize,
                    textAlign = TextAlign.Center,
                )
            }
            Button(
                onClick = {
                    if (input1.isEmpty()) {
                        input1 = input2
                        input2 = "0"
                        operation = " ÷"
                    }
                },
                modifier = Modifier.weight(1f),
                shape = RoundedCornerShape(4.dp),
                contentPadding = PaddingValues(8.dp),
            ) {
                Text(
                    text = "÷",
                    modifier = Modifier.fillMaxWidth(),
                    color = Color.White,
                    fontSize = MaterialTheme.typography.titleLarge.fontSize,
                    textAlign = TextAlign.Center,
                )
            }

        }
        // row three of the calc
        Row (
            modifier = modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalAlignment = Alignment.Top,
        ) {
            Button(
                onClick = { input2 = if (input2 == "0") "7" else input2 + "7" },
                modifier = Modifier.weight(1f),
                shape = RoundedCornerShape(4.dp),
                contentPadding = PaddingValues(8.dp),
            ) {
                Text(
                    text = "7",
                    modifier = Modifier.fillMaxWidth(),
                    color = Color.White,
                    fontSize = MaterialTheme.typography.titleLarge.fontSize,
                    textAlign = TextAlign.Center,
                )
            }
            Button(
                onClick = {
                    input2 = if (input2 == "0") "8" else input2 + "8"
                },
                modifier = Modifier.weight(1f),
                shape = RoundedCornerShape(4.dp),
                contentPadding = PaddingValues(8.dp),
            ) {
                Text(
                    text = "8",
                    modifier = Modifier.fillMaxWidth(),
                    color = Color.White,
                    fontSize = MaterialTheme.typography.titleLarge.fontSize,
                    textAlign = TextAlign.Center,
                )
            }
            Button(
                onClick = {
                    input2 = if (input2 == "0") "9" else input2 + "9"
                },
                modifier = Modifier.weight(1f),
                shape = RoundedCornerShape(4.dp),
                contentPadding = PaddingValues(8.dp),
            ) {
                Text(
                    text = "9",
                    modifier = Modifier.fillMaxWidth(),
                    color = Color.White,
                    fontSize = MaterialTheme.typography.titleLarge.fontSize,
                    textAlign = TextAlign.Center,
                )
            }
            Button(
                onClick = {
                    if (input1.isEmpty()) {
                        if (input2.toDouble() < 0) {
                            output = "Sorry, square root for negative numbers is not supported"
                        }
                        else {
                            output = sqrt(input2.toDouble()).toString()
                            input2 = "0"
                        }
                    } else {
                        output = "Sorry you can only do one operation at a time"
                    }
                },
                modifier = Modifier.weight(2f),
                shape = RoundedCornerShape(4.dp),
                contentPadding = PaddingValues(8.dp),
            ) {
                Text(
                    text = "√",
                    modifier = Modifier.fillMaxWidth(),
                    color = Color.White,
                    fontSize = MaterialTheme.typography.titleLarge.fontSize,
                    textAlign = TextAlign.Center,
                )
            }

        }
        // row four of the calc
        Row (
            modifier = modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalAlignment = Alignment.Top,
        ) {
            Button(
                onClick = {
                    input2 = if (input2 == "0") input2 else input2 + "0"
                },
                modifier = Modifier.weight(2f),
                shape = RoundedCornerShape(4.dp),
                contentPadding = PaddingValues(8.dp),
            ) {
                Text(
                    text = "0",
                    modifier = Modifier.fillMaxWidth(),
                    color = Color.White,
                    fontSize = MaterialTheme.typography.titleLarge.fontSize,
                    textAlign = TextAlign.Center,
                )
            }

            Button(
                onClick = {
                    input2 += "."
                },
                modifier = Modifier.weight(1f),
                shape = RoundedCornerShape(4.dp),
                contentPadding = PaddingValues(8.dp),
            ) {
                Text(
                    text = ".",
                    modifier = Modifier.fillMaxWidth(),
                    color = Color.White,
                    fontSize = MaterialTheme.typography.titleLarge.fontSize,
                    textAlign = TextAlign.Center,
                )
            }
            Button(
                onClick = {
                    if (input1.isNotEmpty() && input2.isNotEmpty()) {
                        output = calculateResult(input1, input2, operation)

                        // Only reset input1 and input2 if the output is not an error
                        if (!output.startsWith("Error")) {
                            input1 = ""
                            input2 = "0"
                            operation = ""
                        }
                    }
                },
                modifier = Modifier.weight(2f),
                shape = RoundedCornerShape(4.dp),
                contentPadding = PaddingValues(8.dp),
            ) {
                Text(
                    text = "=",
                    modifier = Modifier.fillMaxWidth(),
                    color = Color.White,
                    fontSize = MaterialTheme.typography.titleLarge.fontSize,
                    textAlign = TextAlign.Center,
                )
            }

        }
    }
}

fun calculateResult(input1: String, input2: String, operation: String): String {

    return try {
        val num1 = input1.toDouble()
        val num2 = input2.toDouble()
        val result = when (operation.trim()) { // Use trim to remove any leading spaces
            "+" -> num1 + num2
            "-" -> num1 - num2
            "×" -> num1 * num2
            "÷" -> if (num2 != 0.0) num1 / num2 else return "Error: You cannot divide by zero"
            else -> return "Error: That operation is not supported"
        }
        result.toString()
    } catch (e: NumberFormatException) {
        "Error: Invalid Number Format"
    }
}


@Preview(showBackground = true)
@Composable
fun CalculatorPreview() {
    CalculatorTheme {
        Scaffold(
            modifier = Modifier
                .fillMaxSize()
        ) { innerPadding ->
            Calculator(
                modifier = Modifier
                    .background(Color(0xFFBBDEFB))
                    .padding(innerPadding),
            )
        }
    }
}