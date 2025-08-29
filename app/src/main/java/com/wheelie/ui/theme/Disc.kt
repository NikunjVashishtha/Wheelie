package com.wheelie.ui.theme

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.nativeCanvas
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.wheelie.R
import com.wheelie.ui.theme.DialogBox
import com.wheelie.Sector
import kotlinx.coroutines.launch
import kotlin.math.cos
import kotlin.math.sin

@Composable
fun Disc(modifier: Modifier = Modifier) {
    var sectors by remember { mutableStateOf(listOf<Sector>()) }
    var showDialog by remember { mutableStateOf(false) }
    val rotation = remember { Animatable(0f) }
    val scope = rememberCoroutineScope()

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(R.drawable.arrow),
            contentDescription = null,
            modifier = Modifier.size(50.dp)
        )
        Spacer(modifier = Modifier.height(20.dp))

        // The wheel
        Box(
            modifier = modifier.align(Alignment.CenterHorizontally),
            contentAlignment = Alignment.Center
        ) {
            Canvas(
                modifier = Modifier
                    .size(250.dp)
                    .graphicsLayer { rotationZ = rotation.value }) {

                if (sectors.isNotEmpty()) {
                    val sweepAngle = 360f / sectors.size
                    val radius = size.minDimension / 2f

                    // Pass 1: draw arcs
                    sectors.forEachIndexed { index, sector ->
                        drawArc(
                            color = sector.color,
                            startAngle = index * sweepAngle - 90f,
                            sweepAngle = sweepAngle,
                            useCenter = true
                        )
                    }

                    // Pass 2: draw text
                    drawIntoCanvas { canvas ->
                        val paint = Paint().asFrameworkPaint().apply {
                            isAntiAlias = true
                            textSize = 34f
                            textAlign = android.graphics.Paint.Align.CENTER
                            isFakeBoldText = true
                            color = android.graphics.Color.BLACK
                        }

                        sectors.forEachIndexed { index, sector ->
                            val sliceCenterAngle =
                                (index * sweepAngle + sweepAngle / 2 - 90f)
                            val angleRad = Math.toRadians(sliceCenterAngle.toDouble())

                            val textRadius = radius * 0.65f
                            val x = center.x + (textRadius * cos(angleRad)).toFloat()
                            val y = center.y + (textRadius * sin(angleRad)).toFloat()

                            canvas.nativeCanvas.drawText(
                                sector.value,
                                x,
                                y,
                                paint
                            )
                        }
                    }
                } else {
                    // Draw placeholder disc if empty
                    drawArc(
                        color = Color.LightGray,
                        startAngle = 0f,
                        sweepAngle = 360f,
                        useCenter = true
                    )
                }
            }

            // Spin button
            Image(
                painter = painterResource(R.drawable.rotate),
                contentDescription = null,
                modifier = Modifier
                    .size(50.dp)
                    .clip(CircleShape)
                    .clickable(
                        onClick = {
                            if (sectors.isNotEmpty()) {
                                scope.launch {
                                    val randomExtra = (0..360).random()
                                    val spins = 5 * 360
                                    rotation.animateTo(
                                        targetValue = rotation.value + spins + randomExtra,
                                        animationSpec = tween(
                                            durationMillis = 3000,
                                            easing = FastOutSlowInEasing
                                        )
                                    )
                                    rotation.snapTo(rotation.value % 360)
                                }
                            }
                        }),
            )
        }

        Spacer(modifier = Modifier.height(20.dp))

        // Buttons row
        Row(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
            // ➕ Add
            Image(
                painter = painterResource(R.drawable.add_circle),
                contentDescription = null,
                modifier = Modifier
                    .size(50.dp)
                    .clickable { showDialog = true }
            )

            // ➖ Remove Last
            Image(
                painter = painterResource(R.drawable.remove_circle),
                contentDescription = null,
                modifier = Modifier
                    .size(50.dp)
                    .clickable {
                        if (sectors.isNotEmpty()) {
                            sectors = sectors.dropLast(1)
                        }
                    }
            )

            // 🔄 Reset
            Image(
                painter = painterResource(R.drawable.reset_circle),
                contentDescription = null,
                modifier = Modifier
                    .size(50.dp)
                    .clickable { sectors = emptyList() }
            )
        }
    }

    // Dialog for adding tasks
    if (showDialog) {
        DialogBox(
            showDialog = showDialog,
            onDismiss = { showDialog = false },
            onConfirm = { text ->
                // assign random "nice" color
                val usedColors = sectors.map { it.color }
                val palette = listOf(
                    Color(0xFFFFA8A8),
                    Color(0xFFB5EAD7),
                    Color(0xFF9AD1D4),
                    Color(0xFFFBC4AB),
                    Color(0xFFE4C1F9),
                    Color(0xFFFFDAC1),
                    Color(0xFFFFB5E8)
                )
                val available = palette.filterNot { usedColors.contains(it) }
                val color = if (available.isNotEmpty()) available.random() else palette.random()

                sectors = sectors + Sector(text, color) // 👈 only make Sector here
            }
        )

    }
}
