package com.example.onlinebook.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.onlinebook.R

class ToysAdapter : RecyclerView.Adapter<ToysAdapter.ViewHolder>() {

    val name =
        arrayOf(
            "50 000 So'm",
            "48 000  So'm",
            "40 000 So'm",
            "55 000 So'm",
            "25 000 So'm",
            "45 000 So'm",
            "37 000 So'm",
            "30 000 So'm"
        )
    val image = arrayOf(
        R.drawable.toys1,
        R.drawable.toys2,
        R.drawable.toys3,
        R.drawable.toys4,
        R.drawable.toys5,
        R.drawable.toys6,
        R.drawable.toys7,
        R.drawable.toys8,


        )

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var itemImage: ImageView
        var itemName: TextView


        init {
            itemImage = itemView.findViewById(R.id.iv_toys)
            itemName = itemView.findViewById(R.id.tv_toys)


            /*  itemView.setOnClickListener {
                  val position : Int = adapterPosition
                  Toast.makeText(itemView.context, "${name[position]}", Toast.LENGTH_SHORT).show()
              }*/
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_toys, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemImage.setImageResource(image[position])
        holder.itemName.text = name[position]

    }

    override fun getItemCount(): Int {
        return image.size
    }


}