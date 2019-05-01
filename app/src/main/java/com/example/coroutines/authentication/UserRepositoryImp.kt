package com.example.coroutines.authentication

import com.example.coroutines.comon.dispatchers.BaseDispatchers
import com.example.coroutines.comon.models.User
import com.example.coroutines.comon.models.responses.RegisteredUserResponse
import kotlinx.coroutines.*

class UserRepositoryImp(private var baseDispatchers: BaseDispatchers) :
        UserRepository {


    private var coroutineScope: CoroutineScope? = null

    override suspend fun registerUserAsync(userName: String, email: String, password: String): Deferred<User> =
            coroutineScope!!.async(baseDispatchers.runOnIODispatcher()) {
                delay(1000)
                return@async getFakeUser(userName, email, password)
            }

    override suspend fun loginAsync(email: String, password: String): Deferred<RegisteredUserResponse> =
            coroutineScope!!.async(baseDispatchers.runOnIODispatcher()) {
                delay(1000)
                val registeredUserResponse = RegisteredUserResponse()
                // for now leave the user name empty as we are returning a dummy user
                registeredUserResponse.user = getFakeUser("", email, password)
                return@async registeredUserResponse
            }


    override fun provideCoroutineScope(coroutineScope: CoroutineScope) {
        this.coroutineScope = coroutineScope
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
