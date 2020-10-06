package com.github.af2905.itunessearch.utils

import androidx.recyclerview.widget.DiffUtil
import com.github.af2905.itunessearch.repository.database.entity.TrackEntity

class TrackItemDiffCallback : DiffUtil.ItemCallback<TrackEntity>() {
    override fun areItemsTheSame(oldItem: TrackEntity, newItem: TrackEntity): Boolean =
        oldItem === newItem

    override fun areContentsTheSame(oldItem: TrackEntity, newItem: TrackEntity): Boolean =
        oldItem == newItem
}