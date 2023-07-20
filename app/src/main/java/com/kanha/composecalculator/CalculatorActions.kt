package com.kanha.composecalculator

sealed class CalculatorActions{
    data class Number(val number : Int) : CalculatorActions()
    data class Operations(val operation: CalculatorOperation) : CalculatorActions()
    object Clear : CalculatorActions()
    object Delete : CalculatorActions()
    object Calculate : CalculatorActions()
    object Decimal : CalculatorActions()
}
