package com.example.hw_month7_4.data

import com.example.hw_month7_4.App
import com.example.hw_month7_4.data.local.Statistic
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class Repository {
    suspend fun addStatistic(model: Statistic): Long {
        return withContext(Dispatchers.IO) {
            App.db.getDao().insert(model)
        }
    }

    suspend fun getStatistic(): List<Statistic> {
        return withContext(Dispatchers.IO) {
            App.db.getDao().getAll()
        }
    }

}