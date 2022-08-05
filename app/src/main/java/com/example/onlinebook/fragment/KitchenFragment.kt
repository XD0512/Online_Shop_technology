package com.example.onlinebook.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.onlinebook.R
import com.example.onlinebook.adapter.KitchenAdapter
import com.example.onlinebook.adapter.ShoesAdapter
import com.example.onlinebook.databinding.FragmentKitchenBinding
import com.example.onlinebook.databinding.FragmentShoesBinding

class KitchenFragment : Fragment() {
    lateinit var adapter: RecyclerView.Adapter<KitchenAdapter.ViewHolder>
    lateinit var binding: FragmentKitchenBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentKitchenBinding.inflate(layoutInflater)
        // Inflate the layout for this fragment
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter  = KitchenAdapter()
        binding.rvKitchen.adapter = adapter
    }
}