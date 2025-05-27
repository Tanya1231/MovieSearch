package com.example.moviesearch.di

import com.example.moviesearch.di.modules.DatabaseModule
import com.example.moviesearch.di.modules.DomainModule
import com.example.moviesearch.viewmodel.SettingsFragmentViewModel
import com.example.moviesearch.viewmodel.HomeFragmentViewModel
import com.example.remote_module.RemoteProvider
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    dependencies = [RemoteProvider::class],
    modules = [
        DatabaseModule::class,
        DomainModule::class
    ]
)
interface AppComponent {
    fun inject(homeFragmentViewModel: HomeFragmentViewModel)
    fun inject(settingsFragmentViewModel: SettingsFragmentViewModel)

    @Component.Builder
    interface Builder {
        fun remoteProvider(remoteProvider: RemoteProvider): Builder
        fun databaseModule(databaseModule: DatabaseModule): Builder
        fun domainModule(domainModule: DomainModule): Builder
        fun build(): AppComponent
    }
}
