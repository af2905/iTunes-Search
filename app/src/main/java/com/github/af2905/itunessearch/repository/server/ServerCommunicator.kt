package com.github.af2905.itunessearch.repository.server

import com.github.af2905.itunessearch.repository.database.entity.AlbumEntity
import com.github.af2905.itunessearch.repository.database.entity.ArtistEntity
import com.github.af2905.itunessearch.repository.database.entity.TrackEntity
import io.reactivex.Single

class ServerCommunicator(private val apiService: ApiService) {

    fun getArtists(term: String): Single<List<ArtistEntity>> {
        return apiService.getArtists(term).map { it.results }
    }

    fun getAlbums(artistId: Int): Single<List<AlbumEntity>> {
        return apiService.getAlbums(artistId).map { it.results }
    }

    fun getTracks(collectionId: Int): Single<List<TrackEntity>> {
        return apiService.getTracks(collectionId).map { it.results }
    }
}