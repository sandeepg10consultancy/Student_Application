package com.studentapplication.studentapp.ui.subject

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
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.navigation.NavHostController
import com.studentapplication.studentapp.R
import com.studentapplication.studentapp.ui.theme.nunitoItalic
import com.studentapplication.studentapp.ui.utills.BackArrowBox
import com.studentapplication.studentapp.ui.utills.ChapterListButton
import com.studentapplication.studentapp.ui.utills.SmallCircle
import com.studentapplication.studentapp.ui.utills.TopProgressBox



@Composable
fun TopicListingScreen(navController: NavHostController) {
    val scrollState = rememberScrollState()
    val showChapterDialog = remember { mutableStateOf(false) }


    Box(
        modifier = Modifier
            .fillMaxSize()
            //.verticalScroll(scrollState)
    ){
        Column(
            modifier = Modifier
                .fillMaxSize()
        ) {
            TopProgressBox()
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp, vertical = 30.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                BackArrowBox(
                    boxColor = Color(0xFFFF6020),
                    shadowColor = Color(0xFFFFC8B3),
                    onClick = {navController.popBackStack()}
                )
                Spacer(modifier = Modifier.width(20.dp))
                ChapterListButton(
                    text = "Chapter List",
                    onClick = { navController.navigate(route = "chapterListing")}
                )
            }
        }

        SmallCircle(
            modifier = Modifier
                .align(Alignment.CenterStart)
                .offset(x = 80.dp, y = (-270).dp)
        )
        SmallCircle(
            modifier = Modifier
                .align(Alignment.CenterEnd)
                .offset(x = (-120).dp, y = (-250).dp)
        )

        SmallCircle(
            dim = 28.dp,
            modifier = Modifier
                .align(Alignment.CenterStart)
                .offset(x = (40).dp, y = (0).dp)
        )

        SmallCircle(
            dim = 16.dp,
            modifier = Modifier
                .align(Alignment.CenterEnd)
                .offset(x = (-60).dp, y = (-30).dp)
        )

        SmallCircle(
            modifier = Modifier
                .align(Alignment.Center)
                .offset(x = (-40).dp, y = (110).dp)
        )

        SmallCircle(
            modifier = Modifier
                .align(Alignment.Center)
                .offset(x = 90.dp, y = (230).dp)
        )

        SmallCircle(
            modifier = Modifier
                .align(Alignment.BottomStart)
                .offset(x = 70.dp, y = (-100).dp)
        )

        Box(
            modifier = Modifier
                .size(91.dp, 270.dp)
                .align(Alignment.TopEnd)
                .offset(y = 150.dp)
        ){
            Image(
                painter = painterResource(R.drawable.topic_listing_design1),
                contentDescription = "design",
                modifier = Modifier.fillMaxSize()
            )
            /*
            Canvas(
                modifier = Modifier
                    .height(255.dp)
                    .width(114.dp)
                .offset(x = -1.dp)
            ) {
                val path = Path().apply {
                    moveTo(size.width, 0f )
                    lineTo(size.width, size.height)
                    quadraticTo(
                        size.width * 0.7f, size.height * 0.95f,
                        size.width * 0.8f, size.height * 0.8f
                    )
                    lineTo(size.width * 0.8f, size.height * 0.55f)
                    quadraticTo(
                        0f - 50f, size.height * 0.05f,
                        size.width, 0f
                    )
                }
                drawPath(
                    path = path,
                    color = Color(0xFFFFC8B3),
//                    style = Stroke(
//                        width = 2.dp.toPx()
//                    )
                )
            }
            Canvas(
                modifier = Modifier
                    .height(219.99.dp)
                    .width(102.49.dp)
            ) {
                val path = Path().apply {
                    moveTo(size.width, 0f)
                    lineTo(size.width, size.height)
                    quadraticTo(
                        size.width * 0.5f, size.height * 0.9f,
                        size.width * 0.9f, size.height * 0.6f
                    )
                    quadraticTo(
                        size.width * 0.2f, size.height * 0.1f,
                        size.width,0f
                    )
                }

                drawPath(
                    path = path,
                    color = Color(0xFFFF804D),
//                    style = Stroke(
//                        width = 2.dp.toPx()
//                    )
                )
            }

             */
        }
        Box(
            modifier = Modifier
                .size(97.dp, 291.dp)
                .align(Alignment.CenterStart)
                .offset(x = (-5).dp, y = 150.dp)
        ){
            Image(
                painter = painterResource(R.drawable.topic_listing_design2),
                contentDescription = "design",
                modifier = Modifier
                    .fillMaxSize()
            )
        }
        Box(
            modifier = Modifier
                .size(222.78.dp, 80.dp)
                .align(Alignment.BottomStart)
                .offset(x = 40.dp)
        ){
            Image(
                painter = painterResource(R.drawable.topic_listing_design3),
                contentDescription = "design",
                modifier = Modifier
                    .fillMaxSize()
            )
        }
        Box(
            modifier = Modifier
                .width(300.dp)
                .height(862.4.dp)
                .align(Alignment.BottomCenter)

        ){
            DashedWave(
                modifier = Modifier
                    .fillMaxSize()
            )
            LockedChapter(
                modifier = Modifier
                    .align(Alignment.Center)
                    .offset(x = 70.dp, y = 90.dp),
                title = "Rhyme Time"
            )
            LockedChapter(
                modifier = Modifier
                    .align(Alignment.Center)
                    .offset(x = (-40).dp, y = (-120).dp),
                title = "My Family"
            )
            ChapterNumberCircle(
                modifier = Modifier
                    .align(Alignment.BottomStart)
                    .offset(x = 10.dp, y = (-110).dp),
                onClick = { showChapterDialog.value = true}
            )
            ChapterNavigator(
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .offset(x = (-60).dp, y = (-60).dp)
            )

        }

    }
    if (showChapterDialog.value){
        ChapterDialogBox(
            onDismissClick = { showChapterDialog.value = false },
            onStartClick = { navController.navigate(route = "topicDescription")}
        )
    }
}

@Composable
fun ChapterNavigator(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .size(31.dp)
            .clip(CircleShape)
            .background(
                color = Color(0xFFFF6020).copy(alpha = 0.8f)
            ),
        contentAlignment = Alignment.Center
    ) {
        Box(
            modifier = Modifier
                .size(22.dp)
                .clip(CircleShape)
                .background(color = Color.White),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(R.drawable.navigator),
                contentDescription = "navigator",
                modifier = Modifier
                    .size(16.dp, 18.dp)
            )
        }
    }
}

@Composable
fun LockedChapter(
    modifier: Modifier = Modifier,
    title: String
){
    Column(modifier = modifier){
        Text(
            text = title,
            style = MaterialTheme.typography.titleMedium.copy(
                fontWeight = FontWeight(600),
                color = Color(0xFF1D1751)
            )
        )
        Box(
            modifier = Modifier
                .size(74.dp)
                .clip(CircleShape)
                .background(
                    color = Color(0xFFFF6020)
                ),
            contentAlignment = Alignment.Center
        ) {
            Box(
                modifier = Modifier
                    .size(44.93.dp)
                    .clip(CircleShape)
                    .background(color = Color.White),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(R.drawable.lock_symbol),
                    contentDescription = "locked",
                    modifier = Modifier
                        .size(21.52.dp, 29.03.dp)
                )
            }
        }
    }
}


@Composable
fun ChapterNumberCircle(
    modifier: Modifier = Modifier,
    onClick: () -> Unit = { }
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(5.dp),
        horizontalAlignment = Alignment.CenterHorizontally
        ){
        Card(
            onClick = onClick,
            modifier = Modifier
                .size(177.dp, 65.dp),
            shape = RoundedCornerShape(12.dp),
            colors = CardDefaults.cardColors(
                containerColor = Color.White
            ),
            elevation = CardDefaults.cardElevation(
                defaultElevation = 3.dp
            )
        ) {
            Row(
                modifier = Modifier
                    .fillMaxSize(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceEvenly
            ){
                Text(
                    text = "All About Me",
                    style = MaterialTheme.typography.titleMedium.copy(
                        fontWeight = FontWeight(600),
                        fontSize = 14.sp,
                        lineHeight = 20.23.sp,
                        color = Color(0xFF1D1751)
                    )
                )
                Icon(
                    painter = painterResource(R.drawable.right_arrow),
                    contentDescription = "next",
                )
            }
        }
        Box(
            modifier = Modifier
                .size(74.dp)
                .clip(CircleShape)
                .background(
                    color = Color(0xFFFF6020).copy(alpha = 0.8f)
                    //brush = artGradient
                ),
            contentAlignment = Alignment.Center
        ) {
            Box(
                modifier = Modifier
                    .size(44.93.dp)
                    .clip(CircleShape)
                    .background(color = Color.White),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "01",
                    style = MaterialTheme.typography.bodySmall
                )
            }
        }
    }
}

@Composable
private fun ChapterDialogBox(
    onDismissClick:() -> Unit = { },
    onStartClick:() -> Unit = { },
) {
    Dialog(
        onDismissRequest = onDismissClick,
    ) {
        Box(
            modifier = Modifier
                .size(322.dp, 240.dp)
        ) {
            Box(
                modifier = Modifier
                    .size(34.79.dp)
                    .clip(CircleShape)
                    .background(color = Color.Black.copy(alpha = 0.7f))
                    .align(Alignment.TopCenter)
                    .clickable {
                        onDismissClick()
                    },
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    painter = painterResource(R.drawable.close),
                    contentDescription = "close",
                    tint = Color.White,
                    modifier = Modifier
                        .size(16.18.dp)
                )
            }
            Box(
                modifier = Modifier
                    .size(322.dp, 180.dp)
                    .align(Alignment.BottomCenter)
                    .drawBehind {
                        drawRoundRect(
                            color = Color(0xFFE6E5E5),
                            topLeft = Offset(x = 0.dp.toPx(), y = 6.dp.toPx()),
                            size = size,
                            cornerRadius = CornerRadius(12.dp.toPx())
                        )
                    }
                    .background(
                        color = Color.White,
                        shape = RoundedCornerShape(12.dp)
                    )
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(20.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            text = "01: All About Me",
                            style = MaterialTheme.typography.bodyLarge.copy(
                                fontSize = 20.sp,
                                lineHeight = 27.28.sp,
                                color = Color(0xFFFF6020)
                            )
                        )
                        Text(
                            text = "3 days",
                            style = MaterialTheme.typography.labelMedium.copy(
                                fontSize = 12.sp,
                                lineHeight = 16.37.sp,
                                color = Color(0xFF1D1751)
                            )
                        )
                    }

                    Spacer(modifier = Modifier.height(10.dp))

                    Row(
                        modifier = Modifier
                            .fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            text = buildAnnotatedString {
                                withStyle(
                                    style = SpanStyle(
                                        color = Color(0xFF2679B4)
                                    )
                                ) {
                                    append("Schedule on: ")
                                }
                                withStyle(
                                    style = SpanStyle(
                                        color = Color(0xFF1D1751)
                                    )
                                ) {
                                    append("1st Jul 2024")
                                }
                            },
                            style = TextStyle(
                                fontFamily = nunitoItalic,
                                fontWeight = FontWeight(400),
                                fontSize = 12.sp,
                                lineHeight = 9.6.sp,
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

                    ChapterScheduledProgress(
                        trackColor = Color.White.copy(alpha = 0.9f),
                        progress = 1f
                    )

                    Spacer(modifier = Modifier.height(30.dp))

                    ChapterListButton(
                        modifier = Modifier.width(175.dp),
                        text = "Start",
                        onClick = {
                            onStartClick()
                            onDismissClick()
                        }
                    )
                }
            }
        }
    }
}

@Composable
fun ChapterScheduledProgress(
    modifier: Modifier = Modifier,
    trackColor: Color = Color(0xFFBEBEBE),
    progress: Float = 0.5f,
) {
    Canvas(
        modifier = modifier
            .height(4.dp)
            .fillMaxWidth()
    ) {
        drawRoundRect(
            color = trackColor,
            cornerRadius = CornerRadius(10.dp.toPx()),
            size = size
        )
        drawRoundRect(
            color = Color(0xFF2679B4),
            cornerRadius = CornerRadius(10.dp.toPx()),
            size = Size(size.width * progress, size.height)
        )
    }
}


@Composable
fun DashedWave(
    modifier: Modifier = Modifier
){
    Canvas(
        modifier = modifier
            .fillMaxSize()
    ) {
        val path = Path().apply {
            moveTo(size.width * 0.5f, size.height)

            quadraticTo(
                size.width * 0.05f, size.height * 0.9f,
                size.width * 0.6f, size.height * 0.75f
            )
            quadraticTo(
                size.width * 0.9f, size.height * 0.65f,
                size.width * 0.6f, size.height * 0.52f
            )
            quadraticTo(
                size.width * 0.05f, size.height * 0.3f,
                size.width * 0.5f, size.height * 0.12f
            )
        }
        val dashEffect = PathEffect.dashPathEffect(floatArrayOf(20f, 10f), 0f)
        drawPath(
            path = path,
            color = Color(0xFFFFC8B3),
            style = Stroke(
                width = 1.34.dp.toPx(),
                pathEffect = dashEffect
            )
        )

    }
}

