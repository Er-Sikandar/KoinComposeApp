package com.ex.composeapp.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

class Dimensions(
    val grid_0_25: Dp,
    val grid_0_5: Dp,
    val grid_1: Dp,
    val grid_1_5: Dp,
    val grid_2: Dp,
    val grid_2_5: Dp,
    val grid_3: Dp,
    val grid_3_5: Dp,
    val grid_4: Dp,
    val grid_4_5: Dp,
    val grid_5: Dp,
    val grid_5_5: Dp,
    val grid_6: Dp,
    val grid_8: Dp,
    val grid_9: Dp,
    val grid_10: Dp,
    val grid_12: Dp,
    val grid_14: Dp,
    val grid_15: Dp,
    val grid_16: Dp,
    val grid_17: Dp,
    val grid_18: Dp,
    val grid_19: Dp,
    val grid_20: Dp,
    val grid_21: Dp,
    val grid_23: Dp,
    val grid_25: Dp,
    val plane_0: Dp,
    val plane_1: Dp,
    val plane_2: Dp,
    val plane_3: Dp,
    val plane_4: Dp,
    val plane_5: Dp,
    val minimum_touch_target: Dp = 48.dp,
)

val smallDimensions = Dimensions(
    grid_0_25 = 1.5f.dp,
    grid_0_5 = 3.dp,
    grid_1 = 6.dp,
    grid_1_5 = 9.dp,
    grid_2 = 12.dp,
    grid_2_5 = 15.dp,
    grid_3 = 18.dp,
    grid_3_5 = 21.dp,
    grid_4 = 24.dp,
    grid_4_5 = 27.dp,
    grid_5 = 30.dp,
    grid_5_5 = 33.dp,
    grid_6 = 36.dp,
    grid_8 = 48.dp,
    grid_9 = 54.dp,
    grid_10 = 60.dp,
    grid_12 = 72.dp,
    grid_14 = 84.dp,
    grid_15 = 90.dp,
    grid_16 = 96.dp,
    grid_17 = 102.dp,
    grid_18 = 108.dp,
    grid_19 = 114.dp,
    grid_20 = 120.dp,
    grid_21 = 126.dp,
    grid_23 = 132.dp,
    grid_25 = 138.dp,
    plane_0 = 0.dp,
    plane_1 = 1.dp,
    plane_2 = 2.dp,
    plane_3 = 3.dp,
    plane_4 = 6.dp,
    plane_5 = 12.dp
)

val sw360Dimensions = Dimensions(
    grid_0_25 = 2.dp,
    grid_0_5 = 4.dp,
    grid_1 = 8.dp,
    grid_1_5 = 12.dp,
    grid_2 = 16.dp,
    grid_2_5 = 20.dp,
    grid_3 = 24.dp,
    grid_3_5 = 28.dp,
    grid_4 = 32.dp,
    grid_4_5 = 36.dp,
    grid_5 = 40.dp,
    grid_5_5 = 44.dp,
    grid_6 = 48.dp,
    grid_8 = 64.dp,
    grid_9 = 72.dp,
    grid_10 = 80.dp,
    grid_12 = 96.dp,
    grid_14 = 112.dp,
    grid_15 = 120.dp,
    grid_16 = 128.dp,
    grid_17 = 136.dp,
    grid_18 = 144.dp,
    grid_19 = 152.dp,
    grid_20 = 160.dp,
    grid_21 = 168.dp,
    grid_23 = 176.dp,
    grid_25 = 184.dp,
    plane_0 = 0.dp,
    plane_1 = 1.dp,
    plane_2 = 2.dp,
    plane_3 = 4.dp,
    plane_4 = 8.dp,
    plane_5 = 16.dp
)

val LocalAppDimens = staticCompositionLocalOf {
    smallDimensions
}

val MaterialTheme.dimens: Dimensions
    @Composable
    get() = LocalAppDimens.current