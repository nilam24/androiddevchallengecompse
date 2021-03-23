package com.example.androiddevchallenge

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class WeatherViewModel :ViewModel() {

    private var _liveData: MutableLiveData<List<WeatherDataModel>>? = MutableLiveData()
    var liveWeatherData: LiveData<List<WeatherDataModel>>? = _liveData

    fun getDataList():MutableLiveData<List<WeatherDataModel>> {
        val weatherDataList: List<WeatherDataModel>
        weatherDataList = WeatherDataModel.setWeatherData()

        _liveData?.value = weatherDataList
        return _liveData!!

    }

}