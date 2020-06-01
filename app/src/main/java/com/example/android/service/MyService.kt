package com.example.android.service

import android.annotation.SuppressLint
import android.app.Service
import android.content.Intent
import android.graphics.PixelFormat
import android.os.IBinder
import android.view.Gravity
import android.view.MotionEvent
import android.view.View
import android.view.WindowManager
import android.widget.ImageView
import com.example.android.R

class MyService: Service() {

    private var mWindowManager: WindowManager? = null
    private var image: ImageView? = null

    @SuppressLint("ClickableViewAccessibility")
    override fun onCreate() {
        super.onCreate()

        image = ImageView(this)
        image!!.setImageResource(R.mipmap.ic_launcher)

        mWindowManager = getSystemService(WINDOW_SERVICE) as WindowManager

        val paramsF =
            WindowManager.LayoutParams(
                WindowManager.LayoutParams.WRAP_CONTENT,
                WindowManager.LayoutParams.WRAP_CONTENT,
                WindowManager.LayoutParams.TYPE_PHONE,
                WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE,
                PixelFormat.TRANSLUCENT
            )

        paramsF.gravity = Gravity.TOP or Gravity.LEFT
        paramsF.x = 0
        paramsF.y = 100
        mWindowManager!!.addView(image, paramsF)

        try {
            image!!.setOnTouchListener(object : View.OnTouchListener{
                private var initialX = 0
                private var initialY = 0
                private var initialTouchX = 0f
                private var initialTouchY = 0f

                override fun onTouch(v: View?, event: MotionEvent?): Boolean {
                    when (event!!.action) {
                        MotionEvent.ACTION_DOWN -> {
                            initialX = paramsF.x
                            initialY = paramsF.y
                            initialTouchX = event.rawX
                            initialTouchY = event.rawY
                        }
                        MotionEvent.ACTION_UP -> {
                        }
                        MotionEvent.ACTION_MOVE -> {
                            paramsF.x = initialX + (event.rawX - initialTouchX).toInt()
                            paramsF.y = initialY + (event.rawY - initialTouchY).toInt()
                            mWindowManager!!.updateViewLayout(v, paramsF)
                        }
                    }
                    return false
                }
            })
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        if(mWindowManager != null){
            mWindowManager!!.removeView(image)
        }
    }

    override fun onBind(intent: Intent?): IBinder? {
        return null
    }
}
