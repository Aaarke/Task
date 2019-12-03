package com.example.glowroadtask.model

import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

class PhotoEntityTest {
    @Mock
    internal var photoEntityTest: Photo? = null

    @Before
    @Throws(Exception::class)
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        Mockito.`when`(photoEntityTest?.id).thenReturn("49161314536")
        Mockito.`when`(photoEntityTest?.owner).thenReturn("185667760@N03")
        Mockito.`when`(photoEntityTest?.secret).thenReturn("08735a0e8c")
        Mockito.`when`(photoEntityTest?.server).thenReturn("65535")
        Mockito.`when`(photoEntityTest?.farm).thenReturn(66)
        Mockito.`when`(photoEntityTest?.title).thenReturn("WrestleMania 3D Christmas shirt")
        Mockito.`when`(photoEntityTest?.ispublic).thenReturn(1)
        Mockito.`when`(photoEntityTest?.isfriend).thenReturn(0)
        Mockito.`when`(photoEntityTest?.isfamily).thenReturn(0)
        Mockito.`when`(photoEntityTest?.urlQ)
            .thenReturn("https://live.staticflickr.com/65535/49161314536_08735a0e8c_q.jpg")
        Mockito.`when`(photoEntityTest?.heightQ).thenReturn(150)
        Mockito.`when`(photoEntityTest?.widthQ).thenReturn(150)
    }

    @Test
    fun testId() {
        Assert.assertEquals("49161314536", photoEntityTest?.id)

    }

    @Test
    fun testOwner() {
        Assert.assertEquals("185667760@N03", photoEntityTest?.owner)

    }

    @Test
    fun testSecret() {
        Assert.assertEquals("08735a0e8c", photoEntityTest?.secret)

    }

    @Test
    fun testServer() {
        Assert.assertEquals("65535", photoEntityTest?.server)

    }

    @Test
    fun testFarm() {
        Assert.assertEquals(66, photoEntityTest?.farm)

    }

    @Test
    fun testTitle() {
        Assert.assertEquals("WrestleMania 3D Christmas shirt", photoEntityTest?.title)

    }


    @Test
    fun testIsPublic() {
        Assert.assertEquals(1, photoEntityTest?.ispublic)

    }


    @Test
    fun testIsFriend() {
        Assert.assertEquals(0, photoEntityTest?.isfriend)

    }

    @Test
    fun testIsFamily() {
        Assert.assertEquals(0, photoEntityTest?.isfamily)

    }

    @Test
    fun testUrlQ() {
        Assert.assertEquals(
            "https://live.staticflickr.com/65535/49161314536_08735a0e8c_q.jpg",
            photoEntityTest?.urlQ
        )

    }

    @Test
    fun testWidthQ() {
        Assert.assertEquals(150, photoEntityTest?.widthQ)

    }

    @Test
    fun testHeightQ() {
        Assert.assertEquals(150, photoEntityTest?.heightQ)

    }


}