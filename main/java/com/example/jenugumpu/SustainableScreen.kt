package com.example.jenugumpu

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Eco
import androidx.compose.material.icons.filled.Verified
import androidx.compose.material.icons.filled.WaterDrop
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun SustainableScreen(

    onBackClick: () -> Unit,

    onHomeClick: () -> Unit,

    onHarvestClick: () -> Unit,

    onPricesClick: () -> Unit,

    onStockClick: () -> Unit,

    onProfileClick: () -> Unit
) {

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

                onProfileClick = onProfileClick
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

            // HEADER

            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {

                IconButton(
                    onClick = onBackClick
                ) {

                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = null,
                        tint = Color(0xFF5D4037)
                    )
                }

                Spacer(modifier = Modifier.width(6.dp))

                Text(

                    text =
                        if (isKannada) {
                            "ಸತತ ಜೇನು ಸಂಗ್ರಹ"
                        } else {
                            "Sustainable Harvesting"
                        },

                    fontSize = 28.sp,

                    fontWeight = FontWeight.Bold,

                    color = Color(0xFF5D4037)
                )
            }

            Spacer(modifier = Modifier.height(24.dp))

            // TOP CARD

            Card(

                modifier = Modifier.fillMaxWidth(),

                shape = RoundedCornerShape(30.dp),

                colors = CardDefaults.cardColors(
                    containerColor = Color(0xFF2E7D32)
                )
            ) {

                Box(

                    modifier = Modifier
                        .fillMaxWidth()
                        .height(180.dp),

                    contentAlignment = Alignment.Center
                ) {

                    Text(

                        text =
                            if (isKannada) {
                                "ಜೇನು ಸಂಗ್ರಾಹಕರ ನಿಯಮಗಳು"
                            } else {
                                "Harvester’s Code"
                            },

                        color = Color.White,

                        fontWeight = FontWeight.Bold,

                        fontSize = 34.sp
                    )
                }
            }

            Spacer(modifier = Modifier.height(24.dp))

            // TIP CARDS

            SustainableTipCard(

                title =
                    if (isKannada) {
                        "ಸುರಕ್ಷಿತ ಸಂಗ್ರಹ"
                    } else {
                        "Safe Harvesting"
                    },

                subtitle =
                    if (isKannada) {
                        "ಹಾನಿಕಾರಕವಲ್ಲದ ಹೊಗೆ ವಿಧಾನ ಬಳಸಿ."
                    } else {
                        "Use non-lethal smoke methods."
                    },

                icon = Icons.Default.WaterDrop
            )

            Spacer(modifier = Modifier.height(18.dp))

            SustainableTipCard(

                title =
                    if (isKannada) {
                        "ಗೂಡು ರಕ್ಷಣೆ"
                    } else {
                        "Colony Protection"
                    },

                subtitle =
                    if (isKannada) {
                        "ವರ್ಷಕ್ಕೆ ಎರಡು ಬಾರಿ ಮಾತ್ರ ಸಂಗ್ರಹಿಸಿ."
                    } else {
                        "Harvest only twice a year."
                    },

                icon = Icons.Default.Verified
            )

            Spacer(modifier = Modifier.height(18.dp))

            SustainableTipCard(

                title =
                    if (isKannada) {
                        "ಶುದ್ಧ ಫಿಲ್ಟರಿಂಗ್"
                    } else {
                        "Pure Extraction"
                    },

                subtitle =
                    if (isKannada) {
                        "ಸಾವಯವ ಬಹುಪದರ ಫಿಲ್ಟರಿಂಗ್."
                    } else {
                        "Multi-layer organic filtration."
                    },

                icon = Icons.Default.Verified
            )

            Spacer(modifier = Modifier.height(18.dp))

            SustainableTipCard(

                title =
                    if (isKannada) {
                        "ಜೇನು ಪರಿಸರ"
                    } else {
                        "Bee Ecology"
                    },

                subtitle =
                    if (isKannada) {
                        "ಸ್ಥಳೀಯ ಸಸ್ಯಗಳನ್ನು ರಕ್ಷಿಸಿ."
                    } else {
                        "Protect indigenous plant species."
                    },

                icon = Icons.Default.Eco
            )

            Spacer(modifier = Modifier.height(20.dp))
        }
    }
}

@Composable
fun SustainableTipCard(

    title: String,

    subtitle: String,

    icon: ImageVector
) {

    Card(

        modifier = Modifier.fillMaxWidth(),

        shape = RoundedCornerShape(22.dp),

        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),

        elevation = CardDefaults.cardElevation(
            defaultElevation = 3.dp
        )
    ) {

        Row(

            modifier = Modifier.padding(18.dp),

            verticalAlignment = Alignment.CenterVertically
        ) {

            Box(

                modifier = Modifier
                    .size(54.dp)
                    .background(
                        Color(0xFFEFF5EC),
                        RoundedCornerShape(16.dp)
                    ),

                contentAlignment = Alignment.Center
            ) {

                Icon(

                    imageVector = icon,

                    contentDescription = null,

                    tint = Color(0xFF2E7D32)
                )
            }

            Spacer(modifier = Modifier.width(18.dp))

            Column {

                Text(

                    text = title,

                    fontSize = 20.sp,

                    fontWeight = FontWeight.Bold,

                    color = Color(0xFF5D4037)
                )

                Spacer(modifier = Modifier.height(4.dp))

                Text(

                    text = subtitle,

                    color = Color(0xFF9E7D6B),

                    fontSize = 16.sp
                )
            }
        }
    }
}