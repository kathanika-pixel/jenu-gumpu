package com.example.jenugumpu

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun MarketScreen(

    onBackClick: () -> Unit,

    onHomeClick: () -> Unit,

    onHarvestClick: () -> Unit,

    onStockClick: () -> Unit,

    onProfileClick: () -> Unit
) {

    val isKannada = LanguageManager.isKannada()

    Scaffold(

        containerColor = Color(0xFFF8F5EE),

        bottomBar = {

            BottomNavBar(

                selected = "prices",

                onHomeClick = onHomeClick,

                onHarvestClick = onHarvestClick,

                onPricesClick = {},

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
                        contentDescription = "Back",
                        tint = Color(0xFF5D4037)
                    )
                }

                Spacer(modifier = Modifier.width(6.dp))

                Text(

                    text =
                        if (isKannada) {
                            "ಮಾರುಕಟ್ಟೆ ಬೆಲೆಗಳು"
                        } else {
                            "Market Prices"
                        },

                    fontSize = 28.sp,

                    fontWeight = FontWeight.Bold,

                    color = Color(0xFF5D4037)
                )
            }

            Spacer(modifier = Modifier.height(22.dp))

            // GRAPH CARD

            Card(

                modifier = Modifier.fillMaxWidth(),

                shape = RoundedCornerShape(28.dp),

                colors = CardDefaults.cardColors(
                    containerColor = Color.White
                ),

                elevation = CardDefaults.cardElevation(
                    defaultElevation = 4.dp
                )
            ) {

                Column(
                    modifier = Modifier.padding(20.dp)
                ) {

                    Text(

                        text =
                            if (isKannada) {
                                "ಜೇನು ಮಾರಾಟ ಪ್ರವೃತ್ತಿ"
                            } else {
                                "Honey Sales Trend"
                            },

                        fontSize = 22.sp,

                        fontWeight = FontWeight.Bold,

                        color = Color(0xFF5D4037)
                    )

                    Spacer(modifier = Modifier.height(20.dp))

                    // GRAPH

                    Box(

                        modifier = Modifier
                            .fillMaxWidth()
                            .height(220.dp)
                            .background(
                                Color(0xFFF6F2EA),
                                RoundedCornerShape(22.dp)
                            )
                            .padding(18.dp)
                    ) {

                        Canvas(
                            modifier = Modifier.fillMaxSize()
                        ) {

                            val width = size.width
                            val height = size.height

                            val points = listOf(

                                Offset(0f, height * 0.8f),

                                Offset(width * 0.18f, height * 0.7f),

                                Offset(width * 0.36f, height * 0.55f),

                                Offset(width * 0.54f, height * 0.6f),

                                Offset(width * 0.72f, height * 0.35f),

                                Offset(width, height * 0.18f)
                            )

                            // GRID

                            for (i in 1..4) {

                                drawLine(
                                    color = Color(0xFFE0D8CC),
                                    start = Offset(0f, height / 5 * i),
                                    end = Offset(width, height / 5 * i),
                                    strokeWidth = 2f
                                )
                            }

                            // LINE GRAPH

                            for (i in 0 until points.size - 1) {

                                drawLine(
                                    color = Color(0xFFFFC107),
                                    start = points[i],
                                    end = points[i + 1],
                                    strokeWidth = 8f,
                                    cap = StrokeCap.Round
                                )
                            }

                            // DOTS

                            points.forEach {

                                drawCircle(
                                    color = Color(0xFF2E7D32),
                                    radius = 10f,
                                    center = it
                                )
                            }
                        }
                    }

                    Spacer(modifier = Modifier.height(18.dp))

                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {

                        Text(
                            text = "+4.2%",
                            color = Color(0xFF2E7D32),
                            fontWeight = FontWeight.Bold,
                            fontSize = 24.sp
                        )

                        Spacer(modifier = Modifier.width(8.dp))

                        Text(

                            text =
                                if (isKannada) {
                                    "ಮಾಸಿಕ ಲಾಭದ ಬೆಳವಣಿಗೆ"
                                } else {
                                    "Monthly Profit Growth"
                                },

                            color = Color.Gray,

                            fontSize = 16.sp
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(26.dp))

            Text(

                text =
                    if (isKannada) {
                        "ನಗರವಾರು ಹೋಲಿಕೆ"
                    } else {
                        "City-wise Comparison"
                    },

                fontSize = 24.sp,

                fontWeight = FontWeight.Bold,

                color = Color(0xFF5D4037)
            )

            Spacer(modifier = Modifier.height(18.dp))

            CityCard(

                city =
                    if (isKannada) {
                        "ಬೆಂಗಳೂರು"
                    } else {
                        "Bangalore"
                    },

                wholesale = "₹620",

                retail = "₹850",

                profit = "+15₹",

                profitColor = Color(0xFF2E7D32),

                isKannada = isKannada
            )

            Spacer(modifier = Modifier.height(14.dp))

            CityCard(

                city =
                    if (isKannada) {
                        "ಮೈಸೂರು"
                    } else {
                        "Mysore"
                    },

                wholesale = "₹590",

                retail = "₹820",

                profit = "-5₹",

                profitColor = Color.Red,

                isKannada = isKannada
            )

            Spacer(modifier = Modifier.height(14.dp))

            CityCard(

                city =
                    if (isKannada) {
                        "ಮಂಗಳೂರು"
                    } else {
                        "Mangalore"
                    },

                wholesale = "₹650",

                retail = "₹880",

                profit = "+10₹",

                profitColor = Color(0xFF2E7D32),

                isKannada = isKannada
            )

            Spacer(modifier = Modifier.height(20.dp))
        }
    }
}

@Composable
fun CityCard(

    city: String,

    wholesale: String,

    retail: String,

    profit: String,

    profitColor: Color,

    isKannada: Boolean
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

            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp),

            horizontalArrangement = Arrangement.SpaceBetween,

            verticalAlignment = Alignment.CenterVertically
        ) {

            Column {

                Text(
                    text = city,
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF5D4037)
                )

                Spacer(modifier = Modifier.height(6.dp))

                Text(

                    text =
                        if (isKannada) {
                            "ಹೊಲ್ಸೇಲ್: $wholesale"
                        } else {
                            "Wholesale: $wholesale"
                        },

                    color = Color.Gray,

                    fontSize = 15.sp
                )

                Spacer(modifier = Modifier.height(2.dp))

                Text(

                    text =
                        if (isKannada) {
                            "ಚಿಲ್ಲರೆ: $retail"
                        } else {
                            "Retail: $retail"
                        },

                    color = Color.Gray,

                    fontSize = 15.sp
                )
            }

            Text(
                text = profit,
                color = profitColor,
                fontWeight = FontWeight.Bold,
                fontSize = 22.sp
            )
        }
    }
}