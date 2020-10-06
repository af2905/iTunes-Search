package com.github.af2905.itunessearch.repository.database.pojo

import com.github.af2905.itunessearch.repository.database.entity.ArtistEntity

class SearchResponse(
    val resultCount: Int? = null,
    val results: List<ArtistEntity>? = null
)