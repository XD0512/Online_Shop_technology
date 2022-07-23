package com.example.onlinebook.fragment

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import com.example.onlinebook.R
import com.example.onlinebook.adapter.ViewPagerAdapter
import com.example.onlinebook.databinding.FragmentOrdersBinding
import com.google.android.material.tabs.TabLayoutMediator
class OrdersFragment : Fragment() {
    lateinit var binding:FragmentOrdersBinding
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val adapter = ViewPagerAdapter(requireActivity().supportFragmentManager,lifecycle)
        binding.viewPager2.adapter = adapter
        TabLayoutMediator(binding.tabLayout,binding.viewPager2){tab,position->
            when(position){
                0->{
                    tab.text = "Ongoing"
                }
                1->{
                    tab.text = "Completed"
                }
            }
        }.attach()
        binding.tabLayout.setTabTextColors(Color.parseColor("#1464f4"), Color.parseColor("#FF000000"))
        binding.tabLayout.setSelectedTabIndicatorColor(ContextCompat.getColor(requireContext(),
            R.color.black));//put your color
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentOrdersBinding.inflate(layoutInflater)
        return binding.root
    }
    companion object {
        @JvmStatic
        fun newInstance() =
            OrdersFragment()
    }
}