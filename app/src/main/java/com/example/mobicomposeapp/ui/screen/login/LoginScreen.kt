package com.example.composetemplate.ui.screens.login

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.composetemplate.ui.screens.MainModel
import com.example.composetemplate.ui.screens.components.PublicHeader
import com.example.composetemplate.ui.screens.components.SubmitButton
import com.example.composetemplate.ui.screens.components.InputText
import com.example.mobicomposeapp.ui.screen.login.LoginModel
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

    model.state.login?.also(mainModel::setLogin)

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

            PublicHeader(R.string.app_name)

            InputText(
                value = state.email,
                onValueChange = model::setEmail,
                placeholder = R.string.email,
                keyboardType = KeyboardType.Email,
                error = state.emailError,
                onFocus = model::setEmailError,
            )

            Spacer(Modifier.height(dimensionResource(R.dimen.gap3)))

            InputText(
                value = state.password,
                onValueChange = model::setPassword,
                placeholder = R.string.password,
                error = state.passwordError,
                onFocus = model::setPasswordError,
                security = true,
                onDone = {
                    localFocusManager.clearFocus()
                    coroutineScope.launch {
                        model.submit()
                    }
                },
                maxLength = 10
            )

            Spacer(Modifier.weight(1.0f))

            SubmitButton(
                {
                    localFocusManager.clearFocus()
                    coroutineScope.launch {
                        model.submit()
                    }
                },
                text = R.string.login,
                loading = state.loading,
            )

            Spacer(Modifier.weight(1.0f))

        }

    }

}


@Preview(showBackground = true)
@Composable
fun loginPreview() {
    LoginScreen(viewModel(),viewModel(), rememberNavController())
}