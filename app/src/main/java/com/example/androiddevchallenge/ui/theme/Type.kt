/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.ui.theme.FontFamilyData.Companion.appFontFamily

// Set of Material typography styles to start with
val typography = Typography(
    h1 = TextStyle(
        fontFamily = appFontFamily,
        fontWeight = FontWeight.W700,
        fontSize = 18.sp,
        letterSpacing = 0.sp
    ),
    h2 = TextStyle(
        fontFamily = appFontFamily,
        fontWeight = FontWeight.W600,
        fontSize = 14.sp,
        letterSpacing = .15.sp
    ),
    subtitle1 = TextStyle(
        fontFamily = appFontFamily,
        fontWeight = FontWeight.W300,
        fontSize = 16.sp,
        letterSpacing = 0.sp
    ),

    body1 = TextStyle(
        fontFamily = appFontFamily,
        fontSize = 14.sp,
        letterSpacing = 0.sp,
        fontWeight = FontWeight.W300
    ),
    body2 = TextStyle(
        fontFamily = appFontFamily,
        fontSize = 12.sp,
        fontWeight = FontWeight.W300,
        letterSpacing = 0.sp
    ),

    // Other default text styles to override
    button = TextStyle(
        fontFamily = appFontFamily,
        fontSize = 14.sp,
        fontWeight = FontWeight.W600,
        letterSpacing = 1.sp
    ),
    caption = TextStyle(
        fontFamily = appFontFamily,
        fontSize = 12.sp,
        letterSpacing = 0.sp,
        fontWeight = FontWeight.W600
    ),

    //////////////////////////
//    body1 = TextStyle(
//        fontFamily = appFontFamily,
//        fontWeight = FontWeight.Normal,
//        fontSize = 16.sp
//    ),
//        // Other default text styles to override
//    button = TextStyle(
//        fontFamily = appFontFamily,
//        fontWeight = FontWeight.W500,
//        fontSize = 14.sp
//    ),
//    caption = TextStyle(
//        fontFamily = appFontFamily,
//        fontWeight = FontWeight.Normal,
//        fontSize = 12.sp
//    )
)
class FontFamilyData {

    companion object {
        val appFontFamily = FontFamily(
            fonts = listOf(
                Font(
                    resId = R.font.nunitosansbold, weight = FontWeight.W700,
                ),
                Font(resId = R.font.nunitosanssemibold, weight = FontWeight.W600),
                (Font(resId = R.font.nunitosanslight, weight = FontWeight.W300))
            )
        )
    }
}
