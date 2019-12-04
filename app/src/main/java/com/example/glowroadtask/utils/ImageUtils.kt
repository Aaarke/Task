package com.example.glowroadtask.utils

import android.content.Context
import android.widget.ImageView
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.glowroadtask.R

class ImageUtils {
    companion object{
        fun loadImage(
            view: ImageView,
            url: String,
            circularProgressDrawable: CircularProgressDrawable
        ) {
            val requestOptions =
                RequestOptions().placeholder(circularProgressDrawable).error(R.mipmap.ic_launcher_round)
            Glide.with(view.context).setDefaultRequestOptions(requestOptions).load(url).into(view)
        }

        fun getProgressDrawable(context: Context): CircularProgressDrawable {
            val circularProgressDrawable = CircularProgressDrawable(context)
            circularProgressDrawable.strokeWidth = 10f
            circularProgressDrawable.centerRadius = 50f
            circularProgressDrawable.start()
            return circularProgressDrawable
        }
    }


}