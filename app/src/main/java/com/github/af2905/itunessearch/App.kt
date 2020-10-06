package com.github.af2905.itunessearch

import android.app.Application
import com.github.af2905.itunessearch.di.api.DaggerApiComponent
import com.github.af2905.itunessearch.di.database.DaggerDatabaseComponent
import com.github.af2905.itunessearch.di.database.DatabaseModule
import com.github.af2905.itunessearch.di.module.ApiModule
import com.github.af2905.itunessearch.di.module.RepositoryModule
import com.github.af2905.itunessearch.di.repository.DaggerRepositoryComponent
import com.github.af2905.itunessearch.di.viewmodel.DaggerViewModelComponent
import com.github.af2905.itunessearch.di.viewmodel.ViewModelComponent
import com.github.af2905.itunessearch.di.viewmodel.ViewModelModule

class App : Application() {
    private lateinit var viewModelComponent: ViewModelComponent

    override fun onCreate() {
        super.onCreate()
        initDagger()
    }

    private fun initDagger() {
        val apiComponent = DaggerApiComponent.builder()
            .apiModule(ApiModule())
            .build()

        val databaseComponent = DaggerDatabaseComponent.builder()
            .databaseModule(DatabaseModule(applicationContext))
            .build()

        val repositoryComponent = DaggerRepositoryComponent.builder()
            .apiComponent(apiComponent)
            .databaseComponent(databaseComponent)
            .repositoryModule(RepositoryModule())
            .build()

        viewModelComponent = DaggerViewModelComponent.builder()
            .repositoryComponent(repositoryComponent)
            .viewModelModule(ViewModelModule())
            .build()
    }

    fun getViewModelComponent(): ViewModelComponent {
        return this.viewModelComponent
    }
}