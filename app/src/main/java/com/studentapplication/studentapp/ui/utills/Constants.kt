package com.studentapplication.studentapp.ui.utills

import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color

val exelaGradient = Brush.linearGradient(
    colors = listOf(Color(0xFF185573), Color(0xFF14868D)),
    start = Offset(0f, 0f),
    end = Offset(Float.POSITIVE_INFINITY, 0f)
)

val artGradient = Brush.linearGradient(
    colors = listOf(Color(0xFFFF6020),Color(0xFFFDC194),),
    start = Offset(0f, 0f),
    end = Offset(Float.POSITIVE_INFINITY, 0f)
)

val pendingGradient = Brush.linearGradient(
    colors = listOf(Color(0xFFE67E22), Color(0xFFFFC261)),
    start = Offset(0f, 0f),
    end = Offset(Float.POSITIVE_INFINITY, 0f)
)
val submittedGradient = Brush.linearGradient(
    colors = listOf(Color(0xFF0D2A3F), Color(0xFF2679B4),),
    start = Offset(0f, 0f),
    end = Offset(Float.POSITIVE_INFINITY, 0f)
)
val markedGradient = Brush.linearGradient(
    colors = listOf(Color(0xFF7BC144), Color(0xFF3B7D00),),
    start = Offset(0f, 0f),
    end = Offset(Float.POSITIVE_INFINITY, 0f)
)