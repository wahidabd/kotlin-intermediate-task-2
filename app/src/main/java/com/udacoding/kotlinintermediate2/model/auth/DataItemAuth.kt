package com.udacoding.kotlinintermediate2.model.auth

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class DataItemAuth(

        @field:SerializedName("user_nama")
        val userNama: String? = null,

        @field:SerializedName("user_email")
        val userEmail: String? = null,

        @field:SerializedName("user_password")
        val userPassword: String? = null,

        @field:SerializedName("user_hp")
        val userHp: String? = null,

        @field:SerializedName("id")
        val id: String? = null
): Parcelable
