package com.example.androiddemo.network

import com.example.androiddemo.network.data.MovieList
import kotlinx.coroutines.flow.Flow
import retrofit2.http.GET
import retrofit2.http.Query

interface NetworkInterface {

    @GET
    suspend fun getMovieList(@Query("s") searchString:String): MovieList
}