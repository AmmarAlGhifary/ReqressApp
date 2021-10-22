package com.ammar.reqressapp.data.model


import java.io.Serializable

data class User(
    val avatar: String,
    val email: String,
    val first_name: String,
    val id: Int,
    val last_name: String

) : Serializable