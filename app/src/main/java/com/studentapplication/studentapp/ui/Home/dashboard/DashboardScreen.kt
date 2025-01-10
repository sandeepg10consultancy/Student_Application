package com.studentapplication.studentapp.ui.Home.dashboard

import android.widget.Space
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
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
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemColors
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.NavigationDrawerItemDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.draw.scale
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Fill
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.studentapplication.studentapp.R
import com.studentapplication.studentapp.ui.utills.exelaGradient
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.window.Dialog
import androidx.navigation.NavHostController
import com.studentapplication.studentapp.ui.theme.nunitoFont
import com.studentapplication.studentapp.ui.utills.CommonButton
import kotlinx.coroutines.launch


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DashboardScreen(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    viewModel: DashboardViewModel
){

    val scrollState = rememberScrollState()
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ProfileDrawerContent(
                navController = navController,
                onClose = {
                    scope.launch {
                        drawerState.close()
                    }
                },
            )
        }
    ) {
        Box(
            modifier = modifier
                .fillMaxSize()
                .background(
                    brush = exelaGradient
                )
        ){
            Image(
                painter = painterResource(R.drawable.dashboard_design),
                contentDescription = "design",
                modifier = Modifier
                    .height(223.59.dp)
                    .width(143.6.dp)
                    .align(Alignment.TopStart)
                    .offset(y = (-40).dp)
            )
            Image(
                painter = painterResource(R.drawable.dog),
                contentDescription = "dog",
                modifier = Modifier
                    .height(263.23.dp)
                    .width(218.dp)
                    .rotate(340f)
                    .align(Alignment.TopEnd),
                alpha = 0.4f,
            )
            Box(
                modifier = Modifier
                    .height(172.dp)
                    .fillMaxWidth(),
                contentAlignment = Alignment.Center
            ){
                Row(
                    modifier = Modifier
                        .height(53.dp)
                        .fillMaxWidth()
                        .padding(horizontal = 15.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ){
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(10.dp)
                    ){
                        ProfileWithMenuIcon(
                            onOpenDrawer = {
                                scope.launch {
                                    drawerState.apply {
                                        if (isClosed) open() else close()
                                    }
                                }
                            }
                        )
                        Column(
                            modifier = Modifier
                                .fillMaxHeight(),
                        ) {
                            Text(
                                text = "Good Morning,",
                                style = MaterialTheme.typography.labelMedium.copy(
                                    lineHeight = 17.6.sp,
                                    color = Color(0xFFE8E8E6)
                                ),
                                modifier = Modifier
                            )
                            Text(
                                text = "Vinay",
                                style = MaterialTheme.typography.bodyLarge.copy(
                                    fontSize = 25.sp,
                                    lineHeight = 33.sp,
                                    color = Color(0xFFE8E8E6)
                                ),
                                modifier = Modifier
                            )
                        }
                    }
                    Box(
                        modifier = Modifier
                            .size(40.dp)
                            .drawBehind {
                                drawRoundRect(
                                    color = Color(0xFF056E70),
                                    topLeft = Offset(x = 0f, y = 3.03f),
                                    size = Size(size.width, size.height),
                                    cornerRadius = CornerRadius(12.dp.toPx())
                                )
                            }
                            .background(
                                color = Color(0xFF129193),
                                shape = RoundedCornerShape(12.dp)
                            )
                            .clickable {
                                navController.navigate(route = "notificationsScreen")
                            },
                        contentAlignment = Alignment.Center
                    ){
                        Icon(
                            painter = painterResource(R.drawable.notification),
                            contentDescription = "notification",
                            tint = Color.White,
                            modifier = Modifier
                                .size(24.dp)
                        )
                    }
                }
            }
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 172.dp)
                    .background(
                        shape = RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp),
                        color = Color.White
                    )
            ){

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
                            .offset(x = (75).dp)
                    )
                    Image(
                        painter = painterResource(R.drawable.bird),
                        contentDescription = "bird",
                        modifier = Modifier
                            .size(229.68.dp)
                            .align(Alignment.BottomStart)
                            .offset(x = (-10).dp, y = (-20).dp),
                        alpha = 0.6f
                    )
                    Image(
                        painter = painterResource(R.drawable.cat),
                        contentDescription = "cat",
                        modifier = Modifier
                            .height(162.32.dp)
                            .width(141.35.dp)
                            .align(Alignment.BottomEnd)
                            .offset(y = (-50).dp),
                        alpha = 0.6f
                    )
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(start = 20.dp, top = 40.dp, end = 10.dp)
                            .verticalScroll(scrollState),
                    ) {
                        SubjectPathDesign1(
                            subject = "Arts",
                            image = R.drawable.art,
                            gradientBrush = Brush.linearGradient(
                                colors = listOf(Color(0xFFFF6020), Color(0xFFFDC194),),
                            ),
                            onClick = { navController.navigate(route = "topicListing") }
                        )

                        SubjectPathDesign2(
                            subject = "Numeracy",
                            image = R.drawable.numeracy,
                            gradientBrush = Brush.linearGradient(
                                colors = listOf(Color(0xFF2C84DA), Color(0xFF99D6FC))
                            ),
                            onClick = { navController.navigate(route = "topicListing") }
                        )
                        Spacer(modifier = Modifier.height(20.dp))
                        SubjectPathDesign1(
                            subject = "General A",
                            image = R.drawable.general_awareness,
                            gradientBrush = Brush.linearGradient(
                                colors = listOf( Color(0xFF2093C3),Color(0xFF93ECFF),)
                            ),
                            onClick = { navController.navigate(route = "topicListing") }
                        )
                        SubjectPathDesign2(
                            subject = "English",
                            image = R.drawable.alphabets,
                            gradientBrush = Brush.linearGradient(
                                colors = listOf( Color(0xFFFF992E),Color(0xFFFED276),)
                            ),
                            onClick = { navController.navigate(route = "topicListing") }
                        )
                        Spacer(modifier = Modifier.height(150.dp))
                    }
                }
            }
            BottomAppBar(
                modifier = Modifier
                    .align(Alignment.BottomCenter),
                containerColor = Color.White
            ){
                BottomNavigationBar(navController, viewModel)
            }

        }
    }

}

@Composable
private fun ProfileWithMenuIcon(
    onOpenDrawer: () -> Unit
) {
    Box(
        modifier = Modifier
            .height(53.dp)
            .width(51.dp)
            .clickable {
                onOpenDrawer()
            }
    ) {
        Box(
            modifier = Modifier
                .size(45.dp)
                .clip(CircleShape)
                .border(
                    width = 2.dp,
                    color = Color.White,
                    shape = CircleShape
                )
                .align(Alignment.TopStart),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(R.drawable.profile_boy),
                contentDescription = "profile",
                modifier = Modifier
                    .fillMaxSize()
                    .clip(CircleShape)
            )
        }
        Box(
            modifier = Modifier
                .size(20.dp)
                .clip(CircleShape)
                .align(Alignment.BottomEnd)
                .background(
                    brush = Brush.linearGradient(
                        colors = listOf(Color(0xFF129193), Color(0xFF062C2D))
                    )
                ),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                painter = painterResource(R.drawable.menu),
                contentDescription = "menu",
                tint = Color.White
            )
        }
    }
}

@Composable
private fun SubjectPathDesign2(
    subject: String,
    image: Int,
    gradientBrush: Brush,
    onClick:()-> Unit = { }
) {
    Box(
        modifier = Modifier
            .size(387.dp, 180.dp)
            .clickable { onClick() }
    ) {
        Canvas(
            modifier = Modifier
                .size(387.dp, 180.dp)
        ) {
            val cornerRadius = 60f
            val path = Path().apply {
                moveTo(0f, cornerRadius)
                quadraticTo(
                    0f, 0f,
                    cornerRadius, 0f
                )
                quadraticTo(
                    size.width * 0.35f, size.height * 0.1f,
                    size.width * 0.65f, size.height * 0.15f
                )
                quadraticTo(
                    size.width * 0.32f, size.height * 0.1f,
                    size.width * 0.85f, size.height * 0.15f
                )
                quadraticTo(
                    size.width, 110f,
                    size.width * 0.95f, size.height * 0.5f
                )
                quadraticTo(
                    size.width * 0.93f, size.height * 0.7f,
                    size.width * 0.95f, size.height * 0.85f
                )
                quadraticTo(
                    size.width * 0.95f, size.height,
                    size.width * 0.85f, size.height
                )
                lineTo(cornerRadius, size.height)
                quadraticTo(
                    0f, size.height,
                    0f, size.height - cornerRadius
                )
                close()
            }


            drawPath(
                path = path,
                brush = gradientBrush
            )
        }
        Box(
            modifier = Modifier
                .align(Alignment.TopStart)
                .offset(x = 10.dp, y = 10.dp)
        ) {
            Canvas(
                modifier = Modifier
                    .size(90.5.dp, 61.dp)
            ) {
                val cornerRadius = 15.dp.toPx()
                val path = Path().apply {
                    moveTo(10f, size.height)
                    lineTo(0f, 0f + cornerRadius)
                    quadraticTo(
                        0f, 0f,
                        cornerRadius, 0f
                    )
                    lineTo(size.width, 30f)
                }
                drawPath(
                    path = path,
                    color = Color.White,
                    style = Stroke(
                        width = 4.dp.toPx()
                    )
                )
            }
        }
        Box(
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .offset(x = (-35).dp, y = (-15).dp)
        ) {
            Canvas(
                modifier = Modifier
                    .size(90.5.dp, 61.dp)
            ) {
                val cornerRadius = 15.dp.toPx()
                val path = Path().apply {
                    moveTo(size.width, 0f)
                    lineTo(size.width, size.height - cornerRadius)
                    quadraticTo(
                        size.width, size.height,
                        size.width - cornerRadius, size.height
                    )
                    lineTo(0f, size.height * 0.95f)
                }
                drawPath(
                    path = path,
                    color = Color.White,
                    style = Stroke(
                        width = 4.dp.toPx()
                    )
                )
            }
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 30.dp, end = 50.dp)
                .align(Alignment.Center),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(image),
                contentDescription = "numeracy",
                modifier = Modifier
                    .size(124.dp)
                    .scale(1.4f)
                    .offset(y = 10.dp)
            )
            Column(
                modifier = Modifier
            ) {
                Text(
                    text = subject,
                    style = MaterialTheme.typography.labelLarge.copy(
                        fontSize = 35.sp,
                        lineHeight = 38.5.sp,
                        color = Color.White
                    ),
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    modifier = Modifier
                        .fillMaxWidth(),
                    textAlign = TextAlign.End
                )
                Text(
                    text = "20 chapter",
                    style = MaterialTheme.typography.labelSmall.copy(
                        fontWeight = FontWeight(700),
                        lineHeight = 15.4.sp,
                        color = Color.White
                    ),
                    modifier = Modifier
                        .fillMaxWidth(),
                    textAlign = TextAlign.End
                )
            }
        }
    }
}

@Composable
private fun SubjectPathDesign1(
    subject: String,
    image: Int,
    gradientBrush: Brush,
    onClick:()-> Unit = { }
) {
    Box(
        modifier = Modifier
            .size(387.dp, 180.dp)
            .padding(end = 10.dp)
            .clickable { onClick() }
    ) {
        Canvas(
            modifier = Modifier
                .size(385.dp, 180.dp)
        ) {
            val cornerRadius = 50f

            val path = Path().apply {
                moveTo(0f, cornerRadius)
                quadraticBezierTo(
                    0f, 0f,
                    cornerRadius, 0f
                )
                lineTo(size.width - cornerRadius, 0f)
                quadraticBezierTo(
                    size.width, 0f,
                    size.width, cornerRadius
                )
                lineTo(size.width, size.height - cornerRadius)
                quadraticBezierTo(
                    size.width, size.height,
                    size.width - cornerRadius, size.height
                )
                lineTo(size.width * 0.6f, size.height * 0.9f)
                quadraticBezierTo(
                    size.width * 0.4f, size.height * 0.9f,
                    size.width * 0.02f + 30f, size.height * 0.65f
                )
                quadraticBezierTo(
                    size.width * 0.02f + 10f, size.height * 0.65f,
                    20f, size.height * 0.5f
                )

                close()
            }
            drawPath(
                path = path,
                brush = gradientBrush,
                style = Fill
            )
        }
        Box(
            modifier = Modifier
                .align(Alignment.TopStart)
                .offset(x = 10.dp, y = 10.dp)
        ) {
            Canvas(
                modifier = Modifier
                    .size(90.5.dp, 61.dp)
            ) {
                val cornerRadius = 15.dp.toPx()
                val path = Path().apply {
                    moveTo(10f, size.height)
                    lineTo(0f, 0f + cornerRadius)
                    quadraticTo(
                        0f, 0f,
                        cornerRadius, 0f
                    )
                    lineTo(size.width, 0f)
                }
                drawPath(
                    path = path,
                    color = Color.White,
                    style = Stroke(
                        width = 4.dp.toPx()
                    )
                )
            }
        }
        Box(
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .offset(x = (-10).dp, y = (-10).dp)
        ) {
            Canvas(
                modifier = Modifier
                    .size(90.5.dp, 61.dp)
            ) {
                val cornerRadius = 15.dp.toPx()
                val path = Path().apply {
                    moveTo(size.width, 0f)
                    lineTo(size.width, size.height - cornerRadius)
                    quadraticTo(
                        size.width, size.height,
                        size.width - cornerRadius, size.height
                    )
                    lineTo(0f, size.height - 30f)
                }
                drawPath(
                    path = path,
                    color = Color.White,
                    style = Stroke(
                        width = 4.dp.toPx()
                    )
                )
            }
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 50.dp, end = 20.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth(0.5f)
            ) {
                Text(
                    text = subject,
                    style = MaterialTheme.typography.labelLarge.copy(
                        fontSize = 35.sp,
                        lineHeight = 38.5.sp,
                        color = Color.White
                    ),
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                Text(
                    text = "20 chapter",
                    style = MaterialTheme.typography.labelSmall.copy(
                        fontWeight = FontWeight(700),
                        lineHeight = 15.4.sp,
                        color = Color.White
                    )
                )
            }
            Image(
                painter = painterResource(image),
                contentDescription = "art",
                modifier = Modifier
                    .size(142.dp)
                    .scale(1.2f)
                    .offset(y = 10.dp)

            )
        }
    }
}


@Composable
fun BottomNavigationBar(navController: NavHostController, viewModel: DashboardViewModel) {

    val selectedItem = viewModel.selectedIcon.collectAsState().value


    // List of navigation items with their labels and icons
    val navItems = listOf(
        "Home" to if (selectedItem == "Home") R.drawable.home_icon else R.drawable.home,
        "Calender" to if (selectedItem == "Calender") R.drawable.calendar_icon else R.drawable.calendar,
        "Daily Diary" to if (selectedItem == "Daily Diary") R.drawable.diary_icon else R.drawable.diary
    )

    NavigationBar(
        containerColor = Color.White,
        modifier = Modifier
    ) {
        navItems.forEach { (label, iconRes) ->
            val isSelected = (selectedItem == label)
            NavigationBarItem(
                selected = isSelected,
                icon = {
                    Image(
                        painter = painterResource(iconRes),
                        contentDescription = label,
                        //alpha = if (isSelected) 1f else 0.5f
                    )
                },
                label = {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            text = label,
                            style = MaterialTheme.typography.labelSmall.copy(
                                fontSize = if (isSelected) 14.sp else 12.sp,
                                fontWeight = FontWeight(600),
                                lineHeight = if (isSelected) 19.1.sp else 16.37.sp,
                                brush = Brush.linearGradient(
                                    colors = if (isSelected) listOf(
                                        Color(0xFF185573),
                                        Color(0xFF14868D)
                                    ) else listOf(
                                        Color(0xFF000000).copy(alpha = 0.5f),
                                        Color(0xFF000000).copy(alpha = 0.5f)
                                    )
                                )
                            )
                        )
                        Spacer(modifier = Modifier.height(5.dp))
                        if (isSelected) {
                            Box(
                                modifier = Modifier
                                    .width(89.dp)
                                    .height(6.dp)
                                    .clip(RoundedCornerShape(topStart = 8.dp, topEnd = 8.dp))
                                    .background(
                                        brush = exelaGradient
                                    )
                            )
                        }
                    }
                },
                onClick = {
                    viewModel.setSelectedIcon(label)
                    val destination = when (label) {
                        "Home" -> "dashboard"
                        "Calender" -> "calendarScreen"
                        "Diary" -> "dairyScreen"
                        else -> "dashboard"
                    }
                    navController.navigate(destination) {
                        launchSingleTop = true
                        restoreState = true
                    }
                },
                colors = NavigationBarItemColors(
                    selectedIconColor = Color.Transparent,
                    selectedTextColor = Color.Transparent,
                    selectedIndicatorColor = Color.Transparent,
                    unselectedIconColor = Color.Transparent,
                    unselectedTextColor = Color.Transparent,
                    disabledIconColor = Color.Transparent,
                    disabledTextColor = Color.Transparent
                )
            )
        }
    }

}

@Composable
fun ProfileDrawerContent(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    onClose: () -> Unit,
){
    val showLogoutDialog = remember { mutableStateOf(false) }

    val iconsList = listOf(
        "Profile" to R.drawable.profile_icon,
        "My Performance" to R.drawable.performance,
        "Bookmarks" to R.drawable.bookmarks,
        "FAQ'S" to R.drawable.faqs,
        "Privacy Policy" to R.drawable.privacy,
        "Logout" to R.drawable.logout
    )

    Box(
        modifier = Modifier
            .fillMaxHeight()
            .width(292.dp)
            .background(
                brush = exelaGradient
            )
    ){
        Image(
            painter = painterResource(R.drawable.menu_bird),
            contentDescription = "bird",
            modifier = Modifier
                .size(229.68.dp)
                .align(Alignment.BottomStart)
                .offset( x = (-25).dp,y = (-120).dp)
        )
        Image(
            painter = painterResource(R.drawable.dog),
            contentDescription = "dog",
            modifier = Modifier
                .size(109.29.dp,132.65.dp)
                .align(Alignment.CenterEnd)
                .rotate(-19.97f)
                .offset( x = (-50).dp, y = 90.dp),
            alpha = 0.4f
        )
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(start = 13.dp, top = 20.dp, end = 13.dp)
        ){
            Icon(
                painter = painterResource(R.drawable.close),
                contentDescription = "close",
                tint = Color.White,
                modifier = Modifier
                    .size(20.dp)
                    .clickable {
                        onClose()
                    }
                    .offset(x = 10.dp)
            )
            Spacer(modifier = Modifier.height(20.dp))
            ProfileBox()
            Spacer(modifier = Modifier.height(10.dp))
            iconsList.forEach { item ->
                NavigationDrawerItem(
                    icon = {
                        Icon(
                            painter = painterResource(item.second),
                            contentDescription = item.first,
                            tint = Color.White,
                            modifier = Modifier
                                .size(24.dp)
                        )
                    },
                    label = {
                        Text(
                            text = item.first,
                            style = MaterialTheme.typography.titleSmall.copy(
                                fontWeight = FontWeight(600),
                                lineHeight = 18.sp,
                                color = Color.White
                            )
                        )
                    },
                    selected = false,
                    onClick = {
                        when(item.first){
                            "Profile" -> { navController.navigate(route = "profileScreen") }
                            "Student Performance" -> {  }
                            "Bookmarks" -> { navController.navigate(route = "bookmarksScreen") }
                            "FAQ'S" -> { navController.navigate(route = "faqsScreen") }
                            "Privacy Policy" -> { }
                            "Logout" -> { showLogoutDialog.value = true}
                        }
                    },
                    colors = NavigationDrawerItemDefaults.colors(
                        selectedContainerColor = Color.Transparent,
                        unselectedContainerColor = Color.Transparent,
                    )
                )
            }

            Spacer(modifier = Modifier.height(270.dp))
            Box(
                modifier = Modifier
                    .size(258.dp, 47.dp)
                    .clip(RoundedCornerShape(8.dp))
                    .background(color = Color(0xFFF3F3F3)),
                contentAlignment = Alignment.Center
            ){
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 20.dp)
                ){
                    Icon(
                        painter = painterResource(R.drawable.help),
                        contentDescription = "help",
                        modifier = Modifier.size(20.dp)
                    )
                    Spacer(modifier = Modifier.width(10.dp))
                    Text(
                        text = "Help",
                        style = MaterialTheme.typography.labelMedium.copy(
                            fontWeight = FontWeight(600),
                            lineHeight = 16.sp
                        )
                    )
                }
            }
            Text(
                text = "V 0.1.0",
                style = TextStyle(
                    fontFamily = nunitoFont,
                    fontWeight = FontWeight(600),
                    fontSize = 12.sp,
                    lineHeight = 12.sp,
                    color = Color.White
                ),
                modifier = Modifier
                    .padding(start = 10.dp, top = 10.dp)
            )
            if (showLogoutDialog.value){
                Dialog(
                    onDismissRequest = { showLogoutDialog.value = false}
                ) {
                    Box(
                        modifier = Modifier
                            .size(390.dp, 279.dp)
                            .clip(RoundedCornerShape(15.dp))
                            .background(color = Color.White)
                    ){
                        Column(
                            modifier = Modifier
                                .fillMaxSize(),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ){
                            Image(
                                painter = painterResource(R.drawable.tiger),
                                contentDescription = "tiger",
                                modifier = Modifier
                                    .size(96.5.dp, 107.dp)
                            )
                            Text(
                                text = "Are you sure you want to log out?",
                                style = MaterialTheme.typography.titleSmall,
                                color = Color.Black.copy(alpha = 0.8f),
                                modifier = Modifier.fillMaxWidth(),
                                textAlign = TextAlign.Center
                            )
                            Spacer(modifier = Modifier.height(40.dp))
                            Row(
                                modifier = Modifier.padding(horizontal = 20.dp),
                                horizontalArrangement = Arrangement.spacedBy(5.dp)
                            ){
                                CommonButton(
                                    modifier = Modifier
                                        .height(60.dp)
                                        .width(140.dp),
                                    text = "Cancel",
                                    textColor = Color(0xFF129193),
                                    textStyle = MaterialTheme.typography.labelLarge.copy(
                                        fontSize = 20.sp,
                                        lineHeight = 28.96.sp
                                    ),
                                    outerBoxColor = Color(0xFFF9F9F9),
                                    outerShadowColor = Color(0xFFD8D8D8),
                                    innerBoxColor = Color.White,
                                    innerShadowColor = Color(0xFFE1E1E1),
                                    curvedBoxColor = Color(0xFFF9F9F9),
                                    ovalColor = Color(0xFFF3F3F3),
                                    onClick = {
                                        showLogoutDialog.value = false
                                    }
                                )
                                CommonButton(
                                    modifier = Modifier
                                        .size(170.dp, 60.dp),
                                    text = "Yes",
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
fun CustomDialogAlternative(
    onYesButtonClick: () -> Unit,
    onCancel: () -> Unit,
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black.copy(alpha = 0.4f)) // Dim background
            .clickable(
                onClick = onCancel,
                indication = null,
                interactionSource = remember { MutableInteractionSource() }
            )
    ){

            Box(
                modifier = Modifier
                    .size(390.dp, 279.dp)
                    .clip(RoundedCornerShape(15.dp))
                    .background(color = Color.White)
                    .align(Alignment.Center)
            ){
                Column(
                    modifier = Modifier
                        .fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ){
                    Image(
                        painter = painterResource(R.drawable.tiger),
                        contentDescription = "tiger",
                        modifier = Modifier
                            .size(96.5.dp, 107.dp)
                    )
                    Text(
                        text = "Are you sure you want to log out?",
                        style = MaterialTheme.typography.titleSmall,
                        color = Color.Black.copy(alpha = 0.8f),
                        modifier = Modifier.fillMaxWidth(),
                        textAlign = TextAlign.Center
                    )
                    Spacer(modifier = Modifier.height(40.dp))
                    Row(
                        modifier = Modifier.padding(horizontal = 20.dp),
                        horizontalArrangement = Arrangement.spacedBy(5.dp)
                    ){
                        CommonButton(
                            modifier = Modifier
                                .size(170.dp, 60.dp),
                            text = "Cancel",
                            textColor = Color(0xFF129193),
                            textStyle = MaterialTheme.typography.labelLarge.copy(
                                fontSize = 20.sp,
                                lineHeight = 28.96.sp
                            ),
                            outerBoxColor = Color(0xFFF9F9F9),
                            outerShadowColor = Color(0xFFD8D8D8),
                            innerBoxColor = Color.White,
                            innerShadowColor = Color(0xFFE1E1E1),
                            curvedBoxColor = Color(0xFFF9F9F9),
                            ovalColor = Color(0xFFF3F3F3),
                            onClick = onCancel
                        )
                        CommonButton(
                            modifier = Modifier
                                .size(170.dp, 60.dp),
                            text = "Yes",
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
                            onClick = onYesButtonClick
                        )
                    }
                }
            }
    }
}



@Composable
private fun ProfileBox() {
    Box(
        modifier = Modifier
            .size(276.dp, 117.dp)
            .clip(RoundedCornerShape(16.dp))
            .background(color = Color.White.copy(alpha = 0.4f)),
        contentAlignment = Alignment.Center
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(R.drawable.profile_boy),
                contentDescription = "profile",
                modifier = Modifier
                    .size(90.dp)
                    .clip(CircleShape)
                    .border(
                        width = 2.dp,
                        color = Color.White,
                        shape = CircleShape
                    )
            )
            Spacer(modifier = Modifier.width(20.dp))
            Column(
                modifier = Modifier
                    .size(96.dp, 58.dp),
            ) {
                Text(
                    text = "Vinay K.",
                    style = MaterialTheme.typography.labelLarge.copy(
                        fontSize = 25.sp,
                        lineHeight = 25.sp,
                        color = Color.White
                    ),
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                Text(
                    text = "Nursery - A",
                    style = MaterialTheme.typography.labelMedium.copy(
                        fontWeight = FontWeight(500),
                        color = Color.White
                    ),
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
            }
        }
    }
}