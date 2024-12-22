package com.example.example

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.example.ui.theme.ExampleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent{
            MyApp()
        }
    }
}

@Composable
fun MyApp() {
    MaterialTheme {
        Surface (modifier = Modifier.fillMaxSize()){
            GreetingScreen()
        }
    }
}

@Composable
fun GreetingScreen(){
    var greeting by remember { mutableStateOf("Witaj w Jetpack Compose!") }
    var clickCount by remember { mutableStateOf(0) }

    Column(
        modifier = Modifier.fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally

    ) {
        Text(text = greeting,
            fontSize = 24.sp,
            modifier = Modifier.padding(bottom = 16.dp)
        )
        Text(
            text = "Kliknięcia $clickCount",
            fontSize = 20.sp,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        Button(onClick = {
            greeting = "Witaj ponownie"
            clickCount++
        }){
            Text(text = "Kliknij mnie!")
        }

    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ExampleTheme {
       MyApp()
    }
}