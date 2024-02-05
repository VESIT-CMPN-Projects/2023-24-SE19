//package com.example.quickfixx.gemini
//
//import android.graphics.Bitmap
//import android.graphics.drawable.BitmapDrawable
//import androidx.compose.runtime.Composable
//
//import androidx.compose.ui.res.painterResource
//import com.example.quickfixx.R
//import com.example.quickfixx.util.constants.Constants
//import com.google.ai.client.generativeai.GenerativeModel
//import com.google.ai.client.generativeai.type.GenerateContentResponse
//import com.google.ai.client.generativeai.type.content
//
//
//@Composable
//fun AppScreen(){
//    // Assuming this is your AIScreen function call
//    val response = aIScreen()
//
//    // Display the generated text using Text composable
//    Text(
//        text = response.text,
//        modifier = Modifier.padding(16.dp) // Add any desired padding
//    )
//}
//
//@Composable
//suspend fun aIScreen(): GenerateContentResponse {
//
//    val generativeModel = GenerativeModel(
//        modelName = "gemini-pro-vision",
//        apiKey = Constants.API_KEY
//    )
//
//    val drawableId = R.drawable.qf_app_logo
//    val cookieImage : Bitmap = (painterResource(id = drawableId) as BitmapDrawable).bitmap
//
//    val inputContent = content() {
//        image(cookieImage)
//        text("Do these look store-bought or homemade?")
//    }
//
//    val response = generativeModel.generateContent(inputContent)
//    print(response.text)
//    return response
//}
