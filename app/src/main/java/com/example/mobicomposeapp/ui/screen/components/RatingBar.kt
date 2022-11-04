package com.example.mobicomposeapp.ui.screen.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mobicomposeapp.R
import com.example.mobicomposeapp.ui.theme.TertiaryDark
import kotlin.math.ceil
import kotlin.math.floor


@Composable
fun RatingBar(
    modifierStar: Modifier = Modifier,
    rating: Float = 0.0f,
    stars: Int = 5,
    starsColor: Color = TertiaryDark,
) {

    val filledStars = floor(rating).toInt()
    val unfilledStars = (stars - ceil(rating)).toInt()
    val halfStar = !(rating.rem(1).equals(0.0))

    Row() {
        repeat(filledStars) {
            Icon(painter = painterResource(R.drawable.ic_star_fill),
                modifier = modifierStar.padding(dimensionResource(R.dimen.gap2)),
                contentDescription = null,
                tint = starsColor)
        }

        if (halfStar) {
            Icon(
                painter = painterResource(R.drawable.ic_star_half),
                modifier = modifierStar.padding(dimensionResource(R.dimen.gap2)),
                contentDescription = null,
                tint = starsColor
            )
        }

        repeat(unfilledStars) {
            Icon(
                painter = painterResource(R.drawable.ic_star_outline),
                contentDescription = null,
                modifier = modifierStar.padding(dimensionResource(R.dimen.gap2)),
                tint = starsColor
            )
        }
    }
}



@Preview
@Composable
fun RatingPreview() {
    RatingBar(rating = 2.5f)
}

@Preview
@Composable
fun TenStarsRatingPreview() {
    RatingBar(stars = 10, rating = 8.5f)
}

@Preview
@Composable
fun RatingPreviewFull() {
    RatingBar(rating = 5.0f)
}

@Preview
@Composable
fun RatingPreviewWorst() {
    RatingBar(rating = 1.0f)
}

@Preview
@Composable
fun RatingPreviewDisabled() {
    RatingBar(rating = 0.0f, starsColor = Color.Gray)
}