package com.example.teste_zup.model

import com.squareup.moshi.Json


data class Error(
    @Json(name = "code")     val code: Int,
    @Json(name = "message")  val message: String

)