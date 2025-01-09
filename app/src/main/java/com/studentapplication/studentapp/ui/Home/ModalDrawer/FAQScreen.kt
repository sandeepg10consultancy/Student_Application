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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.studentapplication.studentapp.R
import com.studentapplication.studentapp.ui.utills.BackArrowBox


val faqsData = listOf(
    "How do I create an account?" to "To create an account, download the app, open it, and follow the registration prompts. You'll need to provide your email, create a password, and verify your email address.",
    "How do I update my profile information?" to "To create an account, download the app, open it, and follow the registration prompts. You'll need to provide your email, create a password, and verify your email address.",
    "How can I track student performance?" to "To create an account, download the app, open it, and follow the registration prompts. You'll need to provide your email, create a password, and verify your email address.",
    "How do I create and assign homework?" to "To create an account, download the app, open it, and follow the registration prompts. You'll need to provide your email, create a password, and verify your email address.",
    "How is my data protected?" to "To create an account, download the app, open it, and follow the registration prompts. You'll need to provide your email, create a password, and verify your email address.",
    "Can I delete my account?" to "To create an account, download the app, open it, and follow the registration prompts. You'll need to provide your email, create a password, and verify your email address.",
    "What tools are available for class communication?" to "To create an account, download the app, open it, and follow the registration prompts. You'll need to provide your email, create a password, and verify your email address.",
    "How do I update my profile information?" to "To create an account, download the app, open it, and follow the registration prompts. You'll need to provide your email, create a password, and verify your email address.",
)


@Composable
fun FAQScreen(navController: NavHostController){

    val scrollState = rememberScrollState()
    val searchedChapter = remember { mutableStateOf("") }

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
                    text = "FAQ",
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
                searchedString = searchedChapter,
                placeholder = "Search your FAQ here"
            )

            Spacer(modifier = Modifier.height(20.dp))

            faqsData.forEach { pair ->
                EachFAQBox(
                    question = pair.first,
                    answer = pair.second
                )
                Spacer(modifier = Modifier.height(20.dp))
            }
        }
    }
}

@Composable
fun SearchTextField(
    searchedString: MutableState<String>,
    placeholder: String
) {
    TextField(
        value = searchedString.value,
        onValueChange = { searchedString.value = it },
        modifier = Modifier
            .height(51.dp)
            .fillMaxSize()
            .clip(RoundedCornerShape(8.dp)),
        colors = TextFieldDefaults.colors(
            unfocusedContainerColor = Color(0xFFF3F9FA),
            focusedContainerColor = Color(0xFFF3F9FA),
            unfocusedIndicatorColor = Color.Transparent,
            focusedIndicatorColor = Color.Transparent,
        ),
        placeholder = {
            Text(
                text = placeholder,
                style = MaterialTheme.typography.labelMedium.copy(
                    lineHeight = 12.8.sp,
                    color = Color(0xFF129193)
                )
            )
        },
        leadingIcon = {
            Icon(
                painter = painterResource(R.drawable.search),
                contentDescription = "search",
                tint = Color(0xFF129193),
                modifier = Modifier
                    .size(15.dp)
            )
        },
        textStyle = MaterialTheme.typography.titleMedium.copy(
            fontSize = 14.sp,
            lineHeight = 11.2.sp,
            color = Color(0xFF129193)
        )
    )
}

@Composable
private fun EachFAQBox(
    question: String,
    answer: String
) {

    val isAnswerVisible = remember { mutableStateOf(false) }
    val shadowColor = if (isAnswerVisible.value) Color(0xFF75B6E4) else Color(0xFFE6E5E5)
    val arrowIcon = if (isAnswerVisible.value) R.drawable.up_arrow else R.drawable.down_arrow

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .drawBehind {
                drawRoundRect(
                    color = shadowColor,
                    topLeft = Offset(x = 0.dp.toPx(), y = 6.dp.toPx()),
                    size = size,
                    cornerRadius = CornerRadius(12.dp.toPx())
                )
            }
            .border(
                width = 1.dp,
                color = Color(0xFFE6E5E5).copy(alpha = 0.3f),
                shape = RoundedCornerShape(12.dp)
            )
            .background(
                color = Color.White,
                shape = RoundedCornerShape(12.dp)
            )
            .padding(horizontal = 20.dp),
    ) {
        Column {
            Row(
                modifier = Modifier
                    .height(62.dp)
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = question,
                    style = MaterialTheme.typography.labelMedium.copy(
                        fontWeight = FontWeight(700),
                        color = Color(0xFF1D1751)
                    ),
                    modifier = Modifier
                        .fillMaxWidth(0.95f),
                )
                Image(
                    painter = painterResource(arrowIcon),
                    contentDescription = "down",
                    modifier = Modifier
                        .size(15.dp)
                        .clickable {
                            isAnswerVisible.value = !isAnswerVisible.value
                        }
                )
            }
            if (isAnswerVisible.value) {
                Text(
                    text = answer,
                    style = MaterialTheme.typography.labelMedium,
                    modifier = Modifier.padding(bottom = 20.dp)
                )
            }
        }

    }
}