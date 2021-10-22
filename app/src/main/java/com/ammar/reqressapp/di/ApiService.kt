package com.ammar.reqressapp.di

import com.ammar.reqressapp.data.model.UserResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("users")
    suspend fun getUser(@Query("page") page : Int = 1) : Response<UserResponse>
}