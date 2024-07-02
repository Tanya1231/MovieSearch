package com.example.moviesearch

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.moviesearch.databinding.ActivityDetailsBinding


@Suppress("DEPRECATION")
class DetailsActivity : AppCompatActivity() {
    private var detailBinding: ActivityDetailsBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        detailBinding = ActivityDetailsBinding.inflate(layoutInflater)
        setContentView(detailBinding!!.root)

        setFilmsDetails()
    }

    private fun setFilmsDetails() {
        //Получаем наш фильм из переданного бандла
        val film = intent.extras?.get("film") as Film

        //Устанавливаем заголовок
        detailBinding?.detailsToolbar?.title = film.title
        //Устанавливаем картинку
        detailBinding?.detailsPoster?.setImageResource(film.poster)
        //Устанавливаем описание
        detailBinding?.detailsDescription?.text = film.description
    }
}