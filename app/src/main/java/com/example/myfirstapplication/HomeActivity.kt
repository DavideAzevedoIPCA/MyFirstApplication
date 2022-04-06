package com.example.myfirstapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import com.example.myfirstapplication.models.User
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.EventListener
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class HomeActivity : AppCompatActivity() {
    var name: String = ""
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

//        name = intent.getStringExtra("name").toString()
//        findViewById<TextView>(R.id.home_welcome_tv).text = getString(R.string.main_welcome) + " " + name

        auth = FirebaseAuth.getInstance()
        var uid = auth.currentUser!!.uid
        val db = Firebase.firestore

        db.collection("users")
            .document(uid).addSnapshotListener(EventListener { value, error ->
                val name = value!!["name"].toString()
                findViewById<TextView>(R.id.home_welcome_tv).setText(name!!)
            })

    }

    fun doUpdate(view: View) {
        val name = findViewById<EditText>(R.id.home_name_et).text.toString()
        val mapName = hashMapOf<String, Any?>("name" to name)
        var uid = auth.currentUser!!.uid
        val db = Firebase.firestore
        db.collection("users")
            .document(uid!!)
            .update(mapName)

    }


}