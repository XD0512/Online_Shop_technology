package com.example.onlinebook.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.onlinebook.R
import com.example.onlinebook.databinding.ItemCartBinding
import com.example.onlinebook.model.CartModel

class CartAdapter(val item: List<CartModel>) : RecyclerView.Adapter<CartAdapter.ItemHolder>() {
    class ItemHolder(val binding: ItemCartBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        return ItemHolder(ItemCartBinding.inflate(LayoutInflater.from(parent.context),
            parent,
            false))
    }
    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
        val items = item[position]
        Glide.with(holder.itemView.context).load(items.image)
            .placeholder(R.drawable.girls).into(holder.binding.ivGirl)
    }
    override fun getItemCount(): Int {
        return item.size
    }
}