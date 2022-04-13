package com.example.myfirstapplication.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.myfirstapplication.R


class MyAdapterRecViewHolder(inflater: LayoutInflater, val parent: ViewGroup) :
    RecyclerView.ViewHolder(inflater.inflate(R.layout.layout_item, parent, false)) {

    private var tv: TextView? = itemView.findViewById(R.id.item_text)

    fun bindData(text: String) {
        tv?.text = text
        itemView.setOnClickListener {
            Toast.makeText(parent.context,text,Toast.LENGTH_LONG).show()
        }
    }
}