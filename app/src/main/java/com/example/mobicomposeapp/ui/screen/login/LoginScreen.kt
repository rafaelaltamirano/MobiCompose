package com.example.mobicomposeapp.ui.screen.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.mobicomposeapp.R
import com.example.mobicomposeapp.ui.screen.MainModel
import kotlinx.coroutines.launch


@Composable
fun LoginScreen(
    mainModel: MainModel,
    model: LoginModel,
    navController: NavController
) {
    val state = model.state
    val localFocusManager = LocalFocusManager.current
    val configuration = LocalConfiguration.current
    val coroutineScope = rememberCoroutineScope()

//    model.state.login?.also(mainModel::setLogin)

    Box(
        Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {

        Column(
            modifier = Modifier
                .width((configuration.screenWidthDp).dp)
                .height(configuration.screenHeightDp.dp)
                .padding(dimensionResource(R.dimen.gap5)),
            verticalArrangement = Arrangement.Center,
        ) {
            Image(
                painter = painterResource(R.drawable.vertical_logo),
                contentDescription = "logo_login",
                modifier = Modifier.padding(horizontal = dimensionResource(R.dimen.gap4))
            )


            Text(
               "Sing in to your account",
                style = MaterialTheme.typography.body1,
                color = Color.Black
            )
        }

    }

}


@Preview(showBackground = true)
@Composable
fun loginPreview() {
    LoginScreen(viewModel(),viewModel(), rememberNavController())
}