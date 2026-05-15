package com.example.jenugumpu

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Bookmark
import androidx.compose.material.icons.filled.Calculate
import androidx.compose.material.icons.filled.TrendingUp
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun HomeScreen(

    onHarvestClick: () -> Unit,

    onGradeClick: () -> Unit,

    onCalculatorClick: () -> Unit,

    onPricesClick: () -> Unit,

    onStockClick: () -> Unit,

    onProfileClick: () -> Unit
) {

    val isKannada = LanguageManager.isKannada()

    var collectiveStock by remember {
        mutableIntStateOf(67)
    }

    var todaysPrice by remember {
        mutableIntStateOf(850)
    }

    var estimatedProfit by remember {
        mutableIntStateOf(12450)
    }

    Scaffold(

        containerColor = Color(0xFFF8F5EE),

        bottomBar = {

            BottomNavBar(

                selected = "home",

                onHomeClick = {},

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
                .verticalScroll(rememberScrollState())
                .padding(16.dp)
        ) {

            Spacer(modifier = Modifier.height(6.dp))

            Text(

                text =
                    if (isKannada) {
                        "ಜೇನು-ಗುಂಪು"
                    } else {
                        "Jenu-Gumpu"
                    },

                fontSize = 32.sp,

                fontWeight = FontWeight.Bold,

                color = Color(0xFF5D4037)
            )

            Spacer(modifier = Modifier.height(20.dp))

            // TOP CARD

            Card(

                modifier = Modifier.fillMaxWidth(),

                shape = RoundedCornerShape(30.dp),

                colors = CardDefaults.cardColors(
                    containerColor = Color.Transparent
                )
            ) {

                Box(

                    modifier = Modifier
                        .background(

                            brush = Brush.horizontalGradient(

                                listOf(
                                    Color(0xFF5D4037),
                                    Color(0xFF795548)
                                )
                            )
                        )
                        .padding(24.dp)
                ) {

                    Column {

                        Text(

                            text =
                                if (isKannada) {
                                    "ಒಟ್ಟು ಸಂಗ್ರಹ"
                                } else {
                                    "Total Collective Stock"
                                },

                            color = Color.LightGray,

                            fontSize = 14.sp
                        )

                        Spacer(modifier = Modifier.height(10.dp))

                        Row(
                            verticalAlignment = Alignment.Bottom
                        ) {

                            Text(

                                text = collectiveStock.toString(),

                                color = Color.White,

                                fontSize = 52.sp,

                                fontWeight = FontWeight.Bold
                            )

                            Spacer(modifier = Modifier.width(6.dp))

                            Text(

                                text =
                                    if (isKannada) {
                                        "ಕೆಜಿ"
                                    } else {
                                        "kg"
                                    },

                                color = Color.White,

                                fontSize = 28.sp,

                                fontWeight = FontWeight.SemiBold
                            )
                        }

                        Spacer(modifier = Modifier.height(22.dp))

                        HorizontalDivider(
                            color = Color(0x55FFFFFF)
                        )

                        Spacer(modifier = Modifier.height(22.dp))

                        Row(

                            modifier = Modifier.fillMaxWidth(),

                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {

                            Column {

                                Text(

                                    text =
                                        if (isKannada) {
                                            "ಇಂದಿನ ಬೆಲೆ"
                                        } else {
                                            "TODAY'S PRICE"
                                        },

                                    color = Color.LightGray,

                                    fontSize = 12.sp
                                )

                                Spacer(modifier = Modifier.height(4.dp))

                                Text(

                                    text = "₹$todaysPrice/kg",

                                    color = Color(0xFFFFC107),

                                    fontSize = 24.sp,

                                    fontWeight = FontWeight.Bold
                                )
                            }

                            Column {

                                Text(

                                    text =
                                        if (isKannada) {
                                            "ಅಂದಾಜು ಲಾಭ"
                                        } else {
                                            "ESTIMATED PROFIT"
                                        },

                                    color = Color.LightGray,

                                    fontSize = 12.sp
                                )

                                Spacer(modifier = Modifier.height(4.dp))

                                Text(

                                    text = "₹$estimatedProfit",

                                    color = Color(0xFF00E676),

                                    fontSize = 24.sp,

                                    fontWeight = FontWeight.Bold
                                )
                            }
                        }
                    }
                }
            }

            Spacer(modifier = Modifier.height(18.dp))

            // QUALITY CARD

            Card(

                modifier = Modifier.fillMaxWidth(),

                shape = RoundedCornerShape(22.dp),

                colors = CardDefaults.cardColors(
                    containerColor = Color(0xFFEAF3E2)
                )
            ) {

                Row(

                    modifier = Modifier.padding(18.dp),

                    verticalAlignment = Alignment.CenterVertically
                ) {

                    Box(

                        modifier = Modifier
                            .size(60.dp)
                            .clip(RoundedCornerShape(18.dp))
                            .background(Color(0xFF2E7D32)),

                        contentAlignment = Alignment.Center
                    ) {

                        Text(
                            text = "🌿",
                            fontSize = 24.sp
                        )
                    }

                    Spacer(modifier = Modifier.width(16.dp))

                    Column {

                        Text(

                            text =
                                if (isKannada) {
                                    "ಶುದ್ಧ ಗುಣಮಟ್ಟ"
                                } else {
                                    "PURE QUALITY"
                                },

                            color = Color(0xFF2E7D32),

                            fontWeight = FontWeight.Bold,

                            fontSize = 16.sp
                        )

                        Spacer(modifier = Modifier.height(4.dp))

                        Text(

                            text =
                                if (isKannada) {
                                    "ಕಾಡಿನಿಂದ ನೇರವಾಗಿ ಶುದ್ಧ ಜೇನು"
                                } else {
                                    "Forest-to-Table Organic Honey"
                                },

                            color = Color(0xFF5D4037),

                            fontSize = 17.sp
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(24.dp))

            // BUTTON GRID

            Row(

                modifier = Modifier.fillMaxWidth(),

                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {

                DashboardCard(

                    title =
                        if (isKannada) {
                            "ಜೇನು ಸೇರಿಸಿ"
                        } else {
                            "Add Harvest"
                        },

                    icon = Icons.Default.Add,

                    iconBackground = Color(0xFFFFC107),

                    onClick = onHarvestClick,

                    modifier = Modifier.weight(1f)
                )

                DashboardCard(

                    title =
                        if (isKannada) {
                            "ಗ್ರೇಡ್ ಪರಿಶೀಲನೆ"
                        } else {
                            "Check Grade"
                        },

                    icon = Icons.Default.Bookmark,

                    iconBackground = Color(0xFFFF9800),

                    onClick = onGradeClick,

                    modifier = Modifier.weight(1f)
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            Row(

                modifier = Modifier.fillMaxWidth(),

                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {

                DashboardCard(

                    title =
                        if (isKannada) {
                            "ಲೆಕ್ಕಪತ್ರ"
                        } else {
                            "Calculator"
                        },

                    icon = Icons.Default.Calculate,

                    iconBackground = Color(0xFF5DA2FF),

                    onClick = onCalculatorClick,

                    modifier = Modifier.weight(1f)
                )

                DashboardCard(

                    title =
                        if (isKannada) {
                            "ಬೆಲೆಗಳು"
                        } else {
                            "View Prices"
                        },

                    icon = Icons.Default.TrendingUp,

                    iconBackground = Color(0xFF2E7D32),

                    onClick = onPricesClick,

                    modifier = Modifier.weight(1f)
                )
            }

            Spacer(modifier = Modifier.height(24.dp))
        }
    }
}

@Composable
fun DashboardCard(

    title: String,

    icon: ImageVector,

    iconBackground: Color,

    onClick: () -> Unit,

    modifier: Modifier = Modifier
) {

    Card(

        modifier = modifier
            .height(170.dp)
            .clickable {
                onClick()
            },

        shape = RoundedCornerShape(24.dp),

        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),

        elevation = CardDefaults.cardElevation(
            defaultElevation = 4.dp
        )
    ) {

        Column(

            modifier = Modifier
                .fillMaxSize()
                .padding(18.dp),

            verticalArrangement = Arrangement.SpaceBetween
        ) {

            Box(

                modifier = Modifier
                    .size(58.dp)
                    .clip(RoundedCornerShape(18.dp))
                    .background(iconBackground),

                contentAlignment = Alignment.Center
            ) {

                Icon(

                    imageVector = icon,

                    contentDescription = title,

                    tint = Color.White,

                    modifier = Modifier.size(30.dp)
                )
            }

            Text(

                text = title,

                fontSize = 22.sp,

                fontWeight = FontWeight.SemiBold,

                color = Color(0xFF5D4037)
            )
        }
    }
}