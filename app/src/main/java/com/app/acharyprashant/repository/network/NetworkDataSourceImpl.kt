package com.app.acharyprashant.repository.network

import com.app.acharyprashant.BuildConfig
import com.app.acharyprashant.entity.Image

class NetworkDataSourceImpl(val unsplashService : UnSplashService) : NetworkDataSource{

    override suspend fun getPhotos(): List<Image> = unsplashService.getPhotos(BuildConfig.UNSPLASH_KEY)

}