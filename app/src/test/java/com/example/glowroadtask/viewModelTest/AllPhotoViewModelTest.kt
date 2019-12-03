package com.example.glowroadtask.viewModelTest

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.glowroadtask.api.RestClient
import com.example.glowroadtask.model.AllPhotoMain
import com.example.glowroadtask.ui.main.AllPhotoViewModel
import io.reactivex.Scheduler
import io.reactivex.Single
import io.reactivex.android.plugins.RxAndroidPlugins
import io.reactivex.internal.schedulers.ExecutorScheduler
import io.reactivex.plugins.RxJavaPlugins
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations
import java.util.concurrent.Executor

class AllPhotoViewModelTest {
    @Rule
    @JvmField
    var rule = InstantTaskExecutorRule()
    @Mock
    internal var restClient: RestClient? = null

    private var testSingle: Single<AllPhotoMain>? = null


    @InjectMocks
    internal var allPhotoViewModel = AllPhotoViewModel()



    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)
    }


    @Test
    fun testAllPhotoDataSuccess() {
        val allPhotoMain = AllPhotoMain()
        testSingle = Single.just(allPhotoMain)
        `when`(restClient?.getAllPhotoData()).thenReturn(testSingle)
        allPhotoViewModel.fetchAllPhotoData()
        Assert.assertEquals(allPhotoMain, allPhotoViewModel.allPhotoMain.value)
        Assert.assertEquals(false, allPhotoViewModel.allPhotoMainLoadError.value)
        Assert.assertEquals(false, allPhotoViewModel.loading.value)
    }


    /*
   * **************Test case of null****************************************************************
   * */
    @Test
    fun testNull() {
        `when`(restClient?.getAllPhotoData()).thenReturn(null)
        Assert.assertNull(allPhotoViewModel.allPhotoMain.value)
    }


    /*
   * *********** test of photo data failure*******************************************************
   * */

    @Test
    fun getPhotoDataFailed() {
        val allPhotoMain = AllPhotoMain()
        testSingle = Single.just(allPhotoMain)
        `when`(restClient?.getAllPhotoData()).thenReturn(Single.error<AllPhotoMain>(Throwable("Api error")))
        allPhotoViewModel.fetchAllPhotoData()
        Assert.assertEquals(true, allPhotoViewModel.allPhotoMainLoadError.value)
        Assert.assertEquals(false, allPhotoViewModel.loading.value)
    }


    /*
     ************ setting rx schedulers*************************************************************
     * */
    @Before
    fun setupRxSchedulers() {
        val immediate = object : Scheduler() {
            override fun createWorker(): Worker {
                return ExecutorScheduler.ExecutorWorker(Executor { it.run() }, true)
            }
        }

        RxJavaPlugins.setInitNewThreadSchedulerHandler { immediate }
        RxAndroidPlugins.setInitMainThreadSchedulerHandler { immediate }
    }

}