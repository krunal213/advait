package com.app.acharyprashant.repository.ram

import com.app.acharyprashant.entity.Image

interface RamDataSource {
    abstract fun getPhotos(): List<Image>
}