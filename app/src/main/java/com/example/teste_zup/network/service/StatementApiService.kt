package com.example.teste_zup.network.service

import com.example.teste_zup.model.StatementsApiResponse
import com.example.teste_zup.util.AppConstants
import com.squareup.moshi.Moshi
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path


interface StatementApiService {

    @Headers("Content-Type: application/x-www-form-urlencoded")
    @GET(AppConstants.API_STATEMENT_PATH + "/{id}")
    fun getUserStatement(
        @Path("id") userID : Int
    ):Call<StatementsApiResponse>

    companion object{

        fun getinstance() : StatementApiService {

            val moshi = Moshi.Builder()
                .build()

            // faz a construção necessaria do service
            val retrofit : Retrofit = Retrofit.Builder()
                .baseUrl(AppConstants.API_BASE_URL)
                .addConverterFactory(MoshiConverterFactory.create(moshi))
                .build();

            // retorna o objeto criado do retrofit
            return retrofit.create(StatementApiService::class.java)

        }

    }
}