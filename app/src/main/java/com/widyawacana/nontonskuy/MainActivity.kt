package com.widyawacana.nontonskuy

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.widyawacana.nontonskuy.ui.presentasion.alarm.AlarmScreen
import com.widyawacana.nontonskuy.ui.theme.NontonskuyappTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NontonskuyappTheme {
                    // A surface container using the 'background' color from the theme
                    Surface(
                        modifier = Modifier.fillMaxSize(),
                        color = MaterialTheme.colorScheme.background
                    ) {
                        AlarmScreen()
                    }
                }
            }
        }
    }

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    NontonskuyappTheme{
        AlarmScreen()
    }
}