package com.example.myfirstapplication

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.myfirstapplication.models.User
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase


class RegisterActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    val db = FirebaseFirestore.getInstance()

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
                    val uid = task.result.user?.uid

                    db.collection("users").document(uid!!)
                        .set(User (name = name))
                        .addOnSuccessListener {
                            Log.d("REGISTER", "DocumentSnapshot successfully written!")
                            Toast.makeText(this,getString(R.string.msg_register_sucess),Toast.LENGTH_LONG).show()
                            this.end(name, email)
                            finish()
                        }
                        .addOnFailureListener {
                                e ->
                            Toast.makeText(this,getString(R.string.msg_register_error),Toast.LENGTH_LONG).show()
                            Log.w("REGISTER", "Error writing document", e)
                        }
                } else {
                    Toast.makeText(this,getString(R.string.msg_register_error),Toast.LENGTH_LONG).show()
                    // If sign in fails, display a message to the user.

                }
            }
    }
}