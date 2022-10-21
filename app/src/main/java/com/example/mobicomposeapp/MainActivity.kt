package com.example.mobicomposeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.mobicomposeapp.ui.router.Router
import com.example.mobicomposeapp.ui.screen.MainModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainComponent()
        }
    }
}
@Composable
fun MainComponent(mainModel: MainModel = viewModel()) {
    Router(mainModel)
}
