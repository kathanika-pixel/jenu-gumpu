package com.example.jenugumpu

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Language
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun AuthScreen(

    onLoginSuccess: () -> Unit

) {

    var isLogin by remember {
        mutableStateOf(true)
    }

    var refresh by remember {
        mutableStateOf(false)
    }

    val isKannada = LanguageManager.isKannada()

    var phoneNumber by remember {
        mutableStateOf("")
    }

    Column(

        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF8F5EE))
            .padding(24.dp),

        horizontalAlignment = Alignment.CenterHorizontally

    ) {

        Spacer(modifier = Modifier.height(120.dp))

        Text(

            text =
                if (isKannada) {

                    if (isLogin) {
                        "ಮತ್ತೆ ಸ್ವಾಗತ"
                    } else {
                        "ಖಾತೆ ತೆರೆಯಿರಿ"
                    }

                } else {

                    if (isLogin) {
                        "Welcome Back"
                    } else {
                        "Create Account"
                    }
                },

            fontSize = 38.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF5D4037)
        )

        Spacer(modifier = Modifier.height(12.dp))

        Text(

            text =
                if (isKannada) {
                    "ನಿಮ್ಮ ಜೇನು ನಿರ್ವಹಿಸಲು ಲಾಗಿನ್ ಮಾಡಿ"
                } else {
                    "Sign in to manage your harvest"
                },

            fontSize = 18.sp,
            color = Color(0xFF9E7D6B)
        )

        Spacer(modifier = Modifier.height(40.dp))

        Column(
            modifier = Modifier.fillMaxWidth()
        ) {

            Text(

                text =
                    if (isKannada) {
                        "ದೂರವಾಣಿ ಸಂಖ್ಯೆ"
                    } else {
                        "Phone Number"
                    },

                fontWeight = FontWeight.SemiBold,
                color = Color(0xFF5D4037),
                fontSize = 16.sp
            )

            Spacer(modifier = Modifier.height(10.dp))

            OutlinedTextField(

                value = phoneNumber,

                onValueChange = {
                    phoneNumber = it
                },

                modifier = Modifier.fillMaxWidth(),

                placeholder = {
                    Text("+91 98765 43210")
                },

                shape = RoundedCornerShape(18.dp),

                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Phone
                ),

                colors = OutlinedTextFieldDefaults.colors(

                    focusedBorderColor = Color(0xFFF4B400),

                    unfocusedBorderColor = Color(0xFFE0C98D),

                    focusedContainerColor = Color.White,

                    unfocusedContainerColor = Color.White
                )
            )
        }

        Spacer(modifier = Modifier.height(26.dp))

        Button(

            onClick = {

                if (phoneNumber.isNotBlank()) {

                    onLoginSuccess()
                }
            },

            modifier = Modifier
                .fillMaxWidth()
                .height(62.dp),

            shape = RoundedCornerShape(18.dp),

            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFFF4B400)
            )
        ) {

            Text(

                text =
                    if (isKannada) {

                        if (isLogin) {
                            "ಲಾಗಿನ್"
                        } else {
                            "ನೋಂದಣಿ"
                        }

                    } else {

                        if (isLogin) {
                            "Sign In"
                        } else {
                            "Register"
                        }
                    },

                color = Color(0xFF5D4037),

                fontWeight = FontWeight.Bold,

                fontSize = 22.sp
            )
        }

        Spacer(modifier = Modifier.height(28.dp))

        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {

            Text(

                text =
                    if (isKannada) {

                        if (isLogin) {
                            "ಖಾತೆ ಇಲ್ಲವೇ?"
                        } else {
                            "ಈಗಾಗಲೇ ಖಾತೆ ಇದೆಯೇ?"
                        }

                    } else {

                        if (isLogin) {
                            "Don't have an account?"
                        } else {
                            "Already have an account?"
                        }
                    },

                color = Color(0xFF9E7D6B),

                fontSize = 16.sp
            )

            Spacer(modifier = Modifier.width(6.dp))

            Text(

                text =
                    if (isKannada) {

                        if (isLogin) {
                            "ಈಗ ಸೇರಿ"
                        } else {
                            "ಲಾಗಿನ್"
                        }

                    } else {

                        if (isLogin) {
                            "Join Now"
                        } else {
                            "Log In"
                        }
                    },

                color = Color(0xFFF4B400),

                fontWeight = FontWeight.Bold,

                fontSize = 16.sp,

                modifier = Modifier.clickable {

                    isLogin = !isLogin
                }
            )
        }

        Spacer(modifier = Modifier.height(52.dp))

        Card(

            modifier = Modifier
                .fillMaxWidth()
                .clickable {

                    LanguageManager.setKannada(
                        !LanguageManager.isKannada()
                    )

                    refresh = !refresh
                },

            shape = RoundedCornerShape(20.dp),

            colors = CardDefaults.cardColors(
                containerColor = Color(0xFFFFF7E6)
            )
        ) {

            Row(

                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp),

                horizontalArrangement = Arrangement.Center,

                verticalAlignment = Alignment.CenterVertically
            ) {

                Icon(

                    imageVector = Icons.Default.Language,

                    contentDescription = null,

                    tint = Color(0xFFF4B400)
                )

                Spacer(modifier = Modifier.width(10.dp))

                Text(

                    text =
                        if (isKannada) {
                            "Switch to English"
                        } else {
                            "ಕನ್ನಡಕ್ಕೆ ಬದಲಾಯಿಸಿ"
                        },

                    color = Color(0xFFF4B400),

                    fontWeight = FontWeight.Bold,

                    fontSize = 20.sp
                )
            }
        }
    }
}