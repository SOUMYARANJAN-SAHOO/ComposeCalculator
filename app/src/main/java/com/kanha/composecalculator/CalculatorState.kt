package com.kanha.composecalculator

data class CalculatorState(
    val Number1 : String = "",
    val Number2 : String = "",
    val Operation : CalculatorOperation? = null
)