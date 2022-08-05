package com.example.onlinebook.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import androidx.recyclerview.widget.RecyclerView
import com.example.onlinebook.R
import com.example.onlinebook.adapter.ClothesAdapter
import com.example.onlinebook.databinding.FragmentCartBinding
import com.example.onlinebook.databinding.FragmentClothesBinding
import com.example.onlinebook.databinding.FragmentFavoriteBinding

class ClothesFragment : Fragment() {

    lateinit var adapter: RecyclerView.Adapter<ClothesAdapter.ViewHolder>
    lateinit var binding: FragmentClothesBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {
        binding = FragmentClothesBinding.inflate(layoutInflater)
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter  = ClothesAdapter()
        binding.rvClothes.adapter = adapter
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ClothesFragment().apply {
                arguments = Bundle().apply {
                }
            }
    }
}