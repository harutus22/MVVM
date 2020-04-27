package com.example.mvvm.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mvvm.models.NicePlace
import com.example.mvvm.repositories.NicePlaceRepository

class MainActivityViewModel: ViewModel() {

    private var mNicePlaces: MutableLiveData<List<NicePlace>>? = null
    private lateinit var mRepo: NicePlaceRepository
    private val mIsUpdating = MutableLiveData<Boolean>()

    fun getNicePlaces() = mNicePlaces

    fun init(){
        if (mNicePlaces != null){
            return
        }
        mRepo = NicePlaceRepository.getInstance()
        mNicePlaces = mRepo.getNicePlaces()
    }

    fun addNewValue(nicePlace: NicePlace){
        mIsUpdating.value = true

        Thread.sleep(2000)
        val currentPlaces = mNicePlaces?.value
        (currentPlaces as ArrayList).add(nicePlace)
        mNicePlaces?.postValue(currentPlaces)
        mIsUpdating.postValue(false)
    }

    fun getIsUpdating(): LiveData<Boolean>{
        return mIsUpdating
    }
}