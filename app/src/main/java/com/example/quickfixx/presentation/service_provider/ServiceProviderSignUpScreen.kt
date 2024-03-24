package com.example.quickfixx.presentation.service_provider

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.quickfixx.presentation.HomePage.BottomNavigationItem
import com.example.quickfixx.presentation.sign_in.SignInViewModel
import com.example.quickfixx.ui.theme.DeepBlue
import com.example.quickfixx.ui.theme.Silver

@SuppressLint("StateFlowValueCalledInComposition")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SPSignUp(
    viewModel: SignInViewModel,
    navController: NavController,
    onSignOut: () -> Unit,
    spViewModel: SpViewModel
){
    val userData = viewModel.state.value.userData

    var domain = remember {
        mutableStateOf("")
    }

    val address = remember {
        mutableStateOf("")
    }

    var experience = remember {
        mutableStateOf("")
    }

    var specz = remember {
        mutableStateOf("")
    }

    var shopName = remember {
        mutableStateOf("")
    }
    val items = listOf(
        BottomNavigationItem(
            title = "Home",
            selectedIcon = Icons.Filled.Home,
//            unselectedIcon = Icons.Outlined.Home,
            hasNews = false,
            route = "home"
        ),
        BottomNavigationItem(
            title = "Messages",
            selectedIcon = Icons.Filled.Notifications,
//            unselectedIcon = Icons.Outlined.Notifications,
            hasNews = false,
            route = "messages"
        ),
        BottomNavigationItem(
            title = "Profile",
            selectedIcon = Icons.Filled.Person,
//            unselectedIcon = Icons.Outlined.Person,
            hasNews = true,
            route = "user_profile"
        ),
    )
    var selectedItemIndex by rememberSaveable {
        mutableStateOf(2)
    }

    Scaffold(
        modifier = Modifier
//                            .fillMaxSize()
            .fillMaxHeight()
            .fillMaxWidth()
//                            .height(800.dp) // Adjust height as needed
            .padding(16.dp),
        topBar = {
            TopAppBar(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(DeepBlue)
                    .padding(0.dp),
                title = {
                    Text(
                        text = "QuickFixx",
                        fontWeight = FontWeight.Bold,
                        fontSize = 30.sp,
                        color = Color.Black,
                    )
                },
                colors = TopAppBarDefaults.topAppBarColors(),
                actions = {
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
                },
            )
        },

        bottomBar = {
            NavigationBar {
                items.forEachIndexed { index, item ->
                    NavigationBarItem(
                        selected = selectedItemIndex == index,
                        onClick = {
                            selectedItemIndex = index
                            navController.navigate(item.route)
                        },
                        label = {
                            Text(text = item.title)
                        },

                        icon = {
                            BadgedBox(
                                badge = {

                                }
                            ) {
                                Icon(
                                    modifier = Modifier
                                        .size(30.dp),
                                    imageVector = item.selectedIcon,
                                    contentDescription = item.title
                                )
                            }
                        }
                    )
                }
            }
        }
    ) {padding ->
        Column(
            modifier = Modifier.padding(top = 90.dp)
        ) {
            Box(
                modifier = Modifier
                    .background(Silver)
            ) {
                Column(
//                    modifier = Modifier
//                        .verticalScroll(rememberScrollState())
                ) {
                    Text(
                        text = "Join as Service Provider",
                        modifier = Modifier
                            .align(Alignment.CenterHorizontally),
//                                            .padding(bottom = 10.dp, start = 20.dp),
                        style = MaterialTheme.typography.headlineLarge
                    )
                    Text(
                        text = "Join as a Service Provider now to increase your reach",
                        modifier = Modifier
                            .align(Alignment.CenterHorizontally)
                            .padding(top = 10.dp),
                        style = MaterialTheme.typography.bodyMedium
                    )
                    Box(
                        modifier = Modifier
                            .background(Silver)
                            .align(Alignment.CenterHorizontally)
                            .padding(30.dp)
                            .padding(start = 10.dp)
                    ){
                        Column (
                            horizontalAlignment = Alignment.CenterHorizontally,
                            modifier = Modifier
                                .verticalScroll(rememberScrollState())
                        ){
                            OutlinedTextField(
                                value = domain.value,
                                onValueChange = {
                                    domain.value = it
                                },
                                label = {
                                    Text(text = "Domain")
                                }
                            )
                            Text(
                                text = "*Currently supported domains are Electrician, Plumber, Carpenter and Housekeeping",
                                modifier = Modifier
                                    .align(Alignment.CenterHorizontally),
                                style = MaterialTheme.typography.bodySmall
                            )

                            Spacer(
                                modifier = Modifier
                                    .height(5.dp)
                            )
                            OutlinedTextField(
                                value = experience.value,
                                onValueChange = {
                                    experience.value = it
                                },
                                label = {
                                    Text(text = "Experience")
                                }
                            )
                            Spacer(
                                modifier = Modifier
                                    .height(5.dp)
                            )
                            OutlinedTextField(
                                value = address.value,
                                onValueChange = {
                                    address.value = it
                                },
                                label = {
                                    Text(text = "Address")
                                }
                            )
                            Spacer(
                                modifier = Modifier
                                    .height(5.dp)
                            )
                            OutlinedTextField(
                                value = specz.value,
                                onValueChange = {
                                    specz.value = it
                                },
                                label = {
                                    Text(text = "Specialization")
                                }
                            )
                            Spacer(
                                modifier = Modifier
                                    .height(5.dp)
                            )
                            OutlinedTextField(
                                value = shopName.value,
                                onValueChange = {
                                    shopName.value = it
                                },
                                label = {
                                    Text(text = "Shop Name")
                                }
                            )
                            Spacer(modifier = Modifier.padding(vertical = 5.dp))
                            Button(
                                onClick = {
//                                    uid: Long, address: String, experience: String, specz: String, rating: Float, domain: String
                                    Log.d("CREATE SP 1", address.value+experience.value+"1")

                                        Log.d("CREATE SP 2", address.value+experience.value+"2")
                                    viewModel.state.value.user?.id?.let {
                                        spViewModel.saveSP(
                                            it.toLong(), address.value, experience.value, specz.value,
                                            1F, shopName.value,domain.value )
                                    }
                                },
                                modifier = Modifier
                                    .align(Alignment.CenterHorizontally),
                                colors = ButtonDefaults.buttonColors(Color.Black)
                            ) {
                                Text(
                                    text = "Join",
                                    color = Color.White
                                )
                            }
                        }
                    }
                }
            }
        }
    }

}