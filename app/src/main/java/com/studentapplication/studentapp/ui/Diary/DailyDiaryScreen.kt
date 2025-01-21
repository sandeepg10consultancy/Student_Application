package com.studentapplication.studentapp.ui.Diary

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.BottomSheetDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.studentapplication.studentapp.R
import com.studentapplication.studentapp.ui.Home.dashboard.DashboardViewModel
import com.studentapplication.studentapp.ui.theme.jostFont
import com.studentapplication.studentapp.ui.utills.BackArrowBox
import com.studentapplication.studentapp.ui.utills.exelaGradient

@Composable
fun DailyDiaryScreen(navController: NavHostController, viewModel: DashboardViewModel){
    val itemsList = listOf("All", "Homework", "Bring to school", "Special Request", "Notice", "Holiday Alert")
    var selectedItem by remember { mutableStateOf(itemsList[0]) }
    val messages = remember { mutableStateListOf(
        "Thank you for the update, Ms. Chandani ! How much time should we spend on the assignment?",
    ) }
    var currentMessage by remember { mutableStateOf(TextFieldValue()) }
    val isModelSheet = remember { mutableStateOf(false) }
    val scrollState = rememberScrollState()

    Box(modifier = Modifier.fillMaxSize()){
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 40.dp)
                .verticalScroll(scrollState)
        ){
            TopSectionCard(
                onClick = {isModelSheet.value = true},
                backButtonClick = {
                    navController.navigate(route = "dashboard")
                    viewModel.setSelectedIcon("Home")
                },
                navController = navController
            )
            Spacer(modifier = Modifier.height(20.dp))
            LazyRow(){
                items(itemsList){ item ->
                    val isSelected = (selectedItem == item)
                    Box(modifier = Modifier
                        .height(30.dp)
                        .padding(start = 10.dp)
                        .drawBehind {
                            if (isSelected) {
                                drawRoundRect(
                                    color = Color(0xFF056E70),
                                    size = size,
                                    topLeft = Offset(x = 0.dp.toPx(), y = 4.dp.toPx()),
                                    cornerRadius = CornerRadius(15.dp.toPx())
                                )
                            }
                        }
                        .background(
                            color = if (isSelected) Color(0xFF129193) else Color(0xFFF5F5F5),
                            shape = RoundedCornerShape(15.dp)
                        )
                        .clickable {
                            selectedItem = item
                        },
                        contentAlignment = Alignment.Center
                    ){
                        Text(
                            text = item,
                            style = MaterialTheme.typography.labelSmall.copy(
                                fontWeight = FontWeight(if (isSelected) 700 else 400),
                                color = if (isSelected) Color.White else Color.Black.copy(alpha = 0.6f)
                            ),
                            modifier = Modifier
                                .padding(start = 25.dp, end = 25.dp)
                        )
                    }
                }
            }
            Spacer(modifier = Modifier.height(20.dp))
            Box(
                modifier = Modifier
                    .height(30.dp)
                    .width(80.dp)
                    .clip(RoundedCornerShape(6.dp))
                    .background(color = Color(0xFFF0FDFF))
                    .align(Alignment.CenterHorizontally),
                contentAlignment = Alignment.Center
            ){
                Text(
                    text = "Today",
                    style = TextStyle(
                        fontFamily = jostFont,
                        fontWeight = FontWeight(400),
                        fontSize = 16.sp,
                        lineHeight = 23.12.sp,
                        color = Color(0xFF1D1751)
                    )
                )
            }
            Spacer(modifier = Modifier.height(20.dp))
            when(selectedItem){
                itemsList[0] -> {
                    AllCards(modifier = Modifier
                        .align(Alignment.Start)
                    )
                }
                itemsList[1] -> {
                    HomeworkCard(modifier = Modifier
                        .align(Alignment.Start)
                    )
                }
                itemsList[2] -> {
                    BringToSchool(modifier = Modifier
                        .align(Alignment.Start)
                    )
                }
                itemsList[3] -> {
                    SpecialRequest(modifier = Modifier
                        .align(Alignment.Start)
                    )
                }
                itemsList[4] -> {
                    NoticeCard(modifier = Modifier
                        .align(Alignment.Start)
                    )
                }
                itemsList[5] -> {
                    HolidayAlert(modifier = Modifier
                        .align(Alignment.Start)
                    )
                }
            }
            Spacer(modifier = Modifier.height(15.dp))
            MessagesList(
                messages = messages,
                modifier = Modifier
                    .padding(end = 10.dp)
                    .align(Alignment.End)
            )
            Spacer(modifier = Modifier.height(120.dp))
        }
        MessageInputField(
            currentMessage = currentMessage,
            onMessageChange = { currentMessage = it },
            onSendMessage = {
                if (currentMessage.text.isNotBlank()) {
                    messages.add(currentMessage.text)
                    currentMessage = TextFieldValue("")
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter)
        )
        /*
        if (isModelSheet.value){
            ModalBottomSheet(
                onDismissRequest = { isModelSheet.value = false},
                dragHandle = { BottomSheetDefaults.ExpandedShape },
                containerColor = Color.White,
                modifier = Modifier.fillMaxSize()
            ) {
                AnnouncementModelSheet(onClick = { isModelSheet.value = false })
            }
        }

         */
    }
}

@Composable
fun MessagesList(messages: List<String>, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ){
        messages.forEach { message ->
            MessageBox(message)
        }
    }
}

@Composable
fun MessageBox(message: String, modifier: Modifier = Modifier){
    Row(
        modifier = modifier
            .width(365.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalAlignment = Alignment.Top
    ){
        Box(
            modifier = Modifier
                .width(307.dp)
                .drawBehind {
                    drawRoundRect(
                        color = Color(0xFF2679B4),
                        size = size,
                        topLeft = Offset(x = 6.dp.toPx(), y = 6.dp.toPx()),
                        cornerRadius = CornerRadius(15.dp.toPx())
                    )
                }
                .clip(RoundedCornerShape(topStart = 15.dp, bottomStart = 15.dp, bottomEnd = 15.dp))
                .background(
                    color = Color(0xFFF0FDFF)
                )
        ) {
            Column(
                modifier = Modifier
                    .padding(10.dp),
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = message,
                    style = MaterialTheme.typography.labelMedium
                )
                Text(
                    text = "11:17 am",
                    style = MaterialTheme.typography.labelMedium.copy(
                        fontSize = 12.sp,
                        lineHeight = 15.sp,
                        color = Color(0xFF1D1751)
                    ),
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.End
                )
            }
        }

        Image(
            painter = painterResource(R.drawable.profile_boy),
            contentDescription = "profile",
            modifier = Modifier
                .size(50.dp)
                .clip(CircleShape)
        )
    }
}

@Composable
fun MessageInputField(
    currentMessage: TextFieldValue,
    onMessageChange: (TextFieldValue) -> Unit,
    onSendMessage: () -> Unit,
    modifier: Modifier = Modifier
){
    Row(
        modifier = modifier
            .padding(start = 10.dp, end = 10.dp, bottom = 40.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        OutlinedTextField(
            value = currentMessage,
            onValueChange = onMessageChange,
            modifier = Modifier
                .height(50.dp)
                .fillMaxWidth(0.84f)
                .clip(RoundedCornerShape(25.dp))
                .border(
                    width = 1.07.dp,
                    brush = exelaGradient,
                    shape = RoundedCornerShape(25.dp)
                ),
            placeholder = {
                Text(
                    text = "Type here",
                    style = TextStyle(
                        //fontFamily = robotoFont,
                        fontWeight = FontWeight(400),
                        fontSize = 16.sp,
                        lineHeight = 21.46.sp
                    ),
                    color = Color(0xFF575757).copy(alpha = 0.3f),
                    modifier = Modifier.fillMaxSize()
                )
            },
            leadingIcon = {
                Row(
                    modifier = Modifier.width(60.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceEvenly
                ){
                    Image(
                        painter = painterResource(R.drawable.emoji),
                        contentDescription = "emoji",
                        modifier = Modifier
                            .size(25.76.dp)
                            .clickable { }
                    )

                    VerticalDivider(
                        thickness = 1.07.dp,
                        color = Color(0xFF9F9F9F),
                        modifier = Modifier.padding(vertical = 5.dp)
                    )
                }
            },
            trailingIcon = {
                Row(
                    modifier = Modifier
                        .width(90.dp),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ){
                    Image(
                        painter = painterResource(R.drawable.link),
                        contentDescription = "emoji",
                        modifier = Modifier
                            .size(25.76.dp)
                            .clickable { }
                    )
                    Image(
                        painter = painterResource(R.drawable.camera),
                        contentDescription = "emoji",
                        modifier = Modifier
                            .size(25.76.dp)
                            .clickable { }
                    )
                }
            },
            textStyle = TextStyle(
                fontFamily = jostFont,
                fontWeight = FontWeight(400),
                fontSize = 16.sp,
                lineHeight = 23.12.sp,
                color = Color.Black
            ),
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color.White,
                unfocusedContainerColor = Color.White,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent
            )
        )

        Box(
            modifier = Modifier
                .size(46.93.dp)
                .border(
                    width = 1.07.dp,
                    brush = exelaGradient,
                    shape = CircleShape
                )
                .padding(8.dp)
                .clickable { onSendMessage() },
        ) {
            Image(
                painter = painterResource(R.drawable.post),
                contentDescription = "post",
                modifier = Modifier
                    .size(27.76.dp)
            )
        }
    }
}

@Composable
private fun TopSectionCard(
    onClick: () -> Unit = {},
    backButtonClick: () -> Unit = {},
    navController: NavHostController,
) {
    Card(
        modifier = Modifier
            .height(78.dp)
            .fillMaxWidth(),
        shape = RectangleShape,
        elevation = CardDefaults.cardElevation(
            defaultElevation = 2.dp
        ),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        )
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(start = 10.dp, end = 10.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                BackArrowBox(onClick = backButtonClick)
                Image(
                    painter = painterResource(R.drawable.students),
                    contentDescription = "icon",
                    modifier = Modifier
                        .size(55.dp)
                        .clip(CircleShape)
                )
                Column {
                    Text(
                        text = "Nursery A",
                        style = MaterialTheme.typography.titleSmall.copy(
                            fontWeight = FontWeight(800),
                            color = Color.Black
                        )
                    )
                    Text(
                        text = "15 Members",
                        style = TextStyle(
                            fontFamily = jostFont,
                            fontWeight = FontWeight(300),
                            fontSize = 14.sp,
                            lineHeight = 20.23.sp,
                            color = Color(0xFF129193)
                        )
                    )
                }
            }
            Icon(
                imageVector = Icons.Filled.MoreVert,
                contentDescription = "more",
                modifier = Modifier
                    .size(24.dp)
                    .clickable { onClick() }
            )

        }
    }
}