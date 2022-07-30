package com.example.onlinebook.model

import java.io.Serializable

data class CategoryModel(
    val id: Int,
    val title: String,
    val icon: String,
    val parent_id: String,
    val created_at: String,
    val update_at: String,
    var checked :  Boolean
):Serializable