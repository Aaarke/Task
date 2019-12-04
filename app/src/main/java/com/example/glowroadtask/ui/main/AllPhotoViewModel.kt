package com.example.glowroadtask.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.glowroadtask.api.RestClient
import com.example.glowroadtask.di.DaggerApiComponent
import com.example.glowroadtask.model.AllPhotoMain
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class AllPhotoViewModel : ViewModel() {
    var allPhotoMain = MutableLiveData<AllPhotoMain>()
    var allPhotoMainLoadError = MutableLiveData<Boolean>()
    var loading = MutableLiveData<Boolean>()
    private val compositeDisposable = CompositeDisposable()

    var restClient: RestClient? = null
        @Inject set

    init {
        DaggerApiComponent.create().inject(this)
    }
    /**
     * *********************************** Function to fetch photo data ***************************
     * */
     fun fetchAllPhotoData(pageSize:Int) {
        loading.value = true
        compositeDisposable.add(
            restClient?.getAllPhotoData(pageSize)?.subscribeOn(Schedulers.newThread())
                ?.observeOn(AndroidSchedulers.mainThread())
            !!.subscribeWith(object : DisposableSingleObserver<AllPhotoMain>() {
                override fun onSuccess(allPhotoMain: AllPhotoMain) {
                    this@AllPhotoViewModel.allPhotoMain.value = allPhotoMain
                    allPhotoMainLoadError.value = false
                    loading.value = false
                }

                override fun onError(e: Throwable) {
                    allPhotoMainLoadError.value = true
                    loading.value = false
                    e.printStackTrace()
                }
            })


        )
    }


    override fun onCleared() {
        super.onCleared()
        /**
         * ************** Preventing memory leaks **************************************************
         * */
        compositeDisposable.clear()
    }
}
