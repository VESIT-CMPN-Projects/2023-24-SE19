package com.example.quickfixx.screens.auth

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowBackIos
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.rounded.Password
import androidx.compose.material.icons.rounded.Phone
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.quickfixx.navigation.Screens
import java.time.format.TextStyle


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OTPScreen2(navController: NavController) {
    var digit1 by remember { mutableStateOf("") }
    var digit2 by remember { mutableStateOf("") }
    var digit3 by remember { mutableStateOf("") }
    var digit4 by remember { mutableStateOf("") }
    var otp by remember { mutableStateOf("____") }
    val isOtpComplete = digit1.isNotBlank() && digit2.isNotBlank() && digit3.isNotBlank() && digit4.isNotBlank()
    Button(
        onClick = {
            navController.navigate(Screens.OTPScreen2.route)
        },
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        enabled = otp.contains("_").not()
    ) {
        Text("Verify OTP")
    }

    Row(
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        BoxForOtp(otp) { newValue ->
            otp = newValue
        }
    }
}
@ExperimentalMaterial3Api
@Composable
fun BoxForOtp(value: String, onValueChange: (String) -> Unit) {
    TextField(
        value = value,
        onValueChange = { newValue ->
            if (newValue.length <= 4) {
                onValueChange(newValue.take(4) + "____".drop(newValue.length))
            }
        },
        keyboardOptions = KeyboardOptions.Default.copy(
            keyboardType = KeyboardType.Number
        ),
        singleLine = true,
        modifier = Modifier
            .width(240.dp)
            .padding(4.dp),
        textStyle = androidx.compose.ui.text.TextStyle(fontSize = 24.sp),
        maxLines = 1
    )
}






