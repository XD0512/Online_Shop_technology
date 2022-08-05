package com.example.onlinebook.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.onlinebook.R
import com.example.onlinebook.adapter.JeweleryAdapter
import com.example.onlinebook.adapter.WatchAdapter
import com.example.onlinebook.databinding.FragmentJewelryBinding

class JewelryFragment : Fragment() {
    lateinit var adapter: RecyclerView.Adapter<JeweleryAdapter.ViewHolder>
    lateinit var binding: FragmentJewelryBinding
     override fun onCreateView(

        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
         binding = FragmentJewelryBinding.inflate(layoutInflater)
        // Inflate the layout for this fragment
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = JeweleryAdapter()
        binding.rvJewelery.adapter = adapter
    }

}