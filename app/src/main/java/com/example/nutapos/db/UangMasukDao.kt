package com.example.nutapos.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface UangMasukDao {
    @Query("SELECT * FROM uangmasuk")
    fun getAll(): List<UangMasuk>

    @Insert
    fun insertAll(vararg users: UangMasuk)

    @Delete
    fun delete(user: UangMasuk)
    
}