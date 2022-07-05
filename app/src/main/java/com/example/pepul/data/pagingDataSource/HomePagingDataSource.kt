package com.example.pepul.data.pagingDataSource

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.pepul.data.model.HomeModel
import com.example.pepul.data.model.HomeRequest
import com.example.pepul.data.remote.ApiService

class HomePagingDataSource(private val apiService: ApiService) :
    PagingSource<Int, HomeModel>(){

    private var lastFetchId: String = ""

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, HomeModel> {

        val request = HomeRequest(
            lastFetchId = lastFetchId
        )

        val page = params.key ?: STARTING_PAGE_INDEX
        return try {
            val response = apiService.getHome(requestBody = request)
            LoadResult.Page(
                data = response.data,
                prevKey = if (page == STARTING_PAGE_INDEX) null else page.minus(1),
                nextKey = if (response.data.isEmpty()) null else page.plus(1)
            )
        } catch (exception: Exception) {
            return LoadResult.Error(exception)
        }
    }


    override fun getRefreshKey(state: PagingState<Int, HomeModel>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(1)
        }
    }

    companion object {
        private const val STARTING_PAGE_INDEX = 0
    }
}