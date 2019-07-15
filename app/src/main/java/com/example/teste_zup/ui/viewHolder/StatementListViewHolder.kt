package com.example.teste_zup.ui.viewHolder

import android.annotation.SuppressLint
import android.content.Context
import android.view.View
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.teste_zup.R
import com.example.teste_zup.model.Statement
import kotlinx.android.synthetic.main.user_details_appbar.view.*
import kotlinx.android.synthetic.main.user_statement_list_item.view.*
import java.text.DateFormat
import java.time.format.DateTimeFormatter
import java.text.SimpleDateFormat
import java.util.*


class StatementListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private val title = itemView.textStatementTitle;

    private val description = itemView.textDescription;

    private val date = itemView.textDateTitle;

    private val value = itemView.textValue;

    val context = itemView.context


    @SuppressLint("SimpleDateFormat")
    fun bind(statement : Statement){

        title.setText(statement.title)

        description.setText(statement.description)

        date.setText(statement.date.toString())

        value.setText(statement.value.toString())

        if (statement.value > 0){
            value.setTextColor(ContextCompat.getColor(this.context,R.color.positive_green))
        }else{
            value.setTextColor(ContextCompat.getColor(this.context,R.color.negative_red))
        }

    }
}