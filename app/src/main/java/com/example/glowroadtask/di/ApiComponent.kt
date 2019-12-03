package com.example.glowroadtask.di

import com.example.glowroadtask.api.RestClient
import com.example.glowroadtask.ui.main.AllPhotoViewModel
import dagger.Component

/**
 * ************ interface acts as a bridge between consumer and provider ***************************
 * */
@Component(modules = [ApiModule::class])
interface ApiComponent {
    fun inject(restClient: RestClient)
    fun inject(allPhotoViewModel: AllPhotoViewModel)

}