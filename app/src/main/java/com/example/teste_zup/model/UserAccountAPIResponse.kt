package com.example.teste_zup.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class UserAccountAPIResponse(
    @Json(name = "userAccount") val userAccount: UserAccount,
    @Json(name = "error")       val error: Error
)