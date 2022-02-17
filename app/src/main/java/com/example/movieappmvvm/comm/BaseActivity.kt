package com.example.movieappmvvm.comm

import android.graphics.Color
import android.os.Build
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.movieappmvvm.R

abstract class BaseActivity<T: BaseViewModel>: AppCompatActivity() {
    abstract val viewModel: T
    abstract val layoutResourceId: Int
    abstract fun initView()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(layoutResourceId)
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
//            window.navigationBarColor = ContextCompat.getColor(this, R.color.deepGray)
//        }
//        initView()
    }
}