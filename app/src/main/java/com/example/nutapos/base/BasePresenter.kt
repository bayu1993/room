package com.example.nutapos.base


interface BasePresenter<T: BaseView>{
    fun onAttach(view: T)

    fun onDetach()
}