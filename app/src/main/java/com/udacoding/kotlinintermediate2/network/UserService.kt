package com.udacoding.kotlinintermediate2.network

import com.udacoding.kotlinintermediate2.model.auth.LoginResponse
import com.udacoding.kotlinintermediate2.model.auth.RegisterResponse
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface UserService {
    @FormUrlEncoded
    @POST("register.php")
    fun register(
        @Field("nama")nama : String,
        @Field("email")email : String,
        @Field("nohp")nohp : String,
        @Field("password")password : String
    ): Single<RegisterResponse>

    @FormUrlEncoded
    @POST("login.php")
    fun login(
        @Field("email")email : String,
        @Field("password")password : String
    ): Observable<LoginResponse>
}