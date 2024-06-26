package com.app.acharyprashant.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.liveData
import com.app.acharyprashant.Result
import com.app.acharyprashant.repository.Repository
import kotlinx.coroutines.Dispatchers
import java.net.UnknownHostException

class UnsplashViewModel(
    application: Application,
    val repository: Repository
) : AndroidViewModel(application) {

    fun getPhotos() = liveData(Dispatchers.IO) {
        try {
            emit(Result.Loading)
            emit(repository.getPhotos())
        } catch (ex: Exception) {
            Log.e("GetPhotos", ex.toString())
            emit(Result.Error(Exception("Something went wrong.")))
        }
    }

}