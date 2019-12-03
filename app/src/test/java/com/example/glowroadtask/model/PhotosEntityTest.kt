package com.example.glowroadtask.model

import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

class PhotosEntityTest {
    @Mock
    internal var photosEntityTest: Photos? = null

    @Before
    @Throws(Exception::class)
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        Mockito.`when`(photosEntityTest?.page).thenReturn(1)
        Mockito.`when`(photosEntityTest?.pages).thenReturn(2604)
        Mockito.`when`(photosEntityTest?.perpage).thenReturn(100)
        Mockito.`when`(photosEntityTest?.total).thenReturn("268348")
        val list: ArrayList<Photo>? = ArrayList()
        val photo = Photo()
        list?.add(photo)
        list?.add(photo)
        list?.add(photo)
        list?.add(photo)
        Mockito.`when`(photosEntityTest?.photo).thenReturn(list)
    }

    @Test
    fun testPage() {
        Assert.assertEquals(1, photosEntityTest?.page)
    }

    @Test
    fun testPages() {
        Assert.assertEquals(2604, photosEntityTest?.pages)

    }

    @Test
    fun testPerPage() {
        Assert.assertEquals(100, photosEntityTest?.perpage)

    }

    @Test
    fun testTotal() {

        Assert.assertEquals("268348", photosEntityTest?.total)

    }

    @Test
    fun testPhoto() {
        val list: ArrayList<Photo>? = ArrayList()
        val photo = Photo()
        list?.add(photo)
        list?.add(photo)
        list?.add(photo)
        list?.add(photo)
        Assert.assertEquals(list, photosEntityTest?.photo)

    }
}