@file:OptIn(ExperimentalMaterial3Api::class)
package com.example.quickfixx.screens.auth

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CalendarMonth
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Timelapse
import androidx.compose.material3.DrawerState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.NavigationDrawerItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Navtest(scope: CoroutineScope, drawerState: DrawerState) {
//    val drawerState = rememberDrawerState(DrawerValue.Closed)
//    val scope = rememberCoroutineScope()

    // Icons and their corresponding labels
    val iconData = listOf(
        Icons.Default.CalendarMonth to "Book",
        Icons.Default.Timelapse to "Estimated time",
        Icons.Default.Email to "Customer service"
    )

    val selectedItem = remember { mutableStateOf(iconData[0]) }

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet {
                Spacer(Modifier.height(12.dp))
                iconData.forEach { (item, label) ->
                    NavigationDrawerItem(
                        icon = { Icon(item, contentDescription = null) },
                        label = { Text(label) },
                        selected = item == selectedItem.value.first,
                        onClick = {
                            scope.launch { drawerState.close() }
                            selectedItem.value = item to label
                        },
                        modifier = Modifier.padding(NavigationDrawerItemDefaults.ItemPadding)
                    )
                }
            }
        },
        content = {
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                IconButton(
                    onClick = {
                        // Use the provided scope to perform operations
                        scope.launch {
                            // Perform some asynchronous operation
                            // For example, open the navigation bar
                            drawerState.open()
                        }
                    }
                ) {
                    Icon(
                        imageVector = Icons.Default.Menu,
                        contentDescription = "Menu icon",
                        tint = MaterialTheme.colorScheme.onSurface
                    )
                }
            }
        }
    )
}
//@Composable
//fun Navtest(navController: NavHostController) {
//    val drawerState = rememberDrawerState(DrawerValue.Closed)
//    val scope = rememberCoroutineScope()
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
//                modifier = Modifier
//                    .fillMaxSize()
//                    .padding(16.dp),
//                horizontalAlignment = Alignment.CenterHorizontally
//            ) {
////                Text(text = if (drawerState.isClosed) ">>> Swipe >>>" else "<<< Swipe <<<")
////                Spacer(Modifier.height(20.dp))
////                Button(onClick = { scope.launch { drawerState.open() } }) {
////                    Text("Click to open")
////                }
//            }
//        }
//    )
//}
