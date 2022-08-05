package com.example.onlinebook.fragment

import android.app.Activity.RESULT_OK
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.onlinebook.R
import com.example.onlinebook.adapter.CategoriesAdapter
import com.example.onlinebook.adapter.CategoryCallBack
import com.example.onlinebook.adapter.PraductAdapter
import com.example.onlinebook.databinding.FragmentHomeBinding
import com.example.onlinebook.model.CategoryModel
import com.example.onlinebook.util.Constant
import com.example.onlinebook.viewModel.MainViewModel

class HomeFragment : Fragment() {

    private var cropImageUri: Uri? = null
    lateinit var viewModel: MainViewModel
    lateinit var binding: FragmentHomeBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        binding.note.setOnClickListener {
            val transaction = requireActivity().supportFragmentManager.beginTransaction()
            transaction.replace(R.id.container,NoteFragment())
            transaction.addToBackStack(null)
            transaction.commit()
        }
        binding.toys.setOnClickListener {
            val transaction = requireActivity().supportFragmentManager.beginTransaction()
            transaction.replace(R.id.container,ToysFragment())
            transaction.addToBackStack(null)
            transaction.commit()
        }
        binding.kitchen.setOnClickListener {
            val transaction = requireActivity().supportFragmentManager.beginTransaction()
            transaction.replace(R.id.container,KitchenFragment())
            transaction.addToBackStack(null)
            transaction.commit()
        }
        binding.jeweraly.setOnClickListener {
            val transaction = requireActivity().supportFragmentManager.beginTransaction()
            transaction.replace(R.id.container,JewelryFragment())
            transaction.addToBackStack(null)
            transaction.commit()
        }
        binding.watch.setOnClickListener {
            val transaction = requireActivity().supportFragmentManager.beginTransaction()
            transaction.replace(R.id.container,WatchFragment())
            transaction.addToBackStack(null)
            transaction.commit()
        }
        binding.electronic.setOnClickListener {
            val transaction = requireActivity().supportFragmentManager.beginTransaction()
            transaction.replace(R.id.container,ElectronicFragment())
            transaction.addToBackStack(null)
            transaction.commit()
        }
        binding.bags.setOnClickListener {
            val transaction = requireActivity().supportFragmentManager.beginTransaction()
            transaction.replace(R.id.container,BagsFragment())
            transaction.addToBackStack(null)
            transaction.commit()
        }
        binding.shoes.setOnClickListener {
            val transaction = requireActivity().supportFragmentManager.beginTransaction()
            transaction.replace(R.id.container,ShoesFragment())
            transaction.addToBackStack(null)
            transaction.commit()
        }
        binding.clothes.setOnClickListener {
            val transaction = requireActivity().supportFragmentManager.beginTransaction()
            transaction.replace(R.id.container,ClothesFragment())
            transaction.addToBackStack(null)
            transaction.commit()
        }
            binding.favoriteHome.setOnClickListener {
                val transaction = requireActivity().supportFragmentManager.beginTransaction()
                transaction.replace(R.id.container,FavoriteFragment())
                transaction.addToBackStack(null)
                transaction.commit()

            }
        binding.prof.setOnClickListener {
            pickImageGallery()
        }
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
            if (it.isEmpty()) {
                binding.productRv.visibility = View.GONE
                binding.animationView.visibility = View.VISIBLE
            } else {
                binding.productRv.visibility = View.VISIBLE
                binding.animationView.visibility = View.GONE
                binding.productRv.adapter = PraductAdapter(it)
            }
        })
        loadData()
    }

    private fun saveData() {

        val sharedPref = requireActivity().getSharedPreferences("shared_pref",Context.MODE_PRIVATE)
        binding.prof.setImageURI(Uri.parse(sharedPref.getString("image","")))
    }


    private fun pickImageGallery() {
        val intent = Intent(Intent.ACTION_PICK)
        intent.type = "image/*"
        startActivityForResult(intent, IMAGE_REQUEST_CODE)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == IMAGE_REQUEST_CODE && resultCode == RESULT_OK){
            binding.prof.setImageURI(data?.data)

           val sharedPreferences = requireActivity().getSharedPreferences("shared_pref",Context.MODE_PRIVATE)
           val editor = sharedPreferences.edit()
            editor.apply{
                putString("image", data?.data.toString())
            }.apply()

        }
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
        val IMAGE_REQUEST_CODE = 100
    }


}


