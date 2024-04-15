package com.app.acharyprashant.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "urls")
data class Urls(
    @ColumnInfo("raw")
    val raw: String,
    @ColumnInfo("full")
    val full: String,
    @ColumnInfo("regular")
    val regular: String,
    @ColumnInfo("small")
    val small: String,
    @ColumnInfo("thumb")
    val thumb: String,
    @ColumnInfo("small_s3")
    val small_s3: String,
    @PrimaryKey(autoGenerate = true)
    val urlId : Int = 0
)