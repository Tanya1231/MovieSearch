package com.example.moviesearch.viewmodel

import androidx.lifecycle.ViewModel
import com.example.moviesearch.App
import com.example.moviesearch.data.entity.Film
import com.example.moviesearch.domain.Interactor
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class HomeFragmentViewModel : ViewModel() {

    //Инициализируем интерактор
    @Inject
    lateinit var interactor: Interactor
    val filmsListData: Flow<List<Film>>
    val showProgressBar: Channel<Boolean>

    init {
        App.instance.dagger.inject(this)
        showProgressBar = interactor.progressBarState
        filmsListData = interactor.getFilmsFromDB()
        getFilms()
    }

    fun getFilms() {
        interactor.getFilmsFromApi(1)
    }
}