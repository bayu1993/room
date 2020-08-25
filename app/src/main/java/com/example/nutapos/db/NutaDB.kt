package com.example.nutapos.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase


@Database(entities = [UangMasuk::class], version = 2, exportSchema = true)
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
                    ).fallbackToDestructiveMigration()
                        .build()
                }
            }
            return INSTANCE as NutaDB
        }
    }
}