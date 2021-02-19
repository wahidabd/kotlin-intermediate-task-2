package com.udacoding.kotlinintermediate2.presenter.auth

import com.udacoding.kotlinintermediate2.model.auth.DataItemAuth
import com.udacoding.kotlinintermediate2.network.ConfigNetwork
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers

class LoginPresenter(val loginView: LoginView) {

    fun login(email: String, password: String){
        ConfigNetwork.getNetwork().login(email, password)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    it.isSuccess?.let { it1 -> loginView.onSuccess(it1, it.data as List<DataItemAuth>?) }
                }, {
                    loginView.onError(it.localizedMessage)
                })
    }

    interface LoginView{
        fun onSuccess(msg: Boolean, user: List<DataItemAuth>?)
        fun onError(msg: String)
    }
}