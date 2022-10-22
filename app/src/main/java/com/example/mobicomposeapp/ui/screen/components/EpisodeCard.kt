package com.example.mobicomposeapp.ui.screen.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.example.mobicomposeapp.R
import com.example.mobicomposeapp.ui.theme.GrayText
import com.example.mobicomposeapp.ui.theme.Primary


@Composable
fun EpisodeCard(
    modifier: Modifier = Modifier
        .height(120.dp)
        .fillMaxWidth()
) {
    Card(
        modifier = modifier
            .padding(dimensionResource(R.dimen.gap2))
            .shadow(dimensionResource(R.dimen.gap2)),
        shape = MaterialTheme.shapes.medium,
        elevation = dimensionResource(R.dimen.gap2)
    ) {
        Row() {
            Box(contentAlignment = Alignment.Center) {
                Image(
                    painter = rememberAsyncImagePainter("https://indiehoy.com/wp-content/uploads/2020/07/bob-esponja.jpg"),
                    contentDescription = "logo",
                    modifier = Modifier
                        .width(112.dp)
                        .height(147.dp),
                    contentScale = ContentScale.Crop
                )
                Image(
                    painter = painterResource(R.drawable.ic_play),
                    contentDescription = "logo_play",
                    modifier = Modifier
                        .width(60.dp)
                        .height(60.dp),
                )

            }
            Box(
                Modifier
                    .fillMaxHeight()
                    .fillMaxWidth()
                    .padding(dimensionResource(R.dimen.gap4))) {
                Column() {
                    Text(
                        text = "Episode 1",
                        style = MaterialTheme.typography.h5,
                        color = GrayText,
                        modifier = Modifier
                            .fillMaxWidth(),
                        maxLines = 1,
                        textAlign = TextAlign.Left
                    )

                    Text(
                        text = "Escape From Beneath Glove World",
                        style = MaterialTheme.typography.body2,
                        color = GrayText,
                        modifier = Modifier
                            .fillMaxWidth(),
                        maxLines = 2,
                        textAlign = TextAlign.Left
                    )

                    Text(
                        text = "1h 14m",
                        style = MaterialTheme.typography.button,
                        color = Primary,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = dimensionResource(R.dimen.gap2)),
                        textAlign = TextAlign.Left
                    )

                }

            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun EpisodeCardPreview() {
    EpisodeCard()
}