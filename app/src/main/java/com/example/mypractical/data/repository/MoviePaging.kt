package com.example.mypractical.data.repository

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.mypractical.api.WebServiceInterface
import com.example.mypractical.data.model.MoviesModel
import com.example.mypractical.utils.Constant
import javax.inject.Inject

class MoviePaging @Inject constructor(
    private val s: String,
    private val webServiceInterface: WebServiceInterface)
    : PagingSource<Int,MoviesModel.Search>() {

    override fun getRefreshKey(state: PagingState<Int, MoviesModel.Search>): Int? {
        return state.anchorPosition?.let {
            val anchorPage = state?.closestPageToPosition(it)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, MoviesModel.Search> {
        val pageNo = params.key?:1
         return try {
             val data = webServiceInterface.getAllMovies(s,pageNo,Constant.API_KEY)
             LoadResult.Page(
                 data = data.body()?.search!!,
                 prevKey = if(pageNo == 1) null else pageNo-1,
                 nextKey = if(data.body()?.search?.isEmpty()!!) null else pageNo +1
             )
         } catch (e: Exception){
             LoadResult.Error(e)
         }
    }
}