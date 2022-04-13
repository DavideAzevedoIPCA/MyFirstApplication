package com.example.myfirstapplication.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class MyAdapterRec(private val mList: List<String>) : RecyclerView.Adapter<MyAdapterRecViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyAdapterRecViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return MyAdapterRecViewHolder(inflater, parent)
    }

    override fun onBindViewHolder(holder: MyAdapterRecViewHolder, position: Int) {
        val text = mList.get(position) ?: "????!???"
        holder.bindData(text)
    }

    override fun getItemCount(): Int {
        return mList.size
    }
}