package com.github.af2905.itunessearch.utils

import androidx.recyclerview.widget.DiffUtil
import com.github.af2905.itunessearch.repository.database.entity.AlbumEntity

class AlbumItemDiffCallback : DiffUtil.ItemCallback<AlbumEntity>() {
    override fun areItemsTheSame(oldItem: AlbumEntity, newItem: AlbumEntity): Boolean =
        oldItem === newItem

    override fun areContentsTheSame(oldItem: AlbumEntity, newItem: AlbumEntity): Boolean =
        oldItem == newItem
}