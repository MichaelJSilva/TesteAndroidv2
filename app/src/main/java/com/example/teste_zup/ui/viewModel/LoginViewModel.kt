package com.example.teste_zup.ui.viewModel

import androidx.lifecycle.ViewModel
import com.example.teste_zup.model.UserAccount
import kotlinx.coroutines.*
import com.example.teste_zup.network.repository.BankAccountRepository
import kotlin.coroutines.CoroutineContext

class LoginViewModel : ViewModel(),CoroutineScope{

    override val coroutineContext: CoroutineContext
        get() = Dispatchers.IO

    val repo = BankAccountRepository()


     fun authUser(user : String, password : String) : UserAccount {

        repo.userLogin(user, password);

        return repo.apiResponse!!.userAccount;


     }

}