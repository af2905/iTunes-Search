package com.github.af2905.itunessearch.repository.database.dao

import androidx.room.Dao
import androidx.room.Query
import com.github.af2905.itunessearch.repository.database.entity.ArtistEntity

@Dao
interface ArtistDao {
    @Query("SELECT * FROM artists")
    fun getAll(): List<ArtistEntity>

    @Query("SELECT * FROM artists WHERE artistId =:id")
    fun getById(id: Int): ArtistEntity
}