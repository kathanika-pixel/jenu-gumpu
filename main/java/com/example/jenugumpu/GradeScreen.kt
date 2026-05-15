package com.example.jenugumpu

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.WaterDrop
import androidx.compose.material.icons.filled.WbSunny
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun GradeScreen(

    onFinishClick: () -> Unit,

    onHomeClick: () -> Unit,

    onHarvestClick: () -> Unit,

    onPricesClick: () -> Unit,

    onStockClick: () -> Unit,

    onProfileClick: () -> Unit
) {

    val isKannada = LanguageManager.isKannada()

    var selectedColor by remember {
        mutableStateOf<String?>(null)
    }

    var selectedMoisture by remember {
        mutableStateOf<String?>(null)
    }

    // GRADE LOGIC

    val grade = when {

        selectedColor == null ||
                selectedMoisture == null -> null

        selectedMoisture == "High" -> "C"

        selectedMoisture == "Medium" -> "B"

        selectedMoisture == "Low" &&
                (
                        selectedColor == "Golden" ||
                                selectedColor == "Light Amber"
                        ) -> "A"

        selectedMoisture == "Low" &&
                selectedColor == "Dark Amber" -> "B"

        else -> null
    }

    val gradeDescription = when (grade) {

        "A" ->

            if (isKannada) {
                "ಉತ್ತಮ ಗುಣಮಟ್ಟದ ರಫ್ತು ಜೇನು."
            } else {
                "Premium export-quality honey with excellent shelf life."
            }

        "B" ->

            if (isKannada) {
                "ಸ್ಥಳೀಯ ಮಾರುಕಟ್ಟೆಗೆ ಸೂಕ್ತ ಗುಣಮಟ್ಟ."
            } else {
                "Standard quality suitable for local and retail markets."
            }

        "C" ->

            if (isKannada) {
                "ಹೆಚ್ಚಿನ ತೇವಾಂಶ ಪತ್ತೆಯಾಗಿದೆ."
            } else {
                "High moisture detected. Recommended for immediate consumption."
            }

        else -> ""
    }

    val gradeColor = when (grade) {

        "A" -> Color(0xFF2E7D32)

        "B" -> Color(0xFFF4B400)

        "C" -> Color(0xFFD84315)

        else -> Color.Gray
    }

    Scaffold(

        containerColor = Color(0xFFF8F5EE),

        bottomBar = {

            BottomNavBar(

                selected = "grade",

                onHomeClick = onHomeClick,

                onHarvestClick = onHarvestClick,

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

                    Spacer(modifier = Modifier.width(8.dp))

                    Text(

                        text =
                            if (isKannada) {
                                "ಜೇನು ಗ್ರೇಡಿಂಗ್"
                            } else {
                                "Honey Grading"
                            },

                        fontSize = 30.sp,

                        fontWeight = FontWeight.Bold,

                        color = Color(0xFF5D4037)
                    )
                }

                Spacer(modifier = Modifier.height(24.dp))

                // COLOR CHECK

                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    Icon(
                        imageVector = Icons.Default.WbSunny,
                        contentDescription = null,
                        tint = Color(0xFFF4B400)
                    )

                    Spacer(modifier = Modifier.width(8.dp))

                    Text(

                        text =
                            if (isKannada) {
                                "ಹಂತ 1: ಬಣ್ಣ ಪರೀಕ್ಷೆ"
                            } else {
                                "Step 1: Color Check"
                            },

                        fontWeight = FontWeight.Bold,

                        fontSize = 22.sp,

                        color = Color(0xFF5D4037)
                    )
                }

                Spacer(modifier = Modifier.height(18.dp))

                Row(
                    horizontalArrangement = Arrangement.spacedBy(12.dp)
                ) {

                    GradeColorCard(

                        title =
                            if (isKannada) {
                                "ಲೈಟ್ ಅಂಬರ್"
                            } else {
                                "Light Amber"
                            },

                        color = Color(0xFFFFB300),

                        selected = selectedColor == "Light Amber"
                    ) {
                        selectedColor = "Light Amber"
                    }

                    GradeColorCard(

                        title =
                            if (isKannada) {
                                "ಡಾರ್ಕ್ ಅಂಬರ್"
                            } else {
                                "Dark Amber"
                            },

                        color = Color(0xFF8D5524),

                        selected = selectedColor == "Dark Amber"
                    ) {
                        selectedColor = "Dark Amber"
                    }

                    GradeColorCard(

                        title =
                            if (isKannada) {
                                "ಗೋಲ್ಡನ್"
                            } else {
                                "Golden"
                            },

                        color = Color(0xFFFFD54F),

                        selected = selectedColor == "Golden"
                    ) {
                        selectedColor = "Golden"
                    }
                }

                Spacer(modifier = Modifier.height(34.dp))

                // MOISTURE

                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    Icon(
                        imageVector = Icons.Default.WaterDrop,
                        contentDescription = null,
                        tint = Color(0xFF42A5F5)
                    )

                    Spacer(modifier = Modifier.width(8.dp))

                    Text(

                        text =
                            if (isKannada) {
                                "ಹಂತ 2: ತೇವಾಂಶ ಪರೀಕ್ಷೆ"
                            } else {
                                "Step 2: Moisture Check"
                            },

                        fontWeight = FontWeight.Bold,

                        fontSize = 22.sp,

                        color = Color(0xFF5D4037)
                    )
                }

                Spacer(modifier = Modifier.height(18.dp))

                Row(
                    horizontalArrangement = Arrangement.spacedBy(12.dp)
                ) {

                    MoistureCard(

                        title =
                            if (isKannada) {
                                "ಕಡಿಮೆ"
                            } else {
                                "Low"
                            },

                        subtitle = "<17%",

                        selected = selectedMoisture == "Low"
                    ) {
                        selectedMoisture = "Low"
                    }

                    MoistureCard(

                        title =
                            if (isKannada) {
                                "ಮಧ್ಯಮ"
                            } else {
                                "Medium"
                            },

                        subtitle = "18-20%",

                        selected = selectedMoisture == "Medium"
                    ) {
                        selectedMoisture = "Medium"
                    }

                    MoistureCard(

                        title =
                            if (isKannada) {
                                "ಹೆಚ್ಚು"
                            } else {
                                "High"
                            },

                        subtitle = ">21%",

                        selected = selectedMoisture == "High"
                    ) {
                        selectedMoisture = "High"
                    }
                }

                Spacer(modifier = Modifier.height(36.dp))

                // RESULT

                if (grade != null) {

                    Card(

                        modifier = Modifier.fillMaxWidth(),

                        shape = RoundedCornerShape(30.dp),

                        colors = CardDefaults.cardColors(
                            containerColor = Color.White
                        )
                    ) {

                        Column(

                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(28.dp),

                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {

                            Box(

                                modifier = Modifier
                                    .size(96.dp)
                                    .clip(CircleShape)
                                    .background(gradeColor),

                                contentAlignment = Alignment.Center
                            ) {

                                Text(
                                    text = grade,
                                    color = Color.White,
                                    fontSize = 44.sp,
                                    fontWeight = FontWeight.Bold
                                )
                            }

                            Spacer(modifier = Modifier.height(22.dp))

                            Text(

                                text =
                                    if (isKannada) {
                                        "ಪ್ರಮಾಣಿತ ಗ್ರೇಡ್ $grade"
                                    } else {
                                        "Certified Grade $grade"
                                    },

                                fontSize = 30.sp,

                                fontWeight = FontWeight.Bold,

                                color = Color(0xFF5D4037)
                            )

                            Spacer(modifier = Modifier.height(12.dp))

                            Text(

                                text = gradeDescription,

                                textAlign = TextAlign.Center,

                                modifier = Modifier.fillMaxWidth(),

                                color = gradeColor,

                                fontSize = 16.sp
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(28.dp))

                    Button(

                        onClick = onFinishClick,

                        modifier = Modifier
                            .fillMaxWidth()
                            .height(60.dp),

                        shape = RoundedCornerShape(18.dp),

                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(0xFFF4B400)
                        )
                    ) {

                        Text(

                            text =
                                if (isKannada) {
                                    "ಮುಗಿಸಿ"
                                } else {
                                    "Finish Assessment"
                                },

                            color = Color(0xFF5D4037),

                            fontWeight = FontWeight.Bold,

                            fontSize = 20.sp
                        )
                    }
                }

                Spacer(modifier = Modifier.height(20.dp))
            }
        }
    }
}

@Composable
fun GradeColorCard(

    title: String,

    color: Color,

    selected: Boolean,

    onClick: () -> Unit
) {

    Card(

        modifier = Modifier
            .width(110.dp)
            .height(125.dp)
            .clickable {
                onClick()
            }
            .border(
                width = if (selected) 3.dp else 1.dp,
                color =
                    if (selected)
                        Color(0xFFF4B400)
                    else
                        Color(0xFFE0E0E0),

                shape = RoundedCornerShape(22.dp)
            ),

        shape = RoundedCornerShape(22.dp),

        colors = CardDefaults.cardColors(
            containerColor = Color.White
        )
    ) {

        Column(

            modifier = Modifier.fillMaxSize(),

            horizontalAlignment = Alignment.CenterHorizontally,

            verticalArrangement = Arrangement.Center
        ) {

            Box(

                modifier = Modifier
                    .size(46.dp)
                    .clip(CircleShape)
                    .background(color)
            )

            Spacer(modifier = Modifier.height(14.dp))

            Text(
                text = title,
                fontWeight = FontWeight.Bold,
                fontSize = 13.sp,
                color = Color(0xFF5D4037),
                textAlign = TextAlign.Center
            )
        }
    }
}

@Composable
fun MoistureCard(

    title: String,

    subtitle: String,

    selected: Boolean,

    onClick: () -> Unit
) {

    Card(

        modifier = Modifier
            .width(110.dp)
            .height(110.dp)
            .clickable {
                onClick()
            }
            .border(
                width = if (selected) 3.dp else 1.dp,
                color =
                    if (selected)
                        Color(0xFF42A5F5)
                    else
                        Color(0xFFE0E0E0),

                shape = RoundedCornerShape(22.dp)
            ),

        shape = RoundedCornerShape(22.dp),

        colors = CardDefaults.cardColors(
            containerColor = Color.White
        )
    ) {

        Column(

            modifier = Modifier.fillMaxSize(),

            horizontalAlignment = Alignment.CenterHorizontally,

            verticalArrangement = Arrangement.Center
        ) {

            Text(
                text = title,
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF5D4037)
            )

            Spacer(modifier = Modifier.height(6.dp))

            Text(
                text = subtitle,
                color = Color.Gray,
                fontSize = 13.sp
            )
        }
    }
}