package com.example.callingmultipleapis.model.service

sealed class ServiceType {

    object Book : ServiceType()
    class Contact : ServiceType()
    class Movie : ServiceType()
}