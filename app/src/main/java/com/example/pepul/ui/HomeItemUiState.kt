package com.example.pepul.ui

import android.view.View
import com.example.pepul.common.BaseUiState
import com.example.pepul.data.model.HomeModel

data class HomeItemUiState(
    private val homeModel: HomeModel
)  : BaseUiState() {

    fun getImageUrl() = homeModel.file
    fun getId() = homeModel.id
    fun getFileType() = if(homeModel.file_type == "1") View.VISIBLE else View.GONE

    fun onClick() = homeModel


}