package com.amrita.affirmaionsapp.adapter

import android.content.Context
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.amrita.affirmaionsapp.R
import com.amrita.affirmaionsapp.model.Affirmations

class ItemAdapter(private val context: Context,private val dataset: List<Affirmations>) {
    class ItemViewHolder(private val view:View):RecyclerView.ViewHolder(view){
        val textview:TextView = view.findViewById(R.id.item_title)
    }
}