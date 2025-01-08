package com.studentapplication.studentapp.ui.Home.ModalDrawer

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.studentapplication.studentapp.R
import com.studentapplication.studentapp.ui.utills.BackArrowBox
import com.studentapplication.studentapp.ui.utills.exelaGradient

@Composable
fun ProfileScreen(){
    Box(
        modifier = Modifier
            .fillMaxSize()
    ){
        Box(modifier = Modifier.offset(x = 0.dp, y = (-160).dp)) {
            Box(
                modifier = Modifier
                    .size(693.dp)
                    .clip(CircleShape)
                    .background(brush = exelaGradient)
                    .align(Alignment.TopCenter)
            )
        }
        Image(
            painter = painterResource(R.drawable.dog),
            contentDescription = "dog",
            modifier = Modifier
                .size(109.29.dp,132.65.dp)
                .rotate(-19.97f)
                .align(Alignment.TopEnd)
                .offset(x = (-60).dp, y = 40.dp),
            alpha = 0.4f
        )
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 20.dp)
        ){
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 70.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                BackArrowBox()
                Box(
                    modifier = Modifier
                        .size(36.dp)
                        .drawBehind {
                            val shadowOffsetY = 3.03.dp.toPx()
                            drawRoundRect(
                                color = Color(0xFF056E70),
                                topLeft = Offset(x = 0f, y = shadowOffsetY),
                                size = Size(size.width, size.height),
                                cornerRadius = CornerRadius(12.dp.toPx())
                            )
                        }
                        .background(
                            color = Color(0xFF129193),
                            RoundedCornerShape(12.dp)
                        )
                        .clickable {
                            //onClick()
                        },
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        painter = painterResource(R.drawable.edit),
                        contentDescription = "back",
                        tint = Color.White,
                        modifier = Modifier
                            .size(24.dp)
                    )
                }
            }

            Box(
                modifier = Modifier
                    .height(877.dp)
                    .fillMaxWidth()
            ){
                Surface(
                    modifier = Modifier
                        .size(379.dp, 780.dp)
                        .clip(RoundedCornerShape(16.dp))
                        .background(color = Color.Black)
                        .padding(top = 0.dp)
                ){

                }
            }

            //ProfileIconEdit()
        }
    }
}

@Composable
private fun ProfileIconEdit() {
    Box(
        modifier = Modifier
            .size(194.31.dp)
    ) {
        Box(
            modifier = Modifier
                .size(194.31.dp)
                .clip(CircleShape)
                .background(color = Color.White),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(R.drawable.profile_boy),
                contentDescription = "profile",
                modifier = Modifier
                    .size(159.dp)
                    .clip(CircleShape)
            )
        }

        Box(
            modifier = Modifier
                .size(51.dp)
                .clip(CircleShape)
                .border(
                    width = 1.76.dp,
                    color = Color.White,
                    shape = CircleShape
                )
                .background(brush = exelaGradient)
                .align(Alignment.BottomEnd)
                .clickable {

                },
            contentAlignment = Alignment.Center
        ) {
            Icon(
                painter = painterResource(R.drawable.edit),
                contentDescription = "back",
                tint = Color.White,
                modifier = Modifier
                    .size(27.1.dp)
            )
        }

    }
}