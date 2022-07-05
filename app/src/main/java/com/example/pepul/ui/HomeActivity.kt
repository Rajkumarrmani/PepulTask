package com.example.pepul.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.paging.LoadState
import androidx.paging.PagingData
import com.example.pepul.R
import com.example.pepul.common.HomeItemClickListener
import com.example.pepul.data.model.HomeModel
import com.example.pepul.databinding.ActivityMainBinding
import com.example.pepul.ui.adapter.FooterAdapter
import com.example.pepul.ui.adapter.HomeAdapter
import com.example.pepul.utlis.ext.collect
import com.example.pepul.utlis.ext.collectLast
import com.example.pepul.utlis.ext.executeWithAction

import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.distinctUntilChangedBy
import kotlinx.coroutines.flow.map
import javax.inject.Inject

@AndroidEntryPoint
class HomeActivity : AppCompatActivity(), HomeItemClickListener {

    private lateinit var binding : ActivityMainBinding
    private val viewModel : HomeActivityViewModel by viewModels()

    @Inject
    lateinit var homeAdapter : HomeAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setBinding()
        setAdapter()
        collectLast(viewModel.homeItemsUiStates, ::setHomeData)



    }

    private fun setBinding() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
    }




    private fun setAdapter() {
        collect(flow = homeAdapter.loadStateFlow
            .distinctUntilChangedBy { it.source.refresh }
            .map { it.refresh },
            action = ::setUsersUiState
        )
        binding.homeRecyclerView.adapter = homeAdapter.withLoadStateFooter(FooterAdapter())

        //binding.homeRecyclerView.adapter = homeAdapter.withLoadStateHeader(HomeAdapter( ))
    }


    private fun setUsersUiState(loadState: LoadState) {
        binding.executeWithAction {
            usersUiState = UsersUiState(loadState)
        }
    }


    private suspend fun setHomeData(homeItemsPagingData: PagingData<HomeItemUiState>) {
        homeAdapter.submitData(homeItemsPagingData)
    }

    override fun onProductItemClicked(homeModel: HomeModel) {
        Toast.makeText(this, "Hello", Toast.LENGTH_SHORT).show()
    }

}