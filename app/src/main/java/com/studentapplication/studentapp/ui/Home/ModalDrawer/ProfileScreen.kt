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
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.navigation.NavHostController
import com.studentapplication.studentapp.R
import com.studentapplication.studentapp.ui.theme.nunitoFont
import com.studentapplication.studentapp.ui.utills.BackArrowBox
import com.studentapplication.studentapp.ui.utills.CommonButton
import com.studentapplication.studentapp.ui.utills.DashedUploadMediaBox
import com.studentapplication.studentapp.ui.utills.exelaGradient

@Composable
fun ProfileScreen(navController: NavHostController) {
    val scrollState = rememberScrollState()
    val photoUploadedDialog = remember { mutableStateOf(false) }

    Box(
        modifier = Modifier
            .drawBehind {
                val path = Path().apply {
                    moveTo(0f, 0f)
                    lineTo(size.width, 0f)
                    lineTo(size.width, size.height * 0.5f)
                    quadraticTo(
                        size.width * 0.5f, size.height * 0.63f,
                        0f, size.height * 0.5f
                    )
                }
                drawPath(
                    path = path,
                    brush = exelaGradient,
                )
            }
            .verticalScroll(scrollState)
    ){

        Image(
            painter = painterResource(R.drawable.dog),
            contentDescription = "dog",
            modifier = Modifier
                .size(109.29.dp, 132.65.dp)
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
                BackArrowBox(
                    onClick = { navController.popBackStack() }
                )
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
                            navController.navigate(route = "profileEditScreen")
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
                    //.height(877.dp)
                    .fillMaxWidth()
            ){
                Column(
                    modifier = Modifier
                        .padding(top = 90.dp)
                ){
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            //.height(780.dp)
                            .clip(RoundedCornerShape(16.dp))
                            .drawBehind {
                                drawRoundRect(
                                    color = Color.Black.copy(alpha = 0.14f),
                                    size = size,
                                    topLeft = Offset(x = 5.dp.toPx(), y = 6.dp.toPx()),
                                    cornerRadius = CornerRadius(16.dp.toPx())
                                )
                            }
                            .background(color = Color.White)
                            .padding(horizontal = 20.dp),
                    ) {
                        Column(
                            modifier = Modifier
                                .padding(top = 110.dp, bottom = 10.dp)
                        ){
                            Text(
                                text = "Vinay Kumar",
                                style = MaterialTheme.typography.labelLarge.copy(
                                    lineHeight = 30.sp,
                                    color = Color(0xFF129193)
                                ),
                                modifier = Modifier
                                    .fillMaxWidth(),
                                textAlign = TextAlign.Center
                            )
                            Text(
                                text = "Nursery - A",
                                style = MaterialTheme.typography.titleSmall.copy(
                                    fontWeight = FontWeight(600),
                                    color = Color(0xFF1D1751)
                                ),
                                modifier = Modifier
                                    .fillMaxWidth(),
                                textAlign = TextAlign.Center
                            )
                        }

                        HorizontalDivider(
                            thickness = 0.5.dp,
                            color = Color.Black.copy(alpha = 0.3f)
                        )
                        Column(
                            modifier = Modifier
                                .padding(vertical = 20.dp, horizontal = 10.dp),
                            verticalArrangement = Arrangement.spacedBy(10.dp)
                        ){

                            Text(
                                text = "Personal Details",
                                style = TextStyle(
                                    fontFamily = nunitoFont,
                                    fontWeight = FontWeight(600),
                                    fontSize = 22.sp,
                                    lineHeight = 30.01.sp
                                )
                            )
                            LabelAndDetails(
                                label = "First Name",
                                details = "Vinay"
                            )
                            LabelAndDetails(
                                label = "Last Name",
                                details = "Kumar"
                            )
                            LabelAndDetails(
                                label = "Gender",
                                details = "Male"
                            )
                            LabelAndDetails(
                                label = "Phone Number",
                                details = "+91 0987654321"
                            )
                        }
                        HorizontalDivider(
                            thickness = 0.5.dp,
                            color = Color.Black.copy(alpha = 0.3f)
                        )
                        Column(
                            modifier = Modifier
                                .padding(vertical = 20.dp, horizontal = 10.dp),
                            verticalArrangement = Arrangement.spacedBy(10.dp)
                        ){

                            Text(
                                text = "School Details",
                                style = TextStyle(
                                    fontFamily = nunitoFont,
                                    fontWeight = FontWeight(600),
                                    fontSize = 22.sp,
                                    lineHeight = 30.01.sp
                                )
                            )
                            LabelAndDetails(
                                label = "School Code",
                                details = "1313"
                            )
                            LabelAndDetails(
                                label = "Roll No",
                                details = "001"
                            )
                            LabelAndDetails(
                                label = "School Name",
                                details = "Exela pvt.school "
                            )

                        }
                    }
                }
                ProfileIconEdit(
                    modifier = Modifier.align(Alignment.TopCenter),
                    onClick = {
                        photoUploadedDialog.value = true
                    }
                )
            }

            Spacer(modifier = Modifier.height(60.dp))

            if (photoUploadedDialog.value){
                Dialog(
                    onDismissRequest = { photoUploadedDialog.value = false },
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                    ){
                        Box(
                            modifier = Modifier
                                .size(44.dp)
                                .clip(CircleShape)
                                .background(color = Color.Black.copy(alpha = 0.7f))
                                .clickable {
                                    photoUploadedDialog.value = false
                                },
                            contentAlignment = Alignment.Center
                        ) {
                            Icon(
                                painter = painterResource(R.drawable.close),
                                contentDescription = "close",
                                tint = Color.White,
                                modifier = Modifier
                                    .size(20.47.dp)
                            )
                        }
                        Spacer(modifier = Modifier.height(10.dp))
                        Box(
                            modifier = Modifier
                                .size(386.dp, 621.dp)
                                .background(
                                    color = Color.White,
                                    shape = RoundedCornerShape(20.dp)
                                )
                                .clip(RoundedCornerShape(20.dp))
                        ) {
                            Column(
                                modifier = Modifier
                                    .fillMaxSize()
                                    .padding(20.dp),
                                horizontalAlignment = Alignment.CenterHorizontally,
                                verticalArrangement = Arrangement.SpaceBetween
                            ) {
                                DashedUploadMediaBox()
                                Text(
                                    text = "Uploaded Photo",
                                    style = MaterialTheme.typography.titleMedium.copy(
                                        fontWeight = FontWeight(600),
                                        fontSize = 19.45.sp,
                                        lineHeight = 14.59.sp,
                                        letterSpacing = 0.18.sp,
                                        color = Color(0xFF1D1751)
                                    ),
                                    modifier = Modifier.fillMaxWidth(),
                                    textAlign = TextAlign.Start
                                )
                                Image(
                                    painter = painterResource(R.drawable.profile_boy),
                                    contentDescription = "profile",
                                    modifier = Modifier
                                        .size(159.dp)
                                        .clip(CircleShape)
                                )
                                CommonButton(
                                    modifier = Modifier
                                        .size(286.dp, 47.14.dp),
                                    text = "Save",
                                    textColor = Color.White,
                                    textStyle = MaterialTheme.typography.labelLarge.copy(
                                        fontSize = 23.57.sp
                                    ),
                                    outerBoxColor = Color(0xFF068183),
                                    outerShadowColor = Color(0xFF036465),
                                    innerBoxColor = Color(0xFF129193),
                                    innerShadowColor = Color(0xFF036465),
                                    curvedBoxColor = Color(0xFF068183),
                                    ovalColor = Color.White,
                                    onClick = {

                                    }
                                )
                            }
                        }
                    }
                }
            }

        }
    }
}

@Composable
fun LabelAndDetails(
    label: String ,
    details: String
) {
    Column {
        Text(
            text = label,
            style = MaterialTheme.typography.bodyLarge.copy(
                fontSize = 14.sp,
                lineHeight = 19.1.sp,
                color = Color(0xFF129193)
            )
        )
        Text(
            text = details,
            style = MaterialTheme.typography.bodyLarge.copy(
                fontSize = 20.sp,
                lineHeight = 27.28.sp,
            )
        )
    }
}

@Composable
private fun ProfileIconEdit(
    modifier: Modifier = Modifier,
    onClick: () -> Unit = { }
) {
    Box(
        modifier = modifier
            .size(194.31.dp)
            .drawBehind {
                drawCircle(
                    color = Color(0xFF64646F).copy(alpha = 0.1f),
                    radius = size.width / 2,
                    center = Offset(center.x, center.y + 4.47.dp.toPx())
                )
            }
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
                    onClick()
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