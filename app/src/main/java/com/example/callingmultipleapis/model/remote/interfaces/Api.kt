package com.example.callingmultipleapis.model.remote.interfaces

import com.example.callingmultipleapis.common.Constants
import com.example.callingmultipleapis.model.dataclasses.book.BookResponse
import com.example.callingmultipleapis.model.dataclasses.contact.ContactResponse
import com.example.callingmultipleapis.model.dataclasses.movie.MovieResponse
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Observer
import retrofit2.http.GET
import retrofit2.http.Query


// Holding Endpoint and get functions

//https://www.googleapis.com/books/v1/volumes?q=pride+prejudice&maxResults=5&printType=books
// https://api.androidhive.info/contacts/
//https://api.androidhive.info/json/movies.json

interface Api {

    @GET(Constants.BOOK_ENDPOINT)
    fun getBooks(
        @Query("q") bookName: String,
        @Query("maxResult") maxResult : Int = 5,
        @Query("printType") printType: String
    ) : Observable<BookResponse>

    @GET(Constants.CONTACT_ENDPOINT)
    fun getContacts() : Observer<ContactResponse>

    @GET(Constants.MOVIE_ENDPOINT)
    fun getMovies() : Observable<MovieResponse>

}