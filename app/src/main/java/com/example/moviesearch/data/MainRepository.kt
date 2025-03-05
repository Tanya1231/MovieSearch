package com.example.moviesearch.data

import com.example.moviesearch.data.dao.FilmDao
import com.example.moviesearch.data.entity.Film
import io.reactivex.rxjava3.core.Observable

class MainRepository(private val filmDao: FilmDao) {

    fun putToDb(films: List<Film>) {
        filmDao.insertAll(films)
    }

    fun getAllFromDB(): Observable<List<Film>> = filmDao.getCachedFilms()

}