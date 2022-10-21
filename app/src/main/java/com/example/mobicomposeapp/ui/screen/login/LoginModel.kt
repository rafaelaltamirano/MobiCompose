package com.example.mobicomposeapp.ui.screen.login

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.viewModelScope
import com.example.domain.enums.Fields
import com.example.domain.exceptions.FieldInvalidException
import com.example.mobicomposeapp.ui.screen.ViewModelWithStatus
import com.example.usecase.LoginCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class LoginModel @Inject constructor(
    private val loginCase: LoginCase
) : ViewModelWithStatus() {

    var state by mutableStateOf(LoginState())
        private set

    private fun setLoading(loading: Boolean) {
        state = state.copy(loading = loading)
    }

    fun setEmail(email: String) {
        state = state.copy(email = email)
    }

    fun setPassword(password: String) {
        state = state.copy(password = password)
    }

    fun setEmailError(emailError: String = "") {
        state = state.copy(emailError = emailError)
    }

    fun setPasswordError(passwordError: String = "") {
        state = state.copy(passwordError = passwordError)
    }

    fun setLogin(login: Boolean) {
        state = state.copy(login = login)
    }


    suspend fun submit() = viewModelScope.launch {
        setLoading(true)
        if (state.email == "") setEmailError("Por favor, ingresa tu usuario")
        if (state.password == "") setPasswordError("Por favor, ingresa tu contraseña")
        try {
          withContext(IO){loginCase.login()}.also(::setLogin)
        } catch (e: Exception) {
            handleNetworkError(e)
        } finally {
            setLoading(false)
        }

    }

    override fun onFieldInvalid(e: FieldInvalidException) {
        when (e.field) {
            Fields.EMAIL -> setEmailError(e.message)
            Fields.PASSWORD -> setPasswordError(e.message)
            else -> {}
        }
        when (e.fieldSecond) {
            Fields.EMAIL -> setEmailError(e.message)
            Fields.PASSWORD -> setPasswordError(e.message)
            else -> {}
        }
    }


}