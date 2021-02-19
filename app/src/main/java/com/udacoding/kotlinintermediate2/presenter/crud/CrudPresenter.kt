package com.udacoding.kotlinintermediate2.presenter.crud

import com.udacoding.kotlinintermediate2.model.crud.CrudResponse
import com.udacoding.kotlinintermediate2.network.ConfigNetwork
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers

class CrudPresenter(val crudView: CrudView) {

    fun insertData(nama: String, deskripsi: String, prasyarat: String, durasi: String){
        ConfigNetwork.getApi().input(nama, deskripsi, prasyarat, durasi)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                crudView.onSuccess(it)
            }, {
                crudView.onError(it.localizedMessage)
            })
    }

    fun delete(id: String){
        ConfigNetwork.getApi().delete(id)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                       crudView.onSuccess(it)
            }, {
                crudView.onError(it.localizedMessage)
            })
    }

    fun update(id: String, nama: String, deskripsi: String, sarat: String, durasi: String){
        ConfigNetwork.getApi().update(id, nama, deskripsi, sarat, durasi)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    crudView.onSuccess(it)
                }, {
                    crudView.onError(it.localizedMessage)
                })
    }

    interface CrudView{
        fun onSuccess(response: CrudResponse)
        fun onError(msg: String)
    }
}