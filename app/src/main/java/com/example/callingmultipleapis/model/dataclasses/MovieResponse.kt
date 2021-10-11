package com.example.callingmultipleapis.model.dataclasses.movie

//https://api.androidhive.info/json/movies.json
class MovieResponse : ArrayList<MovieDescription>()

data class MovieDescription(
    val title: String,
    val image : String,
    val rating: Double,
    val releaseYear: Int,
    val genre: List<String>
)
