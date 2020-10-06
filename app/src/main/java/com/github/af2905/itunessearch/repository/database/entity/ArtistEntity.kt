package com.github.af2905.itunessearch.repository.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "artists")
data class ArtistEntity(
    @SerializedName("wrapperType")
    val wrapperType: String? = null,

    @SerializedName("artistType")
    val artistType: String? = null,

    @SerializedName("artistName")
    val artistName: String? = null,

    @SerializedName("artistLinkUrl")
    val artistLinkUrl: String? = null,

    @SerializedName("artistId")
    @PrimaryKey
    val artistId: Int,

    @SerializedName("primaryGenreName")
    val primaryGenreName: String? = null,

    @SerializedName("primaryGenreId")
    val primaryGenreId: Int? = null
)