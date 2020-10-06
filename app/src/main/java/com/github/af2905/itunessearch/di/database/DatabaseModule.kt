package com.github.af2905.itunessearch.di.database

import android.content.Context
import androidx.room.Room
import com.github.af2905.itunessearch.repository.database.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.Reusable

@Module
class DatabaseModule(private val context: Context) {
    @Reusable
    @Provides
    fun providesRoomDatabase(): AppDatabase {
        return Room.databaseBuilder(context, AppDatabase::class.java, "database")
            .allowMainThreadQueries()
            .build()
    }
}