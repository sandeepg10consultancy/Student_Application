package com.studentapplication.studentapp.ui.subject

import androidx.compose.foundation.Canvas
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
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.BottomSheetDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.studentapplication.studentapp.R
import com.studentapplication.studentapp.ui.theme.interFont
import com.studentapplication.studentapp.ui.theme.openSansItalic
import com.studentapplication.studentapp.ui.utills.BackArrowBox
import com.studentapplication.studentapp.ui.utills.CommonButton
import com.studentapplication.studentapp.ui.utills.DashedUploadMediaBox
import com.studentapplication.studentapp.ui.utills.SmallCircle
import com.studentapplication.studentapp.ui.utills.artGradient
import com.studentapplication.studentapp.ui.utills.exelaGradient


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AssessmentDetailsScreen(navController: NavHostController){

    val scrollState = rememberScrollState()
    val submitBottomSheetStatus = remember { mutableStateOf(false) }
    val fileTitle = remember { mutableStateOf("Rahul_Assessment") }
    val submittedDataList = remember { mutableStateListOf("") }

    Box(
        modifier = Modifier
            .fillMaxSize()
    ){
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 20.dp)
                .verticalScroll(scrollState),
            verticalArrangement = Arrangement.spacedBy(20.dp)
        ){
            Spacer(modifier = Modifier.height(80.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
            ){
                BackArrowBox(
                    boxColor = Color(0xFFFF6020),
                    shadowColor = Color(0xFFFFC8B3),
                    onClick = {navController.popBackStack()}
                )
                Spacer(modifier = Modifier.width(20.dp))
                SubjectChapterTopicBox()
            }
            AssignmentDetailsBox()

            Text(
                text = "Details",
                style = MaterialTheme.typography.bodyLarge.copy(
                    fontSize = 18.sp,
                    lineHeight = 14.4.sp,
                    color = Color(0xFF1D1751)
                ),
            )
            Text(
                text = buildAnnotatedString {
                    withStyle(style = SpanStyle(
                        fontWeight = FontWeight(400),
                        color = Color(0xFF363636)
                    )){
                        append("Hi Nursery A explorers! \nFor your science homework, please find a small leaf or flower and upload a photo of it to our class portal Hi Nursery A explorers! For your science homework, please find a small leaf or flower and upload a photo of it to our class portal ")
                    }
                    withStyle(style = SpanStyle(
                        fontWeight = FontWeight(600),
                        color = Color(0xFF129193),
                    )){
                        append("Read More.")
                    }
                },
                style = MaterialTheme.typography.headlineSmall.copy(
                    fontSize = 14.sp,
                    lineHeight = 21.sp,
                )
            )
            Text(
                text = "Attachment File",
                style = MaterialTheme.typography.bodyLarge.copy(
                    fontSize = 16.sp,
                    lineHeight = 12.8.sp,
                    color = Color(0xFF1D1751)
                )
            )
            AttachmentPdfBox()

            if (submittedDataList.size > 1) {
                SubmittedData()
            }else {
                Spacer(modifier = Modifier.height(40.dp))
                CommonButton(
                    modifier = Modifier.align(Alignment.CenterHorizontally),
                    text = "Submit Assessment",
                    textColor = Color.White,
                    outerBoxColor = Color(0xFFFF5B1A),
                    outerShadowColor = Color(0xFFFFA480),
                    innerBoxColor = Color(0xFFFF804D),
                    innerShadowColor = Color(0xFFFFA480),
                    curvedBoxColor = Color(0xFFFFA480),
                    ovalColor = Color.White,
                    onClick = {
                        submitBottomSheetStatus.value = true
                    }
                )
            }
            if (submitBottomSheetStatus.value){
                ModalBottomSheet(
                    onDismissRequest = { submitBottomSheetStatus.value = false },
                    dragHandle = { BottomSheetDefaults.HiddenShape },
                    containerColor = Color.White,
                    modifier = Modifier.fillMaxSize()
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(40.dp)
                            .verticalScroll(scrollState),
                        verticalArrangement = Arrangement.spacedBy(25.dp)
                    ){
                        BackArrowBox(
                            boxColor = Color(0xFFFF6020),
                            shadowColor = Color(0xFFFFC8B3),
                            onClick = {submitBottomSheetStatus.value = false}
                        )
                        Column {
                            Row {
                                Text(
                                    text = "File Title",
                                    style = MaterialTheme.typography.labelMedium.copy(
                                        fontWeight = FontWeight(700)
                                    )
                                )
                                Text(
                                    text = "*",
                                    style = TextStyle(
                                        fontFamily = interFont,
                                        fontWeight = FontWeight(400),
                                        fontSize = 14.sp,
                                        lineHeight = 16.94.sp,
                                        color = Color(0xFFEF6464)
                                    )
                                )
                            }
                            OutlinedTextField(
                                value = fileTitle.value,
                                onValueChange = { fileTitle.value = it },
                                modifier = Modifier
                                    .size(334.dp, 52.dp)
                                    .border(
                                        width = 2.dp,
                                        brush = exelaGradient,
                                        shape = RoundedCornerShape(6.dp)
                                    )
                                    .clip(RoundedCornerShape(6.dp)),
                                textStyle = MaterialTheme.typography.labelMedium.copy(
                                    fontWeight = FontWeight(700),
                                    color = Color(0xFF1D1751)
                                )
                            )
                        }

                        DashedUploadMediaBox()

                        UploadingPdfDetailsBox()

                        UploadingVideoDetailsBox()

                        Spacer(modifier = Modifier.height(20.dp))
                        CommonButton(
                            modifier = Modifier
                                .align(Alignment.CenterHorizontally),
                            text = "Submit",
                            textColor = Color.White,
                            outerBoxColor = Color(0xFFFF5B1A),
                            outerShadowColor = Color(0xFFFFA480),
                            innerBoxColor = Color(0xFFFF804D),
                            innerShadowColor = Color(0xFFFFA480),
                            curvedBoxColor = Color(0xFFFFA480),
                            ovalColor = Color.White,
                            onClick = {
                                submitBottomSheetStatus.value = false
                                submittedDataList.add("pdf")
                            }
                        )
                    }
                }
            }
        }
    }
}

@Composable
private fun UploadingVideoDetailsBox() {
    Box(
        modifier = Modifier
            .height(68.dp)
            .fillMaxWidth()
            .drawBehind {
                drawRoundRect(
                    color = Color(0xFFE6E5E5),
                    topLeft = Offset(x = 0.dp.toPx(), y = 6.dp.toPx()),
                    size = size,
                    cornerRadius = CornerRadius(12.dp.toPx())
                )
            }
            .border(
                width = 1.dp,
                color = Color(0xFFE6E5E5).copy(alpha = 0.2f),
                shape = RoundedCornerShape(12.dp)
            )
            .background(
                color = Color.White,
                shape = RoundedCornerShape(12.dp)
            ),
        contentAlignment = Alignment.Center
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 15.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                Image(
                    painter = painterResource(R.drawable.video),
                    contentDescription = "video",
                    modifier = Modifier
                        .size(34.25.dp)
                )
                Column(
                    modifier = Modifier
                        .size(162.dp, 44.dp),
                    verticalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "Sample.mp4",
                        style = MaterialTheme.typography.labelSmall.copy(
                            fontWeight = FontWeight(600)
                        )
                    )
                    UploadingProgressBar(progress = 1f)
                }
            }
            Image(
                painter = painterResource(R.drawable.delete),
                contentDescription = "delete",
                modifier = Modifier
                    .size(11.65.dp, 13.92.dp)
                    .clickable {

                    }
            )
        }
    }
}


@Composable
private fun UploadingPdfDetailsBox() {
    Box(
        modifier = Modifier
            .height(68.dp)
            .fillMaxWidth()
            .drawBehind {
                drawRoundRect(
                    color = Color(0xFFE6E5E5),
                    topLeft = Offset(x = 0.dp.toPx(), y = 6.dp.toPx()),
                    size = size,
                    cornerRadius = CornerRadius(12.dp.toPx())
                )
            }
            .border(
                width = 1.dp,
                color = Color(0xFFE6E5E5).copy(alpha = 0.2f),
                shape = RoundedCornerShape(12.dp)
            )
            .background(
                color = Color.White,
                shape = RoundedCornerShape(12.dp)
            ),
        contentAlignment = Alignment.Center
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 15.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                Image(
                    painter = painterResource(R.drawable.pdf),
                    contentDescription = "pdf",
                    modifier = Modifier
                        .size(34.25.dp)
                )
                Column(
                    modifier = Modifier
                        .size(162.dp, 44.dp),
                    verticalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "Shapes and colors.pdf",
                        style = MaterialTheme.typography.labelSmall.copy(
                            fontWeight = FontWeight(600)
                        )
                    )
                    UploadingProgressBar(progress = 0.7f)
                }
            }
            Image(
                painter = painterResource(R.drawable.delete),
                contentDescription = "delete",
                modifier = Modifier
                    .size(11.65.dp, 13.92.dp)
                    .clickable {

                    }
            )
        }
    }
}

@Composable
private fun UploadingProgressBar(progress: Float = 0.5f) {

    Column(
        modifier = Modifier.size(162.dp, 20.dp),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = if (progress == 1f) "Uploaded" else "Uploading",
            style = TextStyle(
                fontFamily = openSansItalic,
                fontSize = 10.sp,
                lineHeight = 13.62.sp,
                color = Color(0xFF129193)
            )
        )
        Canvas(
            modifier = Modifier.size(162.dp, 3.dp)
        ) {
            drawRoundRect(
                color = Color(0xFFC1C1C1),
                size = size,
                cornerRadius = CornerRadius(8.dp.toPx())
            )
            drawRoundRect(
                color = Color(0xFF129193),
                size = Size(size.width * progress, size.height),
                cornerRadius = CornerRadius(8.dp.toPx())
            )
        }
    }
}

@Composable
private fun SubmittedData() {
    Text(
        text = "Your Submission",
        style = MaterialTheme.typography.bodyLarge.copy(
            fontSize = 18.sp,
            lineHeight = 14.4.sp,
            color = Color(0xFF1D1751)
        ),
    )
    Surface(
        modifier = Modifier
            .fillMaxWidth(),
        shape = RoundedCornerShape(12.dp),
        color = Color(0xFFE4E4E4).copy(0.21f)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(19.dp)
        ) {
            Text(
                text = buildAnnotatedString {
                    withStyle(
                        style = SpanStyle(
                            fontWeight = FontWeight(400),
                            color = Color(0xFF363636)
                        )
                    ) {
                        append("Hi Nursery A explorers! \nFor your science homework, please find a small leaf or flower and upload a photo of it to our class portal Hi Nursery A explorers! For your science homework, please find a small leaf or flower and upload a photo of it to our class portal ")
                    }
                    withStyle(
                        style = SpanStyle(
                            fontWeight = FontWeight(600),
                            color = Color(0xFF129193),
                        )
                    ) {
                        append("Read More.")
                    }
                },
                style = MaterialTheme.typography.headlineSmall.copy(
                    fontSize = 12.sp,
                    lineHeight = 18.sp,
                )
            )
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = "Attachment File",
                style = MaterialTheme.typography.bodyLarge.copy(
                    fontSize = 14.sp,
                    lineHeight = 11.2.sp,
                    color = Color(0xFF1D1751)
                )
            )
            Spacer(modifier = Modifier.height(10.dp))
            SubmitAttachmentPdfBox()
        }
    }
}

@Composable
fun SubmitAttachmentPdfBox() {
    Box(
        modifier = Modifier
            .height(57.dp)
            .fillMaxWidth()
            .drawBehind {
                drawRoundRect(
                    color = Color(0xFFE6E5E5),
                    topLeft = Offset(x = 0.dp.toPx(), y = 4.46.dp.toPx()),
                    size = size,
                    cornerRadius = CornerRadius(8.92.dp.toPx())
                )
            }
            .border(
                width = 0.74.dp,
                color = Color(0xFFE6E5E5).copy(alpha = 0.2f),
                shape = RoundedCornerShape(12.dp)
            )
            .background(
                color = Color.White,
                shape = RoundedCornerShape(8.92.dp)
            ),
        contentAlignment = Alignment.Center
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 15.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                Image(
                    painter = painterResource(R.drawable.pdf),
                    contentDescription = "pdf",
                    modifier = Modifier
                        .size(25.46.dp)
                )
                Column {
                    Text(
                        text = "Shapes and colors",
                        style = MaterialTheme.typography.labelSmall.copy(
                            fontWeight = FontWeight(600),
                            fontSize = 10.54.sp,
                            lineHeight = 14.37.sp
                        )
                    )
                    Text(
                        text = "1 Page",
                        style = MaterialTheme.typography.labelMedium.copy(
                            fontSize = 8.92.sp,
                            lineHeight = 12.17.sp,
                            color = Color(0xFF129193)
                        )
                    )
                }
            }
            Text(
                text = "View",
                style = MaterialTheme.typography.labelSmall.copy(
                    fontWeight = FontWeight(600),
                    fontSize = 12.sp,
                    lineHeight = 16.37.sp,
                    color = Color(0xFF129193)
                ),
                modifier = Modifier
                    .clickable {

                    }
            )
        }
    }
}

@Composable
fun AttachmentPdfBox() {
    Box(
        modifier = Modifier
            .height(76.dp)
            .fillMaxWidth()
            .drawBehind {
                drawRoundRect(
                    color = Color(0xFFE6E5E5),
                    topLeft = Offset(x = 0.dp.toPx(), y = 6.dp.toPx()),
                    size = size,
                    cornerRadius = CornerRadius(12.dp.toPx())
                )
            }
            .border(
                width = 1.dp,
                color = Color(0xFFE6E5E5).copy(alpha = 0.2f),
                shape = RoundedCornerShape(12.dp)
            )
            .background(
                color = Color.White,
                shape = RoundedCornerShape(12.dp)
            ),
        contentAlignment = Alignment.Center
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 15.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                Image(
                    painter = painterResource(R.drawable.pdf),
                    contentDescription = "pdf",
                    modifier = Modifier
                        .size(34.25.dp)
                )
                Column {
                    Text(
                        text = "Shapes and colors",
                        style = MaterialTheme.typography.labelSmall.copy(
                            fontWeight = FontWeight(600)
                        )
                    )
                    Text(
                        text = "1 Page",
                        style = MaterialTheme.typography.labelMedium.copy(
                            fontSize = 12.sp,
                            lineHeight = 16.37.sp,
                            color = Color(0xFF129193)
                        )
                    )
                }
            }
            Image(
                painter = painterResource(R.drawable.download),
                contentDescription = "download",
                modifier = Modifier
                    .size(23.62.dp, 21.26.dp)
                    .clickable { }
            )
        }
    }
}


@Composable
fun AssignmentDetailsBox(
    assignmentName: String = "Assignment Name"
) {
    Box(
        modifier = Modifier
            .height(152.dp)
            .fillMaxWidth()
            .drawBehind {
                drawRoundRect(
                    color = Color(0xFFE6E5E5),
                    topLeft = Offset(x = 0.dp.toPx(), y = 6.dp.toPx()),
                    size = size,
                    cornerRadius = CornerRadius(12.dp.toPx())
                )
            }
            .border(
                width = 1.dp,
                color = Color(0xFFE6E5E5).copy(alpha = 0.2f),
                shape = RoundedCornerShape(12.dp)
            )
            .background(
                color = Color.White,
                shape = RoundedCornerShape(12.dp)
            ),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column {
                    Text(
                        text = assignmentName,
                        style = MaterialTheme.typography.bodyLarge.copy(
                            fontSize = 18.sp,
                            lineHeight = 14.4.sp,
                            color = Color(0xFFFF6020)
                        )
                    )
                    Row(
                        modifier = Modifier,
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(5.dp)
                    ) {
                        Text(
                            text = "Arts",
                            style = MaterialTheme.typography.labelSmall.copy(
                                fontWeight = FontWeight(500),
                                lineHeight = 11.2.sp,
                                color = Color(0xFF129193)
                            )
                        )
                        SmallCircle(
                            dim = 4.dp,
                            containerColor = Color(0xFF129193)
                        )
                        Text(
                            text = "Ch-4",
                            style = MaterialTheme.typography.labelSmall.copy(
                                fontWeight = FontWeight(500),
                                lineHeight = 11.2.sp,
                                color = Color(0xFF129193)
                            )
                        )
                        SmallCircle(
                            dim = 4.dp,
                            containerColor = Color(0xFF129193)
                        )
                        Text(
                            text = "Topic 1",
                            style = MaterialTheme.typography.labelSmall.copy(
                                fontWeight = FontWeight(500),
                                lineHeight = 11.2.sp,
                                color = Color(0xFF1D1751)
                            )
                        )
                    }
                }
                AssignmentStatusBox(
                    modifier = Modifier.width(101.dp),
                    status = "Submitted"
                )
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column {
                    Text(
                        text = "Published on",
                        style = MaterialTheme.typography.headlineSmall.copy(
                            fontWeight = FontWeight(400),
                            lineHeight = 9.6.sp,
                            color = Color(0xFF1D1751)
                        )
                    )
                    Spacer(modifier = Modifier.height(5.dp))
                    Text(
                        text = "22 August 2024",
                        style = MaterialTheme.typography.headlineSmall.copy(
                            fontWeight = FontWeight(400),
                            lineHeight = 9.6.sp,
                            color = Color(0xFF129193)
                        )
                    )
                }
                Column {
                    Text(
                        text = "Deadline",
                        style = MaterialTheme.typography.headlineSmall.copy(
                            fontWeight = FontWeight(400),
                            lineHeight = 9.6.sp,
                            color = Color(0xFF1D1751)
                        )
                    )
                    Spacer(modifier = Modifier.height(5.dp))
                    Text(
                        text = "22 August 2024",
                        style = MaterialTheme.typography.headlineSmall.copy(
                            fontWeight = FontWeight(400),
                            lineHeight = 9.6.sp,
                            color = Color(0xFF129193)
                        )
                    )
                }
            }
        }
    }
}