package com.github.af2905.itunessearch.repository.server

import android.content.Context
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions

object GlideClient {
    fun downloadImage(context: Context, imgUrl: String, imgView: ImageView) {
        Glide.with(context).load(imgUrl).transition(DrawableTransitionOptions.withCrossFade())
            .into(imgView)
    }
}