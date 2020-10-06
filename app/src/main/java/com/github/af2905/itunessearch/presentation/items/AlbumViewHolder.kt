package com.github.af2905.itunessearch.presentation.items

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.github.af2905.itunessearch.repository.database.entity.AlbumEntity
import com.github.af2905.itunessearch.repository.server.GlideClient
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.item_album.*

class AlbumViewHolder(override val containerView: View) : RecyclerView.ViewHolder(containerView),
    LayoutContainer {

    fun bind(album: AlbumEntity) {
        album_name_text_view.text = album.collectionName
        album_artist_name_text_view.text = album.artistName
        album.artworkUrl100?.let {
            GlideClient.downloadImage(containerView.context, it, album_image_view)
        }
    }
}