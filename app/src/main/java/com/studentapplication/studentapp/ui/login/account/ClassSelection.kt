package com.studentapplication.studentapp.ui.login.account


import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
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
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
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
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.window.Dialog
import androidx.navigation.NavHostController
import com.studentapplication.studentapp.R
import com.studentapplication.studentapp.ui.utills.BackArrowBox
import com.studentapplication.studentapp.ui.utills.CommonButton
import com.studentapplication.studentapp.ui.utills.exelaGradient
import kotlinx.coroutines.delay

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun ClassSelection(navController: NavHostController) {

    val scrollState = rememberScrollState()
    val classesList = listOf("Nursery" to R.drawable.nursery_cat,
        "Junior KG" to R.drawable.junior_kg_dog,
        "Senior KG" to R.drawable.senior_kg_parrot
    )
    val selectedClass = remember { mutableStateOf("") }
    val selectedSection = remember { mutableStateOf("") }
    val allDoneDialog = remember { mutableStateOf(false) }

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
                verticalAlignment = Alignment.CenterVertically
            ) {
                BackArrowBox(
                    onClick = { navController.popBackStack() }
                )
                Text(
                    text = "Select your Class",
                    style = MaterialTheme.typography.labelLarge.copy(
                        fontSize = 25.sp,
                        lineHeight = 25.sp,
                        brush = exelaGradient
                    ),
                    modifier = Modifier
                        .fillMaxWidth(),
                    textAlign = TextAlign.Center
                )
            }
            Spacer(modifier = Modifier.height(5.dp))
            Text(
                text = "Choose your class to start learning.",
                style = MaterialTheme.typography.labelMedium,
                color = Color(0xFF333333),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp),
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(30.dp))
            SchoolDetailsBox()
            Spacer(modifier = Modifier.height(30.dp))

            classesList.forEachIndexed { index, item ->
                ClassSelectionCard(
                    title = item.first,
                    image = item.second,
                    isCardSelected = selectedClass.value == item.first,
                    onSwitchClick = {
                        if (selectedClass.value == item.first){
                            selectedClass.value = ""
                            selectedSection.value = ""
                        }else{
                            selectedClass.value = item.first
                            selectedSection.value = ""
                        }
                    },
                )
                Spacer(modifier = Modifier.height(20.dp))
                if (selectedClass.value == item.first) {
                    FlowRow(
                        horizontalArrangement = Arrangement.spacedBy(20.dp),
                        verticalArrangement = Arrangement.spacedBy(20.dp)
                    ) {
                        val sections =
                            listOf("Section - A", "Section - B", "Section - C", "Section - D", "Section - E")
                        sections.forEach { section ->
                            val isSelected = selectedSection.value == section
                            SectionSelectionBox(
                                section = section,
                                sectionSelected = isSelected,
                                onSectionSelected = {
                                    selectedSection.value = it
                                })
                        }
                    }
                    Spacer(modifier = Modifier.height(20.dp))
                }
            }
        }
        Column(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 50.dp)
        ){
            CommonButton(
                text = "Save & Proceed",
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
                enabled = selectedSection.value.isNotEmpty(),
                onClick = {
                    allDoneDialog.value = true
                },
                //modifier = Modifier.align(Alignment.CenterHorizontally)
            )
        }
        if (allDoneDialog.value){
            AllDoneDialogBox{ allDoneDialog.value = false }
            LaunchedEffect(Unit) {
                delay(3000)
                navController.navigate(route = "dashboard")
            }
        }
    }
}

@Composable
private fun AllDoneDialogBox(onClick: ()-> Unit = { }) {
    Dialog(
        onDismissRequest = onClick
    ) {
        Box(
            modifier = Modifier
                .height(495.26.dp)
                .width(375.dp)
        ) {
            Box(
                modifier = Modifier
                    .height(161.81.dp)
                    .width(290.82.dp)
                    .drawBehind {
                        drawRoundRect(
                            color = Color(0xFF129193),
                            topLeft = Offset(x = 0.dp.toPx(), y = 4.37.dp.toPx()),
                            size = Size(size.width, size.height),
                            cornerRadius = CornerRadius(32.8.dp.toPx())
                        )
                    }
                    .background(
                        color = Color(0xFFFFF5D1),
                        shape = RoundedCornerShape(32.8.dp)
                    )
                    .align(Alignment.Center),
                contentAlignment = Alignment.BottomCenter
            ) {
                Text(
                    text = "You’re all set and ready to start",
                    style = MaterialTheme.typography.labelMedium.copy(
                        lineHeight = 19.23.sp
                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 30.dp),
                    textAlign = TextAlign.Center
                )
            }
            Image(
                painter = painterResource(R.drawable.all_done),
                contentDescription = "all done",
                modifier = Modifier
                    .height(191.09.dp)
                    .fillMaxWidth()
                    .align(Alignment.TopCenter)
                    .offset(y = 35.dp)
            )

            Box(
                modifier = Modifier
                    .rotate(-10f)
                    .align(Alignment.CenterStart)
                    .offset(x = (10).dp, y = (-40).dp)
            ) {
                Box(
                    modifier = Modifier
                        .height(83.71.dp)
                        .width(60.3.dp)
                        .drawBehind {
                            drawRoundRect(
                                color = Color(0xFF156029),
                                topLeft = Offset(x = 0.dp.toPx(), y = 5.67.dp.toPx()),
                                cornerRadius = CornerRadius(14.18.dp.toPx()),
                                size = Size(size.width, size.height)
                            )
                        }
                        .background(
                            color = Color(0xFF25A455),
                            shape = RoundedCornerShape(14.18.dp)
                        )
                )
            }
            Box(
                modifier = Modifier
                    .rotate(10f)
                    .align(Alignment.CenterEnd)
                    .offset(x = (-10).dp, y = (-40).dp)
            ) {
                Box(
                    modifier = Modifier
                        .height(83.71.dp)
                        .width(60.3.dp)
                        .drawBehind {
                            drawRoundRect(
                                color = Color(0xFF156029),
                                topLeft = Offset(x = 0.dp.toPx(), y = 5.67.dp.toPx()),
                                cornerRadius = CornerRadius(14.18.dp.toPx()),
                                size = Size(size.width, size.height)
                            )
                        }
                        .background(
                            color = Color(0xFF25A455),
                            shape = RoundedCornerShape(14.18.dp)
                        )
                        .align(Alignment.CenterStart)
                )
            }
            Box(
                modifier = Modifier
                    .align(Alignment.Center)
                    .offset(y = (-60).dp)
            ) {
                Box(
                    modifier = Modifier
                        .height(105.31.dp)
                        .width(278.77.dp)
                        .drawBehind {
                            drawRoundRect(
                                color = Color(0xFF156029),
                                topLeft = Offset(x = 0.dp.toPx(), y = 5.67.dp.toPx()),
                                cornerRadius = CornerRadius(28.37.dp.toPx()),
                                size = Size(size.width, size.height)
                            )
                        }
                        .background(
                            color = Color(0xFF2D9549),
                            shape = RoundedCornerShape(28.37.dp)
                        )
                        .clip(CustomCurvedShape),
                    contentAlignment = Alignment.Center
                ) {

                    Text(
                        text = "All Done",
                        style = MaterialTheme.typography.labelLarge.copy(
                            fontSize = 32.05.sp,
                            lineHeight = 32.05.sp,
                            letterSpacing = 0.02.sp,
                            color = Color.White
                        )
                    )
                }
            }


        }

        // SuccessDialogBox()
    }
}

@Composable
fun ClassSelectionCard(
    title: String,
    image: Int,
    isCardSelected: Boolean,
    onSwitchClick: () -> Unit,
) {

    Card(
        modifier = Modifier
            .height(70.dp)
            .width(377.dp),
        shape = RoundedCornerShape(15.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFFF5F5F5)
        )
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 15.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                Box(
                    modifier = Modifier
                        .size(54.dp)
                        .clip(RoundedCornerShape(10.dp))
                        .background(Color.White),
                    contentAlignment = Alignment.Center
                ) {
                    Image(
                        painter = painterResource(image),
                        contentDescription = "cat",
                        modifier = Modifier.size(47.dp)
                    )
                }
                Column() {
                    Text(
                        text = title,
                        style = MaterialTheme.typography.bodyLarge.copy(
                            fontSize = 18.sp,
                            lineHeight = 23.4.sp,
                            color = Color(0xFF1D1751)
                        )
                    )
                    Text(
                        text = "5 Sections",
                        style = MaterialTheme.typography.labelSmall.copy(
                            fontWeight = FontWeight(400),
                            lineHeight = 18.2.sp,
                            color = Color(0xFF5A5A5A)
                        )
                    )
                }
            }

            Switch(
                checked = isCardSelected,
                onCheckedChange = {
                    onSwitchClick()
                },
                modifier = Modifier
                    .height(26.dp)
                    .width(43.dp)
                    .padding(end = 10.dp),
                colors = SwitchDefaults.colors(
                    checkedThumbColor = Color.White,
                    uncheckedThumbColor = Color.White,
                    checkedTrackColor = Color(0xFF1D1751),
                    uncheckedTrackColor = Color(0xFFC4C4C4),
                    uncheckedBorderColor = Color(0xFFC4C4C4),
                )
            )
        }
    }

//    if (isCardSelected) {
//        Spacer(modifier = Modifier.height(20.dp))
//        FlowRow(
//            horizontalArrangement = Arrangement.spacedBy(20.dp),
//            verticalArrangement = Arrangement.spacedBy(20.dp)
//        ) {
//            val sections =
//                listOf("Section - A", "Section - B", "Section - C", "Section - D", "Section - E")
//            sections.forEach { section ->
//                val isSelected = selectedSection == section
//                SectionSelectionBox(
//                    section = section,
//                    sectionSelected = isSelected,
//                    onSectionSelected = {
//                        //selectedSection.value = it
//                    })
//            }
//        }
//    }
}

@Composable
fun SectionSelectionBox(
    section: String,
    sectionSelected: Boolean,
    onSectionSelected: (String) -> Unit) {

    Box(
        modifier = Modifier
            .height(60.dp)
            .width(110.dp)
            .border(
                width = 1.dp,
                color = Color(0xFF1D1751),
                shape = RoundedCornerShape(12.dp)
            )
            .drawBehind {
                drawRoundRect(
                    color = Color(0xFF1D1751),
                    topLeft = Offset(x = 0.dp.toPx(), y = 3.03.dp.toPx()),
                    size = Size(size.width, size.height),
                    cornerRadius = CornerRadius(12.dp.toPx())
                )
            }
            .background(
                color = if (sectionSelected) Color(0xFF362D86) else Color.White,
                shape = RoundedCornerShape(12.dp)
            )
            .clickable {
                onSectionSelected(section)
            },
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = section,
            style = MaterialTheme.typography.labelMedium.copy(
                lineHeight = 20.8.sp,
                color = if (sectionSelected) Color.White else Color(0xFF1D1751)
            )
        )
    }
}

@Composable
private fun SchoolDetailsBox() {
    Box(
        modifier = Modifier
            .height(100.dp)
            .fillMaxWidth()
            .drawBehind {
                drawRoundRect(
                    color = Color(0xFFFFBB88),
                    topLeft = Offset(x = 2.dp.toPx(), y = 4.dp.toPx()),
                    size = Size(size.width, size.height),
                    cornerRadius = CornerRadius(10.dp.toPx())
                )
            }
            .background(
                color = Color(0xFFFEEFE4),
                shape = RoundedCornerShape(10.dp)
            )
            .padding(17.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column(
                modifier = Modifier.fillMaxHeight(),
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "Exela pvt.school",
                    style = MaterialTheme.typography.bodyLarge.copy(
                        fontSize = 18.sp,
                        lineHeight = 24.55.sp,
                        color = Color(0xFF1D1751)
                    )
                )
                Text(
                    text = "School Code : 1313",
                    style = MaterialTheme.typography.labelSmall
                )
            }
            Image(
                painter = painterResource(R.drawable.school),
                contentDescription = "school",
                modifier = Modifier
                    .size(75.dp)
                    .clip(CircleShape)
            )
        }
    }
}

@Preview
@Composable
fun SuccessDialogBox(){
//    Column(
//        modifier = Modifier
//            .fillMaxSize(),
//        horizontalAlignment = Alignment.CenterHorizontally,
//    ){
        Box(
            modifier = Modifier
                .height(495.26.dp)
                .width(375.dp),
            contentAlignment = Alignment.Center
        ){
            Box(
                modifier = Modifier
                    .height(161.81.dp)
                    .width(290.82.dp)
                    .drawBehind {
                        drawRoundRect(
                            color = Color(0xFF129193),
                            topLeft = Offset(x = 0.dp.toPx(), y = 4.37.dp.toPx()),
                            size = Size(size.width, size.height),
                            cornerRadius = CornerRadius(32.8.dp.toPx())
                        )
                    }
                    .background(
                        color = Color(0xFFFFF5D1),
                        shape = RoundedCornerShape(32.8.dp)
                    ),
                contentAlignment = Alignment.BottomCenter
            ){
                Text(
                    text = "You’re all set and ready to start",
                    style = MaterialTheme.typography.labelMedium.copy(
                        lineHeight = 19.23.sp
                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 30.dp),
                    textAlign = TextAlign.Center
                )
            }

            Box(
                modifier = Modifier
                    .height(191.09.dp)
                    .width(374.85.dp)

            ){
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                ){
                    Box(
                        modifier = Modifier
                            .rotate(-28f)
                            .offset(x = 10.dp, y = 0.dp)
                    ) {
                        Box(
                            modifier = Modifier
                                .height(91.87.dp)
                                .width(44.07.dp)
                                .clip(TaperedShape)
                                .background(
                                    brush = Brush.linearGradient(
                                        colors = listOf(
                                            Color(0xFFFFDF6E).copy(alpha = 0.5f),
                                            Color(0xFF2CFA7A)
                                        )
                                    ),
                                    shape = TaperedShape
                                )
                        )
                    }
                    Box(
                        modifier = Modifier
                            .rotate(-17f)
                            .offset(x = 20.dp, y = (-60).dp)
                    ) {
                        Box(
                            modifier = Modifier
                                .height(128.61.dp)
                                .width(61.7.dp)
                                .clip(TaperedShape)
                                .background(
                                    brush = Brush.linearGradient(
                                        colors = listOf(
                                            Color(0xFFFFDF6E).copy(alpha = 0.5f),
                                            Color(0xFF2CFA7A)
                                        )
                                    ),
                                    shape = TaperedShape
                                )
                        )
                    }
                    Box(
                        modifier = Modifier
                            .rotate(-7f)
                            .offset(x = 15.dp, y = (-100).dp)
                    ) {
                        Box(
                            modifier = Modifier
                                .height(149.84.dp)
                                .width(71.84.dp)
                                .clip(TaperedShape)
                                .background(
                                    brush = Brush.linearGradient(
                                        colors = listOf(
                                            Color(0xFFFFDF6E).copy(alpha = 0.5f),
                                            Color(0xFF2CFA7A)
                                        )
                                    ),
                                    shape = TaperedShape
                                )
                        )
                    }
                    Box(
                        modifier = Modifier
                            .rotate(7f)
                            .offset(x = (-1).dp, y = (-100).dp)
                    ) {
                        Box(
                            modifier = Modifier
                                .height(149.84.dp)
                                .width(71.84.dp)
                                .clip(TaperedShape)
                                .background(
                                    brush = Brush.linearGradient(
                                        colors = listOf(
                                            Color(0xFFFFDF6E).copy(alpha = 0.5f),
                                            Color(0xFF2CFA7A)
                                        )
                                    ),
                                    shape = TaperedShape
                                )
                        )
                    }
                    Box(
                        modifier = Modifier
                            .rotate(16.25f)
                            .offset(x = (-10).dp, y = (-65).dp)
                    ) {
                        Box(
                            modifier = Modifier
                                .height(128.61.dp)
                                .width(61.7.dp)
                                .clip(TaperedShape)
                                .background(
                                    brush = Brush.linearGradient(
                                        colors = listOf(
                                            Color(0xFFFFDF6E).copy(alpha = 0.5f),
                                            Color(0xFF2CFA7A)
                                        )
                                    ),
                                    shape = TaperedShape
                                )
                        )
                    }
                    Box(
                        modifier = Modifier
                            .rotate(26.79f)
                            .offset(x = 0.dp, y = (-10).dp)
                    ) {
                        Box(
                            modifier = Modifier
                                .height(91.87.dp)
                                .width(44.07.dp)
                                .clip(TaperedShape)
                                .background(
                                    brush = Brush.linearGradient(
                                        colors = listOf(
                                            Color(0xFFFFDF6E).copy(alpha = 0.5f),
                                            Color(0xFF2CFA7A)
                                        )
                                    ),
                                    shape = TaperedShape
                                )
                        )
                    }
                }
            }

            Box(
                modifier = Modifier
                    .rotate(-10f)
                    .offset(x = (-120).dp, y = (-60).dp)
            ) {
                Box(
                    modifier = Modifier
                        .height(83.71.dp)
                        .width(60.3.dp)
                        .drawBehind {
                            drawRoundRect(
                                color = Color(0xFF156029),
                                topLeft = Offset(x = 0.dp.toPx(), y = 5.67.dp.toPx()),
                                cornerRadius = CornerRadius(14.18.dp.toPx()),
                                size = Size(size.width, size.height)
                            )
                        }
                        .background(
                            color = Color(0xFF25A455),
                            shape = RoundedCornerShape(14.18.dp)
                        )
                        .align(Alignment.CenterStart)
                )
            }
            Box(
                modifier = Modifier
                    .rotate(10f)
                    .offset(x = 120.dp, y = (-60).dp)
            ) {
                Box(
                    modifier = Modifier
                        .height(83.71.dp)
                        .width(60.3.dp)
                        .drawBehind {
                            drawRoundRect(
                                color = Color(0xFF156029),
                                topLeft = Offset(x = 0.dp.toPx(), y = 5.67.dp.toPx()),
                                cornerRadius = CornerRadius(14.18.dp.toPx()),
                                size = Size(size.width, size.height)
                            )
                        }
                        .background(
                            color = Color(0xFF25A455),
                            shape = RoundedCornerShape(14.18.dp)
                        )
                        .align(Alignment.CenterStart)
                )
            }
            Box(
                modifier = Modifier.offset(y = -60.dp)
            ) {
                Box(
                    modifier = Modifier
                        .height(105.31.dp)
                        .width(278.77.dp)
                        .drawBehind {
                            drawRoundRect(
                                color = Color(0xFF156029),
                                topLeft = Offset(x = 0.dp.toPx(), y = 5.67.dp.toPx()),
                                cornerRadius = CornerRadius(28.37.dp.toPx()),
                                size = Size(size.width, size.height)
                            )
                        }
                        .background(
                            color = Color(0xFF2D9549),
                            shape = RoundedCornerShape(28.37.dp)
                        )
                        .clip(CustomCurvedShape),
                    contentAlignment = Alignment.Center
                ) {

                    Text(
                        text = "All Done",
                        style = MaterialTheme.typography.labelLarge.copy(
                            fontSize = 32.05.sp,
                            lineHeight = 32.05.sp,
                            letterSpacing = 0.02.sp,
                            color = Color.White
                        )
                    )
                }
            }



        }
    //}
}

val TaperedShape = object : Shape {
    override fun createOutline(
        size: Size,
        layoutDirection: LayoutDirection,
        density: Density
    ): Outline {
        val path = Path().apply {
            moveTo(0f, 0f) // Top-left, slightly inset
            lineTo(size.width, 0f) // Top-right, slightly inset
            lineTo(size.width * 0.8f, size.height) // Bottom-right corner
            lineTo(size.width * 0.2f, size.height) // Bottom-left corner
            close() // Close the path
        }
        return Outline.Generic(path)
    }
}

val CustomCurvedShape = object: Shape {
    override fun createOutline(
        size: Size,
        layoutDirection: LayoutDirection,
        density: Density
    ): Outline {
        val path = Path().apply {
            moveTo(0f, 0f) // Top-left corner
            lineTo(0f, size.height - 40f) // Left edge
            quadraticBezierTo(
                size.width / 2, size.height + 40f, // Control point for the curve
                size.width, size.height - 40f // End point
            )
            lineTo(size.width, 0f) // Right edge
            close() // Close the path
        }
        return Outline.Generic(path)
    }
}