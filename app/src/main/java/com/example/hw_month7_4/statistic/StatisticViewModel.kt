package com.example.hw_month7_4.statistic

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.hw_month7_4.data.Repository
import com.example.hw_month7_4.data.local.Statistic
import kotlinx.coroutines.Dispatchers

class StatisticViewModel: ViewModel() {
    private val repository = Repository()
    fun getStatistic(): LiveData<List<Statistic>> = liveData(Dispatchers.IO) {
        emit(repository.getStatistic())
    }}