package com.studentapplication.studentapp.ui.Home.ModalDrawer.Performance

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.draw.scale
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.studentapplication.studentapp.R
import com.studentapplication.studentapp.ui.theme.nunitoFont
import com.studentapplication.studentapp.ui.utills.BackArrowBox
import com.studentapplication.studentapp.ui.utills.scienceGradient

@Composable
fun SingleSubjectPerformance(navController: NavHostController){
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
                    text = "My Performance",
                    style = MaterialTheme.typography.labelLarge.copy(
                        fontSize = 25.sp,
                        lineHeight = 25.sp,
                        letterSpacing = 0.03.sp
                    ),
                    modifier = Modifier
                        .fillMaxWidth(0.9f),
                    textAlign = TextAlign.Center
                )
            }
            Spacer(modifier = Modifier.height(30.dp))
            SubjectTitleBox(
                boxGradient = scienceGradient,
                bgImage = R.drawable.perform_science,
                subject = "Science",
                imageModifier = Modifier.scale(1.25f)
            )
            Spacer(modifier = Modifier.height(30.dp))

            Column(
                verticalArrangement = Arrangement.spacedBy(30.dp)
            ){
                ChapterWisePerformance(
                    chapterNo = 1,
                    chapterName = "01:  All About Me"
                )
                ChapterWisePerformance(
                    chapterNo = 2,
                    chapterName = "01:  All About Me"
                )
                ChapterWisePerformance(
                    chapterNo = 3,
                    chapterName = "01:  All About Me"
                )
                ChapterWisePerformance(
                    chapterNo = 4,
                    chapterName = "01:  All About Me"
                )
                ChapterWisePerformance(
                    chapterNo = 5,
                    chapterName = "01:  All About Me"
                )
            }
            Spacer(modifier = Modifier.height(50.dp))
        }
    }
}

@Composable
private fun ChapterWisePerformance(
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
                color = Color(0xFFE6E5E5).copy(alpha = 0.2f),
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
fun SubjectTitleBox(
    boxGradient: Brush,
    bgImage: Int,
    subject: String,
    imageModifier: Modifier = Modifier
){
    Box(
        modifier = Modifier
            .height(76.dp)
            .fillMaxWidth()
            .clip(shape = RoundedCornerShape(8.dp))
            .background(
                brush = boxGradient,
            )
    ) {
        Image(
            painter = painterResource(bgImage),
            contentDescription = "photo",
            modifier = imageModifier
                .size(101.78.dp, 89.35.dp)
                .offset(x = 70.dp, y = 0.dp),
        )
        Text(
            text = subject,
            style = MaterialTheme.typography.labelLarge.copy(
                fontSize = 26.sp,
                lineHeight = 26.sp,
                color = Color.White
            ),
            modifier = Modifier.padding(15.dp)
        )
    }
}

@Composable
fun GradientCircularProgressIndicator(
    progress: Float,
    strokeWidth: Dp,
    modifier: Modifier = Modifier,
    gradientColors: List<Color> = listOf(Color.Cyan, Color.Blue),
    trackColor: Color = Color.LightGray,
) {
    Canvas(modifier = modifier) {
        val diameter = size.minDimension
        val stroke = strokeWidth.toPx()
        val radius = (diameter - stroke) / 2
        drawCircle(
            color = trackColor,
            radius = radius,
            style = Stroke(stroke, cap = StrokeCap.Round)
        )
        val sweepAngle = 360f * progress
        val gradient = Brush.linearGradient(gradientColors)

        drawArc(
            brush = gradient,
            startAngle = -90f,
            sweepAngle = sweepAngle,
            useCenter = false,
            topLeft = Offset(stroke / 2, stroke / 2),
            size = Size(diameter- stroke, diameter - stroke),
            style = Stroke(stroke, cap = StrokeCap.Round)
        )
    }
}