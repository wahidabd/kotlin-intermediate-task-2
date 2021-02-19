package com.udacoding.kotlinintermediate2.model.crud

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class DataItem(

    @field:SerializedName("id")
    val id: String? = null,

    @field:SerializedName("nama")
    val nama: String? = null,

    @field:SerializedName("deskripsi")
    val deskripsi: String? = null,

    @field:SerializedName("sarat")
    val sarat: String? = null,

    @field:SerializedName("durasi")
    val durasi: String? = null

): Parcelable