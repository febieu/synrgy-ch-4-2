package com.example.synrgychallenge4

import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MusicActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_music)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        val music = intent.getParcelableExtra<Kpop>(MainActivity.INTENT_PARCELABLE)
        
        val image = findViewById<ImageView>(R.id.imageview_music)
        val name = findViewById<TextView>(R.id.textview_music)

        image.setImageResource(music?.image!!)
        name.text = music.name
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

}

//        val musicList = listOf<MusicKpop>(
//            MusicKpop(
//                R.drawable.attaca_svt,
//                "Attaca",
//            ),
//            MusicKpop(
//                R.drawable.teen_age_svt,
//                "Teen Age",
//            ),
//            MusicKpop(
//                R.drawable.ftc_svt,
//                "Face the Sun",
//            ),
//        )
//
//
//        val recyclerView = findViewById<RecyclerView>(R.id.recyclerview_music)
//        recyclerView.layoutManager = LinearLayoutManager(this)
//        recyclerView.setHasFixedSize(true)
//        recyclerView.adapter = MusicKpopAdapter(musicList){
//
//        }


//

//
//

