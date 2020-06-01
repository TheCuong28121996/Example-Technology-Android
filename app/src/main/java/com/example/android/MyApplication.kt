package com.example.android

import android.app.Application
import com.facebook.drawee.backends.pipeline.Fresco
import com.google.gson.Gson
import io.flutter.embedding.engine.FlutterEngine
import io.flutter.embedding.engine.FlutterEngineCache
import io.flutter.embedding.engine.dart.DartExecutor

open class MyApplication: Application() {

    private lateinit var mGson: Gson
    private lateinit var flutterEngine : FlutterEngine

    override fun onCreate() {
        super.onCreate()

        instance = this

        mGson = Gson()

        initFresco()

        flutterEngine = FlutterEngine(this)
        flutterEngine.navigationChannel.setInitialRoute("/")

        flutterEngine.dartExecutor.executeDartEntrypoint(
            DartExecutor.DartEntrypoint.createDefault()
        )

        FlutterEngineCache
            .getInstance()
            .put("my_engine_id", flutterEngine)
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