package com.example.onlinebook.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.onlinebook.R
import com.example.onlinebook.adapter.BagAdapter
import com.example.onlinebook.adapter.ClothesAdapter
import com.example.onlinebook.databinding.FragmentBagsBinding
import com.example.onlinebook.databinding.FragmentClothesBinding
import com.example.onlinebook.databinding.FragmentShoesBinding

class BagsFragment : Fragment() {
    lateinit var adapter: RecyclerView.Adapter<BagAdapter.ViewHolder>
    lateinit var binding: FragmentBagsBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBagsBinding.inflate(layoutInflater)
        // Inflate the layout for this fragment
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = BagAdapter()
        binding.rvBags.adapter = adapter
    }
}