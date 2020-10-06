package com.github.af2905.itunessearch.repository.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "albums")
data class AlbumEntity(
    @SerializedName("wrapperType")
    val wrapperType: String? = null,

    @SerializedName("artistType")
    val artistType: String? = null,

    @SerializedName("artistName")
    val artistName: String? = null,

    @SerializedName("artistLinkUrl")
    val artistLinkUrl: String? = null,

    @SerializedName("artistId")
    val artistId: Int? = null,

    @SerializedName("amgArtistId")
    val amgArtistId: Int? = null,

    @SerializedName("primaryGenreName")
    val primaryGenreName: String? = null,

    @SerializedName("primaryGenreId")
    val primaryGenreId: Int? = null,

    @SerializedName("collectionType")
    val collectionType: String? = null,

    @SerializedName("collectionId")
    @PrimaryKey
    val collectionId: Int,

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
    val releaseDate: String? = null
)