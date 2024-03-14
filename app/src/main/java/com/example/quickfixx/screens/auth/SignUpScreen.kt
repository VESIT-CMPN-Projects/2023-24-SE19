package com.example.quickfixx.screens.auth

import android.content.ContentValues.TAG
import android.content.pm.PackageManager.ComponentEnabledSetting
import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.quickfixx.navigation.Screens
import com.example.quickfixx.presentation.sign_in.SignInState
import com.example.quickfixx.presentation.sign_in.SignInViewModel
import com.google.firebase.auth.FirebaseAuth


@OptIn(ExperimentalMaterial3Api::class)
@Composable
//private lateinit var binding:ActivitySignUpBinding
fun SignUpScreen(state: SignInState, navController: NavController, viewModel: SignInViewModel, onSignInClick: ()->Unit) {
    val context = LocalContext.current
    LaunchedEffect(key1 = state.signInError) {
        state.signInError?.let { error ->
            Toast.makeText(
                context,
                error,
                Toast.LENGTH_LONG
            ).show()
        }
    }
    var Name = remember {
        mutableStateOf("")
    }

    val Contact = remember {
        mutableStateOf("")
    }

    var gmail = remember {
        mutableStateOf("")
    }

    var password = remember {
        mutableStateOf("")
    }

    var nameError by remember { mutableStateOf("") }
    var contactError by remember { mutableStateOf("") }
    var gmailError by remember { mutableStateOf("") }
    var passwordError by remember { mutableStateOf("") }


    fun validateFields():Boolean{
        val isValid = false
        if(Name.value.equals("")){
            nameError = "Name is required"
        }
        if(Contact.value.equals("")){
            contactError = "Contact is required"
        }
        if(gmail.value.equals("")){
            gmailError = "Email is required"
        }
        if(password.value.equals("")){
            passwordError = "Password is required"
        }

        return !isValid
    }


    Surface(
        modifier = Modifier.fillMaxHeight(),
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
                        text = "Contact Number",
                        fontSize = 20.sp,
                        modifier = Modifier.padding(12.dp)
                    )
                    OutlinedTextField(
                        value = Contact.value,
                        onValueChange = { Contact.value = it },
                        enabled = true,
                        placeholder = { Text(text = "Contact number") },
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

//                      CREATE ACCOUNT BUTTON
                    Spacer(modifier = Modifier.height(12.dp))
                    Button(
                        onClick = {
                            if(validateFields()){
                                viewModel.saveUser(
                                    Name.value,
                                    gmail.value,
                                    password.value,
                                    "user",
                                    Contact.value,
                                    ""
                                )
                                Log.d("SAVE USER", Name.value)
                                navController.navigate("home")
                            }
                        },
                        enabled = validateFields(),
                        shape = RoundedCornerShape(10.dp),
                        contentPadding = ButtonDefaults.ContentPadding,
                        modifier = Modifier
                            .width(300.dp)
                    ) {
                        Text(
                            text = "Create Account",
                            letterSpacing = 1.sp
                        )
                    }
//                    Spacer(modifier = Modifier.height(12.dp))
                    Text(
                        text = "                   OR",
                        fontSize = 20.sp,
                        modifier = Modifier.padding(12.dp)
                    )
//                    Spacer(modifier = Modifier.height(12.dp))
                    Button(

                        onClick = {
                            onSignInClick()
//                            navController.navigate("home")
                        },
                        shape = RoundedCornerShape(10.dp),
                        contentPadding = ButtonDefaults.ContentPadding,
                        modifier = Modifier
                            .width(300.dp)
                    ) {
                        Text(
                            text = "Login with Google",
                            letterSpacing = 1.sp

                        )
                    }
                }
            }
        }
    }
}
