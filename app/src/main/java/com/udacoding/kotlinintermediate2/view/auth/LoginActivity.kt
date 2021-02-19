package com.udacoding.kotlinintermediate2.view.auth

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import com.google.android.material.textfield.TextInputLayout
import com.udacoding.kotlinintermediate2.R
import com.udacoding.kotlinintermediate2.helper.SessionManager
import com.udacoding.kotlinintermediate2.model.auth.DataItemAuth
import com.udacoding.kotlinintermediate2.presenter.auth.LoginPresenter
import com.udacoding.kotlinintermediate2.view.MainActivity
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity(), View.OnClickListener, LoginPresenter.LoginView {

    private val TAG = "LoginActivity"
    private var presenter: LoginPresenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        presenter = LoginPresenter(this)

        tv_login_daftar?.setOnClickListener(this)
        btn_login.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v){
            tv_login_daftar -> {
                startActivity(Intent(this, RegisterActivity::class.java))
            }

            btn_login -> {
                val email = edt_login_email.editText?.text.toString().trim()
                val password = edt_login_password.editText?.text.toString().trim()

                errorField(edt_login_email)
                errorField(edt_login_password)

                var isEmptyField = false

                when{
                    email.isEmpty() -> {
                        isEmptyField = true
                        edt_login_email.error = "Email tidak boleh kosong"
                    }

                    password.isEmpty() -> {
                        isEmptyField = true
                        edt_login_password.error = "Password tidak boleh kosong"
                    }

                    password.length < 6 -> {
                        edt_login_password.error = "Password terlalu pendek"
                    }
                }

                if (!isEmptyField){
                    presenter?.login(email, password)
                }
            }
        }
    }

    private fun errorField(s: TextInputLayout){
        if(s.editText?.text != null){
            s.isErrorEnabled = false
        }
    }

    override fun onSuccess(msg: Boolean, user: List<DataItemAuth>?) {
        val session = SessionManager(this)
        session.nama = user?.get(0)?.userNama
        session.email = user?.get(0)?.userEmail
        session.hp = user?.get(0)?.userHp
        session.login = true

        Toast.makeText(this, "Berhasil login", Toast.LENGTH_SHORT).show()
        startActivity(Intent(this, MainActivity::class.java))
    }

    override fun onError(msg: String) {
        Log.d(TAG, msg)
    }
}