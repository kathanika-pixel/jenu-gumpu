package com.example.jenugumpu

import androidx.compose.runtime.mutableStateOf

object LanguageManager {

    // EN = English
    // KN = Kannada

    var currentLanguage = mutableStateOf("EN")

    fun toggleLanguage() {

        currentLanguage.value =
            if (currentLanguage.value == "EN") {
                "KN"
            } else {
                "EN"
            }
    }

    fun isKannada(): Boolean {

        return currentLanguage.value == "KN"
    }

    fun setKannada(value: Boolean) {

        currentLanguage.value =
            if (value) {
                "KN"
            } else {
                "EN"
            }
    }
}