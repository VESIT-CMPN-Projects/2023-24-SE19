package com.example.quickfixx.screens.auth

import android.util.Log
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


@OptIn(ExperimentalMaterial3Api::class)
@Composable
//private lateinit var binding:ActivitySignUpBinding
fun HomePage(navController: NavController) {
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
//                    navigationIcon = {
//                        Navtest(scope, drawerState)
//                    }
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
                    }

//                    navigationIcon = {
//                        IconButton(
//                            onClick = {
//                                Navtest(scope, drawerState)
////                                scope.launch {
////                                    // Perform some asynchronous operation
////                                    // For example, open the navigation bar
////                                    drawerState.open()
////                                }
////                                navController.navigate("navtest")
////                                navController.navigate(Screens.Navtest.route)
//                            },
//                        ) {
//                            Icon(
//                                imageVector = Icons.Default.Menu,
//                                contentDescription = "Menu icon",
//                                tint = MaterialTheme.colorScheme.onSurface
//                            )
//                        }
////                        Image(
////                            painter = painterResource(id = R.drawable.qf_app_logo),
////                            contentDescription = "app logo",
////                            modifier = Modifier
////                                .size(25.dp)
////                        )
//
//                    }
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
                        modifier = Modifier
                            .padding(3.dp)
                            .fillMaxWidth(),

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
                        Button(onClick = {
                            navController.navigate("electrician")
                        },
                            modifier = Modifier.size(24.dp)) {
                            Text(text = "Electrician")
                        }
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
fun BigButton(text: String, icon: ImageVector, navController: NavController) {
    Button(
        onClick = {
            Log.d("From ", "Going to Electrician page")
            navController.navigate("electricians") // Ensure the route name is correct
        },
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
            .height(150.dp),
        colors = ButtonDefaults.buttonColors(MaterialTheme.colorScheme.onSurface)
    ) {
        Icon(
            imageVector = icon,
            contentDescription = null,
            modifier = Modifier.size(40.dp)
        )
        Text(text = text, color = Color.White)
    }
}

//@OptIn(ExperimentalMaterial3Api::class)
//@Composable
//fun Navtest(scope: CoroutineScope, drawerState: DrawerState) {
////    val drawerState = rememberDrawerState(DrawerValue.Closed)
////    val scope = rememberCoroutineScope()
//
//    // Icons and their corresponding labels
//    val iconData = listOf(
//        Icons.Default.CalendarMonth to "Book",
//        Icons.Default.Timelapse to "Estimated time",
//        Icons.Default.Email to "Customer service"
//    )
//
//    val selectedItem = remember { mutableStateOf(iconData[0]) }
//
//    ModalNavigationDrawer(
//        drawerState = drawerState,
//        drawerContent = {
//            ModalDrawerSheet {
//                Spacer(Modifier.height(12.dp))
//                iconData.forEach { (item, label) ->
//                    NavigationDrawerItem(
//                        icon = { Icon(item, contentDescription = null) },
//                        label = { Text(label) },
//                        selected = item == selectedItem.value.first,
//                        onClick = {
//                            scope.launch { drawerState.close() }
//                            selectedItem.value = item to label
//                        },
//                        modifier = Modifier.padding(NavigationDrawerItemDefaults.ItemPadding)
//                    )
//                }
//            }
//        },
//        content = {
//            Column(
//                modifier = Modifier.fillMaxSize(),
//                horizontalAlignment = Alignment.CenterHorizontally
//            ) {
//                IconButton(
//                    onClick = {
//                        // Use the provided scope to perform operations
//                        scope.launch {
//                            // Perform some asynchronous operation
//                            // For example, open the navigation bar
//                            drawerState.open()
//                        }
//                    }
//                ) {
//                    Icon(
//                        imageVector = Icons.Default.Menu,
//                        contentDescription = "Menu icon",
//                        tint = MaterialTheme.colorScheme.onSurface
//                    )
//                }
//            }
//        }
//    )
//}

