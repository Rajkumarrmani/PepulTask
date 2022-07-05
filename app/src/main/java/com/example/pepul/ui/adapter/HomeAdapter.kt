package com.example.pepul.ui.adapter


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import com.example.pepul.R
import com.example.pepul.databinding.ItemHomeBinding
import com.example.pepul.ui.HomeItemUiState
import javax.inject.Inject


class HomeAdapter @Inject constructor(
) :
    PagingDataAdapter<HomeItemUiState, HomeViewHolder>(Comparator){


    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        getItem(position)?.let { homeItemUiState -> holder.bind(homeItemUiState) }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {

        val binding = DataBindingUtil.inflate<ItemHomeBinding>(
            LayoutInflater.from(parent.context),
            R.layout.item_home,
            parent,
            false
        )

        return HomeViewHolder(binding)
    }



    object Comparator : DiffUtil.ItemCallback<HomeItemUiState>() {
        override fun areItemsTheSame(oldItem: HomeItemUiState, newItem: HomeItemUiState): Boolean {
            return oldItem.getId() == newItem.getId()
        }

        override fun areContentsTheSame(
            oldItem: HomeItemUiState,
            newItem: HomeItemUiState
        ): Boolean {
            return oldItem == newItem
        }
    }
}
