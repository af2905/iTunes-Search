package com.github.af2905.itunessearch.di.repository

import com.github.af2905.itunessearch.di.api.ApiComponent
import com.github.af2905.itunessearch.di.database.DatabaseComponent
import com.github.af2905.itunessearch.di.module.RepositoryModule
import com.github.af2905.itunessearch.repository.Repository
import dagger.Component

@Component(
    modules = [RepositoryModule::class],
    dependencies = [ApiComponent::class, DatabaseComponent::class]
)
interface RepositoryComponent {
    val repository: Repository
}