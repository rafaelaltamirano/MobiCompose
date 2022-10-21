package com.example.mobicomposeapp.ui.screen.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.mobicomposeapp.R
import com.example.mobicomposeapp.ui.theme.GradientEnd
import com.example.mobicomposeapp.ui.theme.GradientStart

@Composable
fun SplashScreen() {



    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        GradientStart,
                        GradientEnd
                    )
                )
            ),
    contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(R.drawable.horizontal_logo),
            contentDescription = "logo",
            modifier = Modifier.padding(horizontal = dimensionResource(R.dimen.gap4))
        )
    }

}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    SplashScreen()
}