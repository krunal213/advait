package com.app.acharyprashant.repository

import com.app.acharyprashant.Result
import com.app.acharyprashant.entity.Image
import com.app.acharyprashant.repository.database.DatabaseDataSource
import com.app.acharyprashant.repository.network.NetworkDataSource
import java.net.UnknownHostException

class RepositoryImpl(
    val networkDataSource: NetworkDataSource,
    val databaseDataSource: DatabaseDataSource
) : Repository {

    override suspend fun getPhotos(): Result<List<Image>> {
        return try {
            databaseDataSource.insertPhotos(networkDataSource.getPhotos())
            Result.Success(databaseDataSource.getPhotos())
        } catch (exception: UnknownHostException) {
            Result.Success(databaseDataSource.getPhotos())
        } catch (exception: Exception) {
            throw exception
        }
    }
}