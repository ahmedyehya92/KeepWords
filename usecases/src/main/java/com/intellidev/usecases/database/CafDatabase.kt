package com.intellidev.usecases.database

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import com.intellidev.entities.SeatDB
import com.intellidev.usecases.applicationLiveData
import com.intellidev.usecases.getApplication

val cafDatabase by lazy {
    initializeDatabase(applicationLiveData.getApplication())
}

@Database(
    entities = [SeatDB::class],
    version = 1,
    exportSchema = false
)

abstract class CafDatabase : RoomDatabase() {
    abstract val seatsDao: SeatsDao

}