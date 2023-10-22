package com.example.synrgychallenge4

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MusicKpopAdapter (
    private val musicKpop: List<MusicKpop>,
    val listener: (MusicKpop) -> Unit,
): RecyclerView.Adapter<MusicKpopAdapter.KpopViewHolder>() {

    inner class KpopViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView = itemView.findViewById<ImageView>(R.id.imageview_music)
        val nameKpop = itemView.findViewById<TextView>(R.id.textview_music)

        fun bindView(musicKpop: MusicKpop, listener: (MusicKpop) -> Unit) {
            imageView.setImageResource(musicKpop.imageMusic)
            nameKpop.text = musicKpop.nameMusic

            itemView.setOnClickListener {
                listener(musicKpop)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): KpopViewHolder {
        val view = LayoutInflater.from(
            parent.context
        ).inflate(
            R.layout.activity_music,
            parent,
            false,
        )
        return KpopViewHolder(view)
    }

    override fun onBindViewHolder(holder: KpopViewHolder, position: Int) {
        holder.bindView(musicKpop[position], listener)
    }

    override fun getItemCount(): Int {
        return musicKpop.size
    }
}