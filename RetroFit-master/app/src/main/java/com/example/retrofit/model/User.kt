package com.example.retrofit.model

data class User(var id: Int,
           var email: String,
           var address: Address,
           var phone: String,
           var website: String,
           var company: Company) {
}