package com.example.onlinebook.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.onlinebook.activity.ProductDetailsActivity
import com.example.onlinebook.R
import com.example.onlinebook.databinding.ItemFavoriteBinding
import com.example.onlinebook.databinding.RvHomeVerticalBinding
import com.example.onlinebook.fragment.FavoriteFragment
import com.example.onlinebook.model.ProductModel
import com.example.onlinebook.util.Constant

class FavouriteAdapter(val item: List<ProductModel>) :
    RecyclerView.Adapter<FavouriteAdapter.ItemHolders>() {
    class ItemHolders(val binding: ItemFavoriteBinding) : RecyclerView.ViewHolder(binding.root) {


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolders {
        return ItemHolders(
            ItemFavoriteBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ItemHolders, position: Int) {
        val items = item[position]

        holder.binding.tvWerallo.text = items.name
        holder.binding.tv385.text = "${items.price} So'm"

        Glide.with(holder.itemView.context).load(Constant.IMAGE + items.image)
            .placeholder(R.drawable.girls)
            .into(holder.binding.ivGirl)

        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView.context, FavoriteFragment::class.java)
            intent.putExtra("extra_datas", items)
        }
    }

    override fun getItemCount(): Int {

        return item.size
    }
}

