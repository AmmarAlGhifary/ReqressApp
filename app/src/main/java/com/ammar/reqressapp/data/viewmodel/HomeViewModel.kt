package com.ammar.reqressapp.data.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ammar.reqressapp.data.model.UserResponse
import com.ammar.reqressapp.repository.HomeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val repository: HomeRepository) : ViewModel() {

    val _response: MutableLiveData<UserResponse> = MutableLiveData()
    val userResponse: LiveData<UserResponse>
        get() = _response

    init {
        getUser(1)
    }

    private fun getUser(page: Int) = viewModelScope.launch {
        repository.getUserList(page).let { response ->
            if (response.isSuccessful) {
             _response.postValue(response.body())
            } else {
                Log.d("response", "error : ${response.code()}")
            }
        }
    }
}