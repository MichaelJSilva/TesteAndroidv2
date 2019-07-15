package com.example.teste_zup.ui.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.teste_zup.model.Statement
import com.example.teste_zup.network.repository.StatementRepository
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

class DetailsViewModel : ViewModel(), CoroutineScope {
    private lateinit var job : Job

    override val coroutineContext: CoroutineContext
        get() = Dispatchers.IO

    val repo = StatementRepository()

    val statements : MutableLiveData<List<Statement>> by lazy{
        MutableLiveData<List<Statement>>()
    }

    fun getStatementList(userID : Int) {

         launch {
             repo.getUserStatements(userID);

             statements.postValue(repo.statementList?.statementList)
         }

    }

}