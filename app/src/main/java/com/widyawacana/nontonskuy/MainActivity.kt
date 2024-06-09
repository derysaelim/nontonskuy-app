package com.widyawacana.nontonskuy

import PageRegister
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.widyawacana.nontonskuy.ui.presentasion.jadwalnonton.JadwalPengingat
import com.widyawacana.nontonskuy.ui.presentasion.login.LoginScreen
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
                        JadwalPengingat()
                    }
                }
            }
        }
    }

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    NontonskuyappTheme{
        JadwalPengingat()
    }
}