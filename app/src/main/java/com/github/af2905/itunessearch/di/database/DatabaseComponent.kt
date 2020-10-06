package com.github.af2905.itunessearch.di.database

import com.github.af2905.itunessearch.repository.database.AppDatabase
import dagger.Component

@Component(modules = [DatabaseModule::class])
interface DatabaseComponent {
    val database: AppDatabase
}