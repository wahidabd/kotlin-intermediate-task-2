package com.udacoding.kotlinintermediate2.network

import com.udacoding.kotlinintermediate2.model.crud.GetDataResponse
import com.udacoding.kotlinintermediate2.model.crud.CrudResponse
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {

    //Read
    @GET("getData.php")
    fun getData(): Observable<GetDataResponse>

    //Insert
    @FormUrlEncoded
    @POST("insert.php")
    fun input(
        @Field("nama")nama: String,
        @Field("deskripsi")deskripsi: String,
        @Field("sarat")sarat: String,
        @Field("durasi")durasi: String
    ):Single<CrudResponse>

    //Update
    @FormUrlEncoded
    @POST("update.php")
    fun update(
        @Field("id")id: String,
        @Field("nama")nama: String,
        @Field("deskripsi")deskripsi: String,
        @Field("sarat")sarat: String,
        @Field("durasi")durasi: String
    ):Single<CrudResponse>

    //Delete
    @FormUrlEncoded
    @POST("delete.php")
    fun delete(@Field("id")id: String):Observable<CrudResponse>
}