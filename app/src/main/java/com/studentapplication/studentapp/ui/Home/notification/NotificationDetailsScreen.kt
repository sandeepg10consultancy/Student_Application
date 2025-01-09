package com.studentapplication.studentapp.ui.Home.notification

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.studentapplication.studentapp.ui.theme.jostFont
import com.studentapplication.studentapp.ui.utills.BackArrowBox

@Composable
fun NotificationDetailsScreen(navController: NavHostController){

    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(scrollState)
    ) {
        Column(
            modifier = Modifier.padding(horizontal = 20.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 70.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                BackArrowBox(
                    onClick = { navController.popBackStack() }
                )
                Text(
                    text = "Notification",
                    style = MaterialTheme.typography.labelLarge.copy(
                        fontSize = 25.sp,
                        lineHeight = 25.sp
                    ),
                    modifier = Modifier
                        .fillMaxWidth(0.9f),
                    textAlign = TextAlign.Center
                )
            }

            Spacer(modifier = Modifier.height(40.dp))
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .drawBehind {
                        drawRoundRect(
                            color = Color(0xFFFFB866) ,
                            size = size,
                            topLeft = Offset(x = 0.dp.toPx(), y = 4.dp.toPx()),
                            cornerRadius = CornerRadius(15.dp.toPx())
                        )
                    }
                    .clip(RoundedCornerShape(15.dp))
                    .background(color = Color(0xFFFFF5E9))

            ){
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(start = 20.dp, top = 20.dp, end = 15.dp, bottom = 30.dp),
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "Event Reminder",
                            style = TextStyle(
                                fontFamily = jostFont,
                                fontWeight = FontWeight(600),
                                fontSize = 20.sp,
                                lineHeight = 28.9.sp,
                                color = Color(0xFF1D1751)
                            ),
                            modifier = Modifier.fillMaxWidth(0.83f)
                        )
                        Text(
                            text = "10:45 PM",
                            style = MaterialTheme.typography.titleMedium.copy(
                                fontSize = 14.sp,
                                lineHeight = 20.23.sp,
                                color = Color.Black.copy(alpha = 0.8f)
                            )
                        )
                    }
                    Text(
                        text = "\" Reminder: Our exciting school picnic is happening this Friday at 10 AM! Join us for a day of fun games, tasty treats, and laughter in the park. \n" +
                                "\n" +
                                "Please remember to pack a nutritious lunch for your child, along with sunscreen and a hat. We can’t wait to see everyone there!\"",
                        style = MaterialTheme.typography.bodyMedium.copy(
                            fontWeight = FontWeight(400),
                            color = Color.Black.copy(alpha = 0.6f)
                        )
                    )
                }

            }
        }
    }
}