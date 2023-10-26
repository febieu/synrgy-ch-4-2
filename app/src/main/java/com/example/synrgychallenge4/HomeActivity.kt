package com.example.synrgychallenge4

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val groupKpop = findViewById<Button>(R.id.button_group_kpop)
        val singerKpop = findViewById<Button>(R.id.button_singer_kpop)

        groupKpop.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        singerKpop.setOnClickListener{
            val intent = Intent(this, com.example.synrgychallenge4.crud.MainActivity::class.java)
            startActivity(intent)
        }

    }
}