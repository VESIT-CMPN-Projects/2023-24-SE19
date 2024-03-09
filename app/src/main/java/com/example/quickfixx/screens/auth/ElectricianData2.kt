@file:Suppress("PreviewAnnotationInFunctionWithParameters")

package com.example.quickfixx.screens.auth

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CalendarMonth
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.AssistChip
import androidx.compose.material3.AssistChipDefaults
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.quickfixx.R
import com.example.quickfixx.R.drawable.baseline_star_outline_24
import com.example.quickfixx.navigation.Screens

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ElectricianData2(navController: NavController) {

    Surface(
        modifier = Modifier.fillMaxWidth(),
        color = MaterialTheme.colorScheme.background
    ) {
        Scaffold(
            topBar = {
                TopAppBar(title = {
                    Text(text = "QuickFixx",
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.onSurface
                    )
                },
                    navigationIcon = {
                        IconButton(onClick = {
                            navController.navigate(Screens.CustomerSupport.route)
                        },
                        ) {
                          Icon(
                              imageVector = Icons.Default.Menu,
                              contentDescription = "Menu icon",
                              tint = MaterialTheme.colorScheme.onSurface
                          )
                        }
                    }
                    )
            }
        ) {


//                Text(text = "Experts", TextAlign= TextAlign.Start, modifier = Modifier.padding(16.dp))

        Column(
            modifier = Modifier
                .padding(vertical = it.calculateTopPadding())
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
        ) {

            Text(text = "Experts",
                Modifier
                    .padding(top = 5.dp, bottom = 9.dp, start = 9.dp)
                    .fillMaxWidth()
                    .background(MaterialTheme.colorScheme.background)
                    .wrapContentHeight(),
                fontSize = 24.sp,  // Set the desired font size here
                fontWeight = FontWeight.W900,
                textAlign = TextAlign.Left,
                textDecoration = TextDecoration.Underline
            )
            CardElevation("Service_1", 4, navController)
            DataCard(navController = navController)
            Divider(modifier = Modifier.fillMaxWidth(), color = Color.Black, thickness = 1.dp)
            DataCard(navController = navController)
            Divider(modifier = Modifier.fillMaxWidth(), color = Color.Black, thickness = 1.dp)
            DataCard(navController = navController)
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
    }
}

@Composable
fun DataCard(navController: NavController){
    Row (
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 16.dp)
    ){
        Image(imageVector = Icons.Filled.Person, contentDescription = null,  modifier = Modifier.size(40.dp))
        ProviderInfo(name = "Service Provider")
    }
    Button(
        onClick = {
        navController.navigate("home")
    },
        shape = RoundedCornerShape(10.dp),
        modifier = Modifier
            .width(240.dp)
            .padding(start = 56.dp)
    ) {
        Text(text = "Service Provider",
            letterSpacing = 1.sp
        )
        
    }
}

@Composable
fun ProviderInfo(name: String, ){
    Column {
        Text(text = name, Modifier.padding(8.dp), fontWeight = FontWeight.Bold, textAlign = TextAlign.Center)
        Text(text = "Experience: 1 year", Modifier.padding(8.dp))
        AssistChip(
            onClick = { Log.d("Assist chip", "hello world") },
            label = { Text("Assist chip") },
            leadingIcon = {
                Icon(
                    Icons.Filled.Check,
                    contentDescription = "Localized description",
                    Modifier.size(AssistChipDefaults.IconSize)
                )
            }
        )
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

@Composable
fun CardElevation(name: String, rating: Int, navController: NavController) {
    Surface(
        shape = RoundedCornerShape(16.dp),
        color = Color(0xFFDAE1E7),
        modifier = Modifier
            .height(310.dp)
            .padding(10.dp)
            .padding(start = 3.dp)
            .fillMaxWidth(),
        shadowElevation = 10.dp
    ) {
        Column(
            verticalArrangement = Arrangement.Center
        ) {


        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Surface(
                shape = RoundedCornerShape(16.dp),
                modifier = Modifier
                    .size(width = 100.dp, height = 140.dp)

            ) {
                Image(
                    painter = painterResource(id = R.drawable.qf_app_logo),
                    contentScale = ContentScale.Crop,
                    contentDescription = null,
//                    modifier = Modifier.padding(15.dp)

                )
            }
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .weight(2f),
//                verticalArrangement = Arrangement.Center
            ) {
                Surface(
                    shape = RoundedCornerShape(24.dp),
                    modifier = Modifier
                        .padding(2.dp)
                        .fillMaxWidth()
                        .size(width = 500.dp,height =280.dp )
                        .padding(start = 16.dp),
                    color = Color(0xFFD1D5E1)
                ) {
                    Column(
                        Modifier.padding(horizontal = 4.dp)
                    ){
                        Text(
                            text = name,
                            fontSize = 24.sp,
                            style = MaterialTheme.typography.titleLarge,
                            fontWeight = FontWeight.SemiBold,
                            modifier = Modifier.padding(10.dp)
                        )

                        Spacer(modifier = Modifier.height(2.dp))


                        AssistChip(
                                modifier = Modifier.padding(start = 16.dp),
                                onClick = { Log.d("Assist chip", "hello world") },
                                label = { Text("Verified") },
                                leadingIcon = {
                                    Icon(
                                        Icons.Filled.Check,
                                        contentDescription = "Localized description",
                                        Modifier.size(AssistChipDefaults.IconSize)
                                    )
                                }
                            )


                        Spacer(modifier = Modifier.height(2.dp))

                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Text(
                                text = buildAnnotatedString {

                                    if (rating >= 4) {
                                        withStyle(style = SpanStyle(color = Color.Black)) {
                                            append("Excellent: $rating")
                                        }
                                    } else if (rating > 3) {
                                        withStyle(style = SpanStyle(color = Color.Black)) {
                                            append("Good: $rating")
                                        }
                                    } else {
                                        withStyle(style = SpanStyle(color = Color.Black)) {
                                            append("Average: $rating")
                                        }
                                    }
                                },
                                fontSize = 14.sp,
                                fontWeight = FontWeight.SemiBold,
                                style = MaterialTheme.typography.titleLarge
                            )
                            Spacer(modifier = Modifier.width(4.dp))
                            repeat(5) { index ->
                                val starColor =
                                    if (index < rating) Color(0xFFF6B266) else Color.Gray

                                Icon(
                                    painter = painterResource(id = baseline_star_outline_24),
                                    tint = starColor,
                                    contentDescription = null
                                )
                            }
                        }

                        Spacer(modifier = Modifier.height(4.dp))

                        OutlinedButton(
                            modifier = Modifier.padding(start = 56.dp),
                            shape = RoundedCornerShape(8.dp),
                            colors = ButtonDefaults.buttonColors(
                                contentColor = Color.Black,
                                containerColor = Color.White
                            ),
                            onClick = { /*TODO*/ }
                        ) {
                            Text(
                                text = "View Profile",
                                fontSize = 11.sp,
                                fontWeight = FontWeight.SemiBold,
                                style = MaterialTheme.typography.titleLarge
                            )
                        }

                        Spacer(modifier = Modifier.width(20.dp))
                        OutlinedButton(
                            modifier = Modifier.padding(start = 66.dp),
                            shape = RoundedCornerShape(8.dp),
                            border = BorderStroke(1.dp, Color.Blue),
                            colors = ButtonDefaults.buttonColors(
                                contentColor = Color.Blue,
                                containerColor = Color.White,
                            ),
                            onClick = { /*TODO*/ }
                        ) {
                            Text(
                                text = "Contact",
                                fontSize = 11.sp,
                                fontWeight = FontWeight.SemiBold,
                                style = MaterialTheme.typography.titleLarge
                            )
                        }
                    }
            }

        }
            Spacer(modifier = Modifier.width(20.dp))
        }
//            OutlinedButton(
//                shape = RoundedCornerShape(8.dp),
//                border = BorderStroke(1.dp, Color.Blue),
//                colors = ButtonDefaults.buttonColors(
//                    contentColor = Color.Blue,
//                    containerColor = Color.White,
//                ),
//                onClick = { /*TODO*/ }
//            ) {
//                Text(
//                    text = "Contact",
//                    fontSize = 11.sp,
//                    fontWeight = FontWeight.SemiBold,
//                    style = MaterialTheme.typography.titleLarge
//                )
//            }
//            Text(
//                text = "Contact",
//                fontSize = 11.sp,
//                fontWeight = FontWeight.SemiBold,
//                style = MaterialTheme.typography.titleLarge
//            )
        }
}}

