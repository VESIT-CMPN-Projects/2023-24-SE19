
package com.example.quickfixx.screens.auth

import android.annotation.SuppressLint
import android.content.Intent
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
import androidx.compose.material.icons.filled.RateReview
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.material.icons.filled.Timer
import androidx.compose.material3.AssistChip
import androidx.compose.material3.AssistChipDefaults
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
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
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import android.net.Uri
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue

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
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UserDetails(navController: NavController) {
    var offerAccepted by remember { mutableStateOf(false) }

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
            Column(
                modifier = Modifier
                    .padding(vertical = it.calculateTopPadding())
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState())
            ) {
                Text(text = "Electricians",
                    Modifier
                        .padding(top = 5.dp, bottom = 9.dp, start = 9.dp)
                        .fillMaxWidth()
                        .background(MaterialTheme.colorScheme.background)
                        .wrapContentHeight(),
                    fontSize = 24.sp,
                    fontWeight = FontWeight.W900,
                    textAlign = TextAlign.Left,
                    textDecoration = TextDecoration.Underline
                )
                CardElevation_user("Service_1", 4, navController)
                Summary_user("User Name", 4, 5, 30, 50, "AYZAYZAYAZ",10, 3, navController)
                StatsRecord(
                    moneyEarned = "$1000",
                    hoursWorked = "50",
                    streakInMonth = "10"
                )
            }
        }
    }
}

@Composable
fun StatsRecord(moneyEarned: String, hoursWorked: String, streakInMonth: String) {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        shape = RoundedCornerShape(16.dp),
        color = Color(0xFFD1D5E1)
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(
                text = "Statistics",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(bottom = 8.dp)
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "Money Earned:",
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = moneyEarned,
                fontSize = 14.sp
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "Hours Worked:",
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = hoursWorked,
                fontSize = 14.sp
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "Streak in the Month:",
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = streakInMonth,
                fontSize = 14.sp
            )
        }
    }
}
@Composable
fun Summary_user(
    name: String,
    rating: Int,
    distance: Int,
    time: Int,
    price: Int,
    location: String,
    reviews: Int,
    yearsOfExperience: Int,
    navController: NavController
) {
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
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .weight(2f),
                ) {
                    Surface(
                        shape = RoundedCornerShape(24.dp),
                        modifier = Modifier
                            .padding(2.dp)
                            .fillMaxWidth()
                            .size(width = 500.dp, height = 280.dp)
                            .padding(start = 16.dp),
                        color = Color(0xFFD1D5E1)
                    ) {
                        Column(
                            Modifier.padding(horizontal = 4.dp)
                        ) {
                            Text(
                                text = name,
                                fontSize = 24.sp,
                                style = MaterialTheme.typography.titleLarge,
                                fontWeight = FontWeight.SemiBold,
                                modifier = Modifier.padding(10.dp)
                            )

                            Spacer(modifier = Modifier.height(2.dp))

                            Column(
                                modifier = Modifier.padding(start = 16.dp)
                            ) {
                                SummaryItem(Icons.Default.Timer, "Distance: $distance km")
                                SummaryItem(Icons.Default.Timer, "Time: $time min")
                                SummaryItem(Icons.Default.Timer, "Price: $$price")
                                SummaryItem(Icons.Default.ThumbUp, "Location: $location")
                            }

                            Spacer(modifier = Modifier.height(15.dp))

                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.spacedBy(20.dp),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Button(
                                    onClick = { /* Handle accept offer action */ },
                                    modifier = Modifier
                                        .weight(1f)
                                        .height(40.dp)
                                ) {
                                    Text(
                                        text = "Accept Offer",
                                        fontSize = 11.sp,
                                        fontWeight = FontWeight.SemiBold,
                                        style = MaterialTheme.typography.titleLarge
                                    )
                                }

                                Button(
                                    onClick = { /* Handle reject offer action */ },
                                    modifier = Modifier
                                        .weight(1f)
                                        .height(40.dp)
                                ) {
                                    Text(
                                        text = "Reject Offer",
                                        fontSize = 11.sp,
                                        fontWeight = FontWeight.SemiBold,
                                        style = MaterialTheme.typography.titleLarge
                                    )
                                }
                            }
                        }
                    }
                }

                Spacer(modifier = Modifier.width(20.dp))
            }
        }
    }
}



@Composable
fun CardElevation_user(name: String, rating: Int, navController: NavController) {
    val context = LocalContext.current
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
                        painter = painterResource(id = R.drawable.biharimajdur),
                        contentScale = ContentScale.Crop,
                        contentDescription = null,
                    )
                }
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .weight(2f),
                ) {
                    Surface(
                        shape = RoundedCornerShape(24.dp),
                        modifier = Modifier
                            .padding(2.dp)
                            .fillMaxWidth()
                            .size(width = 500.dp, height = 280.dp)
                            .padding(start = 16.dp),
                        color = Color(0xFFD1D5E1)
                    ) {
                        Column(
                            Modifier.padding(horizontal = 4.dp)
                        ) {
                            Text(
                                text = name,
                                fontSize = 24.sp,
                                style = MaterialTheme.typography.titleLarge,
                                fontWeight = FontWeight.SemiBold,
                                modifier = Modifier.padding(10.dp)
                            )

                            Spacer(modifier = Modifier.height(2.dp))

                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                modifier = Modifier.padding(start = 1.dp)
                            ) {
                                AssistChip(
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

                                AssistChip(
                                    onClick = { Log.d("Assist chip", "hello world") },
                                    label = { Text("Great Value") },
                                    leadingIcon = {
                                        Icon(
                                            Icons.Filled.Check,
                                            contentDescription = "Localized description",
                                            Modifier.size(AssistChipDefaults.IconSize)
                                        )
                                    },
                                    modifier = Modifier.padding(start = 8.dp)
                                )
                            }

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
                                        if (index < rating) Color.Yellow else Color.Gray

                                    Icon(
                                        painter = painterResource(id = baseline_star_outline_24),
                                        tint = starColor,
                                        contentDescription = null
                                    )
                                }
                            }

                            Spacer(modifier = Modifier.height(4.dp))


                            Text(
                                text = "This is a description of the service provider...",
                                fontSize = 12.sp,
                                color = Color.Gray,
                                modifier = Modifier.padding(start = 16.dp, end = 16.dp, bottom = 8.dp)
                            )

                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.spacedBy(20.dp),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                OutlinedButton(
                                    modifier = Modifier
                                        .weight(1f)
                                        .height(40.dp),
                                    shape = RoundedCornerShape(8.dp),
                                    colors = ButtonDefaults.buttonColors(
                                        contentColor = Color.Black,
                                        containerColor = Color.White
                                    ),
                                    onClick = { /*TODO*/ }
                                ) {
                                    Text(
                                        text = "Active",
                                        fontSize = 11.sp,
                                        fontWeight = FontWeight.SemiBold,
                                        style = MaterialTheme.typography.titleLarge
                                    )
                                }

                                OutlinedButton(
                                    modifier = Modifier
                                        .weight(1f)
                                        .height(40.dp),
                                    shape = RoundedCornerShape(8.dp),
                                    border = BorderStroke(1.dp, Color.Blue),
                                    colors = ButtonDefaults.buttonColors(
                                        contentColor = Color.Blue,
                                        containerColor = Color.White,
                                    ),
                                    onClick = { /*TODO*/ }
                                ) {
                                    Text(
                                        text = "Inactive",
                                        fontSize = 11.sp,
                                        fontWeight = FontWeight.SemiBold,
                                        style = MaterialTheme.typography.titleLarge
                                    )
                                }
                                Row(
                                    modifier = Modifier.fillMaxWidth(),
                                    horizontalArrangement = Arrangement.spacedBy(20.dp),
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    OutlinedButton(
                                        modifier = Modifier
                                            .weight(1f)
                                            .height(40.dp),
                                        shape = RoundedCornerShape(8.dp),
                                        border = BorderStroke(1.dp, Color.Green),
                                        colors = ButtonDefaults.buttonColors(
                                            contentColor = Color.Black,
                                            containerColor = Color.White
                                        ),
                                        onClick = { /* TODO: Handle booking action */ }
                                    ) {
                                        Text(
                                            text = "Active",
                                            fontSize = 11.sp,
                                            fontWeight = FontWeight.SemiBold,
                                            style = MaterialTheme.typography.titleLarge
                                        )
                                    }

                                    OutlinedButton(
                                        modifier = Modifier
                                            .weight(1f)
                                            .height(40.dp),
                                        shape = RoundedCornerShape(8.dp),
                                        border = BorderStroke(1.dp, Color.Red),
                                        colors = ButtonDefaults.buttonColors(
                                            contentColor = Color.Blue,
                                            containerColor = Color.White,
                                        ),
                                        onClick = {

                                            val phoneNumber = "7045432201"
                                            val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:$phoneNumber"))
                                            context.startActivity(intent)
                                        }
                                    ) {
                                        Text(
                                            text = "Inactive",
                                            fontSize = 11.sp,
                                            fontWeight = FontWeight.SemiBold,
                                            style = MaterialTheme.typography.titleLarge
                                        )
                                    }
                                }
                            }

                        }
                    }
                }
            }
        }
    }
}
