package com.example.movieappmvvm.view.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.movieappmvvm.R
import com.example.movieappmvvm.comm.BaseActivity
import com.example.movieappmvvm.util.Debug
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : BaseActivity<MainViewModel>() {
    override val viewModel: MainViewModel by viewModel()
    override val layoutResourceId: Int
        get() = R.layout.activity_main

    override fun initView() {
        viewModel.callMovies(
            success = {
                Debug.log("list in activity : $it")
            },
            fail = {}
        )
    }
}