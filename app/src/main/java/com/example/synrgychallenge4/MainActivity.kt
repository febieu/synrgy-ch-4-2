package com.example.synrgychallenge4

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    companion object{
        val INTENT_PARCELABLE = "OBJECT_INTENT"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val kpopList = listOf<Kpop>(
             Kpop(
                 R.drawable.svt_,
                 "Seventeen",
             ),
             Kpop(
                 R.drawable.bts,
                 "BTS",
             ),
             Kpop(
                 R.drawable.blackpink,
                 "Blackpink",
             ),
             Kpop(
                 R.drawable.aespa,
                 "AESPA",
             ),
             Kpop(
                 R.drawable.winner,
                 "Winner",
             ),
             Kpop(
                 R.drawable.newjeans,
                 "New Jeans",
             ),
         )

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerview_kpop)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = KpopAdapter(kpopList){
            val intent = Intent(this, MusicActivity::class.java)
            intent.putExtra(INTENT_PARCELABLE, it)
            startActivity(intent)
        }
    }
}