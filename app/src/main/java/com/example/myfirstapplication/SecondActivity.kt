package com.example.myfirstapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewParent
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Spinner
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.PagerSnapHelper
import androidx.recyclerview.widget.RecyclerView
import com.example.myfirstapplication.adapters.MyAdapterRec
import com.example.myfirstapplication.adapters.MySimpleArrayAdapter
import java.text.FieldPosition

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val values = listOf<String>("Android","iPhone","WindowsMobile","Blackberry","webOS","Ubunto",
            "Windows7","Mac OS X", "Linux","OS/2","Android","iPhone","WindowsMobile","Blackberry","webOS","Ubunto",
            "Windows7","Mac OS X", "Linux","OS/2")

        val listView = findViewById<ListView>(R.id.second_listView)
        var adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1,values)
        listView.adapter=adapter

        val listView1 = findViewById<ListView>(R.id.second_listView1)
        var adapter1 = MySimpleArrayAdapter(this, R.layout.layout_item, values.toMutableList())
        listView1.adapter = adapter1

        val recyclerView = findViewById<RecyclerView>(R.id.second_recycler_view)
        recyclerView.adapter = MyAdapterRec(values)

        /*val linearLayoutManager = LinearLayoutManager(this) //para horizontal
        linearLayoutManager.orientation = LinearLayoutManager.HORIZONTAL //para horizontal
        recyclerView.layoutManager = linearLayoutManager //para horizontal*/
        recyclerView.layoutManager = LinearLayoutManager(this)
        PagerSnapHelper().attachToRecyclerView(recyclerView)

        val spinner = findViewById<Spinner>(R.id.second_spinner)
        if (spinner != null){
            val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item,
            values)
            spinner.adapter = adapter
        }
        spinner.onItemSelectedListener = object :
            AdapterView.OnItemSelectedListener {

            override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id:Long) {
            }
            override fun onNothingSelected(parent: AdapterView<*>?) {
            }
        }

    }

    fun doClose(view: View) {
        finish()
    }
}