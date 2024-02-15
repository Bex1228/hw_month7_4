package com.example.hw_month7_4.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface StatisticDao {

    @Query("SELECT * FROM statistic")
    fun getAll():List<Statistic>

    @Insert
    fun insert(model:Statistic):Long

    @Delete
    fun delete(model: Statistic)

}