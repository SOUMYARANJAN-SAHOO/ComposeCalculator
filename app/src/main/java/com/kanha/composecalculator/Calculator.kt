package com.kanha.composecalculator

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kanha.composecalculator.ui.theme.*

@Composable
fun Calculator(
    state: CalculatorState,
    viewModel: CalculatorViewModel,
    modifier: Modifier = Modifier,
    buttonSpacing: Dp = 8.dp
) {
    Box(modifier = modifier
        .fillMaxSize()
        .padding(buttonSpacing)){
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter),
            verticalArrangement = Arrangement.spacedBy(buttonSpacing)
        ){
            Text(
                text = (state.Number1) + (state.Operation?.symbol ?: "") + (state.Number2),
                textAlign = TextAlign.Right,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 32.dp),
                fontWeight = FontWeight.Light,
                fontSize = 80.sp,
                color = White,
                lineHeight = 80.sp
            )
            ThreeButtonRow(
                symbol1 = "AC",
                symbol2 = "Del",
                symbol3 = "/",
                onClick1 = { viewModel.onAction(CalculatorActions.Clear) },
                onClick2 = { viewModel.onAction(CalculatorActions.Delete) },
                onClick3 = { viewModel.onAction(CalculatorActions.Operations(CalculatorOperation.Divide)) },
                color1 = LightGray,
                color2 = LightGray,
                color3 = Orange
            )
            FourButtonRow(
                symbol1 = "7",
                symbol2 = "8",
                symbol3 = "9",
                symbol4 = "x",
                onClick1 = { viewModel.onAction(CalculatorActions.Number(7)) },
                onClick2 = { viewModel.onAction(CalculatorActions.Number(8)) },
                onClick3 = { viewModel.onAction(CalculatorActions.Number(9)) },
                onClick4 = { viewModel.onAction(CalculatorActions.Operations(CalculatorOperation.Multiply)) },
                color1 = Black,
                color2 = Black,
                color3 = Black,
                color4 = Orange
            )
            FourButtonRow(
                symbol1 = "4",
                symbol2 = "5",
                symbol3 = "6",
                symbol4 = "-",
                onClick1 = { viewModel.onAction(CalculatorActions.Number(4)) },
                onClick2 = { viewModel.onAction(CalculatorActions.Number(5)) },
                onClick3 = { viewModel.onAction(CalculatorActions.Number(6)) },
                onClick4 = { viewModel.onAction(CalculatorActions.Operations(CalculatorOperation.Substract)) },
                color1 = Black,
                color2 = Black,
                color3 = Black,
                color4 = Orange
            )
            FourButtonRow(
                symbol1 = "1",
                symbol2 = "2",
                symbol3 = "3",
                symbol4 = "+",
                onClick1 = { viewModel.onAction(CalculatorActions.Number(1)) },
                onClick2 = { viewModel.onAction(CalculatorActions.Number(2)) },
                onClick3 = { viewModel.onAction(CalculatorActions.Number(3)) },
                onClick4 = { viewModel.onAction(CalculatorActions.Operations(CalculatorOperation.Add)) },
                color1 = Black,
                color2 = Black,
                color3 = Black,
                color4 = Orange
            )
            ThreeButtonRow(
                symbol1 = "0",
                symbol2 = ".",
                symbol3 = "=",
                onClick1 = { viewModel.onAction(CalculatorActions.Number(0)) },
                onClick2 = { viewModel.onAction(CalculatorActions.Decimal) },
                onClick3 = { viewModel.onAction(CalculatorActions.Calculate) },
                color1 = Black,
                color2 = Black,
                color3 = Orange
            )
        }
    }
}