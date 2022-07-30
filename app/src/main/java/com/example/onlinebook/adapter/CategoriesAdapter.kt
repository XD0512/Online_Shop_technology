package com.example.onlinebook.adapter

import android.annotation.SuppressLint
import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.onlinebook.R
import com.example.onlinebook.databinding.BackgroundBinding
import com.example.onlinebook.model.CategoryModel

interface CategoryCallBack {
    fun onClickItem(item: CategoryModel)
}

class CategoriesAdapter(val item: List<CategoryModel>, val callBack: CategoryCallBack) :
    RecyclerView.Adapter<CategoriesAdapter.ItemHolder>() {
    class ItemHolder(val binding: BackgroundBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        return ItemHolder(BackgroundBinding.inflate(LayoutInflater.from(parent.context),
            parent,
            false))
    }

    @SuppressLint("NewApi", "NotifyDataSetChanged", "ResourceAsColor")
    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
        val items = item[position]
        holder.binding.name.text = items.title
/*
        holder.itemView.setOnClickListener {
            item.forEach {
                it.checked = false
            }
            callBack.onClickItem(items)
            items.checked = true

            notifyDataSetChanged()
        }

        if (items.checked) {
            holder.binding.cardView.setCardBackgroundColor(ContextCompat.getColor(holder.itemView.context,
                R.color.black))
            holder.binding.name.setTextColor(Color.WHITE)
        }else{
            holder.binding.cardView.setCardBackgroundColor(ContextCompat.getColor(holder.itemView.context,
                R.color.white))
            holder.binding.name.setTextColor(Color.BLACK)
        }*/
        holder.itemView.setOnClickListener {
            item.forEach {
                it.checked = false
            }
            callBack.onClickItem(items)
            items.checked = true


            notifyDataSetChanged()
        }
        if (items.checked) {
            holder.binding.cardView.setCardBackgroundColor(ContextCompat.getColor(holder.itemView.context,
                R.color.black))
            holder.binding.name.setTextColor(Color.WHITE)
        }
        else{
            holder.binding.cardView.setCardBackgroundColor(ContextCompat.getColor(holder.itemView.context,
            R.color.white))
            holder.binding.name.setTextColor(Color.BLACK)
        }
    }
    override fun getItemCount(): Int {
        return item.size
    }
}