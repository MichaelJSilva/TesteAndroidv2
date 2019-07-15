package com.example.teste_zup.network.service


import com.example.teste_zup.model.UserAccountAPIResponse
import com.example.teste_zup.util.AppConstants
import com.squareup.moshi.Moshi
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.Headers
import retrofit2.http.POST

interface UserAccountApiService {

    @FormUrlEncoded
    @Headers("Content-Type: application/x-www-form-urlencoded")
    @POST(AppConstants.API_LOGIN_PATH)
    fun userLogin(
        @Field("user") user: String,
        @Field("password") password: String
    ): Call<UserAccountAPIResponse>


    companion object {

        fun getInstance() : UserAccountApiService {

            val moshi = Moshi.Builder()
                .build()


            // faz a construção necessaria do service
            val retrofit : Retrofit = Retrofit.Builder()
                .baseUrl(AppConstants.API_BASE_URL)
                .addConverterFactory(MoshiConverterFactory.create(moshi))
                .build();


            // retorna o objeto criado do retrofit
            return retrofit.create(UserAccountApiService::class.java)


        }


    }


}