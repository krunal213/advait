package com.app.acharyprashant.repository.database

import androidx.room.AutoMigration
import androidx.room.Database
import androidx.room.RenameColumn
import androidx.room.RoomDatabase
import androidx.room.migration.AutoMigrationSpec
import com.app.acharyprashant.entity.Image
import com.app.acharyprashant.entity.Urls

@RenameColumn(tableName = "image", fromColumnName = "imageId", toColumnName = "id")
private class MigrationOne : AutoMigrationSpec

@Database(entities = [Image::class,Urls::class], version = 2, exportSchema = true,autoMigrations = [
    AutoMigration(from = 1, to = 2, spec = MigrationOne::class)
])
abstract class AppDatabase : RoomDatabase() {
    abstract fun imageDao(): ImageDao
}