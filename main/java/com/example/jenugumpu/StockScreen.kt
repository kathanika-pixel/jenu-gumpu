package com.example.jenugumpu

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun StockScreen(

    onHomeClick: () -> Unit,

    onHarvestClick: () -> Unit,

    onPricesClick: () -> Unit,

    onProfileClick: () -> Unit
) {

    val isKannada = LanguageManager.isKannada()

    // DYNAMIC VALUES

    var userHarvest by remember {
        mutableIntStateOf(SharedData.totalHarvestKg)
    }

    val collectiveStock = userHarvest + 1200

    val availableStock = SharedData.availableStock

    val soldStock = SharedData.soldStock

    val pendingStock = SharedData.pendingStock

    Scaffold(

        containerColor = Color(0xFFF8F5EE),

        bottomBar = {

            BottomNavBar(

                selected = "stock",

                onHomeClick = onHomeClick,

                onHarvestClick = onHarvestClick,

                onPricesClick = onPricesClick,

                onStockClick = { },

                onProfileClick = onProfileClick
            )
        }

    ) { paddingValues ->

        LazyColumn(

            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFFF8F5EE))
                .padding(paddingValues)
                .padding(16.dp)
        ) {

            item {

                // HEADER

                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    IconButton(
                        onClick = onHomeClick
                    ) {

                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = "Back",
                            tint = Color(0xFF5D4037)
                        )
                    }

                    Spacer(modifier = Modifier.width(8.dp))

                    Text(

                        text =
                            if (isKannada) {
                                "ಒಟ್ಟು ಸ್ಟಾಕ್"
                            } else {
                                "Collective Stock"
                            },

                        fontSize = 30.sp,

                        fontWeight = FontWeight.Bold,

                        color = Color(0xFF5D4037)
                    )
                }

                Spacer(modifier = Modifier.height(22.dp))

                // MAIN CARD

                Card(

                    modifier = Modifier.fillMaxWidth(),

                    shape = RoundedCornerShape(30.dp),

                    colors = CardDefaults.cardColors(
                        containerColor = Color.White
                    )
                ) {

                    Column(
                        modifier = Modifier.padding(24.dp)
                    ) {

                        Text(

                            text =
                                if (isKannada) {
                                    "ಒಟ್ಟು ಸಂಗ್ರಹ"
                                } else {
                                    "TOTAL COLLECTIVE STOCK"
                                },

                            color = Color.Gray,

                            fontSize = 14.sp
                        )

                        Spacer(modifier = Modifier.height(10.dp))

                        Row(
                            verticalAlignment = Alignment.Bottom
                        ) {

                            Text(
                                text = collectiveStock.toString(),
                                fontSize = 54.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color(0xFF5D4037)
                            )

                            Spacer(modifier = Modifier.width(6.dp))

                            Text(

                                text =
                                    if (isKannada) {
                                        "ಕೆಜಿ"
                                    } else {
                                        "kg"
                                    },

                                fontSize = 26.sp,

                                color = Color(0xFF5D4037)
                            )
                        }

                        Spacer(modifier = Modifier.height(24.dp))

                        Text(

                            text =
                                if (isKannada) {
                                    "ಗೋದಾಮು ಸಾಮರ್ಥ್ಯ"
                                } else {
                                    "Warehouse Capacity"
                                },

                            color = Color.Gray,

                            fontSize = 15.sp
                        )

                        Spacer(modifier = Modifier.height(10.dp))

                        LinearProgressIndicator(

                            progress = { 0.65f },

                            modifier = Modifier
                                .fillMaxWidth()
                                .height(10.dp),

                            color = Color(0xFFF4B400),

                            trackColor = Color(0xFFFFF3CD)
                        )

                        Spacer(modifier = Modifier.height(8.dp))

                        Text(

                            text =
                                if (isKannada) {
                                    "65% ಸಾಮರ್ಥ್ಯ ಬಳಸಲಾಗಿದೆ"
                                } else {
                                    "65% Capacity Used"
                                },

                            color = Color(0xFF8D6E63),

                            fontSize = 14.sp
                        )
                    }
                }

                Spacer(modifier = Modifier.height(22.dp))

                // STATUS CARDS

                Row(

                    modifier = Modifier.fillMaxWidth(),

                    horizontalArrangement = Arrangement.spacedBy(12.dp)
                ) {

                    StockStatusCard(

                        title =
                            if (isKannada) {
                                "ಲಭ್ಯ"
                            } else {
                                "AVAILABLE"
                            },

                        value = "${availableStock}kg",

                        color = Color(0xFF2E7D32),

                        modifier = Modifier.weight(1f)
                    )

                    StockStatusCard(

                        title =
                            if (isKannada) {
                                "ಮಾರಾಟ"
                            } else {
                                "SOLD"
                            },

                        value = "${soldStock}kg",

                        color = Color(0xFFF4B400),

                        modifier = Modifier.weight(1f)
                    )

                    StockStatusCard(

                        title =
                            if (isKannada) {
                                "ಬಾಕಿ"
                            } else {
                                "PENDING"
                            },

                        value = "${pendingStock}kg",

                        color = Color(0xFFD84315),

                        modifier = Modifier.weight(1f)
                    )
                }

                Spacer(modifier = Modifier.height(28.dp))

                Text(

                    text =
                        if (isKannada) {
                            "ಸದಸ್ಯರ ಕೊಡುಗೆ"
                        } else {
                            "Member Contributions"
                        },

                    fontSize = 24.sp,

                    fontWeight = FontWeight.Bold,

                    color = Color(0xFF5D4037)
                )

                Spacer(modifier = Modifier.height(18.dp))

                ContributionCard(

                    name = "Basappa Gowda",

                    quantity = "45kg",

                    status =
                        if (isKannada) {
                            "ಮಾರಾಟ"
                        } else {
                            "SOLD"
                        }
                )

                Spacer(modifier = Modifier.height(14.dp))

                ContributionCard(

                    name = "Kushal Tribesman",

                    quantity = "122kg",

                    status =
                        if (isKannada) {
                            "ಲಭ್ಯ"
                        } else {
                            "AVAILABLE"
                        }
                )

                Spacer(modifier = Modifier.height(14.dp))

                ContributionCard(

                    name = "Siddharth M.",

                    quantity = "89kg",

                    status =
                        if (isKannada) {
                            "ಬಾಕಿ"
                        } else {
                            "PENDING"
                        }
                )

                Spacer(modifier = Modifier.height(20.dp))
            }
        }
    }
}

@Composable
fun StockStatusCard(

    title: String,

    value: String,

    color: Color,

    modifier: Modifier = Modifier
) {

    Card(

        modifier = modifier,

        shape = RoundedCornerShape(22.dp),

        colors = CardDefaults.cardColors(
            containerColor = Color.White
        )
    ) {

        Column(

            modifier = Modifier.padding(14.dp),

            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Text(
                text = title,
                fontSize = 11.sp,
                color = Color.Gray
            )

            Spacer(modifier = Modifier.height(6.dp))

            Text(
                text = value,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = color
            )
        }
    }
}

@Composable
fun ContributionCard(

    name: String,

    quantity: String,

    status: String
) {

    Card(

        modifier = Modifier.fillMaxWidth(),

        shape = RoundedCornerShape(22.dp),

        colors = CardDefaults.cardColors(
            containerColor = Color.White
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
                    text = name,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF5D4037)
                )

                Spacer(modifier = Modifier.height(4.dp))

                Text(
                    text = status,
                    color = Color(0xFF8D6E63),
                    fontSize = 14.sp
                )
            }

            Text(
                text = quantity,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFFF4B400)
            )
        }
    }
}