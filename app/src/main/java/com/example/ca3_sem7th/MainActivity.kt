package com.example.ca3_sem7th

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.foundation.layout.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

class WorkoutViewModel : ViewModel() {

    var count by mutableIntStateOf(0)
        private set

    fun increment() {
        count++
    }

    fun reset() {
        count = 0
    }
}

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MaterialTheme {
                WorkoutApp()
            }
        }
    }
}
@Composable
fun WorkoutApp(vm: WorkoutViewModel = viewModel()) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Text(
            text = "Workout Rep Counter",
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(modifier = Modifier.height(30.dp))

        Text(
            text = "Reps: ${vm.count}",
            style = MaterialTheme.typography.headlineLarge
        )

        Spacer(modifier = Modifier.height(20.dp))

        Button(onClick = { vm.increment() }) {
            Text("Increment")
        }

        Spacer(modifier = Modifier.height(10.dp))

        Button(onClick = { vm.reset() }) {
            Text("Reset")
        }
    }
}
