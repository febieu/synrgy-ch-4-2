package com.example.synrgychallenge4

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class SharedPreferencesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shared_preferences)

        val editTextName = findViewById<EditText>(R.id.edittext_login)
        val editTextPassword = findViewById<EditText>(R.id.edittext_password)
        val button = findViewById<Button>(R.id.button_login)

        button.setOnClickListener {
            val username = editTextName.text.toString()
            val password = editTextPassword.text.toString()

            val sharedPreferences = getSharedPreferences("MYPREFERRENCES", Context.MODE_PRIVATE)
            val editor = sharedPreferences.edit()
            editor.putString("USERNAME", username)
            editor.putString("PASSWORD", password)
            editor.apply()
        }


    }















//    private lateinit var binding: ActivitySharedPreferencesBinding
//    private lateinit var  sharedPreferences: SharedPreferences
//    private val sharedPrefName = "sharedprefbinar"
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        binding= ActivitySharedPreferencesBinding.inflate(layoutInflater)
//        setContentView(binding.root)
//        sharedPreferences = this.getSharedPreferences(sharedPrefName, MODE_PRIVATE)
//        initLayout()
//
//    }
//
//    private fun initLayout(){
//        binding
//        binding.btnSave.setOnClickListener{
//            val id = Integer.parseInt(binding.etInputId.text.toString())
//            val name =binding.etInputName.text.toString()
//            val editor = sharedPreferences.edit()
//            editor.putInt("id_key", id)
//            editor.putString("name_key", name)
//            editor.apply()
//            Toast.makeText(this, "Data tersimpan", Toast.LENGTH_SHORT).show()
//        }
//    }
}