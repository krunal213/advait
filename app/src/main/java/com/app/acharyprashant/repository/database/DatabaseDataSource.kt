package com.app.acharyprashant.repository.database

import com.app.acharyprashant.entity.Image

interface DatabaseDataSource {
    suspend fun getPhotos(): List<Image>
    suspend fun insertPhotos(photos: List<Image>)
}