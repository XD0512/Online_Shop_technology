package com.example.onlinebook.util

import com.example.onlinebook.model.CartModel
import com.example.onlinebook.model.ProductModel
import com.orhanobut.hawk.Hawk

object PrefUtils {

    const val PREF_CART = "pref_cart"
    const val PREF_FAVORITE = "pref_favorite"

    fun setCart(item : ProductModel){
        val items = Hawk.get<ArrayList<CartModel>>(PREF_CART, arrayListOf<CartModel>())
        val cart =  items.filter {it.product_id == item.id}.firstOrNull()
        if (cart != null){
            if (item.cartCount > 0){
                cart.count = item.cartCount
            }else{
                items.remove(cart)
            }
        }else{
            var newCart = CartModel(item.id,item.cartCount)
            items.add(newCart)
        }
        Hawk.put(PREF_CART,items)
    }

    fun getCartList(): ArrayList<CartModel>{
        return Hawk.get(PREF_CART, arrayListOf<CartModel>())
    }
    fun getCartCount(item:ProductModel):Int{
        val items = Hawk.get<ArrayList<CartModel>>(PREF_CART, arrayListOf<CartModel>())
        return items.filter { it.product_id == item.id }.firstOrNull()?.count?:0
    }

    fun setFavorite(item : ProductModel){
        val items = Hawk.get(PREF_FAVORITE, arrayListOf<Int>())

        if (items.filter {it == item.id}.firstOrNull() != null){
            items.remove(item.id)
        }else{
            items.add(item.id)
        }

        Hawk.put(PREF_FAVORITE,items)
    }

    fun getFavoritesList():ArrayList<Int>{
        return Hawk.get(PREF_FAVORITE, arrayListOf<Int>())
    }

    fun checkFavorite(item : ProductModel):Boolean{
        val items = Hawk.get(PREF_FAVORITE, arrayListOf<Int>())
        return items.filter { it == item.id }.firstOrNull() != null
    }


}