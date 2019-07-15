package com.example.teste_zup.network.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.teste_zup.model.UserAccount
import com.example.teste_zup.model.UserAccountAPIResponse
import com.example.teste_zup.network.service.UserAccountApiService

class BankAccountRepository {

    var userAccount = MutableLiveData<UserAccount>();

    var apiResponse : UserAccountAPIResponse? = null

    fun getUserAccount() : LiveData<UserAccount>{
        return this.userAccount;
    }

    // autentica e loga o usuario no sistema
    fun userLogin (userLogin : String, userPassword : String) {

        val loginInstance = UserAccountApiService.getInstance();

        apiResponse = loginInstance.userLogin(userLogin,userPassword).execute().body();

    }

}