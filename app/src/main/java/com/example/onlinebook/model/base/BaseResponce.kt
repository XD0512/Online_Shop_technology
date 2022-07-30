package com.example.onlinebook.model.base

data class BaseResponce <T>(
    var success : Boolean,
    val data : T,
    val message : String,
    var error_code : Int
)