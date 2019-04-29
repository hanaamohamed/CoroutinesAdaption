package com.example.coroutines.authentication

import com.example.coroutines.comon.dispatchers.BaseDispatchers
import com.example.coroutines.comon.models.User
import com.example.coroutines.comon.models.responses.RegisteredUserResponse
import com.example.coroutines.comon.mvp.BaseRepository
import kotlinx.coroutines.*

class UserRepository(coroutineScope: CoroutineScope, dispatcher: BaseDispatchers) :
        BaseRepository(baseDispatchers = dispatcher) {

    private val coroutineScope = coroutineScope


    suspend fun registerUser(userName: String, email: String, password: String): Deferred<User> =
            coroutineScope!!.async(baseDispatchers.runOnIODispatcher()) {
                delay(1000)
                return@async getFakeUser(userName, email, password)
            }


    suspend fun login(email: String, password: String): Deferred<RegisteredUserResponse> =
            coroutineScope!!.async(baseDispatchers.runOnIODispatcher()) {
                delay(1000)
                var registeredUserResponse = RegisteredUserResponse()
                // for now leave the user name empty as we are returning a dummy user
                registeredUserResponse.user = getFakeUser("", email, password)
                return@async registeredUserResponse
            }

    private fun getFakeUser(userName: String, email: String, password: String): User {
        var user = User()
        user.name = userName
        user.email = email
        return user
    }

    override fun destroy() {
        coroutineScope?.cancel()
    }

}
