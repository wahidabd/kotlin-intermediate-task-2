package com.udacoding.kotlinintermediate2.view.auth

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import com.google.android.material.textfield.TextInputLayout
import com.udacoding.kotlinintermediate2.R
import com.udacoding.kotlinintermediate2.model.auth.RegisterResponse
import com.udacoding.kotlinintermediate2.presenter.auth.RegisterPresenter
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : AppCompatActivity(), RegisterPresenter.RegisterView, View.OnClickListener {

    private val TAG = "RegisterActivity"
    private var presenter: RegisterPresenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        presenter = RegisterPresenter(this)
        btn_register.setOnClickListener(this)
        tv_register_login?.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v){
            btn_register -> {
                val name = edt_register_fullname.editText?.text.toString()
                val email = edt_register_email.editText?.text.toString().trim()
                val hp = edt_register_hp.editText?.text.toString().trim()
                val password = edt_register_password.editText?.text.toString().trim()

                errorField(edt_register_fullname)
                errorField(edt_register_email)
                errorField(edt_register_hp)
                errorField(edt_register_password)

                var isEmptyField = false

                when{
                    name.isEmpty() -> {
                        isEmptyField = true
                        edt_register_fullname.error = "Tidak boleh kosong"
                    }

                    email.isEmpty() -> {
                        isEmptyField = true
                        edt_register_email.error = "Tidak boleh kosong"
                    }

                    hp.isEmpty() -> {
                        isEmptyField = true
                        edt_register_hp.error = "Tidak boleh kosong"
                    }

                    password.isEmpty() -> {
                        edt_register_password.error = "Tidak boleh kosong"
                    }
                }

                if(!isEmptyField){
                    presenter?.register(name, email, hp, password)
                }
            }

            tv_register_login -> {
                startActivity(Intent(this, LoginActivity::class.java))
            }
        }
    }

    private fun errorField(s: TextInputLayout){
        if(s.editText?.text != null){
            s.isErrorEnabled = false
        }
    }

    override fun onSuccess(response: RegisterResponse) {
        Toast.makeText(this, "Berhasil mendaftar", Toast.LENGTH_SHORT).show()
        startActivity(Intent(this, LoginActivity::class.java))
    }

    override fun onError(msg: String) {
        Log.d(TAG, msg)
    }
}