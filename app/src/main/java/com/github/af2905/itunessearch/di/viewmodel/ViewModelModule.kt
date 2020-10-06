package com.github.af2905.itunessearch.di.viewmodel

import com.github.af2905.itunessearch.repository.Repository
import com.github.af2905.itunessearch.viewmodel.AlbumViewModel
import com.github.af2905.itunessearch.viewmodel.SearchViewModel
import com.github.af2905.itunessearch.viewmodel.TrackViewModel
import dagger.Module
import dagger.Provides
import dagger.Reusable

@Module
class ViewModelModule {
    @Reusable
    @Provides
    fun providesArtistViewModel(repository: Repository): SearchViewModel {
        return SearchViewModel(repository)
    }

    @Reusable
    @Provides
    fun providesAlbumViewModel(repository: Repository): AlbumViewModel {
        return AlbumViewModel(repository)
    }

    @Reusable
    @Provides
    fun provideTrackViewModel(repository: Repository): TrackViewModel {
        return TrackViewModel(repository)
    }
}