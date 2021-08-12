package com.example.movieappmvvm.comm

import android.app.Application
import com.example.movieappmvvm.service.RetrofitService
import com.example.movieappmvvm.view.main.MainViewModel
import com.google.gson.GsonBuilder
import dagger.hilt.android.HiltAndroidApp
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.startKoin
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

@HiltAndroidApp
class BaseApplication : Application() {
//    private val baseUrl = "https://yts.mx/api/v2/"
//
//    private val viewModelModule = module {
//        viewModel { BaseViewModel() }
//        viewModel { MainViewModel() }
//    }
//
//    private val retrofitModule = module {
//        single {
//            GsonBuilder().setLenient().create()
//        }
//
//        single {
//            Retrofit.Builder()
//                .baseUrl(baseUrl)
//                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
//                .addConverterFactory(GsonConverterFactory.create(get()))
//                .build()
//        }
//
//        single {
//            get<Retrofit>().create(RetrofitService::class.java)
//        }
//    }
//
//    private val myDiModules = listOf(
//        viewModelModule,
//        retrofitModule
//    )
//
//    override fun onCreate() {
//        super.onCreate()
//
//        startKoin {
//            androidContext(applicationContext)
//            modules(myDiModules)
//        }
//    }
}