package com.ammar.reqressapp.data.model


import com.google.gson.annotations.SerializedName
import android.os.Parcelable

data class User(
    @SerializedName("avatar")
    val avatar: String,
    @SerializedName("email")
    val email: String,
    @SerializedName("first_name")
    val firstName: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("last_name")
    val lastName: String
)