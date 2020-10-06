package com.github.af2905.itunessearch.repository.database.pojo

import com.github.af2905.itunessearch.repository.database.entity.AlbumEntity

class AlbumsResponse(
    val resultCount: Int? = null,
    val results: List<AlbumEntity>? = null
)