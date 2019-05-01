package com.example.coroutines.authentication

import com.example.coroutines.comon.dispatchers.BaseDispatchers
import com.example.coroutines.comon.models.User
import com.example.coroutines.comon.models.responses.RegisteredUserResponse
import com.example.coroutines.comon.mvp.BaseRepository
import kotlinx.coroutines.*

interface UserRepository: BaseRepository {

    fun provideCoroutineScope(coroutineScope: CoroutineScope)

    suspend fun registerUserAsync(userName: String, email: String, password: String): Deferred<User>


    suspend fun loginAsync(email: String, password: String): Deferred<RegisteredUserResponse>

}
