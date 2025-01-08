package com.studentapplication.studentapp.ui.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.studentapplication.studentapp.R
import com.studentapplication.studentapp.ui.utills.CommonButton
import com.studentapplication.studentapp.ui.utills.exelaGradient



@Composable
fun LoginAndRegisterScreen(
    modifier: Modifier = Modifier,
    navController: NavHostController
){
    val scrollState = rememberScrollState()

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = exelaGradient
            )
    ){
        Image(
            painter = painterResource(R.drawable.bottom_dots),
            contentDescription = "dots",
            modifier = Modifier
                .height(220.14.dp)
                .width(134.15.dp)
                .align(Alignment.BottomEnd)
                .offset(x = (-60).dp, y = (-135).dp)
        )
        Image(
            painter = painterResource(R.drawable.top_dots),
            contentDescription = "dots",
            modifier = Modifier
                .height(499.7.dp)
                .width(391.01.dp)
                .align(Alignment.TopStart)
                .offset(x = (-65).dp)
        )
        Image(
            painter = painterResource(R.drawable.bird),
            contentDescription = "bird",
            modifier = Modifier
                .size(229.68.dp)
                .align(Alignment.BottomStart)
                .offset(x = (-7).dp, y = 4.dp)
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
                .verticalScroll(scrollState),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Image(
                painter = painterResource(R.drawable.dog),
                contentDescription = "dog",
                modifier = Modifier
                    .height(193.14.dp)
                    .width(159.89.dp)
            )
            Spacer(modifier = Modifier.height(30.dp))
            Text(
                text = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s,",
                style = MaterialTheme.typography.labelMedium,
                color = Color.White,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp),
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.height(30.dp))
            CommonButton(
                text = "Log In",
                textColor = Color.White,
                outerBoxColor = Color(0xFF068183),
                outerShadowColor = Color(0xFF036465),
                innerBoxColor = Color(0xFF129193),
                innerShadowColor = Color(0xFF036465),
                curvedBoxColor = Color(0xFF068183),
                ovalColor = Color.White,
                onClick = {
                    navController.navigate(route = "login")
                }
            )
            Spacer(modifier = Modifier.height(30.dp))
            CommonButton(
                text = "Register",
                textColor = Color(0xFF129193),
                outerBoxColor = Color(0xFFF9F9F9),
                outerShadowColor = Color(0xFFD8D8D8),
                innerBoxColor = Color.White,
                innerShadowColor = Color(0xFFE1E1E1),
                curvedBoxColor = Color(0xFFF9F9F9),
                ovalColor = Color(0xFFF3F3F3),
                onClick = {
                    navController.navigate("register")
                }
            )
            Spacer(modifier = Modifier.height(70.dp))

        }
    }
}

