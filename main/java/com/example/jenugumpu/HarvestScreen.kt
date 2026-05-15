package com.example.jenugumpu

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HarvestScreen(

    onHomeClick: () -> Unit,

    onPricesClick: () -> Unit,

    onStockClick: () -> Unit,

    onProfileClick: () -> Unit
) {

    val isKannada = LanguageManager.isKannada()

    var quantity by remember {
        mutableStateOf("")
    }

    var selectedFlower by remember {
        mutableStateOf("")
    }

    var expanded by remember {
        mutableStateOf(false)
    }

    val flowers =
        if (isKannada) {

            listOf(
                "ಕಾಫಿ ಹೂವು",
                "ಕಾಡು ಹೂವು",
                "ಬೆವು",
                "ಅರಣ್ಯ ಮಿಶ್ರಣ"
            )

        } else {

            listOf(
                "Coffee Blossom",
                "Wildflower",
                "Neem",
                "Forest Mix"
            )
        }

    val batchHistory = remember {

        mutableStateListOf(

            if (isKannada)
                "ಅರಣ್ಯ ಮಿಶ್ರಣ - 45kg"
            else
                "Forest Mix - 45kg",

            if (isKannada)
                "ಕಾಡು ಹೂವು - 32kg"
            else
                "Wildflower - 32kg",

            if (isKannada)
                "ಕಾಫಿ ಹೂವು - 20kg"
            else
                "Coffee Blossom - 20kg"
        )
    }

    Scaffold(

        containerColor = Color(0xFFF8F5EE),

        bottomBar = {

            BottomNavBar(

                selected = "harvest",

                onHomeClick = onHomeClick,

                onHarvestClick = { },

                onPricesClick = onPricesClick,

                onStockClick = onStockClick,

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

                    Spacer(modifier = Modifier.width(6.dp))

                    Text(

                        text =
                            if (isKannada) {
                                "ಸಂಗ್ರಹ ದಾಖಲೆ"
                            } else {
                                "Harvest Log"
                            },

                        fontSize = 30.sp,

                        fontWeight = FontWeight.Bold,

                        color = Color(0xFF5D4037)
                    )
                }

                Spacer(modifier = Modifier.height(20.dp))

                // ADD ENTRY CARD

                Card(

                    modifier = Modifier.fillMaxWidth(),

                    shape = RoundedCornerShape(28.dp),

                    colors = CardDefaults.cardColors(
                        containerColor = Color.White
                    )
                ) {

                    Column(
                        modifier = Modifier.padding(20.dp)
                    ) {

                        Text(

                            text =
                                if (isKannada) {
                                    "ಹೊಸ ಬ್ಯಾಚ್ ಸೇರಿಸಿ"
                                } else {
                                    "Add New Batch"
                                },

                            fontSize = 22.sp,

                            fontWeight = FontWeight.Bold,

                            color = Color(0xFF5D4037)
                        )

                        Spacer(modifier = Modifier.height(20.dp))

                        // DATE

                        Text(

                            text =
                                if (isKannada) {
                                    "ದಿನಾಂಕ"
                                } else {
                                    "Date"
                                },

                            fontWeight = FontWeight.SemiBold,

                            color = Color(0xFF8D6E63)
                        )

                        Spacer(modifier = Modifier.height(8.dp))

                        OutlinedTextField(

                            value = "07-05-2026",

                            onValueChange = { },

                            modifier = Modifier.fillMaxWidth(),

                            shape = RoundedCornerShape(16.dp),

                            colors = OutlinedTextFieldDefaults.colors(

                                focusedBorderColor = Color(0xFFFFC107),

                                unfocusedBorderColor = Color(0xFFFFE082),

                                focusedContainerColor = Color.White,

                                unfocusedContainerColor = Color.White
                            )
                        )

                        Spacer(modifier = Modifier.height(18.dp))

                        // QUANTITY

                        Text(

                            text =
                                if (isKannada) {
                                    "ಪ್ರಮಾಣ (ಕೆಜಿ)"
                                } else {
                                    "Quantity (KG)"
                                },

                            fontWeight = FontWeight.SemiBold,

                            color = Color(0xFF8D6E63)
                        )

                        Spacer(modifier = Modifier.height(8.dp))

                        OutlinedTextField(

                            value = quantity,

                            onValueChange = {
                                quantity = it
                            },

                            modifier = Modifier.fillMaxWidth(),

                            shape = RoundedCornerShape(16.dp),

                            colors = OutlinedTextFieldDefaults.colors(

                                focusedBorderColor = Color(0xFFFFC107),

                                unfocusedBorderColor = Color(0xFFFFE082),

                                focusedContainerColor = Color.White,

                                unfocusedContainerColor = Color.White
                            )
                        )

                        Spacer(modifier = Modifier.height(18.dp))

                        // FLORAL SOURCE

                        Text(

                            text =
                                if (isKannada) {
                                    "ಹೂ ಮೂಲ"
                                } else {
                                    "Floral Source"
                                },

                            fontWeight = FontWeight.SemiBold,

                            color = Color(0xFF8D6E63)
                        )

                        Spacer(modifier = Modifier.height(8.dp))

                        ExposedDropdownMenuBox(

                            expanded = expanded,

                            onExpandedChange = {
                                expanded = !expanded
                            }
                        ) {

                            OutlinedTextField(

                                value = selectedFlower,

                                onValueChange = { },

                                readOnly = true,

                                modifier = Modifier
                                    .menuAnchor()
                                    .fillMaxWidth(),

                                trailingIcon = {

                                    Icon(
                                        imageVector = Icons.Default.KeyboardArrowDown,
                                        contentDescription = null
                                    )
                                },

                                shape = RoundedCornerShape(16.dp),

                                colors = OutlinedTextFieldDefaults.colors(

                                    focusedBorderColor = Color(0xFFFFC107),

                                    unfocusedBorderColor = Color(0xFFFFE082),

                                    focusedContainerColor = Color.White,

                                    unfocusedContainerColor = Color.White
                                )
                            )

                            ExposedDropdownMenu(

                                expanded = expanded,

                                onDismissRequest = {
                                    expanded = false
                                }
                            ) {

                                flowers.forEach { flower ->

                                    DropdownMenuItem(

                                        text = {
                                            Text(flower)
                                        },

                                        onClick = {

                                            selectedFlower = flower

                                            expanded = false
                                        }
                                    )
                                }
                            }
                        }

                        Spacer(modifier = Modifier.height(24.dp))

                        // SAVE BUTTON

                        Button(

                            onClick = {

                                if (
                                    quantity.isNotEmpty() &&
                                    selectedFlower.isNotEmpty()
                                ) {

                                    batchHistory.add(
                                        0,
                                        "$selectedFlower - ${quantity}kg"
                                    )

                                    quantity = ""

                                    selectedFlower = ""
                                }
                            },

                            modifier = Modifier
                                .fillMaxWidth()
                                .height(58.dp),

                            shape = RoundedCornerShape(18.dp),

                            colors = ButtonDefaults.buttonColors(
                                containerColor = Color(0xFFF4B400)
                            )
                        ) {

                            Text(

                                text =
                                    if (isKannada) {
                                        "ಉಳಿಸಿ"
                                    } else {
                                        "Save Entry"
                                    },

                                color = Color(0xFF5D4037),

                                fontWeight = FontWeight.Bold,

                                fontSize = 20.sp
                            )
                        }
                    }
                }

                Spacer(modifier = Modifier.height(26.dp))

                Text(

                    text =
                        if (isKannada) {
                            "ಇತ್ತೀಚಿನ ಬ್ಯಾಚ್ ಇತಿಹಾಸ"
                        } else {
                            "Latest Batch History"
                        },

                    fontSize = 24.sp,

                    fontWeight = FontWeight.Bold,

                    color = Color(0xFF5D4037)
                )

                Spacer(modifier = Modifier.height(16.dp))
            }

            items(batchHistory) { batch ->

                Card(

                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 14.dp),

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

                        Text(
                            text = batch,
                            fontSize = 18.sp,
                            fontWeight = FontWeight.SemiBold,
                            color = Color(0xFF5D4037)
                        )

                        Text(

                            text =
                                if (isKannada) {
                                    "ಗ್ರೇಡ್ A"
                                } else {
                                    "GRADE A"
                                },

                            color = Color(0xFF2E7D32),

                            fontWeight = FontWeight.Bold
                        )
                    }
                }
            }

            item {

                Spacer(modifier = Modifier.height(20.dp))
            }
        }
    }
}