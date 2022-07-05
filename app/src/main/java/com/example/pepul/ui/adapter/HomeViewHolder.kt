package com.example.pepul.ui.adapter

import androidx.recyclerview.widget.RecyclerView
import com.example.pepul.common.HomeItemClickListener
import com.example.pepul.databinding.ItemHomeBinding
import com.example.pepul.ui.HomeItemUiState
import com.example.pepul.utlis.ext.executeWithAction

class HomeViewHolder(private val binding: ItemHomeBinding) : RecyclerView.ViewHolder(binding.root) {



    fun bind(homeItemUiState: HomeItemUiState) {

        binding.executeWithAction {
            this.homeItemUiState = homeItemUiState
        }





    }
}