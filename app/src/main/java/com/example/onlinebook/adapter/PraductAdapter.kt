package com.example.onlinebook.adapter

import android.content.Intent
import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.onlinebook.activity.ProductDetailsActivity
import com.example.onlinebook.R
import com.example.onlinebook.databinding.RvHomeVerticalBinding
import com.example.onlinebook.model.ProductModel
import com.example.onlinebook.util.Constant

class PraductAdapter(val item: List<ProductModel>) :
    RecyclerView.Adapter<PraductAdapter.ItemHolders>() {
    class ItemHolders(val binding: RvHomeVerticalBinding) : RecyclerView.ViewHolder(binding.root)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolders {
        return ItemHolders(RvHomeVerticalBinding.inflate(LayoutInflater.from(parent.context),
            parent,
            false))
    }

    override fun onBindViewHolder(holder: ItemHolders, position: Int) {
        val items = item[position]

        holder.binding.tvSnake.text = items.name
        holder.binding.price.text = "${items.price} so'm"

        Glide.with(holder.itemView.context).load(Constant.IMAGE+items.image).placeholder(R.drawable.girls).into(holder.binding.imgGirl)

        holder.itemView.setOnClickListener{
            val intent = Intent(holder.itemView.context, ProductDetailsActivity::class.java)
            intent.putExtra("extra_data",items)

            holder.itemView.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return item.size
    }
}