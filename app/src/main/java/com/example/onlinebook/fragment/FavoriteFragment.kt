package com.example.onlinebook.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.onlinebook.R
import com.example.onlinebook.adapter.FavouriteAdapter
import com.example.onlinebook.databinding.FragmentFavoriteBinding
import com.example.onlinebook.model.ProductModel
import com.example.onlinebook.util.PrefUtils
import com.example.onlinebook.viewModel.MainViewModel

class FavoriteFragment : Fragment() {

    lateinit var binding: FragmentFavoriteBinding
    lateinit var viewModel: MainViewModel
    lateinit var item: ProductModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.rvFavorite.layoutManager = LinearLayoutManager(requireActivity())
        viewModel.error.observe(viewLifecycleOwner, Observer {
            Toast.makeText(requireContext(), it, Toast.LENGTH_SHORT).show()
        })
        viewModel.progress.observe(viewLifecycleOwner, Observer {
            binding.swipe.isRefreshing = it
        })
        viewModel.productData.observe(viewLifecycleOwner, Observer {
            binding.rvFavorite.adapter = FavouriteAdapter(it)
        })
        binding.swipe.setOnRefreshListener {
            loadData()
        }

        binding.pending.setOnClickListener {
            requireActivity().onBackPressed()
        }
        loadData()

    }

    private fun loadData() {
        viewModel.getProductsByIds(PrefUtils.getFavoritesList())
    }

    override fun onCreateView(

        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentFavoriteBinding.inflate(layoutInflater)
        return binding.root
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            FavoriteFragment()
    }
}