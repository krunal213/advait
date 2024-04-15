package com.app.imageutils

import android.content.Context
import android.net.Uri
import android.util.Log
import androidx.lifecycle.liveData
import kotlinx.coroutines.Dispatchers
import okhttp3.ResponseBody
import retrofit2.Retrofit
import retrofit2.http.GET
import retrofit2.http.Url
import java.io.File

object ImageUtils {

    private val TAG = "SRC"

    private val fileDownloadService = Retrofit.Builder()
        .baseUrl("http://localhost/")
        .build()
        .create(FileDownloadService::class.java)

    interface FileDownloadService {
        @GET
        suspend fun downloadImage(@Url fileUrl: String): ResponseBody
    }

    fun loadImage(
        url: String,
        context: Context,
    ) = liveData<Result<Uri>>(Dispatchers.IO) {
        try {
            emit(Result.Loading)
            val fileName = "${Uri.parse(url).lastPathSegment}.png"
            val file = File(context.filesDir, fileName)
            if (file.exists()) {
                Log.i(TAG,"File")
                emit(Result.Success(Uri.fromFile(file)))
            } else {
                Log.i(TAG,"Network")
                emit(with(fileDownloadService.downloadImage(url).bytes()) {
                    Result.Success(
                        Uri.fromFile(
                            context.openFileOutput(fileName, Context.MODE_PRIVATE)
                                .use {
                                    it.write(this)
                                    File(context.filesDir, fileName)
                                })
                    )
                })
            }
        } catch (ex: Exception) {
            emit(Result.Error(Exception("Something went wrong")))
        }
    }
}

