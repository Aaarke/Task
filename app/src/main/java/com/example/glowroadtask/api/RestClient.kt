package com.example.glowroadtask.api

import com.example.glowroadtask.di.DaggerApiComponent
import com.example.glowroadtask.model.AllPhotoMain
import io.reactivex.Single
import javax.inject.Inject

class RestClient   {


    //will get inject by dagger
    var getApiService: ApiService? = null
        @Inject set

    init {
        initDagger()
    }

    private fun initDagger(){
        DaggerApiComponent.create().inject(this)

    }


    fun getAllPhotoData(): Single<AllPhotoMain> {
        val map = HashMap<String, String>()
        map[Keys.ApiField.REQ_METHOD]="flickr.photos.search"
        map[Keys.ApiField.REQ_API_KEY]=Keys.Constant.API_KEY
        map[Keys.ApiField.REQ_FORMAT]="json"
        map[Keys.ApiField.REQ_NOJSONCALLBACK]="1"
        map[Keys.ApiField.REQ_TEXT]="shirts"
        map[Keys.ApiField.REQ_EXTRAS]="url_q"
        return getApiService!!.getAllPhotoData(map)

    }

    companion object {
        const val BASE_URL = "https://api.flickr.com/"
        private var instance: RestClient? = null
        fun getInstance(): RestClient {
            if (instance == null) {
                instance = RestClient()
            }
            return RestClient()
        }
    }


}