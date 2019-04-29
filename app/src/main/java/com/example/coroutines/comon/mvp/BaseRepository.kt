package com.example.coroutines.comon.mvp

import com.example.coroutines.comon.dispatchers.BaseDispatchers

abstract class BaseRepository {
    var baseDispatchers: BaseDispatchers

    constructor(baseDispatchers: BaseDispatchers) {
        this.baseDispatchers = baseDispatchers
    }

    abstract fun destroy()
}