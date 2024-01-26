import androidx.compose.foundation.Canvas
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.times

@Composable
@Preview(name = "NEXUS_10", device = Devices.NEXUS_10)
fun TShirt(
    number: Int? = 1,
    size: Dp = 210.dp,
    color: Color = Color.Red,
    onClick: () -> Unit = {}
) {
    val padding = 0.1 * size
    val fontSize = (0.7 * size).value.sp
    Box(
        modifier = Modifier
            .padding(padding)
            .clickable { onClick() },
        contentAlignment = Alignment.Center,
    ) {
        DrawTShirt(color = color, size)
        Text(
            text = number?.toString() ?: "",
            fontSize = fontSize,
            fontFamily = FontFamily.Cursive
        )
    }
}

@Composable
@Preview
fun DrawTShirt(color: Color = Color.Red, size: Dp = 100.dp) {
    Canvas(modifier = Modifier.size(size)) {
        val a = size.toPx() //required square side
        val base = 80 //base square side
        val multiplier = a/base
        val path = Path().apply {
            moveTo(0f * multiplier, 15f * multiplier)
            lineTo(30f * multiplier, 0f * multiplier)
            quadraticBezierTo(40f * multiplier, 5f * multiplier, 50f * multiplier, 0f * multiplier)
            lineTo(80f * multiplier, 15f * multiplier)
            lineTo(75f * multiplier, 30f * multiplier)
            lineTo(65f * multiplier, 25f * multiplier)
            lineTo(65f * multiplier, 75f * multiplier)
            quadraticBezierTo(40f * multiplier, 80f * multiplier, 15f * multiplier, 75f * multiplier)
            lineTo(15f * multiplier, 25f * multiplier)
            lineTo(5f * multiplier, 30f * multiplier)
            close()
        }
        drawPath(path = path, color = color)
    }
}
