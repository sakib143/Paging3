package com.example.mypractical.api

import com.example.mypractical.data.model.MoviesModel
import com.example.mypractical.data.model.TopicModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query


/**
 * REST API access points
 */
interface WebServiceInterface {

    @GET("/")
    suspend fun getAllMovies(
        @Query("s")s: String,
        @Query("page")page: Int,
        @Query("apikey")apikey: String): Response<MoviesModel>

}