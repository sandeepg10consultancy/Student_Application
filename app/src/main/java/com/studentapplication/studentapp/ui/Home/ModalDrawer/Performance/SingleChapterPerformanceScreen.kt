package com.studentapplication.studentapp.ui.Home.ModalDrawer.Performance

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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
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
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.studentapplication.studentapp.R
import com.studentapplication.studentapp.ui.subject.AssignmentStatusBox
import com.studentapplication.studentapp.ui.theme.nunitoFont
import com.studentapplication.studentapp.ui.theme.nunitoItalic
import com.studentapplication.studentapp.ui.utills.BackArrowBox
import com.studentapplication.studentapp.ui.utills.SmallCircle
import com.studentapplication.studentapp.ui.utills.scienceGradient

@Composable
fun SingleChapterPerformance(navController: NavHostController){
    val scrollState = rememberScrollState()
    val selectedItem = remember { mutableStateOf("Completed") }

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
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(25.dp)
            ) {
                BackArrowBox(
                    onClick = { navController.popBackStack() }
                )
                ProgressDetailsBox()
            }
            Spacer(modifier = Modifier.height(30.dp))
            ChapterPerformanceBox(
                chapterNo = 1,
                chapterName = "01:  All About Me"
            )
            Spacer(modifier = Modifier.height(30.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
            ){
                Box(
                    modifier = Modifier
                        .height(40.dp)
                        .fillMaxWidth(0.5f)
                        .clip(RoundedCornerShape(16.dp))
                        .background(
                            color = if(selectedItem.value == "Completed") Color(0xFF1D1751) else Color.Transparent
                        )
                        .clickable {
                            selectedItem.value = "Completed"
                        },
                    contentAlignment = Alignment.Center
                ){
                    Text(
                        text = "Completed",
                        style = MaterialTheme.typography.labelMedium.copy(
                            fontWeight = FontWeight(if(selectedItem.value == "Completed") 600 else 400),
                            lineHeight = 24.sp,
                            color = if(selectedItem.value == "Completed") Color.White else Color(0xFF1D1751)
                        )
                    )
                }
                Box(
                    modifier = Modifier
                        .height(40.dp)
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(16.dp))
                        .background(
                            color = if(selectedItem.value == "Pending") Color(0xFF1D1751) else Color.Transparent
                        )
                        .clickable {
                            selectedItem.value = "Pending"
                        },
                    contentAlignment = Alignment.Center
                ){
                    Text(
                        text = "Pending",
                        style = TextStyle(
                            fontFamily = nunitoFont,
                            fontWeight = FontWeight(if(selectedItem.value == "Pending") 600 else 400),
                            fontSize = 16.sp,
                            lineHeight = 24.sp,
                            color = if(selectedItem.value == "Pending") Color.White else Color(0xFF1D1751)
                        )
                    )
                }
            }
            Spacer(modifier = Modifier.height(20.dp))
            if (selectedItem.value == "Completed"){
                CompletedAssignmentBox(
                    bgImage = R.drawable.assignment_land,
                    shadowColor = Color(0xFF19610F)
                )
                Spacer(modifier = Modifier.height(20.dp))
                CompletedAssignmentBox(
                    bgImage = R.drawable.assignment_mountain,
                    shadowColor = Color(0xFF3E3925)
                )
                Spacer(modifier = Modifier.height(20.dp))
                CompletedAssignmentBox(
                    bgImage = R.drawable.assignment_sky,
                    shadowColor = Color(0xFF00839A)
                )
                Spacer(modifier = Modifier.height(20.dp))
                CompletedAssignmentBox(
                    bgImage = R.drawable.assignment_land,
                    shadowColor = Color(0xFF19610F)
                )
            } else {
                PendingAssignmentBox()
                Spacer(modifier = Modifier.height(20.dp))
                PendingAssignmentBox()
                Spacer(modifier = Modifier.height(20.dp))
                PendingAssignmentBox()
                Spacer(modifier = Modifier.height(20.dp))
                PendingAssignmentBox()
            }
            Spacer(modifier = Modifier.height(50.dp))
        }
    }
}

@Composable
private fun CompletedAssignmentBox(
    bgImage: Int,
    shadowColor: Color
) {
    val labelStyle = TextStyle(
        fontFamily = nunitoFont,
        fontWeight = FontWeight(500),
        fontSize = 12.sp,
        lineHeight = 9.6.sp,
        color = Color.White.copy(alpha = 0.8f)
    )
    val valueStyle = MaterialTheme.typography.labelSmall.copy(
        fontWeight = FontWeight(600),
        lineHeight = 11.2.sp,
        color = Color.White
    )
    Box(
        modifier = Modifier
            .height(152.dp)
            .fillMaxWidth()
            .drawBehind {
                drawRoundRect(
                    color = shadowColor,
                    size = size,
                    topLeft = Offset(x = 0.dp.toPx(), y = 6.dp.toPx()),
                    cornerRadius = CornerRadius(12.dp.toPx())
                )
            }
            .clip(RoundedCornerShape(12.dp))
    ) {
        Image(
            painter = painterResource(bgImage),
            contentDescription = "image",
            modifier = Modifier
                .matchParentSize(),
            contentScale = ContentScale.Crop
        )
        Box(modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(Color.Black.copy(alpha = 0f),Color.Black.copy(alpha = 0.5f))
                )
            )
        )
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column {
                    Text(
                        text = "Assignment Name",
                        style = MaterialTheme.typography.bodyLarge.copy(
                            fontSize = 20.sp,
                            lineHeight = 16.sp,
                            color = Color.White
                        )
                    )
                    Row(
                        modifier = Modifier,
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(10.dp)
                    ) {
                        Text(
                            text = "Science",
                            style = MaterialTheme.typography.labelSmall.copy(
                                fontWeight = FontWeight(500),
                                lineHeight = 11.2.sp,
                                color = Color.White
                            )
                        )
                        SmallCircle(
                            dim = 4.dp,
                            containerColor = Color.White
                        )
                        Text(
                            text = "Topic-1",
                            style = MaterialTheme.typography.labelSmall.copy(
                                fontWeight = FontWeight(500),
                                lineHeight = 11.2.sp,
                                color = Color.White
                            )
                        )
                        SmallCircle(
                            dim = 4.dp,
                            containerColor = Color.White
                        )
                        Text(
                            text = "Nursery-A",
                            style = MaterialTheme.typography.labelSmall.copy(
                                fontWeight = FontWeight(500),
                                lineHeight = 11.2.sp,
                                color = Color.White
                            )
                        )
                    }
                }
                AssignmentStatusBox(
                    modifier = Modifier.width(101.dp),
                    status = "Submitted"
                )
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column {
                    Text(
                        text = "Created by",
                        style = labelStyle
                    )
                    Spacer(modifier = Modifier.height(5.dp))
                    Text(
                        text = "Teacher",
                        style = valueStyle
                    )
                }
                Column {
                    Text(
                        text = "Created On",
                        style = labelStyle
                    )
                    Spacer(modifier = Modifier.height(5.dp))
                    Text(
                        text = "22 August 2024",
                        style = valueStyle
                    )
                }
                Column {
                    Text(
                        text = "Deadline",
                        style = labelStyle
                    )
                    Spacer(modifier = Modifier.height(5.dp))
                    Text(
                        text = "22 August 2024",
                        style = valueStyle
                    )
                }
            }
        }
    }
}

@Composable
private fun PendingAssignmentBox() {
    val labelStyle = TextStyle(
        fontFamily = nunitoFont,
        fontWeight = FontWeight(500),
        fontSize = 12.sp,
        lineHeight = 9.6.sp,
        color = Color(0xFF1D1751)
    )
    val valueStyle = MaterialTheme.typography.labelSmall.copy(
        fontWeight = FontWeight(600),
        lineHeight = 11.2.sp,
        color = Color(0xFF129193)
    )
    Box(
        modifier = Modifier
            .height(152.dp)
            .fillMaxWidth()
            .drawBehind {
                drawRoundRect(
                    color = Color(0xFFE6E5E5),
                    size = size,
                    topLeft = Offset(x = 0.dp.toPx(), y = 6.dp.toPx()),
                    cornerRadius = CornerRadius(12.dp.toPx())
                )
            }
            .clip(RoundedCornerShape(12.dp))
            .border(
                width = 1.dp,
                color = Color(0xFFE6E5E5).copy(alpha = 0.2f),
                shape = RoundedCornerShape(12.dp)
            )
            .background(color = Color.White)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column {
                    Text(
                        text = "Assignment Name",
                        style = MaterialTheme.typography.bodyLarge.copy(
                            fontSize = 20.sp,
                            lineHeight = 16.sp,
                            color = Color(0xFF2093C3)
                        )
                    )
                    Row(
                        modifier = Modifier,
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(10.dp)
                    ) {
                        Text(
                            text = "Science",
                            style = MaterialTheme.typography.labelSmall.copy(
                                fontWeight = FontWeight(500),
                                lineHeight = 11.2.sp,
                                color = Color(0xFF129193)
                            )
                        )
                        SmallCircle(
                            dim = 4.dp,
                            containerColor = Color(0xFF129193)
                        )
                        Text(
                            text = "Topic-1",
                            style = MaterialTheme.typography.labelSmall.copy(
                                fontWeight = FontWeight(500),
                                lineHeight = 11.2.sp,
                                color = Color(0xFF1D1751)
                            )
                        )
                        SmallCircle(
                            dim = 4.dp,
                            containerColor = Color(0xFF129193)
                        )
                        Text(
                            text = "Nursery-A",
                            style = MaterialTheme.typography.labelSmall.copy(
                                fontWeight = FontWeight(500),
                                lineHeight = 11.2.sp,
                                color = Color(0xFF129193)
                            )
                        )
                    }
                }
                AssignmentStatusBox(
                    modifier = Modifier.width(101.dp),
                    status = "Pending"
                )
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column {
                    Text(
                        text = "Created by",
                        style = labelStyle
                    )
                    Spacer(modifier = Modifier.height(5.dp))
                    Text(
                        text = "Teacher",
                        style = valueStyle
                    )
                }
                Column {
                    Text(
                        text = "Created On",
                        style = labelStyle
                    )
                    Spacer(modifier = Modifier.height(5.dp))
                    Text(
                        text = "22 August 2024",
                        style = valueStyle
                    )
                }
                Column {
                    Text(
                        text = "Deadline",
                        style = labelStyle
                    )
                    Spacer(modifier = Modifier.height(5.dp))
                    Text(
                        text = "22 August 2024",
                        style = valueStyle
                    )
                }
            }
        }
    }
}

@Composable
private fun ChapterPerformanceBox(
    chapterNo: Int,
    chapterName: String
) {
    Box(
        modifier = Modifier
            .height(107.dp)
            .fillMaxWidth()
            .drawBehind {
                drawRoundRect(
                    color = Color(0xFF00A9DC),
                    size = size,
                    topLeft = Offset(x = 0.dp.toPx(), y = 6.dp.toPx()),
                    cornerRadius = CornerRadius(12.dp.toPx())
                )
            }
            .clip(RoundedCornerShape(12.dp))
            .border(
                width = 1.dp,
                color = Color(0xFFE6E5E5).copy(alpha = 0.8f),
                shape = RoundedCornerShape(12.dp)
            )
            .background(color = Color.White)
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 20.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                verticalArrangement = Arrangement.spacedBy(20.dp)
            ) {
                Text(
                    text = "Chapter $chapterNo",
                    style = MaterialTheme.typography.bodyLarge.copy(
                        fontSize = 18.sp,
                        lineHeight = 14.4.sp,
                        brush = scienceGradient
                    )
                )
                Text(
                    text = chapterName,
                    style = MaterialTheme.typography.bodyLarge.copy(
                        fontSize = 18.sp,
                        lineHeight = 14.4.sp,
                        color = Color(0xFF1D1751)
                    )
                )
            }

            Box(
                contentAlignment = Alignment.Center
            ) {
                GradientCircularProgressIndicator(
                    progress = 0.1f,
                    strokeWidth = 4.53.dp,
                    modifier = Modifier
                        .size(80.dp),
                    gradientColors = listOf(Color(0xFF2093C3), Color(0xFF93ECFF)),
                    trackColor = Color(0xFFC3F1FF)
                )
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "10%",
                        style = MaterialTheme.typography.bodyLarge.copy(
                            fontSize = 18.sp,
                            lineHeight = 27.sp,
                            color = Color(0xFF0C092A)
                        )
                    )
                    Text(
                        text = "Submissions",
                        style = TextStyle(
                            fontFamily = nunitoFont,
                            fontWeight = FontWeight(600),
                            fontSize = 10.sp,
                            lineHeight = 15.sp
                        )
                    )
                }
            }

        }
    }
}


@Composable
private fun ProgressDetailsBox() {
    Box(
        modifier = Modifier
            .size(241.dp, 36.dp)
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
                color = Color(0xFF129193),
                RoundedCornerShape(12.dp)
            ),
        contentAlignment = Alignment.Center
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Text(
                text = "Science",
                style = TextStyle(
                    fontFamily = nunitoItalic,
                    fontWeight = FontWeight(800),
                    fontSize = 14.sp,
                    lineHeight = 19.1.sp,
                    color = Color.White
                )
            )
            SmallCircle(
                dim = 4.dp,
                containerColor = Color.White.copy(alpha = 0.4f)
            )
            Text(
                text = "CH1",
                style = TextStyle(
                    fontFamily = nunitoItalic,
                    fontWeight = FontWeight(800),
                    fontSize = 14.sp,
                    lineHeight = 19.1.sp,
                    color = Color.White
                )
            )
            SmallCircle(
                dim = 4.dp,
                containerColor = Color.White.copy(alpha = 0.4f)
            )
            Text(
                text = "Assessment",
                style = TextStyle(
                    fontFamily = nunitoItalic,
                    fontWeight = FontWeight(800),
                    fontSize = 14.sp,
                    lineHeight = 19.1.sp,
                    color = Color.White
                )
            )
        }
    }
}