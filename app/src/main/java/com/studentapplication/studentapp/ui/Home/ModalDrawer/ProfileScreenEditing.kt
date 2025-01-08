package com.studentapplication.studentapp.ui.Home.ModalDrawer

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.studentapplication.studentapp.R
import com.studentapplication.studentapp.ui.theme.nunitoFont
import com.studentapplication.studentapp.ui.utills.BackArrowBox
import com.studentapplication.studentapp.ui.utills.CommonButton
import com.studentapplication.studentapp.ui.utills.exelaGradient

@Composable
fun ProfileScreenEditing(navController: NavHostController) {

    val scrollState = rememberScrollState()
    val firstName = remember { mutableStateOf("Vinay") }
    val lastName = remember { mutableStateOf("Kumar") }
    val genderChecked = remember { mutableStateOf(false) }
    val genderValue = if (genderChecked.value) "Female" else "Male"
    val phoneNumber = remember { mutableStateOf("+91 0987654321") }
    val schoolCode = remember { mutableStateOf("1313") }
    val rollNo = remember { mutableStateOf("001") }
    val schoolName = remember { mutableStateOf("Exela Pvt.School") }

    Box(
        modifier = Modifier
            .fillMaxSize()
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
                                .padding(vertical = 20.dp),
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
                            LabelAndField(
                                labelName = "First Name",
                                value = firstName.value,
                                onValueChange = { firstName.value = it}
                            )
                            LabelAndField(
                                labelName = "Last Name",
                                value = lastName.value,
                                onValueChange = { lastName.value = it}
                            )
                            Column {
                                Text(
                                    text = "Gender",
                                    style = MaterialTheme.typography.bodyLarge.copy(
                                        fontSize = 14.sp,
                                        lineHeight = 19.1.sp,
                                        color = Color(0xFF129193)
                                    )
                                )
                                Spacer(modifier = Modifier.height(5.dp))
                                EditProfileGenderField(
                                    genderValue = genderValue,
                                    genderChecked = genderChecked
                                )
                            }
                            LabelAndField(
                                labelName = "Phone Number",
                                value = phoneNumber.value,
                                onValueChange = { phoneNumber.value = it}
                            )
                        }
                        HorizontalDivider(
                            thickness = 0.5.dp,
                            color = Color.Black.copy(alpha = 0.3f)
                        )
                        Column(
                            modifier = Modifier
                                .padding(vertical = 20.dp),
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
                            LabelAndField(
                                labelName = "School Code",
                                value = schoolCode.value,
                                onValueChange = { schoolCode.value = it}
                            )
                            LabelAndField(
                                labelName = "Roll - No",
                                value = rollNo.value,
                                onValueChange = { rollNo.value = it}
                            )
                            LabelAndField(
                                labelName = "School Name",
                                value = schoolName.value,
                                onValueChange = { schoolName.value = it}
                            )

                        }
                        CommonButton(
                            modifier = Modifier
                                .size(286.dp, 47.14.dp)
                                .align(Alignment.CenterHorizontally),
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
                                navController.popBackStack()
                            }
                        )
                        Spacer(modifier = Modifier.height(20.dp))
                    }
                }
                Box(
                    modifier = Modifier
                        .size(194.31.dp)
                        .clip(CircleShape)
                        .align(Alignment.TopCenter)
                        .drawBehind {
                            drawCircle(
                                color = Color.Black.copy(alpha = 0.5f),
                                radius = size.width / 2,
                                center = Offset(center.x, center.y + 7.45.dp.toPx())
                            )
                        }
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
            }

            Spacer(modifier = Modifier.height(60.dp))


        }
    }
}

@Composable
fun LabelAndField(
    labelName: String,
    value: String,
    onValueChange: (String) -> Unit = { }
){
    Column {
        Text(
            text = labelName,
            style = MaterialTheme.typography.bodyLarge.copy(
                fontSize = 14.sp,
                lineHeight = 19.1.sp,
                color = Color(0xFF129193)
            )
        )
        Spacer(modifier = Modifier.height(5.dp))
        OutlinedTextField(
            value = value,
            onValueChange = onValueChange,
            modifier = Modifier
                .height(52.dp)
                .fillMaxWidth()
                .clip(RoundedCornerShape(6.dp))
                .border(
                    width = 1.5.dp,
                    brush = exelaGradient,
                    shape = RoundedCornerShape(6.dp)
                ),
            textStyle = MaterialTheme.typography.labelMedium.copy(
                color = Color(0xFF1D1751)
            )
        )
    }
}

@Composable
fun EditProfileGenderField(
    genderValue: String,
    genderChecked: MutableState<Boolean>
) {
    OutlinedTextField(
        value = genderValue,
        onValueChange = { },
        modifier = Modifier
            .height(52.dp)
            .fillMaxWidth()
            .clip(RoundedCornerShape(6.dp))
            .border(
                width = 1.5.dp,
                brush = exelaGradient,
                shape = RoundedCornerShape(6.dp)
            ),
        readOnly = true,
        trailingIcon = {
            Row(
                modifier = Modifier
                    .padding(end = 20.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(20.dp)
            ) {
                Icon(
                    painter = painterResource(R.drawable.male),
                    contentDescription = "male",
                    tint = if (genderChecked.value) Color.Black.copy(alpha = 0.3f) else Color(
                        0xFF4DB4F8
                    ),
                    modifier = Modifier
                        .size(18.86.dp)
                )
                Switch(
                    checked = genderChecked.value,
                    onCheckedChange = {
                        genderChecked.value = !genderChecked.value
                    },
                    modifier = Modifier
                        .height(12.86.dp)
                        .width(39.43.dp),
                    colors = SwitchDefaults.colors(
                        checkedThumbColor = Color.White,
                        uncheckedThumbColor = Color.White,
                        checkedTrackColor = Color(0xFFFF499C),
                        uncheckedTrackColor = Color(0xFF4DB4F8),
                        uncheckedBorderColor = Color(0xFF4DB4F8),
                    )
                )
                Icon(
                    painter = painterResource(R.drawable.female),
                    contentDescription = "female",
                    tint = if (genderChecked.value) Color(0xFFFF499C) else Color.Black.copy(alpha = 0.3f),
                    modifier = Modifier
                        .size(18.86.dp)
                )
            }
        },
        textStyle = MaterialTheme.typography.labelMedium.copy(
            fontWeight = FontWeight(700),
            color = Color(0xFF1D1751)
        ),
        colors = TextFieldDefaults.colors(
            focusedContainerColor = Color.White,
            unfocusedContainerColor = Color.White,
        )
    )
}