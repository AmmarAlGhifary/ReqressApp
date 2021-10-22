package com.ammar.reqressapp.repository

import com.ammar.reqressapp.di.ApiService
import javax.inject.Inject

class HomeRepository @Inject constructor(private val apiService: ApiService) {

    suspend fun getUserList(page : Int) =
        apiService.getUser(page)
}