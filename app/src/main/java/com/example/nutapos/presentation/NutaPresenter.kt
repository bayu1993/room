package com.example.nutapos.presentation

import com.example.nutapos.base.BasePresenter
import com.example.nutapos.db.Rekening
import com.example.nutapos.db.RekeningDao
import com.example.nutapos.db.UangMasuk
import com.example.nutapos.db.UangMasukDao
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

class NutaPresenter(val uangMasukDao: UangMasukDao, val rekeningDao: RekeningDao) : BasePresenter<View> {
    private var mView: View? = null
    private val executorService: ExecutorService = Executors.newSingleThreadExecutor()

    override fun onAttach(view: View) {
        mView = view
    }

    override fun onDetach() {
        mView = null
    }

    fun insertData(uangMasuk: UangMasuk) {
        executorService.execute{
            uangMasukDao.insertAll(uangMasuk)
            mView?.onInsertSuccess()
        }
    }

    fun insertRekening(rekening: Rekening){
        executorService.execute {
            rekeningDao.insert(rekening)
            mView?.onInsertRekeningSuccess()
        }
    }
}