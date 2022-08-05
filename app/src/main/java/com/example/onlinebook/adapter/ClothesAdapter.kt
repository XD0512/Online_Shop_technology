package com.example.onlinebook.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.onlinebook.R

class ClothesAdapter : RecyclerView.Adapter<ClothesAdapter.ViewHolder>() {

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
        R.drawable.i,
        R.drawable.im,
        R.drawable.imag,
        R.drawable.img,
        R.drawable.image,
        R.drawable.clothes_1,
        R.drawable.clothes_2,
        R.drawable.clothes_3,

        )

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var itemImage: ImageView
        var itemName: TextView


        init {
            itemImage = itemView.findViewById(R.id.iv_clothes)
            itemName = itemView.findViewById(R.id.tv_clothes)


            /*  itemView.setOnClickListener {
                  val position : Int = adapterPosition
                  Toast.makeText(itemView.context, "${name[position]}", Toast.LENGTH_SHORT).show()
              }*/
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_clothes, parent, false)
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