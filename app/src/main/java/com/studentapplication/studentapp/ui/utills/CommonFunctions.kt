package com.studentapplication.studentapp.ui.utills

import androidx.compose.foundation.Canvas
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.studentapplication.studentapp.R

@Composable
fun CommonButton(
    modifier: Modifier = Modifier,
    text: String,
    textColor: Color,
    textStyle: TextStyle = MaterialTheme.typography.labelLarge,
    outerBoxColor: Color,
    outerShadowColor: Color,
    innerBoxColor: Color,
    innerShadowColor: Color,
    curvedBoxColor: Color,
    ovalColor: Color,
    enabled: Boolean = true,
    onClick: () -> Unit = { },
) {
    val adjustedOuterBoxColor = if (enabled) outerBoxColor else Color(0xFF6AB3B5)
    val adjustedInnerBoxColor = if (enabled) innerBoxColor else Color(0xFF71BDBE)
    val adjustedOuterShadowColor = if (enabled) outerShadowColor else Color(0xFF68A2A3)
    val adjustedInnerShadowColor = if (enabled) innerShadowColor else Color(0xFF68A2A3)
    val adjustedCurvedBoxColor = if (enabled) curvedBoxColor else Color(0xFF6AB3B5)


    Box(
        modifier = modifier
            .height(60.dp)
            .width(343.dp)
            .drawBehind {
                val shadowOffsetY = 4.dp.toPx()
                drawRoundRect(
                    color = adjustedOuterShadowColor,
                    topLeft = Offset(x = 0f, y = shadowOffsetY),
                    size = Size(size.width, size.height),
                    cornerRadius = CornerRadius(20.dp.toPx())
                )
            }
            .background(color = adjustedOuterBoxColor, shape = RoundedCornerShape(20.dp))
            .padding(horizontal = 5.dp, vertical = 3.dp)
            .clickable {
                if (enabled) {
                    onClick()
                }
            }
    ) {
        Box(
            modifier = modifier
                .height(50.dp)
                .width(333.dp)
                .drawBehind {
                    val shadowOffsetY = 4.dp.toPx()
                    drawRoundRect(
                        color = adjustedInnerShadowColor,
                        topLeft = Offset(x = 0f, y = shadowOffsetY),
                        size = Size(size.width, size.height),
                        cornerRadius = CornerRadius(20.dp.toPx())
                    )
                }
                .background(
                    color = adjustedInnerBoxColor,
                    shape = RoundedCornerShape(20.dp)
                )
                .padding(horizontal = 5.dp, vertical = 2.dp),
            contentAlignment = Alignment.Center
        ) {
            Box(
                modifier = Modifier
                    .height(22.dp)
                    .width(313.dp)
                    .background(
                        color = Color.Transparent,
                    )
                    .clip(RoundedCornerShape(20.dp))
                    .align(Alignment.TopStart)
            ) {
                Canvas(
                    modifier = Modifier
                        .fillMaxSize()
                        .align(Alignment.BottomCenter)
                ) {
                    val width = size.width
                    val height = size.height

                    val curveWidth = width / 2
                    val curveHeight = 10.dp.toPx()

                    val path = Path().apply {
                        moveTo(0f, 0f)
                        lineTo(0f, height)

                        lineTo((width / 2) - curveWidth, height)

                        quadraticBezierTo(
                            width / 2,
                            height - curveHeight,
                            (width / 2) + curveWidth, height
                        )

                        lineTo(width, height)
                        lineTo(width, 0f)

                        close()
                    }

                    drawPath(
                        path = path,
                        color = adjustedCurvedBoxColor
                    )
                }
                Box(
                    modifier = Modifier
                        .height(10.72.dp)
                        .width(15.96.dp)
                        .offset(x = 0.dp, y = 2.dp)
                ) {
                    Canvas(
                        modifier = Modifier
                            .fillMaxSize()
                            .rotate(-40.29f)
                    ) {
                        drawOval(
                            color = ovalColor,
                            size = size
                        )
                    }
                }
            }
            Text(
                text = text,
                style = textStyle,
                color = textColor,
                modifier = Modifier
                    .fillMaxWidth()
                    .offset(y = (-3).dp),
                textAlign = TextAlign.Center,
            )
        }
    }
}


@Composable
fun BackArrowBox(
    modifier: Modifier = Modifier,
    boxColor: Color = Color(0xFF129193),
    shadowColor: Color = Color(0xFF056E70),
    iconColor: Color = Color.White,
    onClick: () -> Unit = { }) {
    Box(
        modifier = modifier
            .size(36.dp)
            .drawBehind {
                val shadowOffsetY = 3.03.dp.toPx()
                drawRoundRect(
                    color = shadowColor,
                    topLeft = Offset(x = 0f, y = shadowOffsetY),
                    size = Size(size.width, size.height),
                    cornerRadius = CornerRadius(12.dp.toPx())
                )
            }
            .background(
                color = boxColor,
                RoundedCornerShape(12.dp)
            )
            .clickable {
                onClick()
            },
        contentAlignment = Alignment.Center
    ) {
        Icon(
            painter = painterResource(R.drawable.left_arrow),
            contentDescription = "back",
            tint = iconColor,
            modifier = Modifier
                .height(15.75.dp)
                .width(8.76.dp)
        )
    }
}

@Composable
fun LoginScreenTextField(
    text: String,
    labelText: String = "",
    onValueChange: (String) -> Unit = { }
){
    OutlinedTextField(
        value = text,
        onValueChange = onValueChange,
        modifier = Modifier
            .height(52.dp)
            .fillMaxWidth()
            .clip(RoundedCornerShape(6.dp))
            .border(
                width = 2.dp,
                brush = exelaGradient,
                shape = RoundedCornerShape(6.dp)
            ),
        placeholder = {
            Text(
                text = labelText,
                style = MaterialTheme.typography.labelMedium,
                color = Color(0xFF9D9D9D),
            )
        },
        textStyle = MaterialTheme.typography.labelMedium.copy(
            color = Color(0xFF1D1751)
        )
    )
}

@Composable
fun PasswordField(
    password: String,
    labelText: String,
    onValueChange: (String) -> Unit = {}
){
    var isPasswordVisible by remember { mutableStateOf(false) }

    OutlinedTextField(
        value = password,
        onValueChange = onValueChange,
        modifier = Modifier
            .height(52.dp)
            .fillMaxWidth()
            .clip(RoundedCornerShape(6.dp))
            .border(
                width = 2.dp,
                brush = exelaGradient,
                shape = RoundedCornerShape(6.dp)
            ),
        placeholder = {
            Text(
                text = labelText,
                style = MaterialTheme.typography.labelMedium,
                color = Color(0xFF9D9D9D),
            )
        },
        textStyle = MaterialTheme.typography.labelMedium.copy(
            color = Color(0xFF1D1751)
        ),
        visualTransformation = if (isPasswordVisible) VisualTransformation.None else PasswordVisualTransformation(),
        trailingIcon = {
            Image(painter = painterResource(id = if (isPasswordVisible) R.drawable.eye_close else R.drawable.eye),
                contentDescription = "eye",
                modifier = Modifier
                    .height(14.dp)
                    .width(19.dp)
                    .clickable {
                        isPasswordVisible = !isPasswordVisible
                    }
            )
        }

    )
}

@Composable
fun GenderField(
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
                width = 2.dp,
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

@Composable
fun TopProgressBox(){
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp)
            .background(color = Color.White)
    ){
        Box(
            modifier = Modifier
                .height(10.dp)
                .fillMaxWidth()
                .align(Alignment.BottomCenter)
                .background(
                    color = Color(0xFFD9D9D9),
                )
        )
        Box(
            modifier = Modifier
                .size(169.dp, 10.dp)
                .clip(RoundedCornerShape(topEnd = 10.dp, bottomEnd = 10.dp))
                .background(
                    brush = Brush.linearGradient(
                        colors = listOf(Color(0xFFFFD7C7), Color(0xFFFF804D))
                    )
                )
                .align(Alignment.BottomStart)
        )
    }
}

@Composable
fun ChapterListButton(
    modifier: Modifier = Modifier,
    text: String = "",
    textColor: Color = Color.White,
    textStyle: TextStyle = MaterialTheme.typography.labelLarge,
    outerBoxColor: Color = Color(0xFFFF5B1A),
    outerShadowColor: Color = Color(0xFFFFA480),
    innerBoxColor: Color = Color(0xFFFF804D),
    innerShadowColor: Color = Color(0xFFFFA480),
    curvedBoxColor: Color = Color(0xFFFFA480),
    ovalColor: Color = Color.White,
    enabled: Boolean = true,
    onClick: () -> Unit = { },
) {

    Box(
        modifier = modifier
            .height(37.dp)
            .width(150.dp)
            .drawBehind {
                val shadowOffsetY = 2.04.dp.toPx()
                drawRoundRect(
                    color = outerShadowColor,
                    topLeft = Offset(x = 0f, y = shadowOffsetY),
                    size = Size(size.width, size.height),
                    cornerRadius = CornerRadius(10.02.dp.toPx())
                )
            }
            .background(color = outerBoxColor, shape = RoundedCornerShape(10.02.dp))
            .padding(start = 2.5.dp, top = 1.5.dp)
            .clickable {
                if (enabled) {
                    onClick()
                }
            }
    ) {
        Box(
            modifier = modifier
                .height(30.83.dp)
                .width(145.63.dp)
                .drawBehind {
                    val shadowOffsetY = 2.04.dp.toPx()
                    drawRoundRect(
                        color = innerShadowColor,
                        topLeft = Offset(x = 0f, y = shadowOffsetY),
                        size = Size(size.width, size.height),
                        cornerRadius = CornerRadius(10.02.dp.toPx())
                    )
                }
                .background(
                    color = innerBoxColor,
                    shape = RoundedCornerShape(10.02.dp)
                )
                .padding(start = 5.dp, top = 1.5.dp),
            contentAlignment = Alignment.Center
        ) {
            Box(
                modifier = modifier
                    .height(13.57.dp)
                    .width(136.88.dp)
                    .background(
                        color = Color.Transparent,
                    )
                    .clip(RoundedCornerShape(10.02.dp))
                    .align(Alignment.TopStart)
            ) {
                Canvas(
                    modifier = Modifier
                        .fillMaxSize()
                        .align(Alignment.BottomCenter)
                ) {
                    val width = size.width
                    val height = size.height

                    val curveWidth = width / 2
                    val curveHeight = 5.dp.toPx()

                    val path = Path().apply {
                        moveTo(0f, 0f)
                        lineTo(0f, height)

                        lineTo((width / 2) - curveWidth, height)

                        quadraticBezierTo(
                            width / 2,
                            height - curveHeight,
                            (width / 2) + curveWidth, height
                        )

                        lineTo(width, height)
                        lineTo(width, 0f)

                        close()
                    }

                    drawPath(
                        path = path,
                        color = curvedBoxColor
                    )
                }
                Box(
                    modifier = Modifier
                        .height(5.89.dp)
                        .width(8.3.dp)
                        .offset(x = 0.dp, y = 2.dp)
                ) {
                    Canvas(
                        modifier = Modifier
                            .fillMaxSize()
                            .rotate(-50.09f)
                    ) {
                        drawOval(
                            color = ovalColor,
                            size = size
                        )
                    }
                }
            }
            Text(
                text = text,
                style = textStyle.copy(
                    fontSize = 15.31.sp,
                    lineHeight = 22.16.sp
                ),
                color = textColor,
                modifier = Modifier
                    .fillMaxWidth()
                    .offset(y = (-2).dp),
                textAlign = TextAlign.Center,
            )
        }
    }
}

@Composable
fun DashedUploadMediaBox(modifier: Modifier = Modifier){
    Box(
        modifier = modifier
            .size(334.dp, 179.dp)
            .drawBehind {
                drawRoundRect(
                    brush = artGradient,
                    size = size,
                    style = Stroke(
                        width = 0.95.dp.toPx(),
                        pathEffect = PathEffect.dashPathEffect(intervals = floatArrayOf(5.dp.toPx(), 5.dp.toPx()), phase = 0f)
                    ),
                    cornerRadius = CornerRadius(18.9.dp.toPx())
                )
            },
        contentAlignment = Alignment.Center
    ){
        Column(
            modifier = Modifier.size(247.37.dp, 120.29.dp),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(5.dp)
            ){
                Image(
                    painter = painterResource(R.drawable.upload),
                    contentDescription = "upload",
                    modifier = Modifier
                        .size(22.68.dp)
                )
                Text(
                    text = "Upload media",
                    style = MaterialTheme.typography.bodyLarge.copy(
                        fontSize = 17.01.sp,
                        lineHeight = 11.34.sp,
                        color = Color(0xFFFF6020)
                    )
                )
            }
            Text(
                text = "Click on the button or Drag and Drop files here ",
                style = MaterialTheme.typography.titleMedium.copy(
                    fontSize = 11.34.sp,
                    lineHeight = 11.34.sp,
                    letterSpacing = 0.14.sp,
                    color = Color(0xFF129193)
                )
            )
            Box(
                modifier = Modifier
                    .size(247.37.dp, 44.29.dp)
                    .clip(RoundedCornerShape(8.dp))
                    .background(color = Color(0xFF129193))
                    .clickable {

                    },
                contentAlignment = Alignment.Center
            ){
                Text(
                    text = "Browse Files",
                    style = MaterialTheme.typography.bodyLarge.copy(
                        fontSize = 14.sp,
                        lineHeight = 10.03.sp,
                        color = Color.White
                    )
                )
            }
        }

    }
}
