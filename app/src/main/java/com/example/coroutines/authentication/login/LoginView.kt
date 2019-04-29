package com.example.coroutines.authentication.login

import com.example.coroutines.comon.mvp.BaseView

interface LoginView : BaseView {
    fun onSuccessfullyLoggedIn(token: String)
    fun onErrorOccurred()
}