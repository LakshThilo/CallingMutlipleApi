package com.example.callingmultipleapis.model.dataclasses.book


//https://www.googleapis.com/books/v1/volumes?q=pride+prejudice&maxResults=5&printType=books
data class BookResponse(
    val items: List<BookDescription>
)

data class BookDescription(

    val publisher : String,
    val volumeInfo : VolumeInfo,

)

data class VolumeInfo(

    val title: String,
    val authors : List<String>?,
    val imageLinks: ImageLinks,
    val description: String?,
    val publisher: String?
)


data class ImageLinks(
    val thumbnail: String
)