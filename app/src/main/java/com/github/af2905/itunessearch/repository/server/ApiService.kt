package com.github.af2905.itunessearch.repository.server

import com.github.af2905.itunessearch.repository.database.pojo.AlbumsResponse
import com.github.af2905.itunessearch.repository.database.pojo.SearchResponse
import com.github.af2905.itunessearch.repository.database.pojo.TracksResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    //    https://itunes.apple.com/search?term=martin&media=music&entity=musicArtist
    @GET("search")
    fun getArtists(
        @Query(QUERY_PARAM_TERM) term: String,
        @Query(QUERY_PARAM_MEDIA) attribute: String = MUSIC,
        @Query(QUERY_PARAM_ENTITY) entity: String = MUSIC_ARTIST
    ): Single<SearchResponse>

    //    https://itunes.apple.com/lookup?id=217142&entity=album
    @GET("lookup")
    fun getAlbums(
        @Query(QUERY_PARAM_ID) id: Int,
        @Query(QUERY_PARAM_ENTITY) entity: String = ALBUM
    ): Single<AlbumsResponse>

    //    https://itunes.apple.com/lookup?id=413766706&entity=song
    @GET("lookup")
    fun getTracks(
        @Query(QUERY_PARAM_ID) id: Int,
        @Query(QUERY_PARAM_ENTITY) entity: String = SONG
    ): Single<TracksResponse>

    companion object {
        private const val QUERY_PARAM_TERM = "term"
        private const val QUERY_PARAM_MEDIA = "media"
        private const val QUERY_PARAM_ENTITY = "entity"
        private const val QUERY_PARAM_ID = "id"

        private const val MUSIC = "music"
        private const val MUSIC_ARTIST = "musicArtist"
        private const val ALBUM = "album"
        private const val SONG = "song"
    }
}