package com.example.callingmultipleapis.model.dataclasses.contact

// https://api.androidhive.info/contacts/
data class ContactResponse(
    val contacts : List<ContactDescription>
)

data class ContactDescription(
    val id : String,
    val name: String,
    val email: String,
    val address: String,
    val gender: String,
    val phone: PhoneNumbers
)

data class PhoneNumbers(
    val mobile: String,
    val home : String,
    val office: String
)
