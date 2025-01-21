package com.studentapplication.studentapp.ui.Calendar

import android.annotation.SuppressLint
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.studentapplication.studentapp.R
import com.studentapplication.studentapp.ui.Home.dashboard.BottomNavigationBar
import com.studentapplication.studentapp.ui.Home.dashboard.DashboardViewModel
import com.studentapplication.studentapp.ui.theme.nunitoFont
import com.studentapplication.studentapp.ui.utills.BackArrowBox
import com.studentapplication.studentapp.ui.utills.exelaGradient

@SuppressLint("NewApi")
@Composable
fun CalendarScreen(
    navController: NavHostController,
    viewModel: DashboardViewModel
){
    Box(modifier = Modifier.fillMaxSize()) {

        val scrollState = rememberScrollState()
        val daysList = listOf("M" to "08", "T" to "09", "W" to "10", "T" to "11", "F" to "12", "S" to "13", "S" to "14")
        val today = "10"
        val isCalenderOpen = remember { mutableStateOf(false) }
        val selectedDate = remember { mutableStateOf(today.toInt()) }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(scrollState)
                .padding(start = 15.dp, top = 40.dp, end = 15.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                BackArrowBox(onClick = {
                    navController.navigate(route = "dashboard")
                    viewModel.setSelectedIcon("Home")
                })
                Text(
                    text = "Calendar",
                    style = MaterialTheme.typography.labelLarge.copy(
                        fontSize = 25.sp,
                        lineHeight = 25.sp
                    ),
                    modifier = Modifier
                        .fillMaxWidth(0.9f),
                    textAlign = TextAlign.Center
                )
                Box(
                    modifier = Modifier
                        .size(36.dp)
                        .drawBehind {
                            val shadowOffsetY = 3.03.dp.toPx()
                            drawRoundRect(
                                color = Color(0xFF056E70),
                                topLeft = Offset(x = 0f, y = shadowOffsetY),
                                size = Size(size.width, size.height),
                                cornerRadius = CornerRadius(12.dp.toPx())
                            )
                        }
                        .background(
                            color = Color(0xFFECF6F6),
                            RoundedCornerShape(12.dp)
                        )
                        .clickable {
                            isCalenderOpen.value = !isCalenderOpen.value
                        },
                    contentAlignment = Alignment.Center
                ){
                    Image(
                        painter = painterResource(if (isCalenderOpen.value) R.drawable.close_calendar else R.drawable.display_calendar),
                        contentDescription = "calendar",
                        modifier = Modifier
                            .size(20.dp)
                    )
                }
            }
            Spacer(modifier = Modifier.height(20.dp))
            if (isCalenderOpen.value){
                Box(
                    modifier = Modifier
                        .height(55.dp)
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(7.96.dp))
                        .background(
                            brush = exelaGradient
                        )
                ){
                    Row(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(horizontal = 10.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ){
                        Icon(
                            painter = painterResource(R.drawable.left_arrow),
                            contentDescription = "left",
                            tint = Color.White,
                            modifier = Modifier
                                .size(16.47.dp)
                                .clickable {

                                }
                        )
                        Text(
                            text = "August 2024",
                            style = MaterialTheme.typography.bodyLarge.copy(
                                fontSize = 18.sp,
                                lineHeight = 22.68.sp,
                                color = Color.White
                            )
                        )
                        Icon(
                            painter = painterResource(R.drawable.right_arrow),
                            contentDescription = "right",
                            tint = Color.White,
                            modifier = Modifier
                                .size(16.47.dp)
                                .clickable {

                                }
                        )
                    }
                }
                DashedLine(
                    modifier = Modifier
                        .height(40.dp)
                        .fillMaxWidth(),
                    color = Color(0xFF1D1751)
                )
                CustomCalendar(selectedDate)
                DashedLine(
                    modifier = Modifier
                        .height(50.dp)
                        .fillMaxWidth(),
                    color = Color(0xFF5A5A5A)
                )

            }else {
                Text(
                    text = "August, 2024",
                    style = MaterialTheme.typography.labelMedium.copy(
                        fontWeight = FontWeight(600)
                    ),
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center
                )
                Spacer(modifier = Modifier.height(20.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    daysList.forEach { day ->
                        DateAndDayCard(
                            day = day.first,
                            date = day.second,
                            isToday = (day.second == today)
                        )
                    }
                }

                DashedLine(
                    modifier = Modifier
                        .height(50.dp)
                        .fillMaxWidth(),
                    color = Color(0xFF1D1751)
                )
            }
            Text(
                text = "Wed, August 10",
                style = MaterialTheme.typography.labelMedium.copy(
                    fontWeight = FontWeight(700),
                    color = Color.Black.copy(alpha = 0.8f)
                )
            )

            if (selectedDate.value == 13){
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(top = 50.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ){
                    Image(
                        painter = painterResource(R.drawable.no_schedule),
                        contentDescription = "no schedule",
                        modifier = Modifier
                            .size(153.dp, 170.49.dp)
                    )
                    Spacer(modifier = Modifier.height(20.dp))
                    Text(
                        text = "\"No classes scheduled.\"",
                        style = MaterialTheme.typography.titleSmall.copy(
                            fontWeight = FontWeight(600),
                            color = Color(0xFF1D1751)
                        ),
                    )
                }
            }else {
                StepperScreen()
            }
            Spacer(modifier = Modifier.height(100.dp))
        }
        BottomAppBar(
            modifier = Modifier
                .align(Alignment.BottomCenter),
            containerColor = Color.White
        ){
            BottomNavigationBar(navController, viewModel)
        }
    }
}


@Composable
fun DashedLine(
    modifier: Modifier = Modifier,
    color: Color = Color.Black,
    dashLength: Float = 18f,
    gapLength: Float = 18f,
    strokeWidth: Float = 2f
) {
    Canvas(modifier = modifier) {
        val totalWidth = size.width
        var startX = 0f

        while (startX < totalWidth) {
            drawLine(
                color = color,
                start = Offset(x = startX, y = size.height / 2),
                end = Offset(x = startX + dashLength, y = size.height / 2),
                strokeWidth = strokeWidth
            )
            startX += dashLength + gapLength
        }
    }
}


@Composable
fun DateAndDayCard(
    day: String,
    date: String,
    isToday: Boolean
) {
    val gradientColor = if (isToday) exelaGradient else Brush.linearGradient(
        colors = listOf(Color(0xFFF6F6F6),Color(0xFFF6F6F6))
    )

    Box(
        modifier = Modifier
            .width(45.dp)
            .height(75.dp)
            .background(
                brush = gradientColor,
                shape = RoundedCornerShape(8.dp),
            ),
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceAround
        ) {
            Text(
                text = day,
                style = MaterialTheme.typography.headlineSmall.copy(
                    fontSize = 20.sp,
                    lineHeight = 25.2.sp,
                    color = if (isToday) Color.White else Color(0xFF1D1751)
                )
            )
            Text(
                text = date,
                style = MaterialTheme.typography.bodySmall.copy(
                    fontWeight = FontWeight(500),
                    color = if (isToday) Color.White else Color(0xFF8F8F8F)
                )
            )
        }
    }
}


@Composable
fun CustomCalendar(selectedDate: MutableState<Int>) {

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(0.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly) {
            listOf("Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat").forEach {
                Text(
                    text = it,
                    style = TextStyle(
                        fontFamily = nunitoFont,
                        fontWeight = FontWeight(600),
                        fontSize = 17.29.sp,
                        lineHeight = 23.55.sp,
                        color = Color(0xFF1D1751)
                    ),
                    modifier = Modifier.padding(8.dp)
                )
            }
        }
        for (week in 0..4) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                for (day in 1..7) {
                    val num = week * 7 + day
                    if (num>31) {
                        for (i in 1..(8-day)){
                            Box(
                                modifier = Modifier
                                    .size(32.dp)
                                    .clip(CircleShape)
                                    .background(Color.Transparent)
                                    .clickable {

                                    },
                                contentAlignment = Alignment.Center
                            ) {
                                Text(
                                    text = "$i",
                                    style = TextStyle(
                                        fontFamily = nunitoFont,
                                        fontWeight = FontWeight(600),
                                        fontSize = 17.2.sp,
                                        lineHeight = 23.46.sp,
                                        color = Color.Black.copy(alpha = 0.2f)
                                    ),
                                )
                            }
                        }
                        break
                    }
                    else {
                        Box(
                            modifier = Modifier
                                .size(32.dp)
                                .clip(CircleShape)
                                .background(if (selectedDate.value == num) Color(0xFF129193) else Color.Transparent)
                                .clickable {
                                    selectedDate.value = num
                                },
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = "${week * 7 + day}",
                                style = TextStyle(
                                    fontFamily = nunitoFont,
                                    fontWeight = FontWeight(600),
                                    fontSize = 17.2.sp,
                                    lineHeight = 23.43.sp,
                                    color = if (selectedDate.value == num) Color.White else Color(0xFF636161)
                                ),
                            )
                        }
                    }
                }
            }
        }
    }
}