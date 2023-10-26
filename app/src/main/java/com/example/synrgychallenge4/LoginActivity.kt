package com.example.synrgychallenge4

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        val editTextName = findViewById<EditText>(R.id.edittext_login)
        val editTextPassword = findViewById<EditText>(R.id.edittext_password)
        val button = findViewById<Button>(R.id.button_login)
        
        button.setOnClickListener {
            val username = editTextName.text.toString()
            val password = editTextPassword.text.toString()

            if(username.isEmpty() || password.isEmpty()){
                Toast.makeText(applicationContext, "Username dan Password Harus di Isi!", Toast.LENGTH_SHORT).show()
            }
            else{
                val sharedPreferences = getSharedPreferences("MYPREFERRENCES", Context.MODE_PRIVATE)
                val editor = sharedPreferences.edit()
                editor.putString("USERNAME", username)
                editor.putString("PASSWORD", password)
                editor.apply()

                val intent = Intent(this, HomeActivity::class.java)
                startActivity(intent)
            }
        }
    }
}