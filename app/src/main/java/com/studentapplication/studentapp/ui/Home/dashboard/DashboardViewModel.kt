package com.studentapplication.studentapp.ui.Home.dashboard

import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class DashboardViewModel: ViewModel() {

    private val _selectedIcon = MutableStateFlow<String>("Home")
    val selectedIcon: StateFlow<String> = _selectedIcon

    val subjectColors = listOf(
        Brush.linearGradient(
            colors = listOf(
                Color(0xFFFF6020),      //.copy(alpha = 0.8f),
                Color(0xFFFDC194)       //.copy(alpha = 0.9f)
            ),
//            start = Offset(0f, 1f),
//            end = Offset(0f,0f)
        ),
        Brush.linearGradient(
            colors = listOf(
                Color(0xFF2C84DA),
                Color(0xFF99D6FC),
            )
        ),
        Brush.linearGradient(
            colors = listOf(
                Color(0xFF2093C3),
                Color(0xFF93ECFF),
            )
        ),
        Brush.linearGradient(
            colors = listOf(
                Color(0xFFFF992E),
                Color(0xFFFED276),
            )
        ),
        Brush.linearGradient(
            colors = listOf(
                Color(0xFFDA5151),
                Color(0xFFF2C0C0),
            )
        ),
    )


    fun setSelectedIcon(selectedIcon: String){
        if (_selectedIcon.value != selectedIcon) {
            _selectedIcon.value = selectedIcon
        }
    }

}