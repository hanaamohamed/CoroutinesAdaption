package com.example.coroutines.authentication.login

import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import butterknife.BindView
import butterknife.OnClick
import com.example.coroutinekotlinarticle.R
import com.example.coroutines.authentication.UserRepository
import com.example.coroutines.comon.activities.BaseActivity

class LoginActivity : BaseActivity<LoginPresenter>(), LoginView {


    @BindView(R.id.et_email)
    lateinit var emailEt: EditText
    @BindView(R.id.et_password)
    lateinit var passwordEt: EditText
    @BindView(R.id.btn_login)
    lateinit var loginBtn: Button

    override fun getLayout(): Int = R.layout.activity_login

    override fun onSuccessfullyLoggedIn(token: String) {
        Toast.makeText(this, "logged in successfully: $token", Toast.LENGTH_LONG).show()
    }

    override fun onErrorOccurred() {
    }

    override fun createPresenter(): LoginPresenter = LoginPresenter(this,
            UserRepository(dispatcher), dispatcher)

    @OnClick(R.id.btn_login)
    fun onLoginButtonClicked() {
        Toast.makeText(this, "clicked", Toast.LENGTH_LONG).show()

        presenter?.login(email = emailEt.text.toString(), password = passwordEt.text.toString())
    }


}