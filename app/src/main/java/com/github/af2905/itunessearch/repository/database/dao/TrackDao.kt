package com.github.af2905.itunessearch.repository.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.github.af2905.itunessearch.repository.database.entity.TrackEntity

@Dao
interface TrackDao {
    @Query("SELECT * FROM songs WHERE collectionId =:collectionId and wrapperType =:wrapperType")
    fun getAll(collectionId: Int, wrapperType: String = "track"): List<TrackEntity>

    @Query("SELECT * FROM songs WHERE trackId =:id")
    fun getById(id: Int): TrackEntity

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertTracks(tracks: List<TrackEntity>)
}