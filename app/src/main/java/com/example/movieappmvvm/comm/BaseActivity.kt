package com.example.movieappmvvm.comm

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

abstract class BaseActivity<R: BaseViewModel>: AppCompatActivity() {
    abstract val viewModel: R

    abstract fun initView()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initView()
    }
}