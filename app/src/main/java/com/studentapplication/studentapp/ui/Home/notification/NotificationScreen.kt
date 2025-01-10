package com.studentapplication.studentapp.ui.Home.notification

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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
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
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.studentapplication.studentapp.ui.Home.ModalDrawer.SearchTextField
import com.studentapplication.studentapp.ui.utills.BackArrowBox

data class NotificationData(
    val character: String,
    val boxColor: Color,
    val shadowColor: Color,
    val title: String,
    val time: String,
    val subTopic: String,
)



@Composable
fun NotificationsScreen(navController: NavHostController){

    val scrollState = rememberScrollState()
    val searchedNotification = remember { mutableStateOf("") }

    val notifications = listOf(
        NotificationData(
            character = "R",
            boxColor = Color(0xFFFFF5E9),
            shadowColor = Color(0xFFFFB866),
            title = "Upcoming Class Reminder",
            time = "10:45 PM",
            subTopic = "Your Nursery-A Math class starts in 15 minutes."
        ),
        NotificationData(
            character = "R",
            boxColor = Color(0xFFFDF8E8),
            shadowColor = Color(0xFFF2C94C),
            title = "Meeting Reminder",
            time = "Yesterday",
            subTopic = "Parent-Teacher meeting with Mr. Smith is happen."
        ),
        NotificationData(
            character = "N",
            boxColor = Color(0xFFEEEEFE),
            shadowColor = Color(0xFF5458F7),
            title = "New Resource Available",
            time = "Yesterday",
            subTopic = "A new study guide has been added to your class work"
        ),
        NotificationData(
            character = "M",
            boxColor = Color(0xFFE5FAF5),
            shadowColor = Color(0xFF00CC99),
            title = "New Message from Sarah",
            time = "12th Aug",
            subTopic = "You have a new message from Sarah.."
        ),
        NotificationData(
            character = "S",
            boxColor = Color(0xFFFDEEEE),
            shadowColor = Color(0xFFEB5757),
            title = "New Submission Alert",
            time = "12th Aug",
            subTopic = "John Doe has submitted the Science assignment"
        ),
        NotificationData(
            character = "R",
            boxColor = Color(0xFFFFF5E9),
            shadowColor = Color(0xFFFFB866),
            title = "Upcoming Class Reminder",
            time = "12th Aug",
            subTopic = "Your Nursery-A Math class starts in 15 minutes."
        ),
    )

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
            Spacer(modifier = Modifier.height(30.dp))

            SearchTextField(
                searchedString = searchedNotification,
                placeholder = "Search your Notifications here"
            )
            Spacer(modifier = Modifier.height(30.dp))

            notifications.forEach { notification ->
                NotificationCard(
                    character = notification.character,
                    boxColor = notification.boxColor,
                    shadowColor = notification.shadowColor,
                    title = notification.title,
                    time = notification.time,
                    subTopic = notification.subTopic,
                    navController = navController
                )
                Spacer(modifier = Modifier.height(20.dp))
            }
        }
    }
}

@Composable
private fun NotificationCard(
    character: String,
    boxColor: Color,
    shadowColor: Color,
    title: String,
    time: String,
    subTopic: String,
    navController: NavHostController,
) {

    Box(
        modifier = Modifier
            .height(93.dp)
            .fillMaxWidth()
            .drawBehind {
                drawRoundRect(
                    color = shadowColor ,
                    size = size,
                    topLeft = Offset(x = 0.dp.toPx(), y = 4.dp.toPx()),
                    cornerRadius = CornerRadius(15.dp.toPx())
                )
            }
            .clip(RoundedCornerShape(15.dp))
            .background(color = boxColor)
            .clickable {
                navController.navigate(route = "notificationDetails")
            }

    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(10.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(15.dp)
        ) {
            Box(
                modifier = Modifier
                    .size(60.dp)
                    .clip(CircleShape)
                    .background(
                        color = shadowColor,
                        shape = CircleShape
                    ),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = character,
                    style = MaterialTheme.typography.bodyLarge.copy(
                        fontWeight = FontWeight(800),
                        fontSize = 22.sp,
                        lineHeight = 17.6.sp,
                        color = Color.White
                    )
                )
            }
            Column(
                verticalArrangement = Arrangement.spacedBy(5.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = title,
                        style = MaterialTheme.typography.labelMedium.copy(
                            fontWeight = FontWeight(700),
                            color = Color(0xFF1D1751)
                        ),
                        modifier = Modifier.fillMaxWidth(0.8f)
                    )
                    Text(
                        text = time,
                        style = MaterialTheme.typography.labelMedium.copy(
                            fontSize = 12.sp,
                            lineHeight = 16.37.sp,
                            color = Color.Black.copy(alpha = 0.8f)
                        )
                    )
                }
                Text(
                    text = subTopic,
                    style = MaterialTheme.typography.labelSmall.copy(
                        fontWeight = FontWeight(400),
                        color = Color.Black.copy(alpha = 0.6f)
                    ),
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
            }
        }
    }
}