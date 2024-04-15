package com.app.acharyprashant.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.app.acharyprashant.AcharyaprashantApplication
import com.app.acharyprashant.R
import com.app.acharyprashant.Result

class MainActivity : AppCompatActivity() {
    private lateinit var mAdapter: PhotoAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val main_recycler_view = findViewById<RecyclerView>(R.id.main_recycler_view)
        main_recycler_view.setHasFixedSize(true)
        main_recycler_view.itemAnimator = null
        main_recycler_view.layoutManager =
            StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL)
        mAdapter = PhotoAdapter(this)
        main_recycler_view.adapter = mAdapter

        val acharyaprashantApplication = application as AcharyaprashantApplication
        acharyaprashantApplication.unsplashViewModel.getPhotos().observe(this) {
            when (it) {
                is Result.Success -> {
                    mAdapter.setListOfPhotos(it.data)
                }
            }
        }

    }

}