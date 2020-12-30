package com.example.android4a.presentation.main

sealed class CreateStatus

data class CreateSucess(val email : String) : CreateStatus()
object CreateError : CreateStatus()