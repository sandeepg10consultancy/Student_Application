package com.studentapplication.studentapp.ui.login.otp

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.studentapplication.studentapp.R
import com.studentapplication.studentapp.ui.utills.BackArrowBox
import com.studentapplication.studentapp.ui.utills.CommonButton
import com.studentapplication.studentapp.ui.utills.exelaGradient

@Composable
fun OTPScreen(navController: NavHostController) {

    val scrollState = rememberScrollState()
    val otpDigits = remember { List(4) { mutableStateOf("") } }
    val buttonEnabled = otpDigits.all { it.value.isNotEmpty() }

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
                        onClick = {
                            navController.popBackStack()
                        }
                    )
                }
                Box(
                    modifier = Modifier
                        .fillMaxWidth(0.9f),
                    contentAlignment = Alignment.Center
                ) {
                    Image(
                        painter = painterResource(R.drawable.chick),
                        contentDescription = "Chick",
                        modifier = Modifier
                            .height(225.dp)
                            .width(186.dp)
                    )
                }
            }
            Text(
                text = "OTP Verification",
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
                text = buildAnnotatedString {
                    append("A 4 digit code has been sent to\n +")
                    withStyle(style = SpanStyle(
                        fontWeight = FontWeight(700)
                    )){
                        append(" 98900000XXXXX ")
                    }
                },
                style = MaterialTheme.typography.labelMedium,
                modifier = Modifier
                    .fillMaxWidth(),
                textAlign = TextAlign.Center,
                color = Color(0xFF333333)
            )
            Spacer(modifier = Modifier.height(30.dp))
            OTPField(otpDigits)
            Spacer(modifier = Modifier.height(30.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ){
                Text(
                    text = "Don’t receive the code ? ",
                    style = MaterialTheme.typography.labelMedium,
                    color = Color(0xFF333333)
                )
                Text(
                    text = "RESEND",
                    style = MaterialTheme.typography.titleMedium.copy(
                        fontWeight = FontWeight(600),
                        brush = exelaGradient
                    ),
                    textDecoration = TextDecoration.Underline
                )
            }
            Spacer(modifier = Modifier.height(30.dp))
            CommonButton(
                text = "Verify",
                textColor = Color.White,
                outerBoxColor = Color(0xFF068183),
                outerShadowColor = Color(0xFF036465),
                innerBoxColor = Color(0xFF129193),
                innerShadowColor = Color(0xFF036465),
                curvedBoxColor = Color(0xFF068183),
                ovalColor = Color.White,
                enabled = buttonEnabled,
                modifier = Modifier.align(Alignment.CenterHorizontally),
                onClick = {
                    navController.navigate(route = "password")
                }
            )
        }
    }

}

@Composable
fun OTPField(otpDigits: List<MutableState<String>>) {

    val focusManager = LocalFocusManager.current

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
    ){
        otpDigits.forEachIndexed { index, digitState ->
            Box(
                modifier = Modifier
                    .size(58.dp)
                    .drawBehind {
                        val shadowColor = Color(0xFF036465)
                        val shadowOffsetY = 5.52.dp.toPx()
                        drawRoundRect(
                            color = shadowColor,
                            topLeft = Offset(x = 0f, y = shadowOffsetY),
                            size = Size(size.width,size.height),
                            cornerRadius = CornerRadius(20.dp.toPx())
                        )
                    }
                    .background(
                        color = Color(0xFFFDC201),
                        shape = RoundedCornerShape(20.dp)
                    ),
                contentAlignment = Alignment.Center
            ){
                Column(
                    modifier = Modifier
                        .fillMaxSize(),
                    verticalArrangement = Arrangement.SpaceEvenly,
                    horizontalAlignment = Alignment.CenterHorizontally
                ){
                    BasicTextField(
                        value = digitState.value,
                        onValueChange = { value ->
                            if (value.length <= 1 && value.all { it.isDigit() }){
                                digitState.value = value
                                if (value.isNotEmpty() && index < otpDigits.size - 1){
                                    focusManager.moveFocus(FocusDirection.Next)
                                }
                            }
                        },
                        modifier = Modifier
                            .height(43.dp)
                            .width(24.dp)
                            .background(Color.Transparent),
                        textStyle = MaterialTheme.typography.bodyLarge.copy(
                            color = Color(0xFFFFFEFF),
                            textAlign = TextAlign.Center
                        ),
                        singleLine = true,
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                        cursorBrush = SolidColor(Color.White),
                    )
                    if (digitState.value.isEmpty()) {
                        Box(
                            modifier = Modifier
                                .height(2.dp)
                                .width(20.dp)
                                .clip(RoundedCornerShape(5.dp))
                                .background(color = Color.White)
                        )
                    }
                    Spacer(modifier = Modifier.height(6.dp))
                }
            }
        }
    }
}