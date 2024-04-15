package com.app.acharyprashant.entity

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "image")
data class Image(
    @PrimaryKey val id: String,
    @Embedded val urls: Urls
)
