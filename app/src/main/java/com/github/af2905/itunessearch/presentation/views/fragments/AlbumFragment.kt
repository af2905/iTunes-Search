package com.github.af2905.itunessearch.presentation.views.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.github.af2905.itunessearch.Constants.ALBUM_ID
import com.github.af2905.itunessearch.Constants.ALBUM_NAME
import com.github.af2905.itunessearch.Constants.ALBUM_URL
import com.github.af2905.itunessearch.Constants.ARTIST_ID
import com.github.af2905.itunessearch.Constants.ARTIST_NAME
import com.github.af2905.itunessearch.Constants.GENRE_NAME
import com.github.af2905.itunessearch.Constants.TRACK_COUNT
import com.github.af2905.itunessearch.R
import com.github.af2905.itunessearch.di.viewmodel.ViewModelComponent
import com.github.af2905.itunessearch.presentation.adapters.AlbumAdapter
import com.github.af2905.itunessearch.presentation.base.BaseFragment
import com.github.af2905.itunessearch.presentation.decoration.DivItemDecoration
import com.github.af2905.itunessearch.presentation.items.IAlbumClickListener
import com.github.af2905.itunessearch.repository.database.entity.AlbumEntity
import com.github.af2905.itunessearch.viewmodel.AlbumViewModel
import kotlinx.android.synthetic.main.artist_header.*
import kotlinx.android.synthetic.main.fragment_album.*
import javax.inject.Inject

class AlbumFragment : BaseFragment() {
    private lateinit var adapter: AlbumAdapter
    private val albumClickListener: IAlbumClickListener<AlbumEntity> =
        object : IAlbumClickListener<AlbumEntity> {
            override fun openAlbumDetail(m: AlbumEntity) {
                showAlbumDetail(m)
            }
        }
    lateinit var viewModel: AlbumViewModel @Inject set

    override fun injectDependency(component: ViewModelComponent) {
        component.inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_album, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = AlbumAdapter(albumClickListener)
        val recycler = albums_recycler_view
        recycler.adapter = adapter
        recycler.addItemDecoration(DivItemDecoration(16, 8))
        val artistId = requireArguments().getInt(ARTIST_ID)
        artist_name_text_view.text = requireArguments().getString(ARTIST_NAME)
        if (savedInstanceState == null) {
            viewModel.downloadAlbumsUponRequest(artistId)
        }
        loadDataFromViewModel()
    }

    private fun loadDataFromViewModel() {
        viewModel.getLiveDataAlbums().observe(viewLifecycleOwner, { adapter.submitList(it) })
    }

    private fun showAlbumDetail(album: AlbumEntity) {
        val bundle = Bundle()
        bundle.putInt(ALBUM_ID, album.collectionId)
        bundle.putString(ALBUM_URL, album.artworkUrl100)
        bundle.putString(GENRE_NAME, album.primaryGenreName)
        bundle.putString(ALBUM_NAME, album.collectionName)
        bundle.putString(ARTIST_NAME, album.artistName)
        album.trackCount?.let { bundle.putInt(TRACK_COUNT, it) }
        findNavController().navigate(R.id.action_AlbumFragment_to_TrackFragment, bundle)
    }
}