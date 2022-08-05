package com.example.onlinebook.model

import java.io.Serializable

data class AddressModel(
    val adress: String,
    val latitude: Double,
    val longitude: Double
) : Serializable