package com.github.af2905.itunessearch.utils

import androidx.recyclerview.widget.DiffUtil
import com.github.af2905.itunessearch.repository.database.entity.ArtistEntity

class SearchItemDiffCallback : DiffUtil.ItemCallback<ArtistEntity>() {
    override fun areItemsTheSame(oldItem: ArtistEntity, newItem: ArtistEntity): Boolean =
        oldItem == newItem

    override fun areContentsTheSame(oldItem: ArtistEntity, newItem: ArtistEntity): Boolean =
        oldItem == newItem
}