package com.github.af2905.itunessearch.repository.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.github.af2905.itunessearch.repository.database.entity.AlbumEntity

@Dao
interface AlbumDao {
    @Query("SELECT * FROM albums WHERE artistId =:artistId and wrapperType =:wrapperType")
    fun getAll(artistId: Int, wrapperType: String = "collection"): List<AlbumEntity>

    @Query("SELECT * FROM albums WHERE collectionId =:id")
    fun getById(id: Int): AlbumEntity

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAlbums(albums: List<AlbumEntity>)
}