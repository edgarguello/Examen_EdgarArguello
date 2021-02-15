package com.roshka.examen0

import retrofit2.http.GET
import retrofit2.Call

interface userService {

    @GET("weather?q=CIUDAD&appid=APIKEY")
    fun listUsers(): Call<List<UserDataCollectionItem>>
}