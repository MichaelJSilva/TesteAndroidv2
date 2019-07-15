package com.example.teste_zup.network.repository


import androidx.lifecycle.MutableLiveData
import com.example.teste_zup.model.Statement
import com.example.teste_zup.model.StatementsApiResponse
import com.example.teste_zup.network.service.StatementApiService

class StatementRepository {

    var statementList : StatementsApiResponse? = null

    var statements : MutableLiveData<List<Statement>>? = null;

    val statementService = StatementApiService.getinstance();


    suspend fun getUserStatements(userID : Int){

        statementList = statementService.getUserStatement(userID).execute().body();

        statements?.value = statementList?.statementList

    }


}