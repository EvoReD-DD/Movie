package com.example.movie.services

import com.example.movie.models.Items
import com.example.movie.models.Movie
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface ApiInterface {
    @GET("en/API/Top250Movies/k_3njs1y37")
    fun getMovies(): Call<Movie>

    companion object{
        var BASE_URL = "https://imdb-api.com/"

        fun create() : ApiInterface {
            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build()
            return retrofit.create(ApiInterface::class.java)
        }
    }
}