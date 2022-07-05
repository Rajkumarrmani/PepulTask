package com.example.pepul.common

import com.example.pepul.data.model.HomeModel

interface HomeItemClickListener {
    fun onProductItemClicked(homeModel: HomeModel)
}