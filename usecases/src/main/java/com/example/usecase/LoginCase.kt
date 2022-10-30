package com.example.usecase

import com.example.domain.model.Login


class LoginCase(

) {

    suspend fun login(): Login {
        return Login(1, "rafa", "rafa@gmail.com")

    }
}

