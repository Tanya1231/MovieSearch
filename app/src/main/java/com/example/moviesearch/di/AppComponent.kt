package com.example.moviesearch.di

import com.example.moviesearch.data.AppComponent
import com.example.moviesearch.di.modules.DatabaseModule
import com.example.moviesearch.di.modules.DomainModule
import com.example.moviesearch.di.modules.RemoteModule
import com.example.moviesearch.viewmodel.SettingsFragmentViewModel
import com.example.moviesearch.viewmodel.HomeFragmentViewModel
import dagger.Component
import javax.inject.Singleton


@Singleton
@Component(
    //Внедряем все модули, нужные для этого компонента
    modules = [
        RemoteModule::class,
        DatabaseModule::class,
        DomainModule::class
    ]
)
interface AppComponent {
    //метод для того, чтобы появилась возможность внедрять зависимости в HomeFragmentViewModel
    fun inject(homeFragmentViewModel: HomeFragmentViewModel)

    //метод для того, чтобы появилась возможность внедрять зависимости в SettingsFragmentViewModel
    fun inject(settingsFragmentViewModel: SettingsFragmentViewModel)
}