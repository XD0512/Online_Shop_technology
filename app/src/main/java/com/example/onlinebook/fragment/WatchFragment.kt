package com.example.onlinebook.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.onlinebook.R
import com.example.onlinebook.adapter.BagAdapter
import com.example.onlinebook.adapter.WatchAdapter
import com.example.onlinebook.databinding.FragmentBagsBinding
import com.example.onlinebook.databinding.FragmentWatchBinding

class WatchFragment : Fragment() {
    lateinit var adapter: RecyclerView.Adapter<WatchAdapter.ViewHolder>
    lateinit var binding: FragmentWatchBinding
   override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       binding = FragmentWatchBinding.inflate(layoutInflater)
        // Inflate the layout for this fragment
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = WatchAdapter()
        binding.rvWarch.adapter = adapter
    }

}