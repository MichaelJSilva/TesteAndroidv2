package com.example.teste_zup.ui.adapter


import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.teste_zup.R
import com.example.teste_zup.model.Statement
import com.example.teste_zup.ui.viewHolder.StatementListViewHolder

class StatementListAdapter(var statementList: List<Statement>? = null) : RecyclerView.Adapter<StatementListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StatementListViewHolder {

        val context : Context = parent.context

        val layoutInflater = LayoutInflater.from(context);

        val view : View = layoutInflater.inflate(R.layout.user_statement_list_item,parent,false);

        return StatementListViewHolder(view)


    }

    override fun getItemCount(): Int {

        if (statementList == null){
            return 0
        }else{
            return statementList!!.size
        }
    }

    override fun onBindViewHolder(holder: StatementListViewHolder, position: Int) {

        val currentStatement : Statement = statementList!!.get(position)

        holder.bind(currentStatement);


    }


}