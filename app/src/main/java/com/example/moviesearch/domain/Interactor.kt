package com.example.moviesearch.domain

import androidx.lifecycle.LiveData
import com.example.moviesearch.data.entity.TmdbResults
import com.example.moviesearch.data.MainRepository
import com.example.moviesearch.data.TmdbApi
import com.example.moviesearch.utils.Converter
import com.example.moviesearch.viewmodel.HomeFragmentViewModel
import com.example.moviesearch.API
import com.example.moviesearch.data.PreferenceProvider
import com.example.moviesearch.data.entity.Film
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class Interactor(
    private val repo: MainRepository,
    private val retrofitService: TmdbApi,
    private val preferences: PreferenceProvider
) {
    fun getFilmsFromApi(page: Int, callback: HomeFragmentViewModel.ApiCallback) {
        //Метод getDefaultCategoryFromPreferences() будет нам получать при каждом запросе нужный нам список фильмов
        retrofitService.getFilms(getDefaultCategoryFromPreferences(), API.KEY, "ru-RU", page)
            .enqueue(object : Callback<TmdbResults> {
                override fun onResponse(call: Call<TmdbResults>, response: Response<TmdbResults>) {
                    //При успехе мы вызываем метод, передаем onSuccess и в этот коллбэк список фильмов
                    val list = Converter.convertApiListToDtoList(response.body()?.tmdbFilms)
                    //Кладем фильмы в бд
                    list.forEach {
                        repo.putToDb(list)
                    }
                    callback.onSuccess()
                }

                override fun onFailure(call: Call<TmdbResults>, t: Throwable) {
                    //В случае провала вызываем другой метод коллбека
                    callback.onFailure()
                }
            })
    }

    //Метод для сохранения настроек
    fun saveDefaultCategoryToPreferences(category: String) {
        preferences.saveDefaultCategory(category)
    }

    //Метод для получения настроек
    fun getDefaultCategoryFromPreferences() = preferences.getDefaultCategory()
    fun getFilmsFromDB(): LiveData<List<Film>> = repo.getAllFromDB()
}