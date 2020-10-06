package com.github.af2905.itunessearch.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.github.af2905.itunessearch.repository.Repository
import com.github.af2905.itunessearch.repository.database.entity.TrackEntity
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposables
import io.reactivex.schedulers.Schedulers

class TrackViewModel(private val repository: Repository) : ViewModel() {
    private var requestDisposable = Disposables.empty()
    private val liveDataTracks = MutableLiveData<List<TrackEntity>>()

    fun downloadTracksUponRequest(collectionId: Int) {
        requestDisposable.dispose()
        requestDisposable =
            repository.getTracks(collectionId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ liveDataTracks.value = it }, { })
    }

    fun getLiveDataTracks(): LiveData<List<TrackEntity>> {
        return liveDataTracks
    }

    override fun onCleared() {
        super.onCleared()
        requestDisposable.dispose()
    }
}