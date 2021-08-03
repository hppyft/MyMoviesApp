package com.example.mymoviesapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mymoviesapp.model.model.MovieModel
import com.example.mymoviesapp.model.repository.MovieRepository

class MovieListViewModel : ViewModel() {
    private val liveDataList: MutableLiveData<List<MovieModel>?> = MutableLiveData(null)
    private val liveDataId: MutableLiveData<Int?> = MutableLiveData(null)

    fun getPopular() {
        MovieRepository.getPopular {
            liveDataList.postValue(it)
        }
    }

    fun getLiveDataList(): LiveData<List<MovieModel>?> {
        return liveDataList
    }

    fun getLiveDataId(): LiveData<Int?> = liveDataId

    fun onMovieClicked(id: Int) {
        liveDataId.postValue(id)
    }

}