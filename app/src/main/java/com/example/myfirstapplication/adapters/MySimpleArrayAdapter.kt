package com.example.myfirstapplication.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myfirstapplication.R

class MySimpleArrayAdapter(context: Context,resource: Int, objects: MutableList<String>)
    : ArrayAdapter<String>(context,resource,objects) {

        var mContext : Context
        var mValues : MutableList<String>
        var mResources : Int

        init{
            mContext = context
            mValues = objects
            mResources = resource
        }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view: View
        val vh: MyViewHolder

        if (convertView != null){
            view = convertView
        }
        else{
            view = LayoutInflater.from(context).inflate(R.layout.layout_item,parent,false)
            view.tag=MyViewHolder(view)
        }

        vh = view.tag as MyViewHolder

        vh.textView?.text = getItem(position)

        return view
    }

    private class MyViewHolder(view: View?){
        val textView = view?.findViewById<TextView>(R.id.item_text)
    }
}