package com.studentapplication.studentapp.ui.login.account

import androidx.compose.foundation.Image
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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.studentapplication.studentapp.R
import com.studentapplication.studentapp.ui.login.registration.SchoolNameBox
import com.studentapplication.studentapp.ui.utills.BackArrowBox
import com.studentapplication.studentapp.ui.utills.LoginScreenTextField
import com.studentapplication.studentapp.ui.theme.interFont
import com.studentapplication.studentapp.ui.utills.CommonButton
import com.studentapplication.studentapp.ui.utills.GenderField
import com.studentapplication.studentapp.ui.utills.exelaGradient

@Composable
fun ProfileDetailsScreen(navController: NavHostController) {

    val scrollState = rememberScrollState()
    val firstName = remember { mutableStateOf("") }
    val lastName = remember { mutableStateOf("") }
    val genderChecked = remember { mutableStateOf(false) }
    val genderValue = if (genderChecked.value) "Female" else "Male"

    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Image(
            painter = painterResource(R.drawable.background_small_design),
            contentDescription = "design",
            modifier = Modifier
                .height(223.59.dp)
                .width(143.6.dp)
                .align(Alignment.TopStart)
                .offset(y = (-20).dp)
        )
        Image(
            painter = painterResource(R.drawable.background_large_design),
            contentDescription = "design",
            modifier = Modifier
                .fillMaxHeight()
                .width(409.04.dp)
                .align(Alignment.TopEnd)
                .offset(x = (43).dp)
        )
        Image(
            painter = painterResource(R.drawable.bird),
            contentDescription = "bird",
            modifier = Modifier
                .size(229.68.dp)
                .align(Alignment.BottomStart)
                .offset(x = 0.dp, y = 4.dp)
        )
        Image(
            painter = painterResource(R.drawable.cat),
            contentDescription = "cat",
            modifier = Modifier
                .height(162.32.dp)
                .width(141.35.dp)
                .align(Alignment.BottomEnd)
                .offset(y = 3.dp)
        )
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(scrollState)
                .padding(start = 15.dp, top = 55.dp, end = 15.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
            ) {
                Box(modifier = Modifier.padding(top = 13.dp)) {
                    BackArrowBox(
                        onClick = { navController.popBackStack()}
                    )
                }
                Box(
                    modifier = Modifier
                        .fillMaxWidth(0.9f),
                    contentAlignment = Alignment.Center
                ) {
                    Image(
                        painter = painterResource(R.drawable.giraffe),
                        contentDescription = "deer",
                        modifier = Modifier
                            .height(137.71.dp)
                            .width(128.34.dp)
                    )
                }
            }
            Text(
                text = "Enter Details",
                style = MaterialTheme.typography.labelLarge.copy(
                    fontSize = 25.sp,
                    lineHeight = 25.sp,
                    brush = exelaGradient
                ),
                modifier = Modifier
                    .fillMaxWidth(),
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.height(5.dp))
            Text(
                text = "Create a account by filling in info below.",
                style = MaterialTheme.typography.labelMedium.copy(
                    fontWeight = FontWeight(300)
                ),
                color = Color(0xFF333333),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp),
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.height(30.dp))
            Text(
                text = buildAnnotatedString {
                    append("First Name")
                    withStyle(
                        SpanStyle(
                            fontFamily = interFont,
                            fontWeight = FontWeight(400),
                            fontSize = 14.sp,
                            color = Color(0xFFEF6464)
                        )
                    ) {
                        append(" *")
                    }
                },
                style = MaterialTheme.typography.labelMedium.copy(
                    fontWeight = FontWeight(700),
                ),
            )
            LoginScreenTextField(
                text = firstName.value,
                labelText = "Enter your first name",
                onValueChange = { firstName.value = it}
            )
            Spacer(modifier = Modifier.height(20.dp))
            Text(
                text = buildAnnotatedString {
                    append("Last Name")
                    withStyle(
                        SpanStyle(
                            fontFamily = interFont,
                            fontWeight = FontWeight(400),
                            fontSize = 14.sp,
                            color = Color(0xFFEF6464)
                        )
                    ) {
                        append(" *")
                    }
                },
                style = MaterialTheme.typography.labelMedium.copy(
                    fontWeight = FontWeight(700),
                ),
            )
            LoginScreenTextField(
                text = lastName.value,
                labelText = "Enter your last name",
                onValueChange = { lastName.value = it}
            )
            Spacer(modifier = Modifier.height(20.dp))
            Text(
                text = buildAnnotatedString {
                    append("Gender")
                    withStyle(
                        SpanStyle(
                            fontFamily = interFont,
                            fontWeight = FontWeight(400),
                            fontSize = 14.sp,
                            color = Color(0xFFEF6464)
                        )
                    ) {
                        append(" *")
                    }
                },
                style = MaterialTheme.typography.labelMedium.copy(
                    fontWeight = FontWeight(700),
                ),
            )

            GenderField(genderValue, genderChecked)
            Spacer(modifier = Modifier.height(20.dp))

            Text(
                text = buildAnnotatedString {
                    append("School Name")
                    withStyle(
                        SpanStyle(
                            fontFamily = interFont,
                            fontWeight = FontWeight(400),
                            fontSize = 14.sp,
                            color = Color(0xFFEF6464)
                        )
                    ) {
                        append(" *")
                    }
                },
                style = MaterialTheme.typography.labelMedium.copy(
                    fontWeight = FontWeight(700),
                ),
            )
            SchoolNameBox()
            Spacer(modifier = Modifier.height(30.dp))

            CommonButton(
                text = "Save & Select Class",
                textColor = Color.White,
                textStyle = MaterialTheme.typography.labelLarge.copy(
                    fontSize = 20.sp,
                    lineHeight = 28.96.sp
                ),
                outerBoxColor = Color(0xFF068183),
                outerShadowColor = Color(0xFF036465),
                innerBoxColor = Color(0xFF129193),
                innerShadowColor = Color(0xFF036465),
                curvedBoxColor = Color(0xFF068183),
                ovalColor = Color.White,
                onClick = {
                    navController.navigate(route = "classes")
                },
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
        }
    }
}
