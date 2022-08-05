package com.example.onlinebook

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.onlinebook.databinding.ActivityMainBinding
import com.example.onlinebook.fragment.*

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    var homeFragment = HomeFragment.newInstance()
    var cartFragment= CartFragment.newInstance()
    var ordersFragment= OrdersFragment.newInstance()
    var favoriteFragment= FavoriteFragment.newInstance()
    var profileFragment= ProfileFragment.newInstance()

    var activeFragment: Fragment = homeFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportFragmentManager.beginTransaction().add(
            R.id.container,homeFragment,homeFragment.tag
        ).hide(homeFragment).commit()

        supportFragmentManager.beginTransaction().add(
            R.id.container,cartFragment,cartFragment.tag
        ).hide(cartFragment).commit()

        supportFragmentManager.beginTransaction().add(
            R.id.container,ordersFragment,ordersFragment.tag
        ).hide(ordersFragment).commit()

        supportFragmentManager.beginTransaction().add(
            R.id.container,favoriteFragment,favoriteFragment.tag
        ).hide(favoriteFragment).commit()

        supportFragmentManager.beginTransaction().add(
            R.id.container,profileFragment,profileFragment.tag
        ).hide(profileFragment).commit()

        supportFragmentManager.beginTransaction().show(
            activeFragment
        ).commit()


        binding.bottomNav.setOnItemSelectedListener {
            if (it.itemId == R.id.home){
                supportFragmentManager.beginTransaction().hide(
                    activeFragment
                ).show(homeFragment).commit()
                activeFragment=homeFragment
            }else if (it.itemId == R.id.cart){
                supportFragmentManager.beginTransaction().hide(
                    activeFragment
                ).show(cartFragment).commit()
                activeFragment = cartFragment
            }else if (it.itemId == R.id.orders){
                supportFragmentManager.beginTransaction().hide(
                    activeFragment
                ).show(ordersFragment).commit()
                activeFragment = ordersFragment
            }else if (it.itemId == R.id.wallet){
                supportFragmentManager.beginTransaction().hide(
                    activeFragment
                ).show(favoriteFragment).commit()
                activeFragment = favoriteFragment
            }else if (it.itemId == R.id.profile){
                supportFragmentManager.beginTransaction().hide(
                    activeFragment
                ).show(profileFragment).commit()
                activeFragment = profileFragment
            }
            return@setOnItemSelectedListener true
        }
    }
}