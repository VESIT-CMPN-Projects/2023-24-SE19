package com.example.quickfixx

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.quickfixx.navigation.AppNavigation
import com.example.quickfixx.screens.auth.WelcomePageScreen
import com.example.quickfixx.ui.theme.QuickFixxTheme
import com.google.firebase.FirebaseApp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        FirebaseApp.initializeApp(this)
        setContent {
            QuickFixxTheme {
                AppNavigation()
            }
        }
    }
}





//@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    QuickFixxTheme {

    }
}