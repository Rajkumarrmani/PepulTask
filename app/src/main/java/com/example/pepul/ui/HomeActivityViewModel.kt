package com.example.pepul.ui

import androidx.lifecycle.*
import androidx.paging.cachedIn
import androidx.paging.map
import com.example.pepul.data.repository.HomeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.map
import javax.inject.Inject

@HiltViewModel
class HomeActivityViewModel @Inject constructor(homeRepository: HomeRepository): ViewModel() {

    val homeItemsUiStates = homeRepository.getHome()
        .map { pagingData ->
            pagingData.map { homeModel -> HomeItemUiState(homeModel) }
        }.cachedIn(viewModelScope)
}