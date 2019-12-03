package com.example.glowroadtask.model

import java.io.Serializable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


class AllPhotoMain : Serializable {
    @SerializedName("photos")
    @Expose
    val photos: Photos? = null
    @SerializedName("stat")
    @Expose
    val stat: String? = null
}