package com.example.jenugumpu

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForwardIos
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Language
import androidx.compose.material.icons.filled.Logout
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ProfileScreen(

    onSustainableClick: () -> Unit,

    onLogoutClick: () -> Unit,

    onHomeClick: () -> Unit,

    onHarvestClick: () -> Unit,

    onPricesClick: () -> Unit,

    onStockClick: () -> Unit
) {

    var refresh by remember {
        mutableStateOf(false)
    }

    val isKannada = LanguageManager.isKannada()

    Scaffold(

        containerColor = Color(0xFFF8F5EE),

        bottomBar = {

            BottomNavBar(

                selected = "profile",

                onHomeClick = onHomeClick,

                onHarvestClick = onHarvestClick,

                onPricesClick = onPricesClick,

                onStockClick = onStockClick,

                onProfileClick = { }
            )
        }

    ) { paddingValues ->

        Column(

            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFFF8F5EE))
                .padding(paddingValues)
                .padding(16.dp)
                .verticalScroll(rememberScrollState())
        ) {

            Spacer(modifier = Modifier.height(20.dp))

            // PROFILE TOP

            Box(
                modifier = Modifier.fillMaxWidth(),
                contentAlignment = Alignment.Center
            ) {

                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    Box(

                        modifier = Modifier
                            .size(90.dp)
                            .clip(CircleShape)
                            .background(Color(0xFFF4B400)),

                        contentAlignment = Alignment.Center
                    ) {

                        Icon(

                            imageVector = Icons.Default.Person,

                            contentDescription = null,

                            tint = Color.White,

                            modifier = Modifier.size(44.dp)
                        )
                    }

                    Spacer(modifier = Modifier.height(14.dp))

                    Text(

                        text =
                            if (isKannada) {
                                "ಲಿಂಗಪ್ಪ ನಾಯಕ"
                            } else {
                                "Lingappa Nayaka"
                            },

                        fontSize = 30.sp,

                        fontWeight = FontWeight.Bold,

                        color = Color(0xFF5D4037)
                    )

                    Spacer(modifier = Modifier.height(6.dp))

                    Text(

                        text =
                            if (isKannada) {
                                "ಕೊಡಗು ಸಮೂಹ • ID: 4502"
                            } else {
                                "Kodagu Collective • ID: 4502"
                            },

                        fontSize = 16.sp,

                        color = Color(0xFF9E7D6B)
                    )
                }
            }

            Spacer(modifier = Modifier.height(28.dp))

            // LANGUAGE

            ProfileOptionCard(

                title =
                    if (isKannada) {
                        "ಭಾಷೆ"
                    } else {
                        "Language"
                    },

                subtitle =
                    if (isKannada) {
                        "ಕನ್ನಡ"
                    } else {
                        "English"
                    },

                icon = Icons.Default.Language,

                iconColor = Color(0xFF9E8B7D),

                onClick = {

                    LanguageManager.toggleLanguage()

                    refresh = !refresh
                }
            )

            Spacer(modifier = Modifier.height(16.dp))

            // SUSTAINABLE

            ProfileOptionCard(

                title =
                    if (isKannada) {
                        "ಸತತ ಜೇನು ಸಂಗ್ರಹ"
                    } else {
                        "Sustainable Harvesting"
                    },

                subtitle =
                    if (isKannada) {
                        "ಜೇನು ಸಂರಕ್ಷಣೆ ಸಲಹೆಗಳು"
                    } else {
                        "Bee conservation practices"
                    },

                icon = Icons.Default.Info,

                iconColor = Color(0xFF9E8B7D),

                onClick = onSustainableClick
            )

            Spacer(modifier = Modifier.height(16.dp))

            // LOGOUT

            ProfileOptionCard(

                title =
                    if (isKannada) {
                        "ಲಾಗೌಟ್"
                    } else {
                        "Logout"
                    },

                subtitle = "",

                icon = Icons.Default.Logout,

                iconColor = Color.Red,

                onClick = onLogoutClick
            )

            Spacer(modifier = Modifier.height(24.dp))

            // TIP CARD

            Card(

                shape = RoundedCornerShape(22.dp),

                colors = CardDefaults.cardColors(
                    containerColor = Color(0xFFFFF8EF)
                )
            ) {

                Column(
                    modifier = Modifier.padding(20.dp)
                ) {

                    Text(

                        text =
                            if (isKannada) {
                                "🌱 ಪರಿಸರ ಸಲಹೆ"
                            } else {
                                "🌱 Sustainability Tip"
                            },

                        fontWeight = FontWeight.Bold,

                        color = Color(0xFFB34700),

                        fontSize = 20.sp
                    )

                    Spacer(modifier = Modifier.height(12.dp))

                    Text(

                        text =
                            if (isKannada) {
                                "ಜೇನುಗೂಡಿನ ಉಳಿವಿಗಾಗಿ ಯಾವಾಗಲೂ 20% ಜೇನು ಉಳಿಸಿ."
                            } else {
                                "Always leave 20% of the honey for the bees to ensure colony survival."
                            },

                        color = Color(0xFFCC6E3A),

                        fontSize = 16.sp,

                        lineHeight = 24.sp
                    )
                }
            }

            Spacer(modifier = Modifier.height(20.dp))
        }
    }
}

@Composable
fun ProfileOptionCard(

    title: String,

    subtitle: String,

    icon: androidx.compose.ui.graphics.vector.ImageVector,

    iconColor: Color,

    onClick: () -> Unit
) {

    Card(

        modifier = Modifier
            .fillMaxWidth()
            .clickable {
                onClick()
            },

        shape = RoundedCornerShape(20.dp),

        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),

        elevation = CardDefaults.cardElevation(
            defaultElevation = 3.dp
        )
    ) {

        Row(

            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp),

            verticalAlignment = Alignment.CenterVertically
        ) {

            Icon(

                imageVector = icon,

                contentDescription = null,

                tint = iconColor,

                modifier = Modifier.size(28.dp)
            )

            Spacer(modifier = Modifier.width(18.dp))

            Column(
                modifier = Modifier.weight(1f)
            ) {

                Text(

                    text = title,

                    fontWeight = FontWeight.SemiBold,

                    fontSize = 18.sp,

                    color = Color(0xFF5D4037)
                )

                if (subtitle.isNotEmpty()) {

                    Spacer(modifier = Modifier.height(4.dp))

                    Text(

                        text = subtitle,

                        color = Color(0xFFF4B400),

                        fontSize = 15.sp
                    )
                }
            }

            Icon(

                imageVector = Icons.Default.ArrowForwardIos,

                contentDescription = null,

                tint = Color.LightGray,

                modifier = Modifier.size(18.dp)
            )
        }
    }
}