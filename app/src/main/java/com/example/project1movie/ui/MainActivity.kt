package com.example.project1movie.ui

import com.example.project1movie.R
import com.example.project1movie.base.BaseActivity
import com.example.project1movie.ui.homepage.HomePageFragment

class MainActivity : BaseActivity() {

    override fun getLayoutId() = R.layout.activity_main

    override fun onInit() {
        supportFragmentManager.beginTransaction()
            .add(R.id.mFrameMain, HomePageFragment()).commit()
    }

    override fun onEvent() {
    }
}