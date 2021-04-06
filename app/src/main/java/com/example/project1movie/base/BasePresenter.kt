package com.example.project1movie.base

interface BasePresenter<T> {
    fun onStart()
    fun setView(view: T?)
}
