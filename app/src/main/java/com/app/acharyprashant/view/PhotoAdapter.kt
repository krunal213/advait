package com.app.acharyprashant.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.app.acharyprashant.R
import com.app.acharyprashant.entity.Image
import com.app.imageutils.ImageUtils
import com.app.imageutils.Result

class PhotoAdapter constructor(val context: AppCompatActivity) : RecyclerView.Adapter<PhotoAdapter.PhotoViewHolder>() {

    private val mLayoutInflater: LayoutInflater = LayoutInflater.from(context)

    private var mListOfPhotos: List<Image> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoViewHolder {
        return PhotoViewHolder(mLayoutInflater.inflate(R.layout.item_photo, parent, false))
    }

    override fun onBindViewHolder(holder: PhotoViewHolder, position: Int) {
        // item
        val photo = mListOfPhotos[position]
        // loading the photo
        ImageUtils.loadImage(photo.urls.small, context).observe(context) {
            when (it) {
                is Result.Loading -> {
                    holder.imageView.setImageResource(R.drawable.ic_loading)
                }
                is Result.Success -> {
                    holder.imageView.setImageURI(it.data)
                }
                is Result.Error -> {
                    holder.imageView.setImageResource(R.drawable.ic_no_image)
                }
            }
        }
    }

    override fun getItemCount(): Int {
        return mListOfPhotos.size
    }

    fun setListOfPhotos(listOfPhotos: List<Image>) {
        if (listOfPhotos != null) {
            mListOfPhotos = listOfPhotos
            notifyDataSetChanged()
        }
    }

    /**
     * UnsplashPhoto view holder.
     */
    class PhotoViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imageView: ImageView = view.findViewById(R.id.item_photo_iv)
    }
}


