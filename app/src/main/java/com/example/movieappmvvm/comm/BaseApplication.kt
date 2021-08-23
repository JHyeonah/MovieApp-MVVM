package com.example.movieappmvvm.comm

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

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