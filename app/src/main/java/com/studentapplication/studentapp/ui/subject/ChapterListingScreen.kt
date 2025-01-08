package com.studentapplication.studentapp.ui.subject

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
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
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.studentapplication.studentapp.R
import com.studentapplication.studentapp.ui.utills.BackArrowBox
import com.studentapplication.studentapp.ui.utills.TopProgressBox

@Composable
fun ChapterListingScreen(navController: NavHostController) {
    val searchedChapter = remember { mutableStateOf("") }
    val scrollState = rememberScrollState()
    val chaptersAndTopics = listOf( 1 to 14, 2 to 24, 3 to 4)

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                color = Color(0xFFFF804D)
            )
            .verticalScroll(scrollState)

    ){
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 371.dp)
                .background(
                    color = Color(0xFFF6F6F6),
                    shape = RoundedCornerShape(topStart = 40.dp, topEnd = 40.dp)
                )

        ){
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 50.dp)
            ){
                chaptersAndTopics.forEach { (number, topic) ->
                    EachChapterTopics(
                        chapterNo = number,
                        topics = topic
                    )
                }
            }
        }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .align(Alignment.TopCenter)
        ){
            TopProgressBox()
            Box(
                modifier = Modifier
                    .height(351.dp)
                    .fillMaxWidth()
                    .padding(start = 20.dp, top = 20.dp, end = 20.dp)
            ){
                Column(
                    modifier = Modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.SpaceBetween
                ){
                    Row(
                        modifier = Modifier
                            .fillMaxWidth(),
                        verticalAlignment = Alignment.Top
                    ){
                        BackArrowBox(
                            boxColor= Color.White,
                            shadowColor= Color(0xFFFFC8B3),
                            iconColor= Color(0xFFFF6324),
                            onClick = { navController.popBackStack() }
                        )
                        Text(
                            text = "Art",
                            style = MaterialTheme.typography.labelLarge.copy(
                                fontSize = 50.sp,
                                lineHeight = 55.sp,
                                color = Color.White
                            ),
                            modifier = Modifier
                                .fillMaxWidth(0.95f),
                            textAlign = TextAlign.Center
                        )
                    }
                    Box(
                        modifier = Modifier
                            .size(245.dp, 73.dp)
                            .drawBehind {
                                drawRoundRect(
                                    color = Color(0xFFFFC8B3),
                                    topLeft = Offset(x = 0.dp.toPx(),y = 6.dp.toPx()),
                                    size = Size(size.width, size.height),
                                    cornerRadius = CornerRadius(12.dp.toPx())
                                )
                            }
                            .background(
                                color = Color.White,
                                shape = RoundedCornerShape(12.dp)
                            ),
                        contentAlignment = Alignment.Center
                    ){
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally
                        ){
                            Text(
                                text = "34 Chapters  |  80 Topics",
                                style = MaterialTheme.typography.titleSmall,
                                color = Color(0xFF129193)
                            )
                            Spacer(modifier = Modifier.height(10.dp))

                            SubjectProgressBar()
                        }
                    }

                    ChapterSearchBox(
                        shadowColor = Color(0xFFFFC8B3),
                        iconColor = Color(0xFFFF804D),
                        labelColor = Color(0xFFFF804D),
                        searchedChapter = searchedChapter
                    )

                    Box(
                        modifier = Modifier
                            .size(198.dp,54.dp)
                            .drawBehind {
                                drawRoundRect(
                                    color = Color(0xFFE6E5E5),
                                    topLeft = Offset(x = 0.dp.toPx(), y = 6.dp.toPx()),
                                    size = Size(size.width, size.height),
                                    cornerRadius = CornerRadius(12.dp.toPx())
                                )
                            }
                            .background(
                                color = Color.White,
                                shape = RoundedCornerShape(12.dp)
                            ),
                        contentAlignment = Alignment.Center
                    ){
                        Row(
                            horizontalArrangement = Arrangement.spacedBy(5.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ){
                            Image(
                                painter = painterResource(R.drawable.learning_journey),
                                contentDescription = "",
                                modifier = Modifier
                                    .size(32.dp)
                            )
                            Text(
                                text = "Learning Journey",
                                style = MaterialTheme.typography.labelSmall.copy(
                                    fontWeight = FontWeight(600),
                                    color = Color(0xFF129193)
                                )
                            )
                        }
                    }
                }
            }
        }


    }
}

@Composable
private fun EachChapterTopics(
    chapterNo: Int = 0,
    topics: Int = 0
) {
    val horizontalRowState = rememberScrollState()
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = "Chapter 0$chapterNo",
            style = MaterialTheme.typography.bodyMedium,
            color = Color(0xFFFF804D)
        )
        Text(
            text = "$topics Topics",
            style = MaterialTheme.typography.headlineSmall,
            color = Color(0xFF1D1751)
        )
    }
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 25.dp)
            .horizontalScroll(horizontalRowState),
    ){
        for (i in 1..topics){
            Spacer(modifier = Modifier.width(20.dp))
            ChapterTopicCard(i)
        }
    }

    if (chapterNo < 3) {
        HorizontalDivider(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp),
            thickness = 1.dp,
            color = Color(0xFFC2C2C2)
        )
        Spacer(modifier = Modifier.height(30.dp))
    }
}

@Composable
private fun ChapterTopicCard(
    topicNo: Int
) {
    Card(
        onClick = { },
        modifier = Modifier
            .size(125.dp, 153.dp),
        shape = RoundedCornerShape(10.dp),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 2.dp
        ),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        )
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                modifier = Modifier
                    .size(51.1.dp, 48.16.dp),
                contentAlignment = Alignment.Center
            ) {
                Canvas(
                    modifier = Modifier.fillMaxSize()
                ) {
                    val path = Path().apply {
                        moveTo(0f, size.height * 0.7f)
                        lineTo(size.width * 0.3f, size.height * 0.2f)
                        quadraticTo(
                            size.width * 0.5f, 0f,
                            size.width * 0.7f, size.height * 0.2f
                        )
                        quadraticTo(
                            size.width, size.height * 0.5f,
                            size.width, size.height * 0.7f
                        )
                        quadraticTo(
                            size.width, size.height,
                            size.width * 0.7f, size.height
                        )
                        lineTo(size.width * 0.2f, size.height * 0.95f)
                        quadraticTo(
                            0f, size.height,
                            0f, size.height * 0.7f
                        )
                    }

                    drawPath(
                        path = path,
                        color = Color(0xFFFF804D),
                    )
                }
                Text(
                    text = if (topicNo < 10)"0$topicNo" else "$topicNo",
                    style = MaterialTheme.typography.headlineSmall.copy(
                        fontSize = 18.sp,
                        lineHeight = 22.68.sp,
                        color = Color.White
                    )
                )
            }

            Text(
                text = "All About Me",
                style = MaterialTheme.typography.titleMedium.copy(
                    fontWeight = FontWeight(600),
                    fontSize = 14.sp,
                    lineHeight = 20.23.sp,
                    color = Color(0xFF1D1751)
                )
            )

            ChapterTopicProgressBar(progress = 0.7f)

            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(5.dp)
            ) {
                Icon(
                    painter = painterResource(R.drawable.video),
                    contentDescription = "video",
                    tint = Color.Black.copy(alpha = 0.5f),
                    modifier = Modifier.size(11.dp)
                )
                Text(
                    text = "4 videos",
                    style = MaterialTheme.typography.headlineSmall.copy(
                        fontSize = 10.sp,
                        lineHeight = 12.6.sp,
                        color = Color.Black.copy(alpha = 0.5f),
                    )
                )
            }
        }
    }
}

@Composable
fun ChapterSearchBox(
    modifier: Modifier = Modifier,
    shadowColor: Color = Color(0xFFE6E5E5),
    iconColor: Color = Color(0xFF129193),
    labelColor: Color = Color(0xFF129193),
    searchedChapter: MutableState<String>
) {
    Box(
        modifier = modifier
            .height(50.dp)
            .width(386.dp)
            .drawBehind {
                drawRoundRect(
                    color = shadowColor,
                    topLeft = Offset(x = 0.dp.toPx(), y = 6.dp.toPx()),
                    size = size,
                    cornerRadius = CornerRadius(12.dp.toPx())
                )
            }
            .background(
                color = Color.White,
                shape = RoundedCornerShape(12.dp)
            )
            .clip(RoundedCornerShape(12.dp))
    ) {
        TextField(
            value = searchedChapter.value,
            onValueChange = { searchedChapter.value = it },
            modifier = Modifier
                .fillMaxSize(),
            colors = TextFieldDefaults.colors(
                unfocusedContainerColor = Color.White,
                focusedContainerColor = Color.White,
                unfocusedIndicatorColor = Color.White,
                focusedIndicatorColor = Color.White,
            ),
            placeholder = {
                Text(
                    text = "Search your chapter here",
                    style = MaterialTheme.typography.titleMedium.copy(
                        fontSize = 14.sp,
                        lineHeight = 11.2.sp,
                        color = labelColor
                    )
                )
            },
            leadingIcon = {
                Icon(
                    painter = painterResource(R.drawable.search),
                    contentDescription = "search",
                    tint = iconColor,
                    modifier = Modifier
                        .size(15.dp)
                )
            },
            textStyle = MaterialTheme.typography.titleMedium.copy(
                fontSize = 14.sp,
                lineHeight = 11.2.sp,
                color = labelColor
            )
        )
    }
}

@Composable
fun SubjectProgressBar(progress: Float = 0.7f) {
    Box(
        modifier = Modifier
            .size(121.dp, 5.dp)
    ) {
        Canvas(
            modifier = Modifier
                .fillMaxSize()
        ) {
            drawRoundRect(
                color = Color(0xFFD9D9D9),
                cornerRadius = CornerRadius(30.dp.toPx()),
                size = size
            )
            drawRoundRect(
                color = Color(0xFFFF804D),
                cornerRadius = CornerRadius(30.dp.toPx()),
                size = Size(size.width * progress, size.height)
            )
        }
    }
}

@Composable
fun ChapterTopicProgressBar(progress: Float = 0.7f) {
    Box(
        modifier = Modifier
            .size(73.dp, 2.dp)
    ) {
        Canvas(
            modifier = Modifier
                .fillMaxSize()
        ) {
            drawRoundRect(
                color = Color(0xFFD9D9D9),
                cornerRadius = CornerRadius(2.dp.toPx()),
                size = size
            )
            drawRoundRect(
                color = Color.Black,
                cornerRadius = CornerRadius(2.dp.toPx()),
                size = Size(size.width * progress, size.height)
            )
        }
    }
}