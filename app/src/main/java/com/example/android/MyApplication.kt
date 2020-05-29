package com.example.android

import android.app.Application
import com.facebook.drawee.backends.pipeline.Fresco
import com.google.gson.Gson

open class MyApplication: Application() {
    private lateinit var mGson: Gson

    override fun onCreate() {
        super.onCreate()

        instance = this

        mGson = Gson()

        initFresco()
    }

    private fun initFresco(){
        Fresco.initialize(this)
    }

    fun getGSon(): Gson {
        return mGson
    }

    companion object {
        lateinit var instance: MyApplication
    }
}