package com.example.myapplication.data.login

data class LoginState(
    var email: String = "",
    var password: String = "",
    var emailError: Boolean = true,
    var passwordError: Boolean = true
)
