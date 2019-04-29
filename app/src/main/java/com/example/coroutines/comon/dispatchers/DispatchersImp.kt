package com.example.coroutines.comon.dispatchers

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

public class DispatchersImp: BaseDispatchers{
    override fun runOnIODispatcher(): CoroutineDispatcher = Dispatchers.IO

    override fun runOnMainDispatcher(): CoroutineDispatcher =  Dispatchers.Main


    override fun runOnDefaultDispatcher(): CoroutineDispatcher {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun runBlocking(): CoroutineDispatcher {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}