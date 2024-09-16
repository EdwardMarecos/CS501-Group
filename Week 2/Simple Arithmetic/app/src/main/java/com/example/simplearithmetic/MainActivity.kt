@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.simplearithmetic

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
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
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
import com.example.simplearithmetic.ui.theme.SimpleArithmeticTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SimpleArithmeticTheme {
//                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
//                    Calc(
//                        modifier = Modifier.padding(innerPadding)
//                    )
//                }
            }
        }
    }
}

@Composable
fun Calc(
    modifier: Modifier = Modifier,
    input1: String,
    input2: String,
    operation: String,
    onInputChange1: (String) -> Unit,
    onInputChange2: (String) -> Unit,
    onOperationChange: (String) -> Unit,
    onClear: () -> Unit,    // Add a clear action so it looks nice
    output: String
) {
    Column(
        modifier = modifier
            .padding(horizontal = 24.dp, vertical = 12.dp)
            .fillMaxSize(),
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
            value = input1,
            onValueChange = onInputChange1,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Color.White,
                unfocusedBorderColor = Color.White,
                cursorColor = Color.White,
            ),
            label = {
                Text(
                    text = "Input 1",
                    color = Color(0xff023e8a),
                )
            }
        )

        OutlinedTextField(
            value = input2,
            onValueChange = onInputChange2,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Color.White,
                unfocusedBorderColor = Color.White,
                cursorColor = Color.White,
            ),
            label = {
                Text(
                    text = "Input 2",
                    color = Color(0xff023e8a),
                )
            }
        )

        Row(
            modifier = modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalAlignment = Alignment.Top,
        ) {
            Button(
                onClick = { onOperationChange("+") },
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
                )
            }
            Button(
                onClick = { onOperationChange("-") },
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
                onClick = { onOperationChange("%") },
                modifier = Modifier.weight(1f),
                shape = RoundedCornerShape(4.dp),
                contentPadding = PaddingValues(8.dp),
            ) {
                Text(
                    text = "mod",
                    modifier = Modifier.fillMaxWidth(),
                    color = Color.White,
                    fontSize = MaterialTheme.typography.titleLarge.fontSize,
                    textAlign = TextAlign.Center,
                )
            }
        }
        Row(
            modifier = modifier
                .padding(bottom = 8.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalAlignment = Alignment.Top,
        ) {
            Button(
                onClick = { onOperationChange("×") },
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
            Button(
                onClick = { onOperationChange("÷") },
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
            Button(
                onClick = onClear, // Trigger clear action
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF2196F3),
                ),
                modifier = Modifier.weight(1f),
                shape = RoundedCornerShape(4.dp),
                contentPadding = PaddingValues(8.dp),
            ) {
                Text(
                    text = "Clear",
                    modifier = Modifier.fillMaxWidth(),
                    fontSize = MaterialTheme.typography.titleLarge.fontSize,
                    textAlign = TextAlign.Center,
                )
            }
        }
    }
}


fun getOutput(input1: Int, input2: Int, operation: String) : String {
    return when (operation) {
        "+" -> "Result: ${input1 + input2}"
        "-" -> "Result: ${input1 - input2}"
        "×" -> "Result: ${input1 * input2}"
        "÷" -> if (input2 == 0) {
            "Cannot divide by zero \n $input1 ÷ 0 is undefined"
        } else {
            "Result: ${input1 / input2}"
        }
        "%" -> if (input2 == 0) {
            "Cannot divide by zero \n $input1 % 0 is undefined"
        } else { "Result: ${input1 % input2}"
        }
        else -> "Pick an operation"
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun CalcPreview() {
    var input1 by remember { mutableStateOf("") }
    var input2 by remember { mutableStateOf("") }
    val operation = remember { mutableStateOf("") }
    val output = remember { mutableStateOf("Input some numbers to get started") }

    SimpleArithmeticTheme {
        Scaffold(
            modifier = Modifier
                .fillMaxSize(),
            topBar = {
                TopAppBar(
                    title = {
                        Text(
                            text = "Simple Arithmetic",
                            color = Color.White,
                            fontWeight = MaterialTheme.typography.titleLarge.fontWeight,
                            fontFamily = MaterialTheme.typography.titleLarge.fontFamily,
                        )
                    },
                    colors = TopAppBarDefaults.topAppBarColors(
                        containerColor = Color(0xff023e8a)
                    )
                )
            },
            floatingActionButton = {
                // The compute button now uses the state
                Button(
                    onClick = {
                        // Compute result and update the output state
                        output.value = getOutput(
                            input1.toIntOrNull() ?: 0,
                            input2.toIntOrNull() ?: 0,
                            operation.value
                        )
                    },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFF2196F3)
                    ),
                    modifier = Modifier.padding(top = 16.dp)
                ) {
                    Text(
                        text = "\uD83E\uDD16 Compute",
                        modifier = Modifier.padding(vertical = 8.dp),
                        color = Color.White,
                        fontSize = MaterialTheme.typography.titleMedium.fontSize,
                    )
                }
            }
        ) { innerPadding ->
            Calc(
                modifier = Modifier
                    .padding(innerPadding)
                    .background(Color(0xFFBBDEFB)),
                input1 = input1,
                input2 = input2,
                operation = operation.value,
                onInputChange1 = { input1 = it },
                onInputChange2 = { input2 = it },
                onOperationChange = { operation.value = it },
                onClear = {
                    input1 = ""
                    input2 = ""
                    operation.value = ""
                    output.value = "Input some numbers to get started"
                },
                output = output.value
            )
        }
    }
}
