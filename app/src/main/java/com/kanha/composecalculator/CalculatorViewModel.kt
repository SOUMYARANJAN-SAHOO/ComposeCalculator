package com.kanha.composecalculator

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class CalculatorViewModel : ViewModel() {

    var state by mutableStateOf(CalculatorState())

    fun onAction(action: CalculatorActions) {
        when(action){
            is CalculatorActions.Number -> enteredNumber(action.number)
            is CalculatorActions.Operations -> enteredOperation(action.operation)
            is CalculatorActions.Decimal-> enteredDecimal()
            is CalculatorActions.Delete-> pressedDelete()
            is CalculatorActions.Clear-> pressedClear()
            is CalculatorActions.Calculate-> pressedCalculate()
        }
    }

    private fun pressedCalculate() {
        val number1 = state.Number1.toDoubleOrNull()
        val number2 = state.Number2.toDoubleOrNull()

        if(number1 != null && number2 != null){
            val result = when(state.Operation){
                is CalculatorOperation.Add -> number1 + number2
                is CalculatorOperation.Substract -> number1 - number2
                is CalculatorOperation.Multiply -> number1 * number2
                is CalculatorOperation.Divide -> number1 / number2
                else -> null
            }
            state = state.copy(
                Number1 = result.toString().take(15),
                Number2 = "",
                Operation = null
            )
        }
    }

    private fun pressedClear() {
        state = CalculatorState()
    }

    private fun enteredDecimal() {
        if(state.Operation == null && state.Number1.length < MAX_NUMBER_LENGTH && !state.Number1.contains(".")){
            state = state.copy(Number1 = state.Number1  + ".")
            return
        }
        if(state.Operation != null && state.Number2.length < MAX_NUMBER_LENGTH && !state.Number2.contains(".")){
            state = state.copy(Number2 = state.Number2  + ".")
            return
        }
    }

    private fun pressedDelete() {
        when{
            state.Number2.isNotBlank() -> state = state.copy(Number2 = state.Number2.dropLast(1))

            state.Operation != null -> state = state.copy(Operation = null)

            state.Number1.isNotBlank() -> state = state.copy(Number1 = state.Number1.dropLast(1))
        }
    }

    private fun enteredOperation(operation: CalculatorOperation) {
        if(state.Number1.isNotBlank()) state = state.copy(Operation = operation)
    }

    private fun enteredNumber(number: Int) {
        if(state.Operation == null && state.Number1.length < MAX_NUMBER_LENGTH ){
            state = state.copy(Number1 = state.Number1  + number.toString())
            return
        }
        if(state.Operation != null && state.Number2.length < MAX_NUMBER_LENGTH ){
            state = state.copy(Number2 = state.Number2  + number.toString())
            return
        }
    }

    companion object{
        private const val MAX_NUMBER_LENGTH = 8
    }

}