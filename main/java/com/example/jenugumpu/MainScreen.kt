package com.example.jenugumpu

import androidx.compose.runtime.*
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun MainScreen() {

    var currentScreen by remember {
        mutableStateOf("auth")
    }

    when (currentScreen) {

        // AUTH

        "auth" -> {
            AuthScreen(
                onLoginSuccess = {
                    currentScreen = "home"
                }
            )
        }

        // HOME

        "home" -> {

            HomeScreen(

                onHarvestClick = {
                    currentScreen = "harvest"
                },

                onGradeClick = {
                    currentScreen = "grade"
                },

                onCalculatorClick = {
                    currentScreen = "calculator"
                },

                onPricesClick = {
                    currentScreen = "prices"
                },

                onStockClick = {
                    currentScreen = "stock"
                },

                onProfileClick = {
                    currentScreen = "profile"
                }
            )
        }

        // HARVEST

        "harvest" -> {

            HarvestScreen(

                onHomeClick = {
                    currentScreen = "home"
                },

                onPricesClick = {
                    currentScreen = "prices"
                },

                onStockClick = {
                    currentScreen = "stock"
                },

                onProfileClick = {
                    currentScreen = "profile"
                }
            )
        }

        // GRADE

        "grade" -> {

            GradeScreen(

                onFinishClick = {
                    currentScreen = "home"
                },

                onHomeClick = {
                    currentScreen = "home"
                },

                onHarvestClick = {
                    currentScreen = "harvest"
                },

                onPricesClick = {
                    currentScreen = "prices"
                },

                onStockClick = {
                    currentScreen = "stock"
                },

                onProfileClick = {
                    currentScreen = "profile"
                }
            )
        }

        // CALCULATOR

        "calculator" -> {

            CalculatorScreen(

                onBackClick = {
                    currentScreen = "home"
                },

                onHomeClick = {
                    currentScreen = "home"
                },

                onHarvestClick = {
                    currentScreen = "harvest"
                },

                onPricesClick = {
                    currentScreen = "prices"
                },

                onStockClick = {
                    currentScreen = "stock"
                },

                onProfileClick = {
                    currentScreen = "profile"
                }
            )
        }

        // PRICE SCREEN

        "prices" -> {

            MarketScreen(

                onBackClick = {
                    currentScreen = "home"
                },

                onHomeClick = {
                    currentScreen = "home"
                },

                onHarvestClick = {
                    currentScreen = "harvest"
                },

                onStockClick = {
                    currentScreen = "stock"
                },

                onProfileClick = {
                    currentScreen = "profile"
                }
            )
        }

        // STOCK SCREEN

        "stock" -> {

            StockScreen(

                onHomeClick = {
                    currentScreen = "home"
                },

                onHarvestClick = {
                    currentScreen = "harvest"
                },

                onPricesClick = {
                    currentScreen = "prices"
                },

                onProfileClick = {
                    currentScreen = "profile"
                }
            )
        }

        // PROFILE SCREEN

        "profile" -> {

            ProfileScreen(

                onSustainableClick = {
                    currentScreen = "sustainable"
                },

                onLogoutClick = {
                    currentScreen = "auth"
                },

                onHomeClick = {
                    currentScreen = "home"
                },

                onHarvestClick = {
                    currentScreen = "harvest"
                },

                onPricesClick = {
                    currentScreen = "prices"
                },

                onStockClick = {
                    currentScreen = "stock"
                }
            )
        }

        // SUSTAINABLE SCREEN

        "sustainable" -> {

            SustainableScreen(

                onBackClick = {
                    currentScreen = "profile"
                },

                onHomeClick = {
                    currentScreen = "home"
                },

                onHarvestClick = {
                    currentScreen = "harvest"
                },

                onPricesClick = {
                    currentScreen = "prices"
                },

                onStockClick = {
                    currentScreen = "stock"
                },

                onProfileClick = {
                    currentScreen = "profile"
                }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    MainScreen()
}