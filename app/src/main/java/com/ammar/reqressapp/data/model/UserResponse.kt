package com.ammar.reqressapp.data.model


import androidx.versionedparcelable.VersionedParcelize
import java.io.Serializable

@VersionedParcelize
data class UserResponse(
    val data : List<User>,
    val page: Int,
    val perPage: Int,
    val support: Support,
    val total: Int,
    val totalPages: Int
)  : Serializable