package com.github.af2905.itunessearch.repository.database.pojo

import com.github.af2905.itunessearch.repository.database.entity.TrackEntity

class TracksResponse(
    val resultCount: Int? = null,
    val results: List<TrackEntity>? = null
)