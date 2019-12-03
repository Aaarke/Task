package com.example.glowroadtask.api

import com.example.glowroadtask.model.AllPhotoMain
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.QueryMap

interface ApiService {
    @GET("services/rest/")
    fun getAllPhotoData(@QueryMap map: HashMap<String, String>?): Single<AllPhotoMain>
}