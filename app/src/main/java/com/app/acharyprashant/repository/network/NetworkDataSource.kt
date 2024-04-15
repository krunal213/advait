package com.app.acharyprashant.repository.network

import com.app.acharyprashant.entity.Image

interface NetworkDataSource {
    suspend fun getPhotos(): List<Image>
}