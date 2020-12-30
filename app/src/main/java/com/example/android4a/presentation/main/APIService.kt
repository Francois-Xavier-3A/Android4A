package com.example.android4a.presentation.main

import com.example.android4a.domain.entity.Monster

import retrofit2.Call
import retrofit2.http.GET

interface APIService {

    @GET("/data.json")

    fun fetchAllUsers(): Call<RestMonsterResponce>
}