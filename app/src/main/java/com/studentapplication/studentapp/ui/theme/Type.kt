package com.studentapplication.studentapp.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.studentapplication.studentapp.R

val cherryBombFont = FontFamily(
    Font(R.font.cherry_bomb_one_regular, FontWeight.Normal)
)

val nunitoFont = FontFamily(
    Font(R.font.nunito_regular, FontWeight.Normal)
)
val nunitoItalic = FontFamily(
    Font(R.font.nunito_italic, FontWeight.Normal)
)

val interFont = FontFamily(
    Font(R.font.inter_regular, FontWeight.Normal)
)

val jostFont = FontFamily(
    Font(
        R.font.jost_regular, FontWeight.Normal
    )
)
val poppinsFont = FontFamily(
    Font(
        R.font.poppins_regular, FontWeight.Normal
    )
)
val plusJakartaSansFont = FontFamily(
    Font(
        R.font.plus_jakarta_sans_regular, FontWeight.Normal
    )
)
val openSansFont = FontFamily(
    Font(
        R.font.open_sans_regular, FontWeight.Normal
    )
)
val openSansItalic = FontFamily(
    Font(
        R.font.open_sans_italic, FontWeight.Normal
    )
)


// Set of Material typography styles to start with gh
val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = nunitoFont,
        fontWeight = FontWeight(700),
        fontSize = 40.sp,
        lineHeight = 54.56.sp,
    ),
    bodySmall = TextStyle(
        fontFamily = poppinsFont,
        fontWeight = FontWeight(500),
        fontSize = 20.sp,
        lineHeight = 30.sp
    ),
    labelLarge = TextStyle(
        fontFamily = cherryBombFont,
        fontWeight = FontWeight(400),
        fontSize = 30.sp,
        lineHeight = 43.44.sp,
        letterSpacing = 0.06.sp
    ),
    labelMedium = TextStyle(
        fontFamily = nunitoFont,
        fontWeight = FontWeight(400),
        fontSize = 16.sp,
        lineHeight = 21.82.sp,
    ),
    labelSmall = TextStyle(
        fontFamily = nunitoFont,
        fontWeight = FontWeight(300),
        fontSize = 14.sp,
        lineHeight = 19.1.sp,
    ),
    titleSmall = TextStyle(
        fontFamily = nunitoFont,
        fontWeight = FontWeight(500),
        fontSize = 18.sp,
        lineHeight = 24.55.sp,
    ),
    titleLarge = TextStyle(
        fontFamily = jostFont,
        fontWeight = FontWeight(700),
        fontSize = 25.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    ),
    titleMedium = TextStyle(
        fontFamily = jostFont,
        fontWeight = FontWeight(400),
        fontSize = 16.sp,
        lineHeight = 23.12.sp,
    ),
    bodyMedium = TextStyle(
        fontFamily = plusJakartaSansFont,
        fontWeight = FontWeight(800),
        fontSize = 16.sp,
        lineHeight = 20.16.sp
    ),
    headlineSmall = TextStyle(
        fontFamily = plusJakartaSansFont,
        fontWeight = FontWeight(600),
        fontSize = 12.sp,
        lineHeight = 15.12.sp
    ),


    /* Other default text styles to override
    titleLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 22.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp
    ),
    labelSmall = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Medium,
        fontSize = 11.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp
    )
    */
)