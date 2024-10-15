package com.example.moviesearch.domain

import kotlinx.parcelize.Parcelize
import android.os.Parcelable

@Parcelize
class Film(
    val title: String,
    val poster: Int,
    val description: String,
    var rating: Float = 0f,
    var isInFavorites: Boolean = false
) : Parcelable
