package com.example.onlinebook.api

import com.example.onlinebook.model.CartModel
import com.example.onlinebook.model.CategoryModel
import com.example.onlinebook.model.OffersModel
import com.example.onlinebook.model.ProductModel
import com.example.onlinebook.model.base.BaseResponce
import io.reactivex.Observable
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface Api {

    @GET("api/get_offers")
    fun getOffers(): Observable<BaseResponce<List<OffersModel>>>

    @GET("api/get_categories")
    fun get_categories(): Observable<BaseResponce<List<CategoryModel>>>

    @GET("api/get_top_products")
    fun get_product(): Observable<BaseResponce<List<ProductModel>>>

    @GET("api/get_products/{category_id}")
    fun getCategoryById(@Path("category_id") category_id: Int): Observable<BaseResponce<List<ProductModel>>>


/*      @GET("api/get_top_products")
      fun getCart():Call<BaseResponce<List<CartModel>>>*/
}