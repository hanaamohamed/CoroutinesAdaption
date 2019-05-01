package com.example.coroutines.authentication.login

import com.example.coroutines.authentication.UserRepository
import com.example.coroutines.comon.dispatchers.BaseDispatchers
import com.example.coroutines.comon.mvp.BasePresenter
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

class LoginPresenter(loginView: LoginView, private val userRepository: UserRepository, baseDispatchers: BaseDispatchers) :
        BasePresenter<LoginView, UserRepository>(loginView, userRepository, baseDispatchers = baseDispatchers) {

    private val coroutineScope: CoroutineScope = CoroutineScope(baseDispatchers.runOnMainDispatcher())

    init {
        userRepository.provideCoroutineScope(coroutineScope)
    }


    fun login(email: String, password: String) {
        coroutineScope.launch {
            try {
                val login = userRepository.loginAsync(email, password).await()
                view?.onSuccessfullyLoggedIn(login.token)
            } catch (ex: Exception) {
                view?.onErrorOccurred()
            }
        }

    }


}