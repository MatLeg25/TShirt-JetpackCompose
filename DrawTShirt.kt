package com.bestatsy.live_match.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
@Preview
fun TShirt(
    modifier: Modifier = Modifier,
    number: Int = 7,
    color: Color = Color.Red
) {
    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center
    ) {
        DrawTShirt(color = color)
        Text(
            text = number.toString(),
            fontSize = 32.sp,
            fontFamily = FontFamily.Cursive
        )
    }
}

@Composable
@Preview
fun DrawTShirt(
    size: Dp = 100.dp,
    color: Color = Color.Red
) {
    Canvas(modifier = Modifier.size(size)) {
        val path = Path().apply {
            moveTo(60f, 80f)
            lineTo(120f, 50f)
            quadraticBezierTo(140f, 60f, 160f, 50f)
            lineTo(220f, 80f)
            lineTo(210f, 110f)
            lineTo(190f, 100f)
            lineTo(190f, 200f)
            quadraticBezierTo(140f, 210f, 90f, 200f)
            lineTo(90f, 100f)
            lineTo(70f, 110f)
            close()
        }
        drawPath(path = path, color = color,)
    }
}
