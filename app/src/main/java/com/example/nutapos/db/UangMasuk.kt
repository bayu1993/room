package com.example.nutapos.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class UangMasuk(
    @PrimaryKey val uangMasukID: Int,
    @ColumnInfo(name = "terimaDari") val terimaDari: String,
    @ColumnInfo(name = "keterangan") val keterangan: String,
    @ColumnInfo(name = "jumlah") val jumlah: Int
)