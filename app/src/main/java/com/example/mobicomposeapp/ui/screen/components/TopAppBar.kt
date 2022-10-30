package com.example.mobicomposeapp.ui.screen.components

import android.provider.MediaStore
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.*

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.mobicomposeapp.ui.theme.GrayText
import com.example.mobicomposeapp.ui.theme.Icons
import com.example.mobicomposeapp.ui.theme.White
import kotlinx.coroutines.launch

@Composable
fun TopAppBar(
    navController: NavController,
    onClick: (() -> Unit)? = null,
) {

    TopAppBar(
        title = {
            Text(
                text = "Text",
                style = MaterialTheme.typography.h6,
                color = Color.White,
                textAlign = TextAlign.Left
            )
        },
        actions = {
            AnimatedVisibility(
                visible = true,
                enter = slideInVertically(initialOffsetY = { -it }),
                exit = slideOutVertically(targetOffsetY = { -it }),
                content = {
                    IconButton(onClick = { }) {
                        Icon(
                            painterResource(Icons.search),
                            contentDescription = "search",
                            tint = White
                        )
                    }
                })
            AnimatedVisibility(
                visible = true,
                enter = slideInVertically(initialOffsetY = { -it }),
                exit = slideOutVertically(targetOffsetY = { -it }),
                content = {
                    IconButton(onClick = { }) {
                        Icon(
                            painterResource(Icons.profile),
                            contentDescription = "profile",
                            tint = White
                        )
                    }
                })

        }
    )

}

@Preview
@Composable
fun PreviewTopBar() {
    TopAppBar(rememberNavController())
}