package com.github.af2905.itunessearch.presentation.views.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.github.af2905.itunessearch.Constants.ARTIST_ID
import com.github.af2905.itunessearch.Constants.ARTIST_NAME
import com.github.af2905.itunessearch.R
import com.github.af2905.itunessearch.di.viewmodel.ViewModelComponent
import com.github.af2905.itunessearch.presentation.adapters.ArtistAdapter
import com.github.af2905.itunessearch.presentation.afterTextChanged
import com.github.af2905.itunessearch.presentation.base.BaseFragment
import com.github.af2905.itunessearch.presentation.items.IArtistClickListener
import com.github.af2905.itunessearch.repository.database.entity.ArtistEntity
import com.github.af2905.itunessearch.viewmodel.SearchViewModel
import kotlinx.android.synthetic.main.fragment_search.*
import kotlinx.android.synthetic.main.search_header.*
import kotlinx.android.synthetic.main.search_toolbar.view.*
import javax.inject.Inject

class SearchFragment : BaseFragment() {
    private lateinit var adapter: ArtistAdapter
    private val artistClickListener: IArtistClickListener<ArtistEntity> =
        object : IArtistClickListener<ArtistEntity> {
            override fun openAlbums(m: ArtistEntity) {
                showAlbums(m)
            }
        }

    lateinit var viewModel: SearchViewModel @Inject set

    override fun injectDependency(component: ViewModelComponent) {
        component.inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_search, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = ArtistAdapter(artistClickListener)
        val recycler = artists_recycler_view
        recycler.adapter = adapter
        loadDataFromViewModel()
        search_toolbar.search_edit_text.afterTextChanged {
            viewModel.downloadArtistsUponRequest(it.toString())
        }
    }

    private fun loadDataFromViewModel() {
        viewModel.getLiveDataArtists().observe(viewLifecycleOwner, { adapter.submitList(it) })
    }

    private fun showAlbums(artist: ArtistEntity) {
        val bundle = Bundle()
        bundle.putInt(ARTIST_ID, artist.artistId)
        bundle.putString(ARTIST_NAME, artist.artistName)
        findNavController().navigate(R.id.action_SearchFragment_to_AlbumFragment, bundle)
    }
}