package com.example.coroutines.comon.dispatchers

import kotlinx.coroutines.CoroutineDispatcher

interface BaseDispatchers {

    fun runOnIODispatcher(): CoroutineDispatcher
    fun runOnMainDispatcher(): CoroutineDispatcher
    fun runOnDefaultDispatcher(): CoroutineDispatcher
    fun runBlocking(): CoroutineDispatcher
}