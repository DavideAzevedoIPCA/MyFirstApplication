package com.example.myfirstapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class HomeActivity : AppCompatActivity() {
    var name: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        name = intent.getStringExtra("name").toString()
        findViewById<TextView>(R.id.home_welcome_tv).text = getString(R.string.main_welcome) + " " + name


    }


}