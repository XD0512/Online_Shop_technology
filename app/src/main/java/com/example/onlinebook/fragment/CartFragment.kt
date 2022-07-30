package com.example.onlinebook.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.onlinebook.R
import com.example.onlinebook.adapter.CartAdapter
import com.example.onlinebook.api.NetworkingMenejer
import com.example.onlinebook.databinding.FragmentCartBinding
import com.example.onlinebook.model.CartModel
import com.example.onlinebook.model.base.BaseResponce
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CartFragment : Fragment() {


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

    }
    lateinit var binding:FragmentCartBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentCartBinding.inflate(layoutInflater)
        // Inflate the layout for this fragment
        return binding.root
    }

    companion object {
        fun newInstance() =
            CartFragment()
    }
}