package com.example.onlinebook.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.onlinebook.R

class ElectronicalAdapter : RecyclerView.Adapter<ElectronicalAdapter.ViewHolder>() {

    val name =
        arrayOf(
            "150 000 So'm",
            "140 000  So'm",
            "70 000 So'm",
            "75 000 So'm",
            "65 000 So'm",
            "95 000 So'm",
            "67 000 So'm",
            "80 000 So'm"
        )
    val image = arrayOf(
        R.drawable.e1,
        R.drawable.e2,
        R.drawable.e3,
        R.drawable.e4,
        R.drawable.e5,
        R.drawable.e6,
        R.drawable.e7,
        R.drawable.e8

        )

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var itemImage: ImageView
        var itemName: TextView


        init {
            itemImage = itemView.findViewById(R.id.iv_electronical)
            itemName = itemView.findViewById(R.id.tv_eloctronical)


            /*  itemView.setOnClickListener {
                  val position : Int = adapterPosition
                  Toast.makeText(itemView.context, "${name[position]}", Toast.LENGTH_SHORT).show()
              }*/
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_electonical, parent, false)
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