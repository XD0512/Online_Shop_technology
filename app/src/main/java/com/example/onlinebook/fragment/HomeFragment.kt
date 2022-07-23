package com.example.onlinebook.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.onlinebook.R
import com.example.onlinebook.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    lateinit var binding: FragmentHomeBinding
    var sampleImage = intArrayOf(
        R.drawable.a,
        R.drawable.b,
        R.drawable.s,
        R.drawable.d,
        R.drawable.q,
        R.drawable.w,
        R.drawable.e
    )

    var cities = arrayOf(
        "",
        "",
        "",
        "",
        "",
        "",
        ""
    )

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.carouselView.pageCount = cities.size

        binding.carouselView.setImageListener { position, imageView ->
            imageView.setImageResource(sampleImage[position])
        }
        binding.carouselView.setImageClickListener { position ->
            Toast.makeText(requireContext(), cities[position], Toast.LENGTH_SHORT).show()
        }
    }
        override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?,
        ): View? {
            binding = FragmentHomeBinding.inflate(layoutInflater)
            // Inflate the layout for this fragment
            return binding.root
        }

        companion object {
            @JvmStatic
            fun newInstance() =
                HomeFragment()
        }
    }