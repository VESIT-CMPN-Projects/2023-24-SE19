package com.example.quickfixx.presentation

import android.annotation.SuppressLint
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController

@Composable
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
fun Messages(
    navController: NavController
){
    Surface {
        Scaffold {
            Text(text = "Your messages will appear here")
        }
    }
}