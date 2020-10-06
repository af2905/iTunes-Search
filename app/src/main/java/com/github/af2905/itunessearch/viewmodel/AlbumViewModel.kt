package com.github.af2905.itunessearch.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.github.af2905.itunessearch.repository.Repository
import com.github.af2905.itunessearch.repository.database.entity.AlbumEntity
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposables
import io.reactivex.schedulers.Schedulers

class AlbumViewModel(private val repository: Repository) : ViewModel() {
    private var requestDisposable = Disposables.empty()
    private val liveDataAlbums = MutableLiveData<List<AlbumEntity>>()

    fun downloadAlbumsUponRequest(artistId: Int) {
        requestDisposable.dispose()
        requestDisposable =
            repository.getAlbums(artistId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ liveDataAlbums.value = it }, { })
    }

    fun getLiveDataAlbums(): LiveData<List<AlbumEntity>> {
        return liveDataAlbums
    }

    override fun onCleared() {
        super.onCleared()
        requestDisposable.dispose()
    }
}


