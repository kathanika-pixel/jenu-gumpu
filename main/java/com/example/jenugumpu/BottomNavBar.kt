package com.example.jenugumpu

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Inventory2
import androidx.compose.material.icons.filled.TrendingUp
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Inventory2
import androidx.compose.material.icons.outlined.TrendingUp
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp

@Composable
fun BottomNavBar(

    selected: String,

    onHomeClick: () -> Unit,

    onHarvestClick: () -> Unit,

    onPricesClick: () -> Unit,

    onStockClick: () -> Unit,

    onProfileClick: () -> Unit
) {

    val isKannada = LanguageManager.isKannada()

    NavigationBar(

        containerColor = Color.White
    ) {

        // HOME

        NavigationBarItem(

            selected = selected == "home",

            onClick = onHomeClick,

            icon = {

                Icon(

                    imageVector =
                        if (selected == "home") {
                            Icons.Filled.Home
                        } else {
                            Icons.Outlined.Home
                        },

                    contentDescription = "Home"
                )
            },

            label = {

                Text(

                    text =
                        if (isKannada) {
                            "ಮುಖಪುಟ"
                        } else {
                            "Home"
                        },

                    fontSize = 11.sp
                )
            },

            colors = NavigationBarItemDefaults.colors(

                selectedIconColor = Color(0xFFF4B400),

                selectedTextColor = Color(0xFFF4B400),

                indicatorColor = Color(0x15F4B400),

                unselectedIconColor = Color.Gray,

                unselectedTextColor = Color.Gray
            )
        )

        // HARVEST

        NavigationBarItem(

            selected = selected == "harvest",

            onClick = onHarvestClick,

            icon = {

                Icon(

                    imageVector =
                        if (selected == "harvest") {
                            Icons.Filled.Inventory2
                        } else {
                            Icons.Outlined.Inventory2
                        },

                    contentDescription = "Harvest"
                )
            },

            label = {

                Text(

                    text =
                        if (isKannada) {
                            "ಸಂಗ್ರಹ"
                        } else {
                            "Harvest"
                        },

                    fontSize = 11.sp
                )
            },

            colors = NavigationBarItemDefaults.colors(

                selectedIconColor = Color(0xFFF4B400),

                selectedTextColor = Color(0xFFF4B400),

                indicatorColor = Color(0x15F4B400),

                unselectedIconColor = Color.Gray,

                unselectedTextColor = Color.Gray
            )
        )

        // PRICES

        NavigationBarItem(

            selected = selected == "prices",

            onClick = onPricesClick,

            icon = {

                Icon(

                    imageVector =
                        if (selected == "prices") {
                            Icons.Filled.TrendingUp
                        } else {
                            Icons.Outlined.TrendingUp
                        },

                    contentDescription = "Prices"
                )
            },

            label = {

                Text(

                    text =
                        if (isKannada) {
                            "ಬೆಲೆಗಳು"
                        } else {
                            "Prices"
                        },

                    fontSize = 11.sp
                )
            },

            colors = NavigationBarItemDefaults.colors(

                selectedIconColor = Color(0xFFF4B400),

                selectedTextColor = Color(0xFFF4B400),

                indicatorColor = Color(0x15F4B400),

                unselectedIconColor = Color.Gray,

                unselectedTextColor = Color.Gray
            )
        )

        // STOCK

        NavigationBarItem(

            selected = selected == "stock",

            onClick = onStockClick,

            icon = {

                Icon(

                    imageVector =
                        if (selected == "stock") {
                            Icons.Filled.Inventory2
                        } else {
                            Icons.Outlined.Inventory2
                        },

                    contentDescription = "Stock"
                )
            },

            label = {

                Text(

                    text =
                        if (isKannada) {
                            "ಸ್ಟಾಕ್"
                        } else {
                            "Stock"
                        },

                    fontSize = 11.sp
                )
            },

            colors = NavigationBarItemDefaults.colors(

                selectedIconColor = Color(0xFFF4B400),

                selectedTextColor = Color(0xFFF4B400),

                indicatorColor = Color(0x15F4B400),

                unselectedIconColor = Color.Gray,

                unselectedTextColor = Color.Gray
            )
        )

        // PROFILE

        NavigationBarItem(

            selected = selected == "profile",

            onClick = onProfileClick,

            icon = {

                Icon(

                    imageVector =
                        if (selected == "profile") {
                            Icons.Filled.AccountCircle
                        } else {
                            Icons.Outlined.AccountCircle
                        },

                    contentDescription = "Profile"
                )
            },

            label = {

                Text(

                    text =
                        if (isKannada) {
                            "ಪ್ರೊಫೈಲ್"
                        } else {
                            "Profile"
                        },

                    fontSize = 11.sp
                )
            },

            colors = NavigationBarItemDefaults.colors(

                selectedIconColor = Color(0xFFF4B400),

                selectedTextColor = Color(0xFFF4B400),

                indicatorColor = Color(0x15F4B400),

                unselectedIconColor = Color.Gray,

                unselectedTextColor = Color.Gray
            )
        )
    }
}