package com.github.af2905.itunessearch.presentation.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.github.af2905.itunessearch.R
import com.github.af2905.itunessearch.presentation.items.TrackViewHolder
import com.github.af2905.itunessearch.repository.database.entity.TrackEntity
import com.github.af2905.itunessearch.utils.TrackItemDiffCallback

class TrackAdapter : ListAdapter<TrackEntity, TrackViewHolder>(TrackItemDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TrackViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return TrackViewHolder(inflater.inflate(R.layout.item_track, parent, false))
    }

    override fun onBindViewHolder(holder: TrackViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}