package com.example.mobicomposeapp.ui.screen.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.mobicomposeapp.R

@Composable
fun FilterCategory(
    onClick: () -> Unit,
    text: String = "",
    modifier: Modifier = Modifier,
    enabled:Boolean = true
) {
    Button(
        enabled = enabled,
        onClick = { onClick() },
        shape = RoundedCornerShape(50),
        modifier = modifier,
        contentPadding = PaddingValues(
            horizontal = dimensionResource(R.dimen.gap4),
            vertical = dimensionResource(R.dimen.gap2),
        )
    ) {
        Text(
            text,
            style = MaterialTheme.typography.button
        )
    }
}

@Preview(showBackground = true)
@Composable
fun FilterCategoryPreview() {
    FilterCategory(onClick = {}, "Top Rated")
}