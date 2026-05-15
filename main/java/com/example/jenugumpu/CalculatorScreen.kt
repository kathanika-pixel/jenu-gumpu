package com.example.jenugumpu

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
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
fun CalculatorScreen(

    onBackClick: () -> Unit,

    onHomeClick: () -> Unit,

    onHarvestClick: () -> Unit,

    onPricesClick: () -> Unit,

    onStockClick: () -> Unit,

    onProfileClick: () -> Unit
) {

    val isKannada = LanguageManager.isKannada()

    var quantity by remember {
        mutableStateOf("")
    }

    var costPerKg by remember {
        mutableStateOf("")
    }

    var filteringCost by remember {
        mutableStateOf("")
    }

    var sellingPrice by remember {
        mutableStateOf("")
    }

    val qty = quantity.toDoubleOrNull() ?: 0.0

    val cost = costPerKg.toDoubleOrNull() ?: 0.0

    val filter = filteringCost.toDoubleOrNull() ?: 0.0

    val price = sellingPrice.toDoubleOrNull() ?: 0.0

    // CALCULATIONS

    val revenue = qty * price

    val productionCost = qty * cost

    val totalExpense = productionCost + filter

    val netProfit = revenue - totalExpense

    val roi =
        if (totalExpense > 0) {
            (netProfit / totalExpense) * 100
        } else {
            0.0
        }

    Scaffold(

        containerColor = Color(0xFFF8F5EE),

        bottomBar = {

            BottomNavBar(

                selected = "calculator",

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
                        contentDescription = "Back",
                        tint = Color(0xFF5D4037)
                    )
                }

                Spacer(modifier = Modifier.width(8.dp))

                Text(

                    text =
                        if (isKannada) {
                            "ಲಾಭ ಲೆಕ್ಕಾಚಾರ"
                        } else {
                            "Profit Calculator"
                        },

                    fontSize = 28.sp,

                    fontWeight = FontWeight.Bold,

                    color = Color(0xFF5D4037)
                )
            }

            Spacer(modifier = Modifier.height(24.dp))

            // PROFIT CARD

            Card(

                modifier = Modifier.fillMaxWidth(),

                shape = RoundedCornerShape(28.dp),

                colors = CardDefaults.cardColors(
                    containerColor = Color(0xFF2962FF)
                )
            ) {

                Column(
                    modifier = Modifier.padding(24.dp)
                ) {

                    Text(

                        text =
                            if (isKannada) {
                                "ಒಟ್ಟು ಆದಾಯ"
                            } else {
                                "NET EARNINGS"
                            },

                        color = Color.White.copy(alpha = 0.7f),

                        fontSize = 14.sp
                    )

                    Spacer(modifier = Modifier.height(10.dp))

                    Text(
                        text = "₹${netProfit.toInt()}",
                        color = Color.White,
                        fontSize = 42.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
            }

            Spacer(modifier = Modifier.height(22.dp))

            // INPUT CARD

            Card(

                modifier = Modifier.fillMaxWidth(),

                shape = RoundedCornerShape(22.dp),

                colors = CardDefaults.cardColors(
                    containerColor = Color.White
                )
            ) {

                Column(
                    modifier = Modifier.padding(18.dp)
                ) {

                    CalculatorField(

                        label =
                            if (isKannada) {
                                "ಪ್ರಮಾಣ (ಕೆಜಿ)"
                            } else {
                                "Quantity (KG)"
                            },

                        value = quantity,

                        onValueChange = {
                            quantity = it
                        }
                    )

                    CalculatorField(

                        label =
                            if (isKannada) {
                                "ಪ್ರತಿ ಕೆಜಿ ವೆಚ್ಚ"
                            } else {
                                "Cost Per KG (₹)"
                            },

                        value = costPerKg,

                        onValueChange = {
                            costPerKg = it
                        }
                    )

                    CalculatorField(

                        label =
                            if (isKannada) {
                                "ಫಿಲ್ಟರಿಂಗ್ ವೆಚ್ಚ"
                            } else {
                                "Filtering Cost (₹)"
                            },

                        value = filteringCost,

                        onValueChange = {
                            filteringCost = it
                        }
                    )

                    CalculatorField(

                        label =
                            if (isKannada) {
                                "ಮಾರಾಟ ಬೆಲೆ"
                            } else {
                                "Selling Price Per KG (₹)"
                            },

                        value = sellingPrice,

                        onValueChange = {
                            sellingPrice = it
                        }
                    )
                }
            }

            Spacer(modifier = Modifier.height(22.dp))

            // RESULT CARD

            Card(

                modifier = Modifier.fillMaxWidth(),

                shape = RoundedCornerShape(22.dp),

                colors = CardDefaults.cardColors(
                    containerColor = Color.White
                )
            ) {

                Column(
                    modifier = Modifier.padding(20.dp)
                ) {

                    ResultRow(

                        title =
                            if (isKannada) {
                                "ಒಟ್ಟು ಆದಾಯ"
                            } else {
                                "Total Revenue"
                            },

                        value = "₹${revenue.toInt()}"
                    )

                    ResultRow(

                        title =
                            if (isKannada) {
                                "ಉತ್ಪಾದನಾ ವೆಚ್ಚ"
                            } else {
                                "Production Cost"
                            },

                        value = "₹${productionCost.toInt()}"
                    )

                    ResultRow(

                        title =
                            if (isKannada) {
                                "ಫಿಲ್ಟರಿಂಗ್ ವೆಚ್ಚ"
                            } else {
                                "Filtering Cost"
                            },

                        value = "₹${filter.toInt()}"
                    )

                    ResultRow(

                        title =
                            if (isKannada) {
                                "ನಿಕರ ಲಾಭ"
                            } else {
                                "Net Profit"
                            },

                        value = "₹${netProfit.toInt()}"
                    )

                    ResultRow(

                        title =
                            if (isKannada) {
                                "ROI"
                            } else {
                                "ROI"
                            },

                        value = "${roi.toInt()}%"
                    )
                }
            }

            Spacer(modifier = Modifier.height(20.dp))
        }
    }
}

@Composable
fun CalculatorField(

    label: String,

    value: String,

    onValueChange: (String) -> Unit
) {

    Column {

        Text(
            text = label,
            fontSize = 13.sp,
            color = Color(0xFF8D6E63),
            fontWeight = FontWeight.SemiBold
        )

        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(

            value = value,

            onValueChange = onValueChange,

            modifier = Modifier.fillMaxWidth(),

            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number
            ),

            shape = RoundedCornerShape(16.dp),

            colors = OutlinedTextFieldDefaults.colors(

                focusedBorderColor = Color(0xFFFFC107),

                unfocusedBorderColor = Color(0xFFFFE082),

                focusedContainerColor = Color.White,

                unfocusedContainerColor = Color.White
            )
        )

        Spacer(modifier = Modifier.height(16.dp))
    }
}

@Composable
fun ResultRow(

    title: String,

    value: String
) {

    Row(

        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),

        horizontalArrangement = Arrangement.SpaceBetween
    ) {

        Text(
            text = title,
            fontSize = 16.sp,
            color = Color(0xFF5D4037)
        )

        Text(
            text = value,
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF2E7D32)
        )
    }
}
