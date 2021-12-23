package com.example.movieappmvvm.view.dialog

import android.app.Dialog
import android.content.Context
import android.view.Window
import com.example.movieappmvvm.R

class LoadingDialog(context: Context) : Dialog(context) {
    init {
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(R.layout.dialog_loading)

        val wm = window!!.attributes
        wm.copyFrom(window!!.attributes)
        wm.width = android.view.WindowManager.LayoutParams.MATCH_PARENT
        wm.height = android.view.WindowManager.LayoutParams.WRAP_CONTENT
    }
}