package com.example.pepul.data.model

import java.io.Serializable

data class HomeResponse(
    val statusCode: Int,
    val message: String,
    val data: ArrayList<HomeModel>
) : Serializable