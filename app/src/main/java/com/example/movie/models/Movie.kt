package com.example.movie.models

import com.google.gson.annotations.SerializedName
data class Movie(

    @SerializedName("items"        ) var items        : List<Items> = arrayListOf(),
    @SerializedName("errorMessage" ) var errorMessage : String?          = null

)
data class Items (
   // @SerializedName("id"              ) var id              : String? = null,
   // @SerializedName("rank"            ) var rank            : String? = null,
    @SerializedName("title"           ) var title           : String? = null,
    //@SerializedName("fullTitle"       ) var fullTitle       : String? = null,
    //@SerializedName("year"            ) var year            : String? = null,
    @SerializedName("image"           ) var image           : String? = null,
    //@SerializedName("crew"            ) var crew            : String? = null,
    //@SerializedName("imDbRating"      ) var imDbRating      : String? = null,
   // @SerializedName("imDbRatingCount" ) var imDbRatingCount : String? = null
)