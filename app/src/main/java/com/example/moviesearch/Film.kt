package com.example.moviesearch

import kotlinx.parcelize.Parcelize
import android.os.Parcelable

@Parcelize
class Film(
    val title: String,
    val poster: Int,
    val description: String,
    var isInFavorites: Boolean = false
) : Parcelable

