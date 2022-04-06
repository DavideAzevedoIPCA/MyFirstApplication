package com.example.myfirstapplication.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
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

        val inflater = LayoutInflater.from(mContext)
        val rowView = inflater.inflate(mResources,parent,false)

        val textView = rowView.findViewById<TextView>(R.id.item_text)

        val value = mValues[position]

        textView.text = value

        return rowView
    }
}