package com.example.teste_zup.model


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import java.util.Date

@JsonClass(generateAdapter = true)
data class Statement(
    @Json(name = "title")
    val title : String,
    @Json(name = "desc")
    val description : String,
    @Json(name = "date")
    val date : String,
    @Json(name = "value")
    val value: Double
)
