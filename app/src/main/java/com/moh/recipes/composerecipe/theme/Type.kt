package com.moh.recipes.composerecipe.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.moh.recipes.composerecipe.R

val Roboto = FontFamily(
    Font(R.font.roboto_light, FontWeight.Light),
    Font(R.font.roboto_light_italic, FontWeight.Light, FontStyle.Italic),
    Font(R.font.roboto_regular, FontWeight.Normal),
    Font(R.font.roboto_italic, FontWeight.Normal, FontStyle.Italic),
    Font(R.font.roboto_medium, FontWeight.Medium),
    Font(R.font.roboto_medium_italic, FontWeight.Medium, FontStyle.Italic),
    Font(R.font.roboto_bold, FontWeight.Bold),
    Font(R.font.roboto_bold_italic, FontWeight.Bold, FontStyle.Italic),
    Font(R.font.roboto_black, FontWeight.Black),
    Font(R.font.roboto_black_italic, FontWeight.Black, FontStyle.Italic),
    Font(R.font.roboto_thin, FontWeight.Thin),
    Font(R.font.roboto_thin_italic, FontWeight.Thin, FontStyle.Italic)
)

val Karla = FontFamily(
    Font(R.font.karla_regular),
    Font(R.font.karla_bold, FontWeight.Bold)
)

val sampleTypography = Typography(
    h1 = TextStyle(
        fontFamily = Roboto,
        fontSize = 96.sp,
        fontWeight = FontWeight.Light,
        lineHeight = 117.sp,
        letterSpacing = (-1.5).sp
    ),
    h2 = TextStyle(
        fontFamily = Roboto,
        fontSize = 60.sp,
        fontWeight = FontWeight.Light,
        lineHeight = 73.sp,
        letterSpacing = (-0.5).sp
    ),
    h3 = TextStyle(
        fontFamily = Roboto,
        fontSize = 48.sp,
        fontWeight = FontWeight.Normal,
        lineHeight = 59.sp
    ),
    h4 = TextStyle(
        fontFamily = Roboto,
        fontSize = 30.sp,
        fontWeight = FontWeight.SemiBold,
        lineHeight = 37.sp
    ),
    h5 = TextStyle(
        fontFamily = Roboto,
        fontSize = 24.sp,
        fontWeight = FontWeight.SemiBold,
        lineHeight = 29.sp
    ),
    h6 = TextStyle(
        fontFamily = Roboto,
        fontSize = 20.sp,
        fontWeight = FontWeight.SemiBold,
        lineHeight = 24.sp
    ),
    subtitle1 = TextStyle(
        fontFamily = Karla,
        fontSize = 16.sp,
        fontWeight = FontWeight.SemiBold,
        lineHeight = 24.sp,
        letterSpacing = 0.15.sp
    ),
    body1 = TextStyle(
        fontFamily = Karla,
        fontSize = 16.sp,
        fontWeight = FontWeight.Normal,
        lineHeight = 28.sp,
        letterSpacing = 0.15.sp
    ),
    button = TextStyle(
        fontFamily = Karla,
        fontSize = 14.sp,
        fontWeight = FontWeight.SemiBold,
        lineHeight = 16.sp,
        letterSpacing = 1.25.sp
    ),
    caption = TextStyle(
        fontFamily = Karla,
        fontSize = 12.sp,
        fontWeight = FontWeight.Bold,
        lineHeight = 16.sp,
        letterSpacing = 0.4.sp
    )
)
