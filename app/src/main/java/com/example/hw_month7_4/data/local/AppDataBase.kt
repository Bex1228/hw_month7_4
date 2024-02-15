package com.example.hw_month7_4.data.local

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Statistic::class], version = 1)
abstract class AppDatabase:RoomDatabase() {
    abstract fun getDao():StatisticDao
}