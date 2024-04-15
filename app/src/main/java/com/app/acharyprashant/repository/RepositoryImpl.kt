package com.app.acharyprashant.repository

import com.app.acharyprashant.Result
import com.app.acharyprashant.entity.Image
import com.app.acharyprashant.repository.network.NetworkDataSource
import com.app.acharyprashant.repository.ram.RamDataSource
import java.net.UnknownHostException

class RepositoryImpl(
    val networkDataSource: NetworkDataSource,
    val ramDataSource: RamDataSource
) : Repository {

    override suspend fun getPhotos(): Result<List<Image>> {
        return try {
            Result.Success(networkDataSource.getPhotos())
        } catch (exception: UnknownHostException) {
            println(exception)
            Result.Success(ramDataSource.getPhotos())
        } catch (exception: Exception) {
            throw exception
        }
    }
}