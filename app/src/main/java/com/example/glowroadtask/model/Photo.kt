package com.example.glowroadtask.model

import java.io.Serializable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


class Photo : Serializable {

    @SerializedName("id")
    @Expose
    val id: String? = null
    @SerializedName("owner")
    @Expose
    val owner: String? = null
    @SerializedName("secret")
    @Expose
    val secret: String? = null
    @SerializedName("server")
    @Expose
    val server: String? = null
    @SerializedName("farm")
    @Expose
    val farm: Int? = null
    @SerializedName("title")
    @Expose
    val title: String? = null
    @SerializedName("ispublic")
    @Expose
    val ispublic: Int? = null
    @SerializedName("isfriend")
    @Expose
    val isfriend: Int? = null
    @SerializedName("isfamily")
    @Expose
    val isfamily: Int? = null
    @SerializedName("url_q")
    @Expose
    val urlQ: String? = null
    @SerializedName("height_q")
    @Expose
    val heightQ: Int? = null
    @SerializedName("width_q")
    @Expose
    val widthQ: Int? = null
}