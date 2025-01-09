package com.studentapplication.studentapp.ui.subject

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
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.draw.scale
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.studentapplication.studentapp.R
import com.studentapplication.studentapp.ui.theme.nunitoItalic
import com.studentapplication.studentapp.ui.utills.BackArrowBox
import com.studentapplication.studentapp.ui.utills.SmallCircle
import com.studentapplication.studentapp.ui.utills.TopProgressBox
import com.studentapplication.studentapp.ui.utills.artGradient
import com.studentapplication.studentapp.ui.utills.exelaGradient
import com.studentapplication.studentapp.ui.utills.markedGradient
import com.studentapplication.studentapp.ui.utills.pendingGradient
import com.studentapplication.studentapp.ui.utills.submittedGradient


data class VideosData(
    val duration: String,
    val thumbnailResId: Int
)

val subjectChapterTextStyle = TextStyle(
    fontFamily = nunitoItalic,
    fontWeight = FontWeight(800),
    fontSize = 14.sp,
    lineHeight = 19.01.sp,
    color = Color.White
)

@Composable
fun TopicDescriptionScreen(navController: NavHostController) {

    val scrollState = rememberScrollState()
    val courseContents = listOf("Assessments", "Videos", "E - Books")
    var selectedContent by remember { mutableStateOf(courseContents[0]) }

    val videosData = mapOf(
        "Flowers" to VideosData("3:00 min", R.drawable.videos_flower),
        "Shapes and Colors 1" to VideosData("3:00 min", R.drawable.videos_colors),
        "Shapes and Colors 2" to VideosData("3:00 min", R.drawable.videos_shapes),
        "Shapes and Colors 3" to VideosData("3:00 min", R.drawable.videos_painting),
    )

    val ebooksData = mapOf(
        "Shapes and Colors" to VideosData("3 pages", R.drawable.ebooks_shapes),
        "What are water" to VideosData("6 pages", R.drawable.ebooks_water),
        "Shapes and Colors 1" to VideosData("2 pages", R.drawable.ebooks_colors),
        "Shapes and Colors 2" to VideosData("1 pages", R.drawable.ebooks_reading),
    )



    Box(
        modifier = Modifier
            .fillMaxSize()
    ){
//        Image(
//            painter = painterResource(R.drawable.a_plus),
//            contentDescription = "image",
//            modifier = Modifier
//                .size(246.72.dp)
//                .align(Alignment.BottomEnd),
//            alpha = 0.6f
//        )
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(scrollState)
        ){
            TopProgressBox()
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp)
            ){
                BackArrowBox(
                    boxColor = Color(0xFFFF6020),
                    shadowColor = Color(0xFFFFC8B3),
                    onClick = {navController.popBackStack()}
                )
                Spacer(modifier = Modifier.width(20.dp))
                SubjectChapterTopicBox()
            }
            Column(
                modifier = Modifier
                    .padding(horizontal = 20.dp),
                verticalArrangement = Arrangement.spacedBy(30.dp)
            ){
                Box(
                    modifier = Modifier
                        .height(161.dp)
                        .fillMaxWidth()
                        .drawBehind {
                            drawRoundRect(
                                color = Color(0xFFFFC8B3),
                                size = size,
                                topLeft = Offset(0.dp.toPx(), y = 6.dp.toPx()),
                                cornerRadius = CornerRadius(12.dp.toPx())
                            )
                        }
                        .background(
                            brush = artGradient,
                            shape = RoundedCornerShape(12.dp)
                        )
                        .clip(shape = RoundedCornerShape(12.dp))
                ){
                    Image(
                        painter = painterResource(R.drawable.art),
                        contentDescription = "art",
                        modifier = Modifier
                            .size(180.dp)
                            .align(Alignment.CenterEnd)
                            .scale(1.5f)
                            .padding(end = 0.dp)
                            .offset(x = 20.dp, y = 8.dp),
                        alpha = 0.6f
                    )
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(start = 20.dp, top = 20.dp, end = 20.dp, bottom = 10.dp),
                        verticalArrangement = Arrangement.SpaceBetween
                    ){
                        Text(
                            text = "3 days",
                            style = MaterialTheme.typography.titleMedium.copy(
                                fontWeight = FontWeight(500),
                                fontSize = 14.sp,
                                lineHeight = 20.23.sp,
                                color = Color.White
                            )
                        )
                        Text(
                            text = "01: All About Me",
                            style = MaterialTheme.typography.bodyLarge.copy(
                                fontSize = 22.sp,
                                lineHeight = 30.01.sp,
                                color = Color.White
                            )
                        )
                        Box(
                            modifier = Modifier
                                .height(50.dp)
                                .fillMaxWidth()
                                .clip(RoundedCornerShape(100.dp))
                                .background(color = Color.White.copy(alpha = 0.6f)),
                            contentAlignment = Alignment.Center
                        ){
                            Column(
                                modifier = Modifier
                                    .padding(horizontal = 20.dp)
                            ){
                                Row(
                                    modifier = Modifier
                                        .fillMaxWidth(),
                                    verticalAlignment = Alignment.CenterVertically,
                                    horizontalArrangement = Arrangement.SpaceBetween
                                ) {
                                    Text(
                                        text = "Schedule on: 1st Jul 2024",
                                        style = TextStyle(
                                            fontFamily = nunitoItalic,
                                            fontWeight = FontWeight(500),
                                            fontSize = 14.sp,
                                            lineHeight = 11.2.sp,
                                            color = Color(0xFF2679B4)
                                        )
                                    )
                                    Icon(
                                        painter = painterResource(R.drawable.scheduled_calendar),
                                        contentDescription = "calendar",
                                        tint = Color(0xFF2679B4),
                                        modifier = Modifier.size(18.dp)
                                    )
                                }
                                Spacer(modifier = Modifier.height(5.dp))
                                ChapterScheduledProgress(progress = 0.6f)
                            }
                        }
                    }
                }

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ){
                    courseContents.forEach { content ->
                        val isSelected = content == selectedContent
                        if (isSelected) {
                            ContentBox(
                                text = content,
                                onClick = { selectedContent = content}
                            )
                        }else {
                            Text(
                                text = content,
                                style = MaterialTheme.typography.titleSmall,
                                color = Color(0xFF1D1751),
                                modifier = Modifier
                                    .clickable { selectedContent = content }
                            )
                        }
                    }
                }

                when(selectedContent){
                    "Assessments" -> {
                        repeat(4) { index ->
                            AssignmentNameCard(
                                assignmentNo = index + 1,
                                onClick = { navController.navigate(route = "assessmentDetails")}
                            )
                        }
                    }
                    "Videos" -> {
                        if (videosData.isEmpty()) {
                            videosData.forEach { (title, data) ->
                                VideosCard(
                                    title = title,
                                    time = data.duration,
                                    image = data.thumbnailResId
                                )
                            }
                        }else{
                            VideosEmptyState()
                        }
                    }
                    "E - Books" -> {
                        if (ebooksData.isNotEmpty()) {
                            ebooksData.forEach { (title, data) ->
                                VideosCard(
                                    title = title,
                                    time = data.duration,
                                    image = data.thumbnailResId
                                )
                            }
                        }else{
                            EbooksEmptyState()
                        }
                    }
                }
            }
            Image(
                painter = painterResource(R.drawable.a_plus),
                contentDescription = "image",
                modifier = Modifier
                    .size(246.72.dp)
                    .align(Alignment.End),
                alpha = 0.6f
            )

        }
    }
}

@Composable
fun EbooksEmptyState(){
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ){
        Image(
            painter = painterResource(R.drawable.empty_ebooks),
            contentDescription = "empty",
            modifier = Modifier
                .size(201.dp, 206.dp)
        )
        Text(
            text = "\"Oops!",
            style = MaterialTheme.typography.labelLarge.copy(
                fontSize = 22.sp,
                lineHeight = 22.sp,
                brush = exelaGradient
            ),
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center
        )
        Text(
            text = "No E-Books have been added for this \ntopic yet.",
            style = MaterialTheme.typography.titleSmall.copy(
                fontWeight = FontWeight(400),
                color = Color.Black.copy(alpha = 0.6f)
            ),
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center

        )
    }
}

@Composable
fun VideosEmptyState(){
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ){
        Image(
            painter = painterResource(R.drawable.empty_videos),
            contentDescription = "empty",
            modifier = Modifier
                .size(200.89.dp, 206.dp)
        )
        Text(
            text = "\"Oops!",
            style = MaterialTheme.typography.labelLarge.copy(
                fontSize = 22.sp,
                lineHeight = 22.sp,
                brush = exelaGradient
            ),
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center
        )
        Text(
            text = "No videos have been added for this \ntopic yet.",
            style = MaterialTheme.typography.titleSmall.copy(
                fontWeight = FontWeight(400),
                color = Color.Black.copy(alpha = 0.6f)
            ),
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center

        )
    }
}


@Composable
fun SubjectChapterTopicBox() {
    Box(
        modifier = Modifier
            .size(174.dp, 36.dp)
            .drawBehind {
                drawRoundRect(
                    color = Color(0xFFFFC8B3),
                    size = size,
                    topLeft = Offset(0.dp.toPx(), y = 3.03.dp.toPx()),
                    cornerRadius = CornerRadius(12.dp.toPx())
                )
            }
            .background(
                color = Color(0xFFFF6020),
                shape = RoundedCornerShape(12.dp)
            ),
        contentAlignment = Alignment.Center
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "Art",
                style = subjectChapterTextStyle
            )
            SmallCircle(
                dim = 4.dp,
                containerColor = Color.White.copy(alpha = 0.4f)
            )
            Text(
                text = "CH1",
                style = subjectChapterTextStyle
            )
            SmallCircle(
                dim = 4.dp,
                containerColor = Color.White.copy(alpha = 0.4f)
            )
            Text(
                text = "Topic 1",
                style = subjectChapterTextStyle
            )
        }
    }
}

@Composable
fun VideosCard(
    title: String,
    time: String,
    image: Int
){
    Box(
        modifier = Modifier
            .height(107.dp)
            .fillMaxWidth()
            .drawBehind {
                drawRoundRect(
                    color = Color(0xFFE6E5E5),
                    topLeft = Offset(x = 0.dp.toPx(), y = 6.dp.toPx()),
                    size = size,
                    cornerRadius = CornerRadius(12.dp.toPx())
                )
            }
            .border(
                width = 1.dp,
                color = Color(0xFFE6E5E5).copy(alpha = 0.2f),
                shape = RoundedCornerShape(12.dp)
            )
            .background(
                color = Color.White,
                shape = RoundedCornerShape(12.dp)
            )
            .clickable {

            },
    ){
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 20.dp),
            horizontalArrangement = Arrangement.spacedBy(20.dp),
            verticalAlignment = Alignment.CenterVertically
        ){
            Image(
                painter = painterResource(image),
                contentDescription = "flowers",
                modifier = Modifier
                    .size(141.dp, 82.dp)
                    .clip(RoundedCornerShape(10.dp))
            )
            Column {
                Text(
                    text = title,
                    style = MaterialTheme.typography.titleMedium.copy(
                        fontWeight = FontWeight(600),
                        fontSize = 14.sp,
                        lineHeight = 11.2.sp
                    )
                )
                Text(
                    text = time,
                    style = MaterialTheme.typography.titleMedium.copy(
                        fontSize = 12.sp,
                        lineHeight = 9.6.sp,
                        color = Color.Black.copy(alpha = 0.5f)
                    )
                )
            }
        }
    }
}

@Composable
fun AssignmentNameCard(
    assignmentNo: Int,
    onClick: () -> Unit ={ }
) {
    Box(
        modifier = Modifier
            .height(107.dp)
            .fillMaxWidth()
            .drawBehind {
                drawRoundRect(
                    color = Color(0xFFE6E5E5),
                    topLeft = Offset(x = 0.dp.toPx(), y = 6.dp.toPx()),
                    size = size,
                    cornerRadius = CornerRadius(12.dp.toPx())
                )
            }
            .border(
                width = 1.dp,
                color = Color(0xFFE6E5E5).copy(alpha = 0.2f),
                shape = RoundedCornerShape(12.dp)
            )
            .background(
                color = Color.White,
                shape = RoundedCornerShape(12.dp)
            )
            .clickable {
                onClick()
            },
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(15.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
            ) {
                Text(
                    text = "Assignment Name $assignmentNo",
                    style = MaterialTheme.typography.bodyLarge.copy(
                        fontSize = 18.sp,
                        lineHeight = 14.4.sp,
                        color = Color(0xFFFF6020)
                    )
                )
                AssignmentStatusBox()
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column {
                    Text(
                        text = "Published on",
                        style = MaterialTheme.typography.headlineSmall.copy(
                            fontWeight = FontWeight(400),
                            lineHeight = 9.6.sp,
                            color = Color(0xFF1D1751)
                        )
                    )
                    Spacer(modifier = Modifier.height(5.dp))
                    Text(
                        text = "22 August 2024",
                        style = MaterialTheme.typography.headlineSmall.copy(
                            fontWeight = FontWeight(400),
                            lineHeight = 9.6.sp,
                            color = Color(0xFF129193)
                        )
                    )
                }
                Column {
                    Text(
                        text = "Deadline",
                        style = MaterialTheme.typography.headlineSmall.copy(
                            fontWeight = FontWeight(400),
                            lineHeight = 9.6.sp,
                            color = Color(0xFF1D1751)
                        )
                    )
                    Spacer(modifier = Modifier.height(5.dp))
                    Text(
                        text = "22 August 2024",
                        style = MaterialTheme.typography.headlineSmall.copy(
                            fontWeight = FontWeight(400),
                            lineHeight = 9.6.sp,
                            color = Color(0xFF129193)
                        )
                    )
                }
            }
        }
    }
}

@Composable
fun AssignmentStatusBox(
    modifier: Modifier = Modifier,
    status: String = "Pending"
) {
    var gradientBrushColor = pendingGradient
    var statusIcon = R.drawable.pending

    when(status){
        "Pending" -> {
            gradientBrushColor = pendingGradient
            statusIcon = R.drawable.pending
        }
        "Submitted" -> {
            gradientBrushColor = submittedGradient
            statusIcon = R.drawable.submitted
        }
        "Marked" -> {
            gradientBrushColor = markedGradient
            statusIcon = R.drawable.submitted
        }
    }

    Box(
        modifier = modifier
            .width(97.dp)
            .height(25.dp)
            .clip(RoundedCornerShape(4.dp))
            .background(
                brush = gradientBrushColor
            ),
        contentAlignment = Alignment.Center
    ) {
        Row {
            Image(
                painter = painterResource(statusIcon),
                contentDescription = "pending",
                modifier = Modifier
                    .size(18.dp)
            )
            Spacer(modifier = Modifier.width(5.dp))
            Text(
                text = status,
                style = MaterialTheme.typography.headlineSmall.copy(
                    fontWeight = FontWeight(500),
                    lineHeight = 9.6.sp,
                    color = Color.White
                )
            )
        }
    }
}

@Composable
fun ContentBox(
    text: String,
    onClick: () -> Unit = { }
) {
    Box(
        modifier = Modifier
            .size(131.dp,35.dp)
            .drawBehind {
                drawRoundRect(
                    color = Color(0xFFE6E5E5),
                    topLeft = Offset(x = 0.dp.toPx(), y = 4.dp.toPx()),
                    size = size,
                    cornerRadius = CornerRadius(6.dp.toPx())
                )
            }
            .border(
                width = 1.dp,
                color = Color(0xFFE6E5E5).copy(alpha = 0.2f),
                shape = RoundedCornerShape(6.dp)
            )
            .background(
                color = Color.White,
                shape = RoundedCornerShape(6.dp)
            )
            .clickable {
                onClick()
            },
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = text,
            style = MaterialTheme.typography.titleSmall.copy(
                fontWeight = FontWeight(700),
                color = Color(0xFFFF6020)
            ),

        )
    }
}
