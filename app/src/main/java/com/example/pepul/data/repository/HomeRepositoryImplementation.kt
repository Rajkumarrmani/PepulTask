package com.example.pepul.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.pepul.data.model.HomeModel
import com.example.pepul.data.pagingDataSource.HomePagingDataSource
import com.example.pepul.data.remote.ApiService
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class HomeRepositoryImplementation @Inject constructor(
    private val apiService: ApiService
) : HomeRepository {
    override fun getHome(): Flow<PagingData<HomeModel>> {
        return Pager(
            config = PagingConfig(
                pageSize = NETWORK_PAGE_SIZE
            ),
            pagingSourceFactory = { HomePagingDataSource(apiService) }
        ).flow
    }


    companion object {
        const val NETWORK_PAGE_SIZE = 10
    }
}