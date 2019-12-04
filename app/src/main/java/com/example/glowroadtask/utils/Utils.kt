package com.example.glowroadtask.utils

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo

class Utils {
    companion object{
        @Suppress("DEPRECATION")
        fun internetCheck(context: Context): Boolean {
            val net: Boolean

            try {
                val ConMgr = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
                net =
                    ConMgr.getNetworkInfo(ConnectivityManager.TYPE_WIFI).state == NetworkInfo.State.CONNECTED || ConMgr.getNetworkInfo(
                        ConnectivityManager.TYPE_MOBILE
                    ).state == NetworkInfo.State.CONNECTED
            } catch (e: Exception) {
                e.printStackTrace()
                return false
            }

            return net

        }
    }
}