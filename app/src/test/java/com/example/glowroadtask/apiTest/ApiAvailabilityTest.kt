package com.example.glowroadtask.apiTest

import org.junit.Test
import java.io.BufferedReader
import java.io.InputStreamReader
import java.io.Reader
import java.net.URL
import java.nio.charset.Charset

class ApiAvailabilityTest {
    /*
   * ******************* Function to check if api is available or not ******************************
   * */
    @Test
    @Throws(Exception::class)
    fun testAvailability() {
        val connection =
            URL("https://api.flickr.com/services/rest/?method=flickr.photos.search&api_key=641c87bd78e54920b01e9a5d8bb726d7&format=json&nojsoncallback=1&text=shirts&extras=url_q")
                .openConnection()
        val response = connection.getInputStream()

        val buffer = StringBuffer()
        BufferedReader(
            InputStreamReader(
                response,
                Charset.defaultCharset()
            ) as Reader
        ).use { reader ->
            var line: String?
            do {
                line = reader.readLine()
                if (line == null)
                    break
                buffer.append(line)

            } while (true)
        }

        assert(buffer.isNotEmpty())
    }
}