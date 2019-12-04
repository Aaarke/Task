package com.example.glowroadtask.api

interface Keys {
    interface ApiField{
        companion object{
            const val REQ_METHOD ="method"
            const val REQ_API_KEY ="api_key"
            const val REQ_FORMAT ="format"
            const val REQ_NOJSONCALLBACK ="nojsoncallback"
            const val REQ_TEXT="text"
            const val REQ_EXTRAS="extras"
            const val REQ_PAGE_SIZE="page"


        }
    }


    interface Constant{
        companion object{
            const val API_KEY="641c87bd78e54920b01e9a5d8bb726d7"
        }
    }




}
