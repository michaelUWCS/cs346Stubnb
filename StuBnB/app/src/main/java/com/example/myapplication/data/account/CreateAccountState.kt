package com.example.myapplication.data.account

data class CreateAccountState (
    var name: String = "",
    var email: String = "",
    var password: String = "",
    var nameError: Boolean = true,
    var emailError: Boolean = true,
    var passwordError: Boolean = true
)