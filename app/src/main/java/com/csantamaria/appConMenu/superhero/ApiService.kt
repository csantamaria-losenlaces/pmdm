package com.csantamaria.appConMenu.superhero

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    @GET("/api/1532094887623548/search/{name}")
    suspend fun getSuperheroes(@Path("name") superheroName: String): Response<SuperheroDataResponse>

    @GET("/api/1532094887623548/{id}")
    suspend fun getSuperheroDetail(@Path("id") superheroId: String): Response<SuperheroDetailResponse>

}