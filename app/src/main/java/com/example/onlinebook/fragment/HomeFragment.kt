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
import com.bumptech.glide.Glide
import com.example.onlinebook.adapter.CategoriesAdapter
import com.example.onlinebook.adapter.CategoryCallBack
import com.example.onlinebook.adapter.PraductAdapter
import com.example.onlinebook.databinding.FragmentHomeBinding
import com.example.onlinebook.model.CategoryModel
import com.example.onlinebook.util.Constant
import com.example.onlinebook.viewModel.MainViewModel

class HomeFragment : Fragment() {
    lateinit var viewModel: MainViewModel
    lateinit var binding: FragmentHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        binding.rvHomeHorizontal.layoutManager =
            LinearLayoutManager(requireActivity(), LinearLayoutManager.HORIZONTAL, false)

        viewModel.error.observe(requireActivity(), Observer {
            Toast.makeText(requireActivity(), it, Toast.LENGTH_SHORT).show()
        })
        viewModel.progress.observe(requireActivity(), Observer {
            binding.swipe.isRefreshing = it
        })
        binding.swipe.setOnRefreshListener {
            loadData()

        }

        viewModel.offersData.observe(viewLifecycleOwner, Observer {
            binding.carouselView.setImageListener { position, imageView ->
                Glide.with(imageView)
                    .load(Constant.IMAGE + it[position].image)
                    .into(imageView)
            }
            binding.carouselView.pageCount = it.size
        })
        viewModel.categoryData.observe(viewLifecycleOwner, Observer {
            binding.rvHomeHorizontal.adapter = CategoriesAdapter(it, object : CategoryCallBack {
                override fun onClickItem(item: CategoryModel) {
                       viewModel.getCategoryById(item.id)
                }
            })
        })
        viewModel.productData.observe(viewLifecycleOwner, Observer {
            if (it.isEmpty()){
              binding.productRv.visibility = View.GONE
                binding.animationView.visibility = View.VISIBLE
            }else{
                binding.productRv.visibility = View.VISIBLE
                binding.animationView.visibility = View.GONE
                binding.productRv.adapter = PraductAdapter(it)
            }
        })

        loadData()
    }
    private fun loadData() {
        viewModel.getOffers()
        viewModel.getCategory()
        viewModel.getProduct()
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