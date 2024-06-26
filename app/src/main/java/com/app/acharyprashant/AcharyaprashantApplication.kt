package com.app.acharyprashant

import android.app.Application
import androidx.room.Room
import com.app.acharyprashant.repository.RepositoryImpl
import com.app.acharyprashant.repository.database.AppDatabase
import com.app.acharyprashant.repository.database.DatabaseDataSourceImpl
import com.app.acharyprashant.repository.network.NetworkDataSourceImpl
import com.app.acharyprashant.repository.network.UnSplashService
import com.app.acharyprashant.viewmodel.UnsplashViewModel
import com.unsplash.pickerandroid.photopicker.UnsplashPhotoPicker
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class AcharyaprashantApplication : Application() {

    lateinit var unsplashViewModel: UnsplashViewModel

    override fun onCreate() {
        super.onCreate()
        UnsplashPhotoPicker.init(
            this, // application
            BuildConfig.ACCESS_KEY,
            BuildConfig.SECRET_KEY
        )
        unsplashViewModel =
            UnsplashViewModel(
                this, RepositoryImpl(
                    NetworkDataSourceImpl(
                        Retrofit.Builder()
                            .baseUrl(BuildConfig.HTTP_URL)
                            .addConverterFactory(GsonConverterFactory.create())
                            .build()
                            .create(UnSplashService::class.java)
                    ),
                    DatabaseDataSourceImpl(
                        Room.databaseBuilder(
                            applicationContext,
                            AppDatabase::class.java, "database_image"
                        ).build().imageDao()
                    )
                )
            )

    }

}