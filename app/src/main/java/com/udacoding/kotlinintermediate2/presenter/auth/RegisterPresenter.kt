package com.udacoding.kotlinintermediate2.presenter.auth

import com.udacoding.kotlinintermediate2.model.auth.RegisterResponse
import com.udacoding.kotlinintermediate2.network.ConfigNetwork
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers

class RegisterPresenter(val registerView: RegisterView) {

    fun register(name: String, email: String, hp: String, password: String){
        ConfigNetwork.getNetwork().register(name, email, hp, password)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                           registerView.onSuccess(it)
                }, {
                    registerView.onError(it.localizedMessage)
                })
    }

    interface RegisterView{
        fun onSuccess(response: RegisterResponse)
        fun onError(msg: String)
    }
}