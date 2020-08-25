package com.example.nutapos.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [UangMasukDao::class], version = 1)
abstract class NutaDB : RoomDatabase() {
    abstract fun uangMasukDao(): UangMasukDao

    companion object {
        @Volatile
        private var INSTANCE: NutaDB? = null

        @JvmStatic
        fun getDatabase(context: Context): NutaDB {
            if (INSTANCE == null) {
                synchronized(NutaDB::class.java) {
                    INSTANCE = Room.databaseBuilder(
                        context.applicationContext,
                        NutaDB::class.java,
                        "uang_masuk_db"
                    ).build()
                }
            }
            return INSTANCE as NutaDB
        }
    }
}