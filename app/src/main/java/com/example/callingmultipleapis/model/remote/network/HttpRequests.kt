package com.example.callingmultipleapis.model.remote.network

import com.example.callingmultipleapis.common.Constants
import com.example.callingmultipleapis.model.remote.interfaces.Api
import com.example.callingmultipleapis.model.service.ServiceType
import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object HttpRequests {

    private val builder : Retrofit.Builder = Retrofit.Builder()

    fun getService(serviceType: ServiceType): Api {

        when(serviceType) {

            is ServiceType.Book -> {
                builder.baseUrl(Constants.BOOK_BASEURL)}

            is ServiceType.Contact -> {
                builder.baseUrl(Constants.CONTACT_BASEURL)}

            is ServiceType.Movie -> {
                builder.baseUrl(Constants.MOVIE_BASEURL)}
        }

        builder.addConverterFactory(GsonConverterFactory.create())
        builder.addCallAdapterFactory(RxJava3CallAdapterFactory.create())

        return builder.build().create(Api::class.java)

    }

}