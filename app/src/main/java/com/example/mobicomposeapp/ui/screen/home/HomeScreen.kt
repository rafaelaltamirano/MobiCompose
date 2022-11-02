package com.example.mobicomposeapp.ui.screen.home

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.mobicomposeapp.AppConstants.LARGE_IMAGE_URL
import com.example.mobicomposeapp.R
import com.example.mobicomposeapp.ui.screen.components.FilmCard
import com.example.mobicomposeapp.ui.screen.components.FilterCategoryList
import com.example.mobicomposeapp.ui.screen.components.TopAppBar
import androidx.paging.compose.collectAsLazyPagingItems


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomeScreen(model: HomeModel, navController: NavHostController) {

    val allTvShows = model.requestTvShows.collectAsLazyPagingItems()


    Column() {
        TopAppBar(navController = navController, onClick = {})
        FilterCategoryList(
            categoryList = model.state.category,
            onClickItem = {
//                model.requestTvShows(it)
                }
        )

//        if (model.state.tvShows.isEmpty()) {
//            Text(
//                color = Color.LightGray,
//                textAlign = TextAlign.Center,
//                style = MaterialTheme.typography.caption,
//                text = "nada che"
//            )
//        } else {

            LazyVerticalGrid(
                cells = GridCells.Fixed(2),
                verticalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.gap3)),
                horizontalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.gap3)),
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = dimensionResource(R.dimen.gap4)),
                content = {
                    items(allTvShows.itemSnapshotList) {
                        if (it != null) {
                            FilmCard(
                                image = LARGE_IMAGE_URL + it.poster,
                                title = it.name,
                                rating = it.rating
                            )
                        }
                    }
                }
            )
//        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    HomeScreen(viewModel(), rememberNavController())
}