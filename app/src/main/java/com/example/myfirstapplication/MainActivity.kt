package com.example.myfirstapplication

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase


class MainActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth
    var name: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        auth = Firebase.auth
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 1){ //1 = register
            if (resultCode == Activity.RESULT_OK){
                val email = data?.getStringExtra("email").toString()
                name = data?.getStringExtra("name").toString()
                findViewById<EditText>(R.id.main_email_et).setText(email)
            }
            else if (resultCode == Activity.RESULT_CANCELED){
                //no result
            }
        }
    }

    fun doRegister(view: View) {
        val intent = Intent(this@MainActivity,RegisterActivity::class.java)
        startActivityForResult(intent,1)
    }

    fun doLogin(view: View) {
        val email = findViewById<EditText>(R.id.main_email_et).text.toString()
        val password = findViewById<EditText>(R.id.main_password_et).text.toString()

        if (email.isValidEmail() && password.isValidPassword()){

            auth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this){ task ->
                    if (task.isSuccessful){
                        Log.d("LOGIN","successful login")
                        Toast.makeText(this,getString(R.string.msg_login_sucess),Toast.LENGTH_LONG).show()

                        val intent = Intent(this@MainActivity, HomeActivity::class.java)
                        intent.putExtra("name",name)
                        startActivity(intent)
                    }
                    else {
                        Log.d("LOGIN","insuccessful login")
                        Toast.makeText(this,getString(R.string.msg_login_error),Toast.LENGTH_LONG).show()
                    }
                }
        }
    }

    private fun String.isValidEmail() =
        isNotEmpty() && android.util.Patterns.EMAIL_ADDRESS.matcher(this).matches()

    private fun String.isValidPassword() =
        isNotEmpty() && this.length>6

    fun doOpenSecond(view: View) {

        val intent = Intent(this@MainActivity, SecondActivity::class.java)
        startActivity(intent)
    }
}