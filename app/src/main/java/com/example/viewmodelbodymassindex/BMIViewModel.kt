package com.example.viewmodelbodymassindex

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class BMIViewModel : ViewModel() {
    var weightInput by mutableStateOf("")
    var heightInput by mutableStateOf("")

    fun changeWeight(value: String) {
        weightInput = value
    }

    fun changeHeight(value: String) {
        heightInput = value
    }

    private var weight: Float = 0.0f
        get() {
            return weightInput.toFloatOrNull() ?: 0.0f
        }

    private var height: Float = 0.0f
        get() {
            return heightInput.toFloatOrNull() ?: 0.0f
        }

    var result: Float = 0.0f
        get() {
            return calculate()
        }

    private fun calculate(): Float {
        return if (weight > 0 && height > 0) weight / (height * height) else 0.0f
    }
}