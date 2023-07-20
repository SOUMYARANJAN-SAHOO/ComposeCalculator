package com.kanha.composecalculator

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kanha.composecalculator.ui.theme.MediumGray

@Composable
fun CalculatorButton(
    symbol: String,
    modifier: Modifier,
    color: Color = MediumGray,
    textStyle: TextStyle = TextStyle(),
    onClick: () -> Unit
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .clip(CircleShape)
            .background(color)
            .clickable {
                onClick()
            }
            .then(modifier)
    ) {
        Text(
            text = symbol,
            color = Color.White,
            fontSize = 36.sp,
            style = textStyle
        )
    }
}


@Composable
fun ThreeButtonRow(
    symbol1: String,
    symbol2: String,
    symbol3: String,
    onClick1: () -> Unit,
    onClick2: () -> Unit,
    onClick3: () -> Unit,
    color1: Color,
    color2: Color,
    color3: Color,
    buttonSpacing: Dp = 8.dp,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
    ) {
        CalculatorButton(
            symbol = symbol1,
            modifier = Modifier
                .aspectRatio(2f)
                .weight(2f)
                .background(color1),
            onClick = {
               onClick1()
            }
        )
        CalculatorButton(
            symbol = symbol2,
            modifier = Modifier
                .aspectRatio(1f)
                .weight(1f)
                .background(color2),
            onClick = {
                onClick2()
            }
        )
        CalculatorButton(
            symbol = symbol3,
            modifier = Modifier
                .aspectRatio(1f)
                .weight(1f)
                .background(color3),
            onClick = {
                onClick3()
            }
        )
    }
}

@Composable
fun FourButtonRow(
    symbol1: String,
    symbol2: String,
    symbol3: String,
    symbol4: String,
    onClick1: () -> Unit,
    onClick2: () -> Unit,
    onClick3: () -> Unit,
    onClick4: () -> Unit,
    color1: Color,
    color2: Color,
    color3: Color,
    color4: Color,
    buttonSpacing: Dp = 8.dp,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
    ) {
        CalculatorButton(
            symbol = symbol1,
            modifier = Modifier
                .aspectRatio(1f)
                .weight(1f)
                .background(color1),
            onClick = {
                onClick1()
            }
        )
        CalculatorButton(
            symbol = symbol2,
            modifier = Modifier
                .aspectRatio(1f)
                .weight(1f)
                .background(color2),
            onClick = {
                onClick2()
            }
        )
        CalculatorButton(
            symbol = symbol3,
            modifier = Modifier
                .aspectRatio(1f)
                .weight(1f)
                .background(color3),
            onClick = {
                onClick3()
            }
        )
        CalculatorButton(
            symbol = symbol4,
            modifier = Modifier
                .aspectRatio(1f)
                .weight(1f)
                .background(color4),
            onClick = {
                onClick4()
            }
        )
    }
}