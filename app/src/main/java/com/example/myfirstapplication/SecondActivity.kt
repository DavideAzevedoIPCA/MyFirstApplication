package com.example.myfirstapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.ListView
import com.example.myfirstapplication.adapters.MySimpleArrayAdapter

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

    }

    fun doClose(view: View) {
        finish()
    }
}