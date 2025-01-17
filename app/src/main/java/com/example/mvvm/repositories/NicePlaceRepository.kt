package com.example.mvvm.repositories

import androidx.lifecycle.MutableLiveData
import com.example.mvvm.models.NicePlace

class NicePlaceRepository {
    companion object{
       private lateinit var instance: NicePlaceRepository

        fun getInstance(): NicePlaceRepository{

            return if (!this::instance.isInitialized) {
                instance = NicePlaceRepository()
                instance
            }  else instance
        }
    }

    fun getNicePlaces(): MutableLiveData<List<NicePlace>>{
        setNicePlaces()
        val data = MutableLiveData<List<NicePlace>>()
        data.value = dataSet
        return data
    }

    private val dataSet = ArrayList<NicePlace>()

    private fun setNicePlaces(){
        dataSet.add(
             NicePlace("https://c1.staticflickr.com/5/4636/25316407448_de5fbf183d_o.jpg",
            "Havasu Falls")
        );
        dataSet.add(
             NicePlace("https://i.redd.it/tpsnoz5bzo501.jpg",
            "Trondheim")
        );
        dataSet.add(
             NicePlace("https://i.redd.it/qn7f9oqu7o501.jpg",
            "Portugal")
        );
        dataSet.add(
             NicePlace("https://i.redd.it/j6myfqglup501.jpg",
            "Rocky Mountain National Park")
        );
        dataSet.add(
             NicePlace("https://i.redd.it/0h2gm1ix6p501.jpg",
            "Havasu Falls")
        );
        dataSet.add(
             NicePlace("https://i.redd.it/k98uzl68eh501.jpg",
            "Mahahual")
        );
        dataSet.add(
             NicePlace("https://c1.staticflickr.com/5/4636/25316407448_de5fbf183d_o.jpg",
            "Frozen Lake")
        );
        dataSet.add(
             NicePlace("https://i.redd.it/obx4zydshg601.jpg",
            "Austrailia")
        );
    }
}