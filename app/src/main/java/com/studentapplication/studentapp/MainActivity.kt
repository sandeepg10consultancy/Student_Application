package com.studentapplication.studentapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.studentapplication.studentapp.ui.Calendar.CalendarScreen
import com.studentapplication.studentapp.ui.Diary.DailyDiaryScreen
import com.studentapplication.studentapp.ui.Home.ModalDrawer.BookmarksScreen
import com.studentapplication.studentapp.ui.Home.ModalDrawer.FAQScreen
import com.studentapplication.studentapp.ui.Home.ModalDrawer.ProfileScreen
import com.studentapplication.studentapp.ui.Home.ModalDrawer.ProfileScreenEditing
import com.studentapplication.studentapp.ui.Home.dashboard.CustomDialogAlternative
import com.studentapplication.studentapp.ui.Home.dashboard.DashboardScreen
import com.studentapplication.studentapp.ui.Home.dashboard.DashboardViewModel
import com.studentapplication.studentapp.ui.Home.notification.NotificationDetailsScreen
import com.studentapplication.studentapp.ui.Home.notification.NotificationsScreen
import com.studentapplication.studentapp.ui.login.LoginAndRegisterScreen
import com.studentapplication.studentapp.ui.login.LoginScreen
import com.studentapplication.studentapp.ui.login.account.ClassSelection
import com.studentapplication.studentapp.ui.login.account.ProfileDetailsScreen
import com.studentapplication.studentapp.ui.login.otp.OTPScreen
import com.studentapplication.studentapp.ui.login.registration.PasswordScreen
import com.studentapplication.studentapp.ui.login.registration.RegisterScreen
import com.studentapplication.studentapp.ui.subject.AssessmentDetailsScreen
import com.studentapplication.studentapp.ui.subject.ChapterListingScreen
import com.studentapplication.studentapp.ui.subject.TopicDescriptionScreen
import com.studentapplication.studentapp.ui.subject.TopicListingScreen
import com.studentapplication.studentapp.ui.theme.StudentAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            StudentAppTheme {

                val navController = rememberNavController()
                val viewModel: DashboardViewModel = viewModel()
                DailyDiaryScreen(navController)
                //CalendarScreen(navController,viewModel)

//                DashboardScreen(
//                    navController = navController,
//                    viewModel = viewModel
//                )
                //NotificationDetailsScreen(navController)
                //MyApp()

            }
        }
    }
}

@Composable
fun MyApp(){
    val navController = rememberNavController()
    val viewModel: DashboardViewModel = viewModel()

    NavHost(
        navController = navController,
        startDestination = "home"
    ) {
        composable(route = "home"){
            LoginAndRegisterScreen(modifier = Modifier, navController = navController)
        }
        composable(route = "login"){
            LoginScreen(navController = navController)
        }
        composable(route = "register"){
            RegisterScreen(navController = navController)
        }
        composable(route = "otp"){
            OTPScreen(navController = navController)
        }
        composable(route = "password"){
            PasswordScreen(navController = navController)
        }
        composable(route = "details"){
            ProfileDetailsScreen(navController = navController)
        }
        composable(route = "classes"){
            ClassSelection(navController = navController)
        }
        composable( route = "dashboard"){
            DashboardScreen(
                navController = navController,
                viewModel = viewModel
            )
        }
        composable( route = "profileScreen"){
            ProfileScreen(
                navController = navController,
            )
        }
        composable( route = "profileEditScreen"){
            ProfileScreenEditing(
                navController = navController,
            )
        }
        composable( route = "bookmarksScreen"){
            BookmarksScreen(
                navController = navController,
            )
        }
        composable( route = "faqsScreen"){
            FAQScreen(
                navController = navController,
            )
        }
        composable(route = "notificationsScreen"){
            NotificationsScreen(
                navController = navController
            )
        }
        composable(route = "notificationDetails"){
            NotificationDetailsScreen(
                navController = navController
            )
        }
        composable(route = "calendarScreen"){
            CalendarScreen(
                navController = navController,
                viewModel = viewModel
            )
        }
        composable(route = "topicListing"){
            TopicListingScreen(
                navController = navController
            )
        }
        composable(route = "chapterListing") {
            ChapterListingScreen(
                navController = navController
            )
        }
        composable(route = "topicDescription") {
            TopicDescriptionScreen(
                navController = navController
            )
        }
        composable(route = "assessmentDetails"){
            AssessmentDetailsScreen(
                navController = navController
            )
        }
    }
}