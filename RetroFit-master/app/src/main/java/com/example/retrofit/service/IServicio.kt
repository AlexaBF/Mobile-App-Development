package com.example.retrofit.service

import com.example.retrofit.model.User
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.PUT
import retrofit2.http.Path

interface IServicio{

    //url<-base<- https://jsonplaceholder.typicode.com/
    @GET(value="users/")
    fun getUsers(): Call<List<User>>

    @GET(value = "users/{id}")//id es un path param
    fun getUserById(@Path(value ="id") id: Int): User

    @PUT(value = "users/{id}")
    fun updateUserById(@Path(value ="id") id: Int,
    @Body user: User): User

}