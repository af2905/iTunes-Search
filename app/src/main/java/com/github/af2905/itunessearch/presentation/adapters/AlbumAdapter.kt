package com.github.af2905.itunessearch.presentation.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.github.af2905.itunessearch.R
import com.github.af2905.itunessearch.presentation.items.AlbumViewHolder
import com.github.af2905.itunessearch.presentation.items.IAlbumClickListener
import com.github.af2905.itunessearch.repository.database.entity.AlbumEntity
import com.github.af2905.itunessearch.utils.AlbumItemDiffCallback

class AlbumAdapter(private val clickListener: IAlbumClickListener<AlbumEntity>) :
    ListAdapter<AlbumEntity, AlbumViewHolder>(AlbumItemDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlbumViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.item_album, parent, false)
        val holder = AlbumViewHolder(view)
        holder.itemView.setOnClickListener {
            val position = holder.adapterPosition
            if (position != RecyclerView.NO_POSITION) {
                clickListener.openAlbumDetail(getItem(position))
            }
        }
        return holder
    }

    override fun onBindViewHolder(holder: AlbumViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}
