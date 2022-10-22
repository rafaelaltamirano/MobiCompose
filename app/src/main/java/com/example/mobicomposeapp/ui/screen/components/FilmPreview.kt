package com.example.mobicomposeapp.ui.screen.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.example.mobicomposeapp.R
import com.example.mobicomposeapp.ui.theme.GrayText

@Composable
fun FilmCard(
    modifier: Modifier = Modifier
        .height(216.dp)
        .width(156.dp)
) {
    Card(
        modifier = modifier
            .padding(4.dp)
            .shadow(4.dp),
        shape = MaterialTheme.shapes.medium,
        elevation = 4.dp
    ) {
        Column {
            Image(
                painter = rememberAsyncImagePainter("https://indiehoy.com/wp-content/uploads/2020/07/bob-esponja.jpg"),
                contentDescription = "logo",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(136.dp),
                contentScale = ContentScale.Crop
            )
            Spacer(Modifier.height(dimensionResource(R.dimen.gap4)))

            Box(
                Modifier
                    .fillMaxWidth()
                    .padding(start = dimensionResource(R.dimen.gap3))) {
                Column() {
                    Text(
                        text = "Bob Esponja",
                        style = MaterialTheme.typography.subtitle2,
                        color = GrayText,
                        modifier = Modifier
                            .fillMaxWidth(),
                        maxLines = 1,
                        textAlign = TextAlign.Left
                    )
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        RatingBar(rating = 5.0)
                        Spacer(Modifier.width(dimensionResource(R.dimen.gap3)))
                        Text(
                            text = "5",
                            style = MaterialTheme.typography.body2,
                            color = GrayText,
                            modifier = Modifier
                                .fillMaxWidth(),
                            maxLines = 1,
                            textAlign = TextAlign.Left
                        )
                    }
                }

            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun FilmCardPreview() {
    FilmCard()
}