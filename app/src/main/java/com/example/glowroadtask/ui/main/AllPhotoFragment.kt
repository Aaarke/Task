package com.example.glowroadtask.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AbsListView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.glowroadtask.R
import com.example.glowroadtask.adapter.AllPhotoAdapter
import com.example.glowroadtask.model.AllPhotoMain
import com.example.glowroadtask.utils.Utils
import kotlinx.android.synthetic.main.main_fragment.*

class AllPhotoFragment : Fragment() {

    companion object {
        fun newInstance() = AllPhotoFragment()
    }

    private lateinit var allPhotoViewModel: AllPhotoViewModel
    private lateinit var allPhotoAdapter: AllPhotoAdapter
    private var isScrolling: Boolean = false
    private var currentItems: Int = 0
    private var totalItem: Int = 0
    private var scrollOutItem: Int = 0
    private var pageSiZe: Int = 1
    private var isUpdate: Boolean = false
    private var mLayoutManager = LinearLayoutManager(context)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        allPhotoViewModel = ViewModelProviders.of(this).get(AllPhotoViewModel::class.java)
        main.isRefreshing=true
        performNetCheck()
        allPhotoViewModel.allPhotoMain.observe(this,
            Observer<AllPhotoMain> {
                if (isUpdate) {
                    updateAdapter(it)
                } else {
                    setAdapter(it)
                }
            })

        main.setOnRefreshListener {
            isUpdate=false
            performNetCheck()
        }


    }


    private fun performNetCheck() {
        if (Utils.internetCheck(context!!)) {
            main.isRefreshing = true
            rvAllPhotos.visibility = View.VISIBLE
            tvNoInternet.visibility=View.GONE
            allPhotoViewModel.fetchAllPhotoData(pageSiZe)
        } else {
            main.isRefreshing = false
            rvAllPhotos.visibility = View.GONE
            tvNoInternet.visibility = View.VISIBLE
        }
    }



    private fun updateAdapter(allPhotoMain: AllPhotoMain?) {
        allPhotoAdapter.updateAdapter(allPhotoMain!!.photos?.photo)
    }

    private fun setAdapter(
        allPhotoMain: AllPhotoMain?
    ) {
        isUpdate = true
        rvAllPhotos.visibility = View.VISIBLE
        rvAllPhotos.layoutManager = mLayoutManager
        allPhotoAdapter = AllPhotoAdapter(context!!, allPhotoMain!!.photos?.photo)
        rvAllPhotos.adapter = allPhotoAdapter
        main.isRefreshing=false
        rvAllPhotos.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)
                if (newState == AbsListView.OnScrollListener.SCROLL_STATE_TOUCH_SCROLL) {
                    isScrolling = true
                }
            }

            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                currentItems = mLayoutManager.childCount
                totalItem = mLayoutManager.itemCount
                scrollOutItem = mLayoutManager.findFirstVisibleItemPosition()
                if (isScrolling && (currentItems + scrollOutItem == totalItem)) {
                    progressBar.visibility=View.VISIBLE
                    isScrolling = false
                    pageSiZe++
                    allPhotoViewModel.fetchAllPhotoData(pageSiZe)
                }
            }
        })
    }




}
