package com.example.myapplication.data.account

sealed class CreateAccountEvent {
    data class NameChange(val name: String): CreateAccountEvent()
    data class EmailChange(val email: String): CreateAccountEvent()
    data class PasswordChange(val password: String): CreateAccountEvent()
    object ButtonClicked: CreateAccountEvent()
}