package com.example.coroutines.comon.mvp

import com.example.coroutines.comon.dispatchers.BaseDispatchers

abstract class BasePresenter<V : BaseView, R : BaseRepository>(protected var view: V?,
                             private val repository: R,
                             protected val baseDispatchers: BaseDispatchers) {


    fun destroy() {
        repository.destroy()
        view = null
    }

}