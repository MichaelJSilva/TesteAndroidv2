package com.example.teste_zup.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
class StatementsApiResponse(
    @Json(name = "statementList") val statementList : List<Statement>

)