package com.example.nutapos.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "uang_masuk")
data class UangMasuk(
    @PrimaryKey(autoGenerate = true) val uangMasukID: Int?,
    @ColumnInfo(name = "terimaDari") val terimaDari: String,
    @ColumnInfo(name = "keterangan") val keterangan: String,
    @ColumnInfo(name = "jumlah") val jumlah: Int,
    @ColumnInfo(name = "no") val no: Int,
    @ColumnInfo(name = "tgl") val tgl: String
)