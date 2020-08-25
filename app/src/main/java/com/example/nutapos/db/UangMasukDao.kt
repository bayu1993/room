package com.example.nutapos.db

import androidx.room.*

@Dao
interface UangMasukDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(users: UangMasuk)
}