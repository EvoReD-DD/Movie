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
import com.example.movie.models.Items
import com.example.movie.models.Movie


class Adapter(val context: Context) : RecyclerView.Adapter<Adapter.MyViewHolder>() {

    var movieList : List<Items> = listOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.recyclerview_adapter,parent,false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return movieList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        holder.tvMovieName.text = movieList.get(position).toString()
        Glide.with(context).load(movieList.get(position))
            .apply(RequestOptions().centerCrop())
            .into(holder.image)
    }

    fun setMovieListItems(movies: Movie){
        this.movieList = movies.items
        notifyDataSetChanged()
    }

    class MyViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView!!) {

        val tvMovieName: TextView = itemView!!.findViewById(R.id.title)
        val image: ImageView = itemView!!.findViewById(R.id.image)
    }
}