package com.example.nutapos.db

import androidx.room.*

@Dao
interface UangMasukDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(uangMasuk: UangMasuk)
}

@Dao
interface RekeningDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(rekening: Rekening)
}