package com.example.movie

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.RecyclerView
import com.example.movie.adapters.Adapter
import com.example.movie.models.Movie
import com.example.movie.services.ApiInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    lateinit var recyclerView: RecyclerView
    lateinit var recyclerAdapter: Adapter
    val tag: String = "MyDebug"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerview)
        recyclerAdapter = Adapter(this)
        recyclerView.adapter = recyclerAdapter

        val apiInterface = ApiInterface.create().getMovies()

        apiInterface.enqueue( object : Callback<Movie>{
            override fun onResponse(call: Call<Movie>, response: Response<Movie>) {
                Log.d(tag, response.body().toString())
                if(response.body() != null)
                    recyclerAdapter.setMovieListItems(response.body()!!)
            }

            override fun onFailure(call: Call<Movie>, t: Throwable) {

                Log.d(tag, t.toString())
            }
        })
    }
}

