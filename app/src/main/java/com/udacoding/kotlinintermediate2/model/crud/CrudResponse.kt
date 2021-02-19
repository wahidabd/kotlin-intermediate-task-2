package com.udacoding.kotlinintermediate2.model.crud

import com.google.gson.annotations.SerializedName

data class CrudResponse(

	@field:SerializedName("message")
	val message: String? = null,

	@field:SerializedName("isSuccess")
	val isSuccess: Boolean? = null
)

