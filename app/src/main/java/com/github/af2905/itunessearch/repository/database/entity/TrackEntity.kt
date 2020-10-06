package com.github.af2905.itunessearch.repository.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "songs")
data class TrackEntity(
    @SerializedName("wrapperType")
    val wrapperType: String? = null,

    @SerializedName("collectionType")
    val collectionType: String? = null,

    @SerializedName("artistId")
    val artistId: Int? = null,

    @SerializedName("collectionId")
    val collectionId: Int? = null,

    @SerializedName("amgArtistId")
    val amgArtistId: Int? = null,

    @SerializedName("artistName")
    val artistName: String? = null,

    @SerializedName("collectionName")
    val collectionName: String? = null,

    @SerializedName("collectionCensoredName")
    val collectionCensoredName: String? = null,

    @SerializedName("artistViewUrl")
    val artistViewUrl: String? = null,

    @SerializedName("collectionViewUrl")
    val collectionViewUrl: String? = null,

    @SerializedName("artworkUrl60")
    val artworkUrl60: String? = null,

    @SerializedName("artworkUrl100")
    val artworkUrl100: String? = null,

    @SerializedName("collectionPrice")
    val collectionPrice: Double? = null,

    @SerializedName("collectionExplicitness")
    val collectionExplicitness: String? = null,

    @SerializedName("trackCount")
    val trackCount: Int? = null,

    @SerializedName("copyright")
    val copyright: String? = null,

    @SerializedName("country")
    val country: String? = null,

    @SerializedName("currency")
    val currency: String? = null,

    @SerializedName("releaseDate")
    val releaseDate: String? = null,

    @SerializedName("primaryGenreName")
    val primaryGenreName: String? = null,

    @SerializedName("kind")
    val kind: String? = null,

    @SerializedName("trackId")
    @PrimaryKey
    val trackId: Int,

    @SerializedName("trackName")
    val trackName: String? = null,

    @SerializedName("trackCensoredName")
    val trackCensoredName: String? = null,

    @SerializedName("trackViewUrl")
    val trackViewUrl: String? = null,

    @SerializedName("previewUrl")
    val previewUrl: String? = null,

    @SerializedName("artworkUrl30")
    val artworkUrl30: String? = null,

    @SerializedName("trackPrice")
    val trackPrice: Double? = null,

    @SerializedName("trackExplicitness")
    val trackExplicitness: String? = null,

    @SerializedName("discCount")
    val discCount: Int? = null,

    @SerializedName("discNumber")
    val discNumber: Int? = null,

    @SerializedName("trackNumber")
    val trackNumber: Int? = null,

    @SerializedName("trackTimeMillis")
    val trackTimeMillis: Int? = null,

    @SerializedName("isStreamable")
    val isStreamable: Boolean? = null
)
