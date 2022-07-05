package com.example.pepul.ui.adapter

import androidx.paging.LoadState
import androidx.recyclerview.widget.RecyclerView
import com.example.pepul.databinding.ItemPagingFooterBinding
import com.example.pepul.utlis.ext.executeWithAction


class FooterViewHolder(
    private val binding: ItemPagingFooterBinding
) : RecyclerView.ViewHolder(binding.root) {


    fun bind(loadState: LoadState) {
        binding.executeWithAction {
            footerUiState = FooterUiState(loadState)
        }
    }
}

