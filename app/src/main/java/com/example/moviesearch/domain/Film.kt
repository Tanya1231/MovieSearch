package com.example.moviesearch.domain

import kotlinx.parcelize.Parcelize
import android.os.Parcelable

@Parcelize
class Film(
    val title: String,
    val poster: String,
    val description: String,
    var rating: Double = 0.0,
    var isInFavorites: Boolean = false
) : Parcelable

