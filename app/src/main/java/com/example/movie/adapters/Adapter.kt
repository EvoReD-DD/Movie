package com.example.movie.adapters

import android.content.Context
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import android.view.ViewGroup
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.movie.R
import com.example.movie.models.Movie


class Adapter(val context: Context) : RecyclerView.Adapter<Adapter.MyViewHolder>() {

    var movieList : List<Movie> = listOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.recyclerview_adapter,parent,false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return movieList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        //holder.tvMovieName.text = movieList.get(position).items
        Glide.with(context).load(movieList.get(position).items)
            .apply(RequestOptions().centerCrop())
            .into(holder.image)
    }

    fun setMovieListItems(movieList: List<Movie>){
        this.movieList = movieList
        notifyDataSetChanged()
    }

    class MyViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView!!) {

        val tvMovieName: TextView = itemView!!.findViewById(R.id.title)
        val image: ImageView = itemView!!.findViewById(R.id.image)

    }
}