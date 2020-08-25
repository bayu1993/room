package com.example.nutapos.utils

import java.util.*

object Utils {
    fun getIdTransaksi(date: Date, jmlTransOfDay: Int): List<String> {
        val cal = Calendar.getInstance(TimeZone.getTimeZone("GMT+7"))
        cal.time = date
        val year = cal[Calendar.YEAR]
        val month = cal[Calendar.MONTH]
        val day = cal[Calendar.DAY_OF_MONTH]
        val result = arrayListOf<String>()
        for (i in 1..jmlTransOfDay) {
            result.add("UM/${year.toString().takeLast(2)}$month$day/$i")
        }
        return result
    }
}