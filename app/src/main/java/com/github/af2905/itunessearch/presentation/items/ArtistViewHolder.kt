package com.github.af2905.itunessearch.presentation.items

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.github.af2905.itunessearch.repository.database.entity.ArtistEntity
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.item_artist.*

class ArtistViewHolder(override val containerView: View) : RecyclerView.ViewHolder(containerView),
    LayoutContainer {

    fun bind(artist: ArtistEntity) {
        artist_name_text_view.text = artist.artistName
    }
}