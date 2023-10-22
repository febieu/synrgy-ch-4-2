package com.example.synrgychallenge4

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class KpopAdapter (
    private val kpop: List<Kpop>,
    val listener: (Kpop) -> Unit,
): RecyclerView.Adapter<KpopAdapter.KpopViewHolder>(){
    inner class KpopViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val imageView = itemView.findViewById<ImageView>(R.id.image_view)
        val nameKpop = itemView.findViewById<TextView>(R.id.text_view)

        fun bindView(kpop: Kpop, listener: (Kpop) -> Unit, position: Int){
            imageView.setImageResource(kpop.image)
            nameKpop.text = kpop.name

            itemView.setOnClickListener {
                listener(kpop)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): KpopViewHolder {
        val view = LayoutInflater.from(
            parent.context
        ).inflate(
                R.layout.activity_item,
                parent,
                false,
            )
        return KpopViewHolder(view)
    }

    override fun onBindViewHolder(holder: KpopViewHolder, position: Int) {
        holder.bindView(kpop[position], listener, position)
    }

    override fun getItemCount(): Int {
        return kpop.size
    }
}