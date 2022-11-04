package com.example.mobicomposeapp.ui.screen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mobicomposeapp.R
import com.example.mobicomposeapp.ui.screen.home.TvShowTypes
import com.example.mobicomposeapp.ui.theme.Gray
import com.example.mobicomposeapp.ui.theme.GrayDark
import com.example.mobicomposeapp.ui.theme.Primary

@Composable
fun FilterCategoryItem(
    onClick: () -> Unit,
    text: String = "",
    enabled: Boolean = true
) {
    Text(
        text = text,
        style = MaterialTheme.typography.button,
        color = if (enabled) {
            Color.White
        } else {
            GrayDark
        },
        modifier = Modifier
            .clip(
                shape = RoundedCornerShape(
                    size = 50.dp,
                ),
            )
            .clickable {
                onClick()
            }
            .background(
                if (enabled) {
                    Primary
                } else {
                    Gray
                }
            )
            .padding(
                vertical = dimensionResource(R.dimen.gap3),
                horizontal = dimensionResource(R.dimen.gap4),
            ),
    )
}


@Composable
fun FilterCategoryList(
    onClickItem: (String) -> Unit,
    categoryList: Map<TvShowTypes, String> = emptyMap(),
) {
    var selectedOption by remember {
        mutableStateOf(categoryList.firstNotNullOf {(url,category)  -> url.url })
    }
    val onSelectionChange = { text: String ->
        selectedOption = text
    }
    Row(
        modifier = Modifier
            .padding(
                start = dimensionResource(R.dimen.gap4),
                top = dimensionResource(R.dimen.gap5),
                bottom = dimensionResource(R.dimen.gap5)
            )
            .horizontalScroll(rememberScrollState())
    ) {
        categoryList.forEach { (url,category) ->
            FilterCategoryItem(
                onClick = {
                    onSelectionChange(url.url)
                    onClickItem(url.url)
                },
                text = category,
                enabled = url.url == selectedOption
            )
            Spacer(modifier = Modifier.width(dimensionResource(R.dimen.gap2)))

        }
    }
}


@Preview(showBackground = true)
@Composable
fun FilterCategoryPreview() {
    FilterCategoryItem(onClick = {}, "Top Rated")
}