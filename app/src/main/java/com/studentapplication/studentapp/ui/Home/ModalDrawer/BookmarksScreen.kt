package com.studentapplication.studentapp.ui.Home.ModalDrawer

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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.studentapplication.studentapp.R
import com.studentapplication.studentapp.ui.subject.ChapterCompletionProgress
import com.studentapplication.studentapp.ui.subject.ChapterSearchBox
import com.studentapplication.studentapp.ui.subject.ContentBox
import com.studentapplication.studentapp.ui.subject.subjectChapterTextStyle
import com.studentapplication.studentapp.ui.theme.nunitoItalic
import com.studentapplication.studentapp.ui.utills.BackArrowBox
import com.studentapplication.studentapp.ui.utills.SmallCircle
import com.studentapplication.studentapp.ui.utills.artGradient
import com.studentapplication.studentapp.ui.utills.exelaGradient

@Composable
fun BookmarksScreen(
    navController: NavHostController
){

    val searchedChapter = remember { mutableStateOf("") }
    val subjectsList = listOf("Art", "Numeracy", "English", "Science")
    val selectedSubject = remember { mutableStateOf(subjectsList[0]) }

    Column(
        modifier = Modifier
            .fillMaxSize()
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
                    text = "Bookmarks",
                    style = MaterialTheme.typography.labelLarge.copy(
                        fontSize = 20.sp,
                        lineHeight = 20.sp
                    ),
                    modifier = Modifier
                        .fillMaxWidth(0.9f),
                    textAlign = TextAlign.Center
                )
            }
            Spacer(modifier = Modifier.height(20.dp))
            ChapterSearchBox(
                searchedChapter = searchedChapter
            )
            Spacer(modifier = Modifier.height(20.dp))
        }

        LazyRow(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(10.dp),
            verticalAlignment = Alignment.CenterVertically
        ){
            items(subjectsList){ subject ->
                Spacer(modifier = Modifier.width(20.dp))
                val isSelected = subject == selectedSubject.value
                if (isSelected) {
                    ContentBox(
                        text = subject,
                        onClick = { selectedSubject.value = subject}
                    )
                }else {
                    Text(
                        text = subject,
                        style = MaterialTheme.typography.titleSmall,
                        color = Color(0xFF1D1751),
                        modifier = Modifier
                            .clickable { selectedSubject.value = subject }
                    )
                }

            }
        }
        Column(
            modifier = Modifier
                .padding(20.dp)
        ){
            BookmarkedBox()
        }
    }
}

@Composable
private fun BookmarkedBox() {
    Box(
        modifier = Modifier
            .height(152.dp)
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
            ),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier
                .padding(horizontal = 20.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    Text(
                        text = "Art",
                        style = subjectChapterTextStyle.copy(
                            brush = artGradient
                        )
                    )
                    SmallCircle(
                        dim = 4.dp,
                        containerColor = Color.Black.copy(alpha = 0.4f)
                    )
                    Text(
                        text = "CH1",
                        style = subjectChapterTextStyle.copy(
                            color = Color(0xFF129193)
                        )
                    )
                }
                Image(
                    painter = painterResource(R.drawable.colored_bookmark),
                    contentDescription = "bookmark",
                    modifier = Modifier.size(18.dp)
                )
            }

            Text(
                text = "All About Me",
                style = MaterialTheme.typography.bodyLarge.copy(
                    fontSize = 20.sp,
                    lineHeight = 27.28.sp,
                    color = Color(0xFFFF6020)
                )
            )
            Column(
                modifier = Modifier
                    .size(346.dp, 28.dp)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "Schedule on: 1st Jul 2024",
                        style = TextStyle(
                            fontFamily = nunitoItalic,
                            fontWeight = FontWeight(400),
                            fontSize = 12.sp,
                            lineHeight = 9.6.sp,
                            color = Color(0xFF2679B4)
                        )
                    )
                    Image(
                        painter = painterResource(R.drawable.scheduled_calendar),
                        contentDescription = "calendar",
                        modifier = Modifier
                            .size(18.dp)
                    )
                }
                Spacer(modifier = Modifier.height(5.dp))
                ChapterCompletionProgress(
                    progress = 1f
                )
            }
        }
    }
}