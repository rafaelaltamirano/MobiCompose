package com.example.mobicomposeapp.ui.screen.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.example.mobicomposeapp.R
import com.example.mobicomposeapp.ui.theme.GrayText
import com.example.mobicomposeapp.ui.theme.White

@Composable
fun MovieHeader() {
    Box(contentAlignment = Alignment.BottomStart) {
        Image(painter = rememberAsyncImagePainter("https://images.milenio.com/_ycB6ifnB9xgxhIvJmfqHQKK2ZI=/936x566/uploads/media/2014/07/16/bob-esponja-ha-conquistado-tambien.jpeg"),
            contentDescription = "",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
                .height(232.dp)
                .drawWithCache {
                    val gradient = Brush.verticalGradient(
                        colors = listOf(Color.Transparent, Color.Black),
                        startY = size.height / 3,
                        endY = size.height
                    )
                    onDrawWithContent {
                        drawContent()
                        drawRect(gradient, blendMode = BlendMode.Multiply)
                    }
                }
        )
        Column( verticalArrangement = Arrangement.Bottom,modifier = Modifier.padding(
            dimensionResource(R.dimen.gap4)
        )) {
            Text(
                text = "The Big Hero 6 The series",
                style = MaterialTheme.typography.caption,
                color = White,
                modifier = Modifier
                    .fillMaxWidth(),
                maxLines = 1,
                textAlign = TextAlign.Left
            )
            Text(
                text = "The Big Hero 6",
                style = MaterialTheme.typography.h3,
                color = White,
                modifier = Modifier
                    .fillMaxWidth(),
                maxLines = 1,
                textAlign = TextAlign.Left
            )
            RatingBar(
                rating = 4.3, modifierStar = Modifier
                    .width(22.dp)
                    .height(22.dp)
            )

        }
    }
}

@Preview
@Composable
fun MovieHeaderPreview() {
    MovieHeader()
}