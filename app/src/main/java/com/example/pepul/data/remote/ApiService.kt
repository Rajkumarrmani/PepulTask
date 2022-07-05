package com.example.pepul.data.remote

import com.example.pepul.data.model.HomeRequest
import com.example.pepul.data.model.HomeResponse
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.*


interface ApiService {

    @Headers("Content-Type: application/json")
    @POST("select.php")
    suspend fun getHome(@Body requestBody: HomeRequest): HomeResponse
}