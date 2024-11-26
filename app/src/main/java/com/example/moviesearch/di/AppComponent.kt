package com.example.moviesearch.di

import com.example.moviesearch.data.AppComponent
import com.example.moviesearch.di.modules.DatabaseModule
import com.example.moviesearch.di.modules.DomainModule
import com.example.moviesearch.di.modules.RemoteModule
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
interface AppComponent : AppComponent {
    //метод для того, чтобы появилась внедрять зависимости в HomeFragmentViewModel
    override fun inject(homeFragmentViewModel: HomeFragmentViewModel)
}