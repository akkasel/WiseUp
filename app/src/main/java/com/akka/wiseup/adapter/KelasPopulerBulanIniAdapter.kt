package com.akka.wiseup.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.akka.wiseup.R
import com.akka.wiseup.data.KelasTerpopuler

class KelasPopulerBulanIniAdapter(
    private val itemListKelasPopuler: List<KelasTerpopuler>
) : RecyclerView.Adapter<KelasPopulerBulanIniAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.imageView)
        val titleTextView: TextView = itemView.findViewById(R.id.titleTextView)
        val authorTextView: TextView = itemView.findViewById(R.id.authorTextView)


        fun bind(item: KelasTerpopuler) {
            imageView.setImageResource(item.imageResId)
            titleTextView.text = item.title
            authorTextView.text = item.author
            itemView.setOnClickListener {
                item.action.invoke()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.kelas_terpopuler_bulan_ini, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = itemListKelasPopuler[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int {
        return itemListKelasPopuler.size
    }
}