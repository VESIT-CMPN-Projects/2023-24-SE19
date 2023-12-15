package com.example.quickfixx.screens.auth

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowBackIos
import androidx.compose.material.icons.filled.CalendarMonth
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.rounded.Phone
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.quickfixx.navigation.Screens

@Composable
fun ElectricianData(navController: NavController) {
    Column {
        Text(text = "Name: Raju Rajbhar     Contact No:9845354125 ", modifier = Modifier.padding(8.dp))
        Text(text = "Experience:3 Years      Location:10 minutes ", modifier = Modifier.padding(8.dp))
        CombinedButton(navController)
        Divider(modifier = Modifier.fillMaxWidth(), color = Color.Black, thickness = 1.dp)
        Text(text = "Name: Suresh Jain      Contact No:8451534684 ", modifier = Modifier.padding(8.dp))
        Text(text = "Experience:1 Years      Location:17 minutes ", modifier = Modifier.padding(8.dp))
        CombinedButton(navController)
        Divider(modifier = Modifier.fillMaxWidth(), color = Color.Black, thickness = 1.dp)
        Text(text = "Name: Prashant Rai     Contact No:7564215987 ", modifier = Modifier.padding(8.dp))
        Text(text = "Experience:1 Years      Location:25 minutes ", modifier = Modifier.padding(8.dp))
        CombinedButton(navController)
        Divider(modifier = Modifier.fillMaxWidth(), color = Color.Black, thickness = 1.dp)
        Text(text = "Name: Amit Shah        Contact No:7543265145 ", modifier = Modifier.padding(8.dp))
        Text(text = "Experience:5 Years      Location:45 minutes ", modifier = Modifier.padding(8.dp))
        CombinedButton(navController)
        Divider(modifier = Modifier.fillMaxWidth(), color = Color.Black, thickness = 1.dp)
        Text(text = "Name: Santosh Jain     Contact No:9453651265 ", modifier = Modifier.padding(8.dp))
        Text(text = "Experience:2 Years      Location:60 minutes ", modifier = Modifier.padding(8.dp))
        CombinedButton(navController)
        Divider(modifier = Modifier.fillMaxWidth(), color = Color.Black, thickness = 1.dp)
        Text(text = "Name: Khush Rotak      Contact No:7542651535 ", modifier = Modifier.padding(8.dp))
        Text(text = "Experience:3 Years      Location:10 minutes ", modifier = Modifier.padding(8.dp))
        CombinedButton(navController)
        Divider(modifier = Modifier.fillMaxWidth(), color = Color.Black, thickness = 1.dp)
        Text(text = "Name: Raj Kubal        Contact No:7598463215 ", modifier = Modifier.padding(8.dp))
        Text(text = "Experience:5 Years      Location:75 minutes ", modifier = Modifier.padding(8.dp))
        CombinedButton(navController)
        Divider(modifier = Modifier.fillMaxWidth(), color = Color.Black, thickness = 1.dp)
        Text(text = "Name: Abdul Rafique    Contact No:8756421156 ", modifier = Modifier.padding(8.dp))
        Text(text = "Experience:3 Years      Location:76 minutes ", modifier = Modifier.padding(8.dp))
        CombinedButton(navController)
        Divider(modifier = Modifier.fillMaxWidth(), color = Color.Black, thickness = 1.dp)
        Text(text = "Name: Suraj Patil      Contact No:8754612359 ", modifier = Modifier.padding(8.dp))
        Text(text = "Experience:3 Years      Location:87 minutes ", modifier = Modifier.padding(8.dp))
        CombinedButton(navController)
        Divider(modifier = Modifier.fillMaxWidth(), color = Color.Black, thickness = 1.dp)
        Text(text = "Name: Ramesh Jha       Contact No:7845965845 ", modifier = Modifier.padding(8.dp))
        Text(text = "Experience:2 Years      Location:90 minutes ", modifier = Modifier.padding(8.dp))
        CombinedButton(navController)
        Divider(modifier = Modifier.fillMaxWidth(), color = Color.Black, thickness = 1.dp)
    }
}
@Composable
fun BookButton(navController: NavController) {
    Button(

        onClick = {
            navController.navigate(Screens.ElectricianData.route)
        },
        shape = RoundedCornerShape(10.dp),
        contentPadding = ButtonDefaults.ContentPadding,
        modifier = Modifier
            .width(200.dp)
    ) {
        Icon(
            imageVector = Icons.Default.CalendarMonth,
            contentDescription = null
        )
        Text(
            text = "Book Service",
            letterSpacing = 1.sp

        )
    }
}
@Composable
fun CallButton(navController: NavController) {
    Button(
        onClick = {
            navController.navigate(Screens.ElectricianData.route)
        },
        shape = RoundedCornerShape(10.dp),
        contentPadding = ButtonDefaults.ContentPadding,
        modifier = Modifier
            .width(170.dp)
    ) {
        Icon(
            imageVector = Icons.Default.Phone,
            contentDescription = null
        )
        Text(
            text = "Call",
            letterSpacing = 1.sp

        )
    }
}
@Composable
fun CombinedButton(navController: NavController) {
    Row {
        BookButton(navController)
        Spacer(modifier = Modifier.width(20.dp))
        CallButton(navController)
    }
}


