package com.app.acharyprashant.repository.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.app.acharyprashant.entity.Image

@Dao
interface ImageDao {

    @Query("SELECT * FROM image")
    fun getPhotos(): List<Image>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(images : List<Image>)
}