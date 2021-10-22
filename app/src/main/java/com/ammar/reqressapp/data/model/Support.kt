package com.ammar.reqressapp.data.model

import androidx.versionedparcelable.VersionedParcelize
import java.io.Serializable

@VersionedParcelize
data class Support(
    val text: String,
    val url: String
) : Serializable