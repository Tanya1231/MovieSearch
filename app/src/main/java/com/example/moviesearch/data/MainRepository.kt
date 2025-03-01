package com.example.moviesearch.data

import com.example.moviesearch.data.dao.FilmDao
import com.example.moviesearch.data.entity.Film
import kotlinx.coroutines.flow.Flow

class MainRepository(private val filmDao: FilmDao) {

    fun putToDb(films: List<Film>) {
        filmDao.insertAll(films)
    }

    fun getAllFromDB(): Flow<List<Film>> = filmDao.getCachedFilms()

}