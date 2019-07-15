package com.example.teste_zup.ui.activity

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.teste_zup.R
import com.example.teste_zup.model.Statement
import com.example.teste_zup.model.UserAccount
import com.example.teste_zup.ui.adapter.StatementListAdapter
import com.example.teste_zup.ui.viewModel.DetailsViewModel
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.user_details_appbar.*
import java.text.DecimalFormat


class MainActivity : AppCompatActivity() {

    val USERACCOUNT_TAG = "UserAccount"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()

        val loadingProgress = screenLoading

        loadingProgress.show()

        val context : Context = this

        val userDetailsAccount = userDetailsAccount;

        val userDetailsBallance = userDetailsBalance;

        val mViewModel = ViewModelProviders.of(this).get(DetailsViewModel::class.java)

        val layoutManager = LinearLayoutManager(context,RecyclerView.VERTICAL,false)

        var statement : LiveData<List<Statement>>? = null

        var statementAdapter = StatementListAdapter(statement?.value)

        fun updateAdapter(statementList : List<Statement>){


            statementAdapter = StatementListAdapter(statementList)

            statementAdapter.statementList = statementList;

            rcvStatementList.adapter = statementAdapter;

            statementAdapter.notifyDataSetChanged()

            loadingProgress.hide()


        }

        val statementObserver = Observer<List<Statement>>{
                updatedList ->  updateAdapter(updatedList)
        }

        mViewModel.statements.observe(this,statementObserver)

        val userDetailsName = userDetailsName;

        val rcvStatementList = rcvStatementList;

        rcvStatementList.adapter = null

        rcvStatementList.layoutManager = layoutManager

        rcvStatementList.adapter = statementAdapter;


        var mUserAccount : UserAccount

        // atualiza os campos da appbar
        fun updateFields(userAccount: UserAccount){

            val accountText = String.format("%s / %s",userAccount.bankAccount,userAccount.agency)

            userDetailsAccount.setText(accountText)

            val format = DecimalFormat("R$ 0.###")

            val valorReal = format.format(userAccount.balance)

            userDetailsBallance.setText(valorReal)

            userDetailsName.setText(userAccount.name)

        }

        // carrega o resto dos dados baseado no user passado
        if (intent != null ){

            mUserAccount = intent.getParcelableExtra(USERACCOUNT_TAG);

            mViewModel.getStatementList(mUserAccount.userId)

            updateFields(mUserAccount)

        }

    }
}
