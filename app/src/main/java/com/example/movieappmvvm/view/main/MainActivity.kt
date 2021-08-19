package com.example.movieappmvvm.view.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.movieappmvvm.R
import com.example.movieappmvvm.comm.BaseActivity
import com.example.movieappmvvm.databinding.ActivityMainBinding
import com.example.movieappmvvm.util.Debug
import dagger.hilt.android.AndroidEntryPoint
import org.koin.androidx.viewmodel.ext.android.viewModel
import androidx.databinding.DataBindingUtil.setContentView

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView<ActivityMainBinding>(this, R.layout.activity_main)
    }
    //    override val viewModel: MainViewModel by viewModel()
//    override val layoutResourceId: Int
//        get() = R.layout.activity_main
//
//    override fun initView() {
//        viewModel.callMovies(
//            success = {
//                Debug.log("list in activity : $it")
//            },
//            fail = {}
//        )
//    }
}