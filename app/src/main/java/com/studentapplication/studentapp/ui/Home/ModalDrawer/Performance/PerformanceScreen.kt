package com.studentapplication.studentapp.ui.Home.ModalDrawer.Performance

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.draw.scale
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
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
import com.studentapplication.studentapp.ui.subject.ChapterSearchBox
import com.studentapplication.studentapp.ui.subject.ContentBox
import com.studentapplication.studentapp.ui.theme.nunitoFont
import com.studentapplication.studentapp.ui.utills.BackArrowBox
import com.studentapplication.studentapp.ui.utills.artGradient
import com.studentapplication.studentapp.ui.utills.detailsGradient
import com.studentapplication.studentapp.ui.utills.englishGradient
import com.studentapplication.studentapp.ui.utills.generalGradient
import com.studentapplication.studentapp.ui.utills.scienceGradient

@Composable
fun PerformanceScreen(
    modifier: Modifier = Modifier,
    navController: NavHostController
){
    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(scrollState)
    ) {
        Column(
            modifier = Modifier.padding(horizontal = 20.dp)
        ){
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
            Spacer(modifier = Modifier.height(20.dp))
            Box(
                modifier = Modifier
                    .size(304.58.dp)
                    .clip(CircleShape)
                    .align(Alignment.CenterHorizontally)
                    .background(color = Color.White),
                contentAlignment = Alignment.Center
            ){
                Image(
                    painter = painterResource(R.drawable.profile_boy),
                    contentDescription = "profile",
                    modifier = Modifier
                        .size(249.23.dp)
                        .clip(CircleShape)
                )
            }

            Text(
                text = "Vinay Kumar",
                style = MaterialTheme.typography.labelLarge.copy(
                    fontSize = 32.sp,
                    lineHeight = 32.sp,
                    color = Color(0xFF129193)
                ),
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.height(20.dp))

            DetailsBox(modifier = Modifier.align(Alignment.CenterHorizontally))

            Spacer(modifier = Modifier.height(25.dp))

            Text(
                text = "Your result belongs\nland category",
                style = MaterialTheme.typography.labelMedium.copy(
                    fontWeight = FontWeight(700),
                    color = Color(0xFF1D1751)
                ),
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.height(10.dp))

            Box(
                modifier = Modifier
                    .size(386.dp, 150.dp)
                    .align(Alignment.CenterHorizontally)
            ){
                Box(
                    modifier = Modifier
                        .size(386.dp, 100.dp)
                        .background(
                            color = Color(0xFFEAFAB8),
                            shape = RoundedCornerShape(20.dp)
                        )
                        .align(Alignment.BottomCenter)
                )
                Column(
                    modifier = Modifier
                        .align(Alignment.TopCenter)
                        .padding(vertical = 0.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ){
                    Image(
                        painter = painterResource(R.drawable.land),
                        contentDescription = "land",
                        modifier = Modifier
                            .size(187.dp, 112.dp)
                    )
                    Text(
                        text = "Land",
                        style = MaterialTheme.typography.bodyLarge.copy(
                            fontSize = 28.sp,
                            lineHeight = 38.19.sp,
                            color = Color(0xFF09A76D)
                        )
                    )
                }
            }

            Spacer(modifier = Modifier.height(20.dp))
            Text(
                text = "Performance Subjectwise",
                style = MaterialTheme.typography.titleSmall.copy(
                    fontWeight = FontWeight(800),
                    color = Color(0xFF129193)
                )
            )
            Spacer(modifier = Modifier.height(20.dp))
            Column(
                verticalArrangement = Arrangement.spacedBy(15.dp)
            ){
                EachSubjectPerformance(
                    image = R.drawable.land,
                    boxGradient = scienceGradient,
                    boxShadowColor = Color(0xFF00A9DC),
                    bgImage = R.drawable.perform_science,
                    subject = "Science",
                    onClick = { navController.navigate(route = "singleSubjectPerformance") },
                    imageModifier = Modifier.scale(1.25f)
                )
                EachSubjectPerformance(
                    image = R.drawable.mountain,
                    boxGradient = artGradient,
                    boxShadowColor = Color(0xFFFF6020),
                    bgImage = R.drawable.perform_art,
                    subject = "Arts",
                    onClick = { navController.navigate(route = "singleSubjectPerformance") },
                    imageModifier = Modifier.scale(1.25f)
                )
                EachSubjectPerformance(
                    image = R.drawable.sun_cloud,
                    boxGradient = englishGradient,
                    boxShadowColor = Color(0xFFE78024),
                    bgImage = R.drawable.perform_english,
                    subject = "English",
                    onClick = { navController.navigate(route = "singleSubjectPerformance") },
                    imageModifier = Modifier.scale(1.25f)
                )
                EachSubjectPerformance(
                    image = R.drawable.land,
                    boxGradient = generalGradient,
                    boxShadowColor = Color(0xFFDA5151),
                    bgImage = R.drawable.perform_gk,
                    subject = "General Knowledge",
                    onClick = { navController.navigate(route = "singleSubjectPerformance") },
                    imageModifier = Modifier.offset(x = 20.dp)
                )
            }

            Spacer(modifier = Modifier.height(50.dp))

        }


    }
}

@Composable
private fun EachSubjectPerformance(
    image: Int,
    boxGradient: Brush,
    boxShadowColor: Color,
    bgImage: Int,
    subject: String,
    onClick: () -> Unit = {},
    imageModifier: Modifier = Modifier
) {
    Box(
        modifier = Modifier
            .height(112.dp)
            .fillMaxWidth()
            .clickable { onClick() }
    ) {
        Box(
            modifier = Modifier
                .height(76.dp)
                .fillMaxWidth()
                .drawBehind {
                    drawRoundRect(
                        color = boxShadowColor,
                        size = size,
                        topLeft = Offset(x = 0.dp.toPx(), y = 4.dp.toPx()),
                        cornerRadius = CornerRadius(8.dp.toPx())
                    )
                }
                .clip(shape = RoundedCornerShape(8.dp))
                .background(
                    brush = boxGradient,
                )
                .align(Alignment.BottomCenter)
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
        Image(
            painter = painterResource(image),
            contentDescription = "land",
            modifier = Modifier
                .size(187.dp, 112.dp)
                .align(Alignment.TopEnd),
        )
    }
}

@Composable
private fun DetailsBox(modifier: Modifier = Modifier) {
    val labelStyle = TextStyle(
        fontFamily = nunitoFont,
        fontWeight = FontWeight(600),
        fontSize = 12.sp,
        lineHeight = 18.sp,
        color = Color.White.copy(alpha = 0.7f)
    )
    val valueStyle = TextStyle(
        fontFamily = nunitoFont,
        fontWeight = FontWeight(700),
        fontSize = 16.sp,
        lineHeight = 24.sp,
        color = Color.White
    )
    Box(
        modifier = modifier
            .size(377.dp, 94.dp)
            .drawBehind {
                drawRoundRect(
                    color = Color(0xFF129193),
                    topLeft = Offset(x = 0.dp.toPx(), y = 6.dp.toPx()),
                    size = size,
                    cornerRadius = CornerRadius(17.52.dp.toPx())
                )
            }
            .background(
                brush = detailsGradient,
                shape = RoundedCornerShape(17.52.dp)
            ),
        contentAlignment = Alignment.Center
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(20.dp)
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "CLASS",
                    style = labelStyle
                )
                Text(
                    text = "Nursery-A",
                    style = valueStyle
                )
            }
            Canvas(
                modifier = Modifier
                    .size(1.dp, 74.dp)
            ) {
                drawLine(
                    brush = Brush.linearGradient(
                        colors = listOf(
                            Color.White.copy(alpha = 0.1f),
                            Color.White.copy(alpha = 0.5f),
                            Color.White.copy(alpha = 0.1f),
                        )
                    ),
                    start = Offset.Zero,
                    end = Offset(x = 0f, y = size.height)
                )
            }
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "ROLL NO",
                    style = labelStyle
                )
                Text(
                    text = "01",
                    style = valueStyle
                )
            }
            Canvas(
                modifier = Modifier
                    .size(1.dp, 74.dp)
            ) {
                drawLine(
                    brush = Brush.linearGradient(
                        colors = listOf(
                            Color.White.copy(alpha = 0.1f),
                            Color.White.copy(alpha = 0.5f),
                            Color.White.copy(alpha = 0.1f),
                        )
                    ),
                    start = Offset.Zero,
                    end = Offset(x = 0f, y = size.height)
                )
            }
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "GENDER",
                    style = labelStyle
                )
                Text(
                    text = "Male",
                    style = valueStyle
                )
            }
        }
    }
}