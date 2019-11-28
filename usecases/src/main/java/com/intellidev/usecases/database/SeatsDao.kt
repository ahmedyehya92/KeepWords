package com.intellidev.usecases.database

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Query
import com.intellidev.entities.SeatDB

@Dao
interface SeatsDao {

    @Query("select * from SeatDB ")
    fun queryAll(): List<SeatDB>
}