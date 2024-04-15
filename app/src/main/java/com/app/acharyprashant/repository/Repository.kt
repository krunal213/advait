package com.app.acharyprashant.repository

import com.app.acharyprashant.Result
import com.app.acharyprashant.entity.Image

interface Repository {
    suspend fun getPhotos() : Result<List<Image>>
}