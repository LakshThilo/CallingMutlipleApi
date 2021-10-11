package com.example.callingmultipleapis.common


//https://www.googleapis.com/books/v1/volumes?q=pride+prejudice&maxResults=5&printType=books
// https://api.androidhive.info/contacts/
//https://api.androidhive.info/json/movies.json

object Constants {

    const val BOOK_BASEURL = "https://www.googleapis.com"
    const val CONTACT_BASEURL = "https://api.androidhive.info"
    const val MOVIE_BASEURL = "https://api.androidhive.info"

    const val BOOK_ENDPOINT = "books/v1/volumes"
    const val CONTACT_ENDPOINT = "contacts"
    const val MOVIE_ENDPOINT = "json/movies.json"
}