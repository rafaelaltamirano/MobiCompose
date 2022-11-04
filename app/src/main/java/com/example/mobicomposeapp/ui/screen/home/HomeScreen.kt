package com.example.mobicomposeapp.ui.screen.home

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import androidx.paging.LoadState
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.items
import com.example.mobicomposeapp.R
import com.example.mobicomposeapp.ui.screen.components.FilmCard
import com.example.mobicomposeapp.ui.screen.components.FilterCategoryList
import com.example.mobicomposeapp.ui.screen.components.TopAppBar
import com.example.mobicomposeapp.ui.theme.Primary
import com.example.mobicomposeapp.utils.AppConstants.LARGE_IMAGE_URL
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.SwipeRefreshIndicator
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomeScreen(model: HomeModel, navController: NavHostController) {

    val allTvShows = model.state.tvShows.collectAsLazyPagingItems()
    val state = model.state

    Column() {
        TopAppBar(navController = navController, onClick = {})
        FilterCategoryList(
            categoryList = model.state.category,
            onClickItem = {
                allTvShows.refresh()
                model.setMediator(true)
                model.requestTvShows(it)
            }
        )
        //avoid blinking in initial load
        val refreshState = if (state.mediator) {
            allTvShows.loadState.mediator?.refresh
        } else {
            allTvShows.loadState.source.refresh
        }
        if (refreshState is LoadState.Loading) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(start = 20.dp, end = 20.dp, top = 60.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                CircularProgressIndicator(
                    Modifier
                        .width(37.dp)
                        .height(40.dp)
                        .fillMaxSize(),
                )
            }
        } else if (refreshState is LoadState.Error) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(start = 20.dp, end = 20.dp, top = 60.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Text(
                    color = Color.LightGray,
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.caption,
                    text = "Error Loading"
                )
            }
        } else {
            SwipeRefresh(
                state = rememberSwipeRefreshState(state.loading),
                onRefresh = { allTvShows.refresh() },
                indicator = { state, trigger ->
                    SwipeRefreshIndicator(
                        state = state,
                        refreshTriggerDistance = trigger,
                        contentColor = Primary
                    )
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
            ) {
//                LazyVerticalGrid(
//                    cells = GridCells.Fixed(2),
//                    verticalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.gap3)),
//                    horizontalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.gap3)),
//                    modifier = Modifier
//                        .fillMaxSize()
//                        .padding(horizontal = dimensionResource(R.dimen.gap4)),
//                    content = {
//                        items(allTvShows.itemSnapshotList) {
//                            if (it != null) {
//                                FilmCard(
//                                    image = LARGE_IMAGE_URL + it.poster,
//                                    title = it.name,
//                                    rating = it.rating
//                                )
//                            }
//                        }
//                    }
//                )
                LazyColumn(
                    modifier = Modifier.fillMaxSize(),
                    contentPadding = PaddingValues(all = 12.dp),
                    verticalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    items(allTvShows) {
                            if (it != null) {
                                FilmCard(
                                    image = LARGE_IMAGE_URL + it.poster,
                                    title = it.name,
                                    rating = it.rating
                                )
                            }
                        }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    HomeScreen(viewModel(), rememberNavController())
}


