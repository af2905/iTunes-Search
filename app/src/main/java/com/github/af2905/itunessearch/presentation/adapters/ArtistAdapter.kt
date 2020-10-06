package com.github.af2905.itunessearch.presentation.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.github.af2905.itunessearch.R
import com.github.af2905.itunessearch.presentation.items.ArtistViewHolder
import com.github.af2905.itunessearch.presentation.items.IArtistClickListener
import com.github.af2905.itunessearch.repository.database.entity.ArtistEntity
import com.github.af2905.itunessearch.utils.SearchItemDiffCallback

class ArtistAdapter(private val clickListener: IArtistClickListener<ArtistEntity>) :
    ListAdapter<ArtistEntity, ArtistViewHolder>(SearchItemDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArtistViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.item_artist, parent, false)
        val holder = ArtistViewHolder(view)
        holder.itemView.setOnClickListener {
            val position = holder.adapterPosition
            if (position != RecyclerView.NO_POSITION) {
                clickListener.openAlbums(getItem(position))
            }
        }
        return holder
    }

    override fun onBindViewHolder(holder: ArtistViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}