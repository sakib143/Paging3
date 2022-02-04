package com.example.mypractical.ui.main

import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.switchMap
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import androidx.paging.liveData
import com.example.mypractical.MyApp
import com.example.mypractical.api.WebServiceInterface
import com.example.mypractical.data.model.MoviesModel
import com.example.mypractical.data.repository.MoviePaging
import com.example.mypractical.data.repository.TopicRepository
import com.example.mypractical.ui.main.adapter.MoviePagingAdapter
import com.example.mypractical.utils.GlobalMethods
import javax.inject.Inject

class MovieViewModel @Inject constructor(
    private val application: MyApp,
    private val repository: TopicRepository,
    private val webServiceInterface: WebServiceInterface
)  : AndroidViewModel(application)  {

    private val _query = MutableLiveData<String>("")

    val list = _query.switchMap {_query ->
        Pager(PagingConfig(pageSize = 20)) {
            MoviePaging(_query,webServiceInterface)
        }.liveData.cachedIn(viewModelScope)
    }

    fun setQuery(s: String) {
        _query.postValue(s)
    }



}