package com.example.moviesearch.domain

import android.util.Log
import com.example.moviesearch.data.MainRepository
import com.example.moviesearch.utils.Converter
import com.example.moviesearch.API
import com.example.moviesearch.data.PreferenceProvider
import com.example.moviesearch.data.entity.Film
import com.example.remote_module.TmdbApi
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.kotlin.subscribeBy
import io.reactivex.rxjava3.schedulers.Schedulers
import io.reactivex.rxjava3.subjects.BehaviorSubject

class Interactor(
    private val repo: MainRepository,
    private val retrofitService: TmdbApi,
    private val preferences: PreferenceProvider
) {
    var progressBarState: BehaviorSubject<Boolean> = BehaviorSubject.create()

    private val compositeDisposable = CompositeDisposable()

    fun getFilmsFromApi(page: Int) {
        //Показываем ProgressBar
        progressBarState.onNext(true)

        val disposable = retrofitService.getFilms(getDefaultCategoryFromPreferences(), API.KEY, "ru-RU", page)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread()) // Добавляем observeOn для UI операций
            .map {
                Converter.convertApiListToDtoList(it.tmdbFilms)
            }
            .subscribeBy(
                onError = { error ->
                    progressBarState.onNext(false)
                    // Добавляем логирование ошибки
                    Log.e("API_ERROR", "Error loading films", error)
                },
                onNext = { filmList ->
                    progressBarState.onNext(false)
                    repo.putToDb(filmList)
                }
            )

        // Добавляем disposable в CompositeDisposable для управления подписками
        compositeDisposable.add(disposable)
    }


    fun getSearchResultFromApi(search: String): Observable<List<Film>> =
        retrofitService.getFilmFromSearch(API.KEY, "ru-RU", search, 1)
            .map {
                Converter.convertApiListToDtoList(it.tmdbFilms)
            }

    //Метод для сохранения настроек
    fun saveDefaultCategoryToPreferences(category: String) {
        preferences.saveDefaultCategory(category)
    }

    //Метод для получения настроек
    fun getDefaultCategoryFromPreferences() = preferences.getDefaultCategory()
    fun getFilmsFromDB(): Observable<List<Film>> = repo.getAllFromDB()
}