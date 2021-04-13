package com.example.movieapp_mvvm.comm

import android.app.Application
import com.example.movieapp_mvvm.service.RetrofitService
import com.google.gson.GsonBuilder
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import kotlin.math.sin


class BaseApplication : Application() {
    private val baseUrl = "https://yts.mx/api/v2/"

    val retrofitModule = module {
        single {
            GsonBuilder().setLenient().create()
        }

        single {
            Retrofit.Builder()
                .baseUrl(baseUrl)
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(get()))
                .build()
        }

        single {
            get<Retrofit>().create(RetrofitService::class.java)
        }
    }

    val myDiModules = listOf(
        retrofitModule
    )

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(applicationContext)
            modules(myDiModules)
        }
    }
}