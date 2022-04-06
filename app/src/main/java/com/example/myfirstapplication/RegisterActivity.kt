package com.example.myfirstapplication

import android.app.Activity
import android.content.ActivityNotFoundException
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class RegisterActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        auth = Firebase.auth
    }

    private fun end(name: String, email: String){
        val returnIntent = Intent()
        returnIntent.putExtra("name",name)
        returnIntent.putExtra("email",email)
        setResult(Activity.RESULT_OK,returnIntent)
        finish()
    }

    fun doRegister(view: View) {
        val name = findViewById<EditText>(R.id.register_name_et).text.toString()
        val email = findViewById<EditText>(R.id.register_email_et).text.toString()
        val password = findViewById<EditText>(R.id.register_password_et).text.toString()

        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information
                    Toast.makeText(this,getString(R.string.msg_register_sucess),Toast.LENGTH_LONG).show()
                    this.end(name, email)
                    finish()

                } else {
                    // If sign in fails, display a message to the user.
                    Toast.makeText(this,getString(R.string.msg_register_error),Toast.LENGTH_LONG).show()
                }
            }
    }
}