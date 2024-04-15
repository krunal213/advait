package com.app.acharyprashant.repository.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.app.acharyprashant.entity.Image
import com.app.acharyprashant.entity.Urls

@Database(
    entities = [Image::class, Urls::class], version = 1, exportSchema = true
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun imageDao(): ImageDao
}