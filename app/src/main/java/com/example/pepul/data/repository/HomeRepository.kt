package com.example.pepul.data.repository

import androidx.paging.PagingData
import com.example.pepul.data.model.HomeModel
import kotlinx.coroutines.flow.Flow



interface HomeRepository{
    fun getHome(): Flow<PagingData<HomeModel>>
}
