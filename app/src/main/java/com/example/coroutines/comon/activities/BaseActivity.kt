package com.example.coroutines.comon.activities

import android.os.Bundle
import android.support.annotation.IntegerRes
import android.support.annotation.LayoutRes
import android.support.v7.app.AppCompatActivity
import butterknife.ButterKnife
import butterknife.Unbinder
import com.example.coroutines.comon.dispatchers.DispatchersImp
import com.example.coroutines.comon.mvp.BasePresenter
import com.example.coroutines.comon.mvp.BaseRepository
import com.example.coroutines.comon.mvp.BaseView

abstract class BaseActivity<P : BasePresenter<out BaseView, out BaseRepository>>
    : AppCompatActivity(), BaseView {

    private lateinit var bind: Unbinder
    var presenter: P? = null
    var dispatcher = DispatchersImp()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayout())
        bind = ButterKnife.bind(this)
        presenter = createPresenter()
    }


    @LayoutRes
    abstract fun getLayout(): Int

    abstract fun createPresenter(): P
    override fun onDestroy() {
        presenter?.destroy()
        presenter = null
        bind.unbind()
        super.onDestroy()
    }


}