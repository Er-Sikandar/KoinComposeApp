package com.ex.composeapp.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp

class TextSize(
    val XXXSmall: TextUnit,
    val XXSmall: TextUnit,
    val XSmall: TextUnit,
    val Small: TextUnit,
    val Normal: TextUnit,
    val Medium: TextUnit,
    val Large: TextUnit,
    val XLarge: TextUnit,
    val XXLarge: TextUnit,
    val XXXLarge: TextUnit,
    val Text24: TextUnit,
    val Text26: TextUnit,
    val Text28: TextUnit,
    val Text30: TextUnit,
    val Text32: TextUnit
)

val SmallTextSizes = TextSize(
    XXXSmall = 4.sp,
    XXSmall = 6.sp,
    XSmall = 8.sp,
    Small = 10.sp,
    Normal = 12.sp,
    Medium = 14.sp,
    Large = 16.sp,
    XLarge = 18.sp,
    XXLarge = 20.sp,
    XXXLarge = 22.sp,
    Text24 = 24.sp,
    Text26 = 26.sp,
    Text28 = 28.sp,
    Text30 = 30.sp,
    Text32 = 32.sp
)

val LargeTextSizes = TextSize(
    XXXSmall = 6.sp,
    XXSmall = 8.sp,
    XSmall = 10.sp,
    Small = 12.sp,
    Normal = 14.sp,
    Medium = 16.sp,
    Large = 18.sp,
    XLarge = 20.sp,
    XXLarge = 22.sp,
    XXXLarge = 24.sp,
    Text24 = 24.sp,
    Text26 = 26.sp,
    Text28 = 28.sp,
    Text30 = 30.sp,
    Text32 = 32.sp
)

val LocalTextSizes = staticCompositionLocalOf {
    SmallTextSizes
}

val MaterialTheme.textSizes: TextSize
    @Composable
    get() = LocalTextSizes.current