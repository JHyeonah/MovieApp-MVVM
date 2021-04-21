package com.example.movieappmvvm.comm

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

abstract class BaseActivity<R: BaseViewModel>: AppCompatActivity() {
    abstract val viewModel: R
    abstract val layoutResourceId: Int
    abstract fun initView()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layoutResourceId)
        initView()
    }
}