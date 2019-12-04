package com.example.glowroadtask

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.glowroadtask.ui.main.AllPhotoFragment

class AllPhotoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, AllPhotoFragment.newInstance())
                .commitNow()
        }
    }


}
