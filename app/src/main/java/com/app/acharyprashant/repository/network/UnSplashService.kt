package com.app.acharyprashant.repository.network

import com.app.acharyprashant.entity.Image
import retrofit2.http.GET
import retrofit2.http.Query

interface UnSplashService {

    @GET("/photos")
    suspend fun getPhotos(@Query("client_id") client_id: String): List<Image>

}