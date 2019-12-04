package com.example.glowroadtask.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.glowroadtask.R
import com.example.glowroadtask.model.Photo
import kotlinx.android.synthetic.main.item_allphoto.view.*

class AllPhotoAdapter(private var context: Context, private var listOfPhotos: ArrayList<Photo>?) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val itemView: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_allphoto, parent, false)
        return ViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return listOfPhotos?.size!!
    }

    fun updateAdapter(listOfNewPhotos: ArrayList<Photo>?) {
        if (listOfNewPhotos != null) {
            listOfPhotos?.addAll(listOfNewPhotos)
            notifyDataSetChanged()
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val requestOptions =
            RequestOptions().placeholder(R.drawable.ic_launcher_background)
                .error(R.mipmap.ic_launcher_round)
        Glide.with(context).setDefaultRequestOptions(requestOptions)
            .load(listOfPhotos?.get(position)?.urlQ).into(holder.itemView.ivPhoto)

        holder.itemView.apply {
            tvTitle.text = listOfPhotos?.get(position)?.title
        }
    }

    inner class ViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView!!)

}