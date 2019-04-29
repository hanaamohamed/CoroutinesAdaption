package com.example.coroutines.comon.mvp

import com.example.coroutines.comon.dispatchers.BaseDispatchers

abstract class BasePresenter<V : BaseView, R : BaseRepository,
        D : BaseDispatchers>(protected val view: V,
                             private val repository: R,
                             protected val baseDispatchers: D) {

    fun destroy() {
        repository.destroy()
    }

}