package com.example.nutapos.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.nutapos.R
import com.example.nutapos.db.NutaDB
import com.example.nutapos.db.UangMasuk
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View {
    lateinit var presenter: NutaPresenter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val db = NutaDB.getDatabase(this)
        presenter = NutaPresenter(db.uangMasukDao())
        presenter.insertData(UangMasuk(null, "elissa", "transfer", 12))
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