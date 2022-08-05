package com.example.onlinebook.model

import java.io.Serializable

data class ProductModel(
    val category_id: String,
    val created_at: String,
    val id: Int,
    val image: String,
    val name: String,
    val price: String,
    val updated_at: String,
    var cartCount :Int,
    var checked :  Boolean
    ):Serializable