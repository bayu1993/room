package com.example.nutapos.presentation

import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.example.nutapos.R
import com.example.nutapos.db.NutaDB
import com.example.nutapos.db.UangMasuk
import com.example.nutapos.utils.Utils
import kotlinx.android.synthetic.main.activity_main.*
import java.time.LocalDate
import java.time.ZoneId
import java.util.*

class MainActivity : AppCompatActivity(), View {
    lateinit var presenter: NutaPresenter

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val db = NutaDB.getDatabase(this)
        presenter = NutaPresenter(db.uangMasukDao())
        presenter.insertData(UangMasuk(null, "elissa", "transfer", 12, 1, "02/02/2020"))
        val result = LocalDate.now()
        Utils.getIdTransaksi(Date.from(result.atStartOfDay(ZoneId.of("GMT+7")).toInstant()), 3).forEach {
            Log.d("cek data","data > $it")
        }
        onAttachView()
    }

    override fun onInsertSuccess() {
        tv_greeting.text = "insert success"
    }

    override fun onAttachView() {
        presenter.onAttach(this)
    }

    override fun onDetachView() {
        presenter.onDetach()
    }

    override fun onDestroy() {
        onDetachView()
        super.onDestroy()
    }
}