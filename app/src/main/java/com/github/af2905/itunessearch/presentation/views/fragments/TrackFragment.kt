package com.github.af2905.itunessearch.presentation.views.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.github.af2905.itunessearch.Constants.ALBUM_ID
import com.github.af2905.itunessearch.Constants.ALBUM_NAME
import com.github.af2905.itunessearch.Constants.ALBUM_URL
import com.github.af2905.itunessearch.Constants.ARTIST_NAME
import com.github.af2905.itunessearch.Constants.GENRE_NAME
import com.github.af2905.itunessearch.Constants.TRACK_COUNT
import com.github.af2905.itunessearch.R
import com.github.af2905.itunessearch.di.viewmodel.ViewModelComponent
import com.github.af2905.itunessearch.presentation.adapters.TrackAdapter
import com.github.af2905.itunessearch.presentation.base.BaseFragment
import com.github.af2905.itunessearch.presentation.decoration.DivItemDecoration
import com.github.af2905.itunessearch.repository.server.GlideClient
import com.github.af2905.itunessearch.viewmodel.TrackViewModel
import kotlinx.android.synthetic.main.fragment_track.*
import kotlinx.android.synthetic.main.track_header.*
import javax.inject.Inject

class TrackFragment : BaseFragment() {
    private lateinit var adapter: TrackAdapter
    lateinit var viewModel: TrackViewModel @Inject set

    override fun injectDependency(component: ViewModelComponent) {
        component.inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_track, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = TrackAdapter()
        val recycler = track_recycler_view
        recycler.adapter = adapter
        recycler.addItemDecoration(DivItemDecoration(16, 8))
        getArgumentsAndSetThemIntoViews()
        val collectionId = requireArguments().getInt(ALBUM_ID)
        if (savedInstanceState == null) {
            viewModel.downloadTracksUponRequest(collectionId)
        }
        loadDataFromViewModel()
    }

    private fun getArgumentsAndSetThemIntoViews() {
        artist_name_text_view.text = requireArguments().getString(ARTIST_NAME)
        genre_name_text_view.text = requireArguments().getString(GENRE_NAME)
        album_name_text_view.text = requireArguments().getString(ALBUM_NAME)
        track_count_text_view.text = formatTrackCount(requireArguments().getInt(TRACK_COUNT))
        val albumUrl = requireArguments().getString(ALBUM_URL)
        albumUrl?.let { GlideClient.downloadImage(requireContext(), it, album_image_view) }
    }

    private fun formatTrackCount(trackCount: Int): String {
        return String.format(
            "%s %s", trackCount.toString(), requireContext().getString(R.string.songs)
        )
    }

    private fun loadDataFromViewModel() {
        viewModel.getLiveDataTracks().observe(viewLifecycleOwner, { adapter.submitList(it) })
    }
}