package com.example.onlinebook.fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.onlinebook.activity.CartaActivity
import com.example.onlinebook.adapter.CartAdapter
import com.example.onlinebook.databinding.FragmentCartBinding
import com.example.onlinebook.model.AddressModel
import com.example.onlinebook.util.PrefUtils
import com.example.onlinebook.viewModel.MainViewModel
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe

class CartFragment : Fragment() {

    var address: AddressModel?= null

    lateinit var viewModel: MainViewModel
    lateinit var binding: FragmentCartBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        if (!EventBus.getDefault().isRegistered(this)){
            EventBus.getDefault().register(this)
        }


        binding.map.setOnClickListener {
            startActivity(Intent(requireActivity(),CartaActivity::class.java))
        }

        viewModel.error.observe(viewLifecycleOwner, Observer {
            Toast.makeText(requireContext(), it, Toast.LENGTH_SHORT).show()
        })
        viewModel.progress.observe(viewLifecycleOwner, Observer {
            binding.swipe.isRefreshing = it
        })
        viewModel.productData.observe(viewLifecycleOwner, Observer {
            binding.rvCart.adapter = CartAdapter(it)
        })
        binding.swipe.setOnRefreshListener {
            loadData()
        }
        binding.rvCart.layoutManager = LinearLayoutManager(requireActivity())

        loadData()
    }

    private fun loadData() {
        viewModel.getProductsByIds(PrefUtils.getCartList().map { it.product_id })
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentCartBinding.inflate(layoutInflater)
        // Inflate the layout for this fragment
        return binding.root

    }

    override fun onDestroy() {
        super.onDestroy()
        if (EventBus.getDefault().isRegistered(this)){
            EventBus.getDefault().unregister(this)
        }
    }
    @Subscribe
    fun onEvent(address:AddressModel){
        this.address = address

        binding.longetude.text = "${address.latitude}"
        binding.latetude.text = "${address.longitude}"
    }

    companion object {
        fun newInstance() =
            CartFragment()
    }

}