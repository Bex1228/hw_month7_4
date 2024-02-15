package com.example.hw_month7_4

import android.app.Application
import androidx.room.Room
import com.example.hw_month7_4.data.local.AppDatabase

class App:Application() {

    override fun onCreate() {
        super.onCreate()
        db = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java,
            "database-statistic "
        ).build()
    }

    companion object{
        lateinit var db: AppDatabase
    }
}