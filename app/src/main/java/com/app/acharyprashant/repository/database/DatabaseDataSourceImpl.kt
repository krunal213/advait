package com.app.acharyprashant.repository.database

import com.app.acharyprashant.entity.Image

class DatabaseDataSourceImpl(val imageDao: ImageDao) : DatabaseDataSource{

    override suspend fun getPhotos(): List<Image> = imageDao.getPhotos()

    override suspend fun insertPhotos(photos: List<Image>) {
        imageDao.insertAll(photos)
    }

}