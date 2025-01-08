package com.studentapplication.studentapp.ui.login.registration

import androidx.compose.foundation.Image
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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.studentapplication.studentapp.R
import com.studentapplication.studentapp.ui.utills.BackArrowBox
import com.studentapplication.studentapp.ui.utills.CommonButton
import com.studentapplication.studentapp.ui.utills.LoginScreenTextField
import com.studentapplication.studentapp.ui.theme.interFont
import com.studentapplication.studentapp.ui.utills.exelaGradient


@Composable
fun RegisterScreen(modifier: Modifier = Modifier, navController: NavHostController){

    val scrollState = rememberScrollState()
    val schoolCode = remember { mutableStateOf("") }
    val phoneNumber = remember { mutableStateOf("") }
    val loginButtonEnabled = (phoneNumber.value.isNotEmpty() && schoolCode.value.isNotEmpty())


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
                        onClick = { navController.popBackStack() }
                    )
                }
                Box(
                    modifier = Modifier
                        .fillMaxWidth(0.9f),
                    contentAlignment = Alignment.Center
                ) {
                    Image(
                        painter = painterResource(R.drawable.dog),
                        contentDescription = "dog",
                        modifier = Modifier
                            .height(181.19.dp)
                            .width(150.dp)
                    )
                }
            }
            Text(
                text = "Create Account",
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
                    append("School Code")
                    withStyle(
                        SpanStyle(
                            fontFamily = interFont,
                            fontWeight = FontWeight(400),
                            fontSize = 14.sp,
                            color = Color(0xFFEF6464)
                    )
                    ){
                        append(" *")
                    }
                },
                style = MaterialTheme.typography.labelMedium.copy(
                    fontWeight = FontWeight(700),
                ),
            )
            LoginScreenTextField(
                text = schoolCode.value,
                labelText = "Enter your school code",
                onValueChange = { schoolCode.value = it}
            )
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
                    ){
                        append(" *")
                    }
                },
                style = MaterialTheme.typography.labelMedium.copy(
                    fontWeight = FontWeight(700),
                ),
            )
            SchoolNameBox()
            Spacer(modifier = Modifier.height(20.dp))
            Text(
                text = buildAnnotatedString {
                    append("Phone Number")
                    withStyle(
                        SpanStyle(
                            fontFamily = interFont,
                            fontWeight = FontWeight(400),
                            fontSize = 14.sp,
                            color = Color(0xFFEF6464)
                        )
                    ){
                        append(" *")
                    }
                },
                style = MaterialTheme.typography.labelMedium.copy(
                    fontWeight = FontWeight(700),
                ),
            )
            LoginScreenTextField(
                text = phoneNumber.value,
                labelText = "Enter registered phone number",
                onValueChange = { phoneNumber.value = it}
            )
            Spacer(modifier = Modifier.height(40.dp))
            CommonButton(
                text = "Get OTP",
                textColor = Color.White,
                outerBoxColor = Color(0xFF068183),
                outerShadowColor = Color(0xFF036465),
                innerBoxColor = Color(0xFF129193),
                innerShadowColor = Color(0xFF036465),
                curvedBoxColor = Color(0xFF068183),
                ovalColor = Color.White,
                enabled = loginButtonEnabled,
                modifier = Modifier.align(Alignment.CenterHorizontally),
                onClick = {
                    navController.navigate(route = "otp")
                }
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(15.dp),
                horizontalArrangement = Arrangement.Center
            ){
                Text(
                    text = "Already have an account ? ",
                    style = MaterialTheme.typography.titleMedium,
                    color = Color(0xFF333333)
                )
                Text(
                    text = "Log in",
                    style = MaterialTheme.typography.titleMedium.copy(
                        fontWeight = FontWeight(700),
                        brush = exelaGradient
                    ),
                    textDecoration = TextDecoration.Underline
                )
            }
        }
    }

}

@Composable
fun SchoolNameBox(schoolName: String = "1313- Exela pvt.school"){
    OutlinedTextField(
        value = schoolName,
        onValueChange = { },
        modifier = Modifier
            .height(52.dp)
            .fillMaxWidth()
            .clip(RoundedCornerShape(6.dp))
            .border(
                width = 2.dp,
                brush = Brush.linearGradient(
                    colors = listOf(
                        Color(0xFF185573).copy(alpha = 0.6f),
                        Color(0xFF14868D).copy(alpha = 0.6f)
                    ),
                    start = Offset(0f, 0f),
                    end = Offset(Float.POSITIVE_INFINITY, 0f)
                ),
                shape = RoundedCornerShape(6.dp)
            ),
        readOnly = true,
        textStyle = MaterialTheme.typography.labelMedium.copy(
            fontWeight = FontWeight(700),
            color = Color(0xFF1D1751).copy(alpha = 0.7f)
        ),
        colors = TextFieldDefaults.colors(
            focusedContainerColor = Color(0xFF129193).copy(alpha = 0.08f),
            unfocusedContainerColor = Color(0xFF129193).copy(alpha = 0.08f),
        )
    )
}