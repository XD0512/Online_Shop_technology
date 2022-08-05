package com.example.onlinebook.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.onlinebook.R
import com.example.onlinebook.databinding.ItemCartBinding
import com.example.onlinebook.model.CartModel
import com.example.onlinebook.model.ProductModel
import com.example.onlinebook.util.Constant

class CartAdapter(val item: List<ProductModel>) : RecyclerView.Adapter<CartAdapter.ItemHolder>() {
    class ItemHolder(val binding: ItemCartBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        return ItemHolder(
            ItemCartBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
        val items = item[position]

        holder.binding.tv385.text = items.price
        holder.binding.tvWerallo.text = items.name

        Glide.with(holder.itemView.context).load(Constant.IMAGE+items.image)
            .placeholder(R.drawable.girls).into(holder.binding.ivGirl)
    }

    override fun getItemCount(): Int {
        return item.size
    }
}