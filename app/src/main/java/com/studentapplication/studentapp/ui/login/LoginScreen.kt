package com.studentapplication.studentapp.ui.login

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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
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
import androidx.compose.ui.window.Dialog
import androidx.navigation.NavHostController
import com.studentapplication.studentapp.R
import com.studentapplication.studentapp.ui.utills.BackArrowBox
import com.studentapplication.studentapp.ui.utills.CommonButton
import com.studentapplication.studentapp.ui.utills.LoginScreenTextField
import com.studentapplication.studentapp.ui.utills.PasswordField
import com.studentapplication.studentapp.ui.theme.interFont
import com.studentapplication.studentapp.ui.utills.exelaGradient
import kotlinx.coroutines.delay


@Composable
fun LoginScreen(navController: NavHostController) {
    val phoneNumber = remember { mutableStateOf("") }
    val password = remember { mutableStateOf("") }
    val loginButtonEnabled = (phoneNumber.value.isNotEmpty() && password.value.isNotEmpty())
    val showSuccessDialog = remember { mutableStateOf(false) }
    val showFailedDialog = remember { mutableStateOf(false) }

    Box(
        modifier = Modifier
            .fillMaxSize()
    ){
        val scrollState = rememberScrollState()

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
        ){
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
            ){
                Box(modifier = Modifier.padding(top = 13.dp)) {
                    BackArrowBox(
                        onClick = { navController.popBackStack() }
                    )
                }
                Box(modifier = Modifier
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
                text = "Log In",
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
                text = "We will not share your number without  your permission",
                style = MaterialTheme.typography.labelSmall,
                color = Color(0xFF1D1751),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp),
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.height(30.dp))
            Text(
                text = buildAnnotatedString {
                    append("Phone Number")
                    withStyle(SpanStyle(
                        fontFamily = interFont,
                        fontWeight = FontWeight(400),
                        fontSize = 14.sp,
                    )){
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
            Spacer(modifier = Modifier.height(30.dp))
            Text(
                text = "Password",
                style = MaterialTheme.typography.labelMedium.copy(
                    fontWeight = FontWeight(700),
                ),
            )
            PasswordField(
                password = password.value,
                labelText = "Enter your password",
                onValueChange = { password.value = it }
            )
            Text(
                text = "Forgot Password?",
                style = MaterialTheme.typography.labelMedium.copy(
                    fontWeight = FontWeight(700),
                    lineHeight = 36.sp,
                    color = Color(0xFF129193)
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 10.dp),
                textAlign = TextAlign.End
            )

            CommonButton(
                text = "Log In",
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
                    showSuccessDialog.value = true
                }
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(15.dp),
                horizontalArrangement = Arrangement.Center
            ){
                Text(
                    text = "New to Kindergarten app?",
                    style = MaterialTheme.typography.labelMedium,
                    color = Color(0xFF333333)
                )
                Spacer(modifier = Modifier.width(10.dp))
                Text(
                    text = "Create account",
                    style = MaterialTheme.typography.labelMedium.copy(
                        fontWeight = FontWeight(700),
                        brush = exelaGradient
                    ),
                    textDecoration = TextDecoration.Underline
                )
            }
        }

        if (showSuccessDialog.value){
            LoginSuccessDialog(
                onDismiss = { showSuccessDialog.value = false}
            )
            LaunchedEffect(Unit) {
                delay(3000)
                navController.navigate(route = "dashboard")
            }
        }
    }
}

@Composable
fun LoginSuccessDialog(
    onDismiss: () -> Unit = { }
){
    Dialog(
        onDismissRequest = onDismiss
    ) {
        Box(
            modifier = Modifier
                .height(258.dp)
                .width(382.dp)
        ){
            Box(
                modifier = Modifier
                    .height(172.dp)
                    .width(382.dp)
                    .clip(RoundedCornerShape(25.dp))
                    .border(
                        width = 8.dp,
                        brush = Brush.linearGradient(
                            colors = listOf(Color.White, Color(0xFFE0E0E0))
                        ),
                        shape = RoundedCornerShape(25.dp)
                    )
                    .background(color = Color.White)
                    .align(Alignment.BottomCenter),
                contentAlignment = Alignment.Center
            ){
                Text(
                    text = "Log In Successful",
                    style = MaterialTheme.typography.titleLarge,
                    color = Color(0xFF47CB72)
                )
            }

            Box(
                modifier = Modifier
                    .size(150.dp)
                    .clip(CircleShape)
                    .background(Color.White)
                    .align(Alignment.TopCenter)
                    .shadow(
                        elevation = 60.dp,
                        shape = RoundedCornerShape(100.dp), // Adjust the corner radius as needed
                        clip = false,
                        spotColor = Color.Black.copy(alpha = 0.15f)
                    ),
                contentAlignment = Alignment.Center
            ){
                Image(
                    painter = painterResource(R.drawable.success),
                    contentDescription = "success",
                    modifier = Modifier.size(90.dp)
                )
            }
        }
    }
}


@Composable
fun LoginFailedDialog(
    onDismiss: () -> Unit = { }
){
    Dialog(
        onDismissRequest = onDismiss
    ) {
        Box(
            modifier = Modifier
                .height(258.dp)
                .width(382.dp)
        ){
            Box(
                modifier = Modifier
                    .height(172.dp)
                    .width(382.dp)
                    .clip(RoundedCornerShape(25.dp))
                    .border(
                        width = 8.dp,
                        brush = Brush.linearGradient(
                            colors = listOf(Color.White, Color(0xFFE0E0E0))
                        ),
                        shape = RoundedCornerShape(25.dp)
                    )
                    .background(color = Color.White)
                    .align(Alignment.BottomCenter),
                contentAlignment = Alignment.Center
            ){
                Text(
                    text = "Log In Failed",
                    style = MaterialTheme.typography.titleLarge,
                    color = Color(0xFFEF6464)
                )
            }

            Box(
                modifier = Modifier
                    .size(150.dp)
                    .clip(CircleShape)
                    .background(Color.White)
                    .align(Alignment.TopCenter)
                    .shadow(
                        elevation = 60.dp,
                        shape = RoundedCornerShape(100.dp), // Adjust the corner radius as needed
                        clip = false,
                        spotColor = Color.Black.copy(alpha = 0.15f)
                    ),
                contentAlignment = Alignment.Center
            ){
                Image(
                    painter = painterResource(R.drawable.failed),
                    contentDescription = "success",
                    modifier = Modifier.size(86.dp)
                )
            }
        }
    }
}