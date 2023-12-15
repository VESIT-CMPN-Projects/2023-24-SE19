package com.example.quickfixx.screens.auth

import android.content.ContentValues.TAG
import android.content.pm.PackageManager.ComponentEnabledSetting
import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowBackIos
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.rounded.Edit
import androidx.compose.material.icons.rounded.MailOutline
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
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.quickfixx.navigation.Screens
import com.google.firebase.auth.FirebaseAuth


@OptIn(ExperimentalMaterial3Api::class)
@Composable
//private lateinit var binding:ActivitySignUpBinding
fun SignUpScreen(navController: NavController , isEnabled : Boolean = false) {
    var Name = remember {
        mutableStateOf("")
    }
    var ConfirmPassword = remember {
        mutableStateOf("")
    }


    var gmail = remember {
        mutableStateOf("")
    }

    var password = remember {
        mutableStateOf("")
    }

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = {
                        Text(
                            text = "SignUp",
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colorScheme.onSurface
                        )
                    },
                    navigationIcon = {
                        IconButton(
                            onClick = {
                                navController.popBackStack()
                            }
                        ) {
                            Icon(
                                imageVector = Icons.Default.ArrowBackIos,
                                contentDescription = "back icon",
                                tint = MaterialTheme.colorScheme.onSurface
                            )
                        }
                    }
                )
            }
        ) {
            Surface(
                modifier = Modifier.padding(it.calculateTopPadding())
            ) {
                Column(
                    modifier = Modifier.fillMaxSize()
                ) {
                    Text(
                        text = "Full Name",
                        fontSize = 20.sp,
                        modifier = Modifier.padding(12.dp)
                    )
                    OutlinedTextField(
                        value = Name.value,
                        onValueChange = { Name.value = it },
                        enabled = true,
                        placeholder = { Text(text = "Full Name") },
                        leadingIcon = {
                            Icon(
                                imageVector = Icons.Rounded.Edit,
                                contentDescription = null
                            )
                        },
                        singleLine = true,
                        modifier = Modifier.padding(3.dp),
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Text,
                            imeAction = ImeAction.Done
                        )
                    )
                    Spacer(modifier = Modifier.height(12.dp) )
                    Text(
                        text = "Gmail",
                        fontSize = 20.sp,
                        modifier = Modifier.padding(12.dp)
                    )
                    OutlinedTextField(
                        value = gmail.value,
                        onValueChange = {
                            gmail.value = it
                                        },
                        enabled = true,
                        placeholder = { Text(text = "Gmail Id") },
                        leadingIcon = {
                            Icon(
                                imageVector = Icons.Rounded.MailOutline,
                                contentDescription = null
                            )
                        },
                        singleLine = true,
                        modifier = Modifier.padding(3.dp),
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Text,
                            imeAction = ImeAction.Done
                        )
                    )

                    Spacer(modifier = Modifier.height(12.dp))
                    Text(
                        text = "Password",
                        fontSize = 20.sp,
                        modifier = Modifier.padding(12.dp)
                    )
                    OutlinedTextField(
                        value = password.value,
                        onValueChange = { password.value = it },
                        enabled = true,
                        placeholder = { Text(text = "Password") },
                        leadingIcon = {
                            Icon(
                                imageVector = Icons.Default.Lock,
                                contentDescription = null
                            )
                        },
                        singleLine = true,
                        modifier = Modifier.padding(3.dp),
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Password,
                            imeAction = ImeAction.Done
                        ),
                        visualTransformation = PasswordVisualTransformation()
                    )
                    //CONFIRM PASSWORD
                    Spacer(modifier = Modifier.height(12.dp))
                    Text(
                        text = "Confirm Password",
                        fontSize = 20.sp,
                        modifier = Modifier.padding(12.dp)
                    )
                    OutlinedTextField(
                        value = ConfirmPassword.value,
                        onValueChange = { ConfirmPassword.value = it },
                        enabled = true,
                        placeholder = { Text(text = "Confirm Password") },
                        leadingIcon = {
                            Icon(
                                imageVector = Icons.Default.Lock,
                                contentDescription = null
                            )
                        },
                        singleLine = true,
                        modifier = Modifier.padding(3.dp),
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Password,
                            imeAction = ImeAction.Done
                        ),
                        visualTransformation = PasswordVisualTransformation()
                    )
//                      CREATE ACCOUNT BUTTON
                    Spacer(modifier = Modifier.height(12.dp))
                    Button(
                        onClick = {
                            CreateUserInFirebase(email = gmail.value, password = password.value)
                            navController.navigate(Screens.OTPScreen1.route)
                        },
                        shape = RoundedCornerShape(10.dp),
                        contentPadding = ButtonDefaults.ContentPadding,
                        enabled = isEnabled,
                        modifier = Modifier
                            .width(300.dp)
                    ) {
                        Text(
                            text = "Create Account",
                            letterSpacing = 1.sp
                        )
                    }
                    Spacer(modifier = Modifier.height(12.dp))
                    Text(
                        text = "                   OR",
                        fontSize = 20.sp,
                        modifier = Modifier.padding(12.dp)
                    )
                    Spacer(modifier = Modifier.height(12.dp))
                    Button(

                        onClick = {
                            CreateUserInFirebase(email = gmail.value, password = password.value)
                            navController.navigate(Screens.OTPScreen1.route)
                        },
                        shape = RoundedCornerShape(10.dp),
                        contentPadding = ButtonDefaults.ContentPadding,
                        modifier = Modifier
                            .width(300.dp)
                    ) {
                        Text(
                            text = "Continue with Google",
                            letterSpacing = 1.sp

                        )
                    }


//                    Text(
//                        text = "Phone number is: ${phone.value}",
//                        fontSize = 20.sp,
//                        modifier = Modifier.padding(12.dp)
//                    )

//                    Text(
//                        text = "Password is: ${password.value}",
//                        fontSize = 20.sp,
//                        modifier = Modifier.padding(12.dp)
//                    )
//                    binding = ActivitySignUpBinding.inflate
//                    setContentView(R.layout.SignUpScreen)
                }
            }
        }
    }
}
//private fun CreateUserInFirebase(email:String, password:String){
//    FirebaseAuth
//        .getInstance()
//        .createUserWithEmailAndPassword(email, password)
//        .addOnCompleteListener{
//            Log.d(TAG,"Inside_OnCompleteListener")
//            Log.d(TAG,"isSuccessful = ${it.isSuccessful}")
//        }
//        .addOnFailureListener{
//            Log.d(TAG,"Inside_OnFailureListener")
//            Log.d(TAG,"Exception = ${it.message}")
//            Log.d(TAG,"Exception = ${it.localizedMessage}")
//        }
//}
private fun CreateUserInFirebase(email: String, password: String) {
    if (email.isNotEmpty() && password.isNotEmpty()) {
        FirebaseAuth.getInstance().createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    // User created successfully
                    Log.d(TAG, "User created successfully")
                } else {
                    // User creation failed
                    Log.w(TAG, "User creation failed: ${task.exception}")
                }
            }
    } else {
        // Handle empty email or password error
        Log.w(TAG, "Email or password cannot be empty")
    }
}
