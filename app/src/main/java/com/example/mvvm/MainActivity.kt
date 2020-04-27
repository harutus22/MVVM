package com.example.mvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mvvm.adapters.RecyclerAdapter
import com.example.mvvm.models.NicePlace
import com.example.mvvm.viewmodels.MainActivityViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var mAdapter: RecyclerAdapter
    private lateinit var mMainActivityViewModel: MainActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mMainActivityViewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)

        mMainActivityViewModel.init()

        mMainActivityViewModel.getNicePlaces()?.observe(this, Observer<List<NicePlace>> {
            mAdapter.notifyDataSetChanged()
        })

        mMainActivityViewModel.getIsUpdating().observe(this, Observer<Boolean>{
            if (it) showProgressBar() else {
                hideProgressBar()
                recycler_view.smoothScrollToPosition(mMainActivityViewModel.getNicePlaces()!!.value!!.size - 1)
            }
        })
        fab.setOnClickListener{
            mMainActivityViewModel.addNewValue(NicePlace("https://i.imgur.com/ZcLLrkY.jpg", "Washington"))
        }

        initRecyclerView()
    }

    private fun initRecyclerView() {
        mAdapter = RecyclerAdapter(this, mMainActivityViewModel.getNicePlaces()?.value as ArrayList<NicePlace>)
        val linearLayoutManager = LinearLayoutManager(this)
        recycler_view.layoutManager = linearLayoutManager
        recycler_view.adapter = mAdapter
    }

    private fun showProgressBar(){progress_bar.visibility = View.VISIBLE}
    private fun hideProgressBar(){progress_bar.visibility = View.GONE}
}
