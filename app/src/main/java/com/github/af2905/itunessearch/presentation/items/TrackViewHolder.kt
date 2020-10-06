package com.github.af2905.itunessearch.presentation.items

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.github.af2905.itunessearch.repository.database.entity.TrackEntity
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.item_track.*

class TrackViewHolder(override val containerView: View) : RecyclerView.ViewHolder(containerView),
    LayoutContainer {

    fun bind(album: TrackEntity) {
        track_number_text_view.text = album.trackNumber.toString()
        track_name_text_view.text = album.trackName
    }
}