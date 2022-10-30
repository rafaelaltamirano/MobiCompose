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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.example.mobicomposeapp.R
import com.example.mobicomposeapp.ui.theme.GrayText

@Composable
fun FilmCard(
    modifier: Modifier = Modifier
        .height(216.dp)
        .width(156.dp),
    image: String,
    title: String,
    rating: Float
) {
    Card(
        modifier = modifier
            .padding(4.dp)
            .shadow(4.dp),
        shape = MaterialTheme.shapes.medium,
        elevation = 4.dp
    ) {
        Column {
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(image)
                    .crossfade(true)
                    .build(),
                contentDescription = null,
                placeholder = painterResource(R.drawable.ic_photo),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(136.dp),
                contentScale = ContentScale.Crop,

            )

            Spacer(Modifier.height(dimensionResource(R.dimen.gap4)))

            Box(
                Modifier
                    .fillMaxWidth()
                    .padding(start = dimensionResource(R.dimen.gap3))
            ) {
                Column() {
                    Text(
                        text = title,
                        style = MaterialTheme.typography.subtitle2,
                        color = GrayText,
                        modifier = Modifier
                            .fillMaxWidth(),
                        maxLines = 1,
                        textAlign = TextAlign.Left
                    )
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        RatingBar(rating = rating)
                        Spacer(Modifier.width(dimensionResource(R.dimen.gap3)))
                        Text(
                            text = rating.toString(),
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
    FilmCard(
        image = "https://indiehoy.com/wp-content/uploads/2020/07/bob-esponja.jpg",
        title = " bob esponja",
        rating = 2.0f
    )
}