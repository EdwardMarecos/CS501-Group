package com.example.celsiustofahrenheitconverter

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.celsiustofahrenheitconverter.ui.theme.CelsiusToFahrenheitConverterTheme
import java.math.RoundingMode

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CelsiusToFahrenheitConverterTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    SliderScreen(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun SliderScreen(modifier: Modifier = Modifier) {
    var celsius by remember { mutableStateOf(20f) }
    var fahrenheit by remember { mutableStateOf((20f * 9 / 5) + 32) }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Celsius Slider
            Text(text = "Celsius",
                style = MaterialTheme.typography.titleLarge)
            Slider(
                value = celsius,
                onValueChange = {
                    celsius = it
                    fahrenheit = (celsius * 9 / 5) + 32
                },
                valueRange = 0f..100f,
                steps = 100,
                modifier = modifier
            )
            Box(
                modifier = Modifier
                    .padding(start = 300.dp)
                    .border(1.dp, MaterialTheme.colorScheme.primary)
                    .padding(8.dp)
            ) {
                Text(
                    text = "${celsius.toBigDecimal().setScale(2, RoundingMode.UP).toDouble()}°C",
                    textAlign = TextAlign.Right,
                    style = MaterialTheme.typography.labelLarge,
                    modifier = Modifier.fillMaxWidth().padding(end = 16.dp)
                )
            }
            // Fahrenheit Slider
            Text(text = "Fahrenheit",
                modifier = Modifier.padding(top = 100.dp),
                style = MaterialTheme.typography.titleLarge)
            Slider(
                value = fahrenheit,
                onValueChange = {
                    fahrenheit = if (it >= 32f) it else 32f
                    celsius = (fahrenheit - 32) * 5 / 9
                },
                valueRange = 0f..212f,
                steps = 212,
                modifier = modifier
            )
            Box(
                modifier = Modifier
                    .padding(start = 300.dp)
                    .border(1.dp, MaterialTheme.colorScheme.primary)
                    .padding(8.dp)
            ) {
                Text(
                    text = "${fahrenheit.toBigDecimal().setScale(2, RoundingMode.UP).toDouble()}°F",
                    textAlign = TextAlign.Right,
                    style = MaterialTheme.typography.labelLarge,
                    modifier = Modifier.fillMaxWidth().padding(end = 16.dp)
                )
            }
            Text(
                text = if (celsius <= 20) "I wish it were warmer" else "I wish it were colder",
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier.padding(top = 160.dp)
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    CelsiusToFahrenheitConverterTheme {
        SliderScreen()
    }
}