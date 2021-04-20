package com.example.movieappmvvm.util

import android.util.Log
import com.example.movieappmvvm.BuildConfig

class Debug {
    companion object {
        fun log(log: String) {
            if (BuildConfig.DEBUG)
                Log.d("Debug", log)
        }

        fun log(tag: String, log: String) {
            if (BuildConfig.DEBUG)
                Log.d(tag, log)
        }

        fun err(log: String) {
            if (BuildConfig.DEBUG)
                Log.e("Debug", log)
        }
    }
}