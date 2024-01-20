package com.example.quickfixx.presentation.profile

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.rounded.Carpenter
import androidx.compose.material.icons.rounded.ElectricalServices
import androidx.compose.material.icons.rounded.House
import androidx.compose.material.icons.rounded.Plumbing
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

import com.example.quickfixx.navigation.Screens
import com.example.quickfixx.presentation.sign_in.UserData


@OptIn(ExperimentalMaterial3Api::class)
@Composable
//private lateinit var binding:ActivitySignUpBinding
fun HomePage(navController: NavController,
             userData: UserData?,
             onSignOut: () -> Unit) {
    var SearchBar = remember {
        mutableStateOf("")
    }
    val drawerState = rememberDrawerState(DrawerValue.Closed)
    val scope = rememberCoroutineScope()
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = {
                        Text(
                            text = "QuickFixx",
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colorScheme.onSurface
                        )
                    },
                    navigationIcon = {
                        IconButton(
                            onClick = {
                                navController.navigate(Screens.CustomerSupport.route)
                            },
                        ) {
                            Icon(
                                imageVector = Icons.Default.Menu,
                                contentDescription = "Menu icon",
                                tint = MaterialTheme.colorScheme.onSurface
                            )
                        }
                    },
                    actions = {
                        // Show sign-out button only if user is logged in
                        if (userData != null) {
                            IconButton(
                                onClick = { onSignOut() },
                            ) {
                                Icon(
                                    imageVector = Icons.Default.ExitToApp,
                                    contentDescription = "Sign out",
                                    tint = MaterialTheme.colorScheme.onSurface
                                )
                            }
                        }
                    }
                )
            }
        ) {
            Surface(
                modifier = Modifier
                    .padding(it.calculateTopPadding())
                    .fillMaxSize()
            ) {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.SpaceBetween
                ) {
                    OutlinedTextField(
                        value = SearchBar.value,
                        onValueChange = { SearchBar.value = it },
                        enabled = true,
                        placeholder = { Text(text = "Search") },
                        leadingIcon = {
                            Icon(
                                imageVector = Icons.Rounded.Search,
                                contentDescription = null
                            )
                        },
                        shape = RoundedCornerShape(8.dp),
                        colors = TextFieldDefaults.outlinedTextFieldColors(
                        ),
                        singleLine = true,
                        modifier = Modifier.padding(3.dp).fillMaxWidth(),

                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Text,
                            imeAction = ImeAction.Done
                        )
                    )
                    Spacer(modifier = Modifier.height(12.dp))
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .weight(1f),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        BigButton(text = "   Electrician",icon = Icons.Rounded.ElectricalServices,navController)

                        Icon(
                            imageVector = Icons.Rounded.ElectricalServices,
                            contentDescription = null,
                            modifier = Modifier.size(24.dp) // Adjust the size as needed
                        )
                    }
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .weight(1f),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        BigButton(text = "   Carpenter",icon = Icons.Rounded.Carpenter,navController)
                        Icon(
                            imageVector = Icons.Rounded.Carpenter,
                            contentDescription = null
                        )
                    }
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .weight(1f),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        BigButton(text = "  House Keeping",icon = Icons.Rounded.House,navController)
                        Icon(
                            imageVector = Icons.Rounded.House,
                            contentDescription = null
                        )
                    }
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .weight(1f),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        BigButton(text = "   Plumber",icon = Icons.Rounded.Plumbing,navController)

                    }

                }

            }
        }
    }
}
@Composable
fun BigButton(text: String,icon: ImageVector,navController: NavController) {
    Button(
        onClick = {
                navController.navigate(Screens.ElectricianData.route)
        },
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
            .height(150.dp),
        colors = ButtonDefaults.buttonColors( MaterialTheme.colorScheme.onSurface)
    )
    {
        Icon(
            imageVector = icon,
            contentDescription = null,
            modifier = Modifier.size(40.dp)
        )
        Text(text = text, color = Color.White)
    }
}

