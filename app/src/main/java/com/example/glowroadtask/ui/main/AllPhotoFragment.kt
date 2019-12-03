package com.example.glowroadtask.ui.main

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import com.example.glowroadtask.R
import com.example.glowroadtask.model.AllPhotoMain

class AllPhotoFragment : Fragment() {

    companion object {
        fun newInstance() = AllPhotoFragment()
    }

    private lateinit var allPhotoViewModel: AllPhotoViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        allPhotoViewModel = ViewModelProviders.of(this).get(AllPhotoViewModel::class.java)

    }


    override fun onStart() {
        allPhotoViewModel.fetchAllPhotoData()
        allPhotoViewModel.allPhotoMain.observe(this,
            Observer<AllPhotoMain> {

            })
        super.onStart()
    }

}
