package com.example.android.utils

import android.annotation.SuppressLint
import android.content.Context
import android.text.TextUtils
import android.util.Log
import android.widget.Toast
import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*

/**
 * @author TheCuong
 * @since 01/06/2018
 */
object DebugLog {
    private const val TAG = "Logger"
    private const val DOT_LEVEL = 5 //3 package name dots + 2
    private var mTag = TAG
    private var isDebug = true
    fun init(tag: String, isDebuggable: Boolean) {
        mTag = tag
        if (TextUtils.isEmpty(tag)) {
            mTag = TAG
        }
        isDebug = isDebuggable
    }

    /**
     * <pre>
     * Show log with Debug able in android
     *
     * @param logType includes Log.DEBUG, INFO, VERBOSE, WARN, ERROR
     * @param tag     name for search
     * @param msg     message when show log
    </pre> */
    private fun show(logType: Int, tag: String?, msg: String) {
        var tag = tag
        if (!isDebug) {
            return
        }
        if (TextUtils.isEmpty(tag)) {
            tag = mTag
        }
        when (logType) {
            Log.DEBUG -> Log.d(tag, log(msg, DOT_LEVEL))
            Log.VERBOSE -> Log.v(tag, log(msg, DOT_LEVEL))
            Log.ERROR -> Log.e(tag, log(msg, DOT_LEVEL))
            Log.INFO -> Log.i(tag, log(msg, DOT_LEVEL))
            else ->  // is Log.WARN
                Log.w(tag, log(msg, DOT_LEVEL))
        }
    }

    /**
     * Show log (Log.DEBUG) with tag and message
     *
     * @param tag filter tag
     * @param msg message when show log
     */
    fun show(tag: String?, msg: String) {
        show(Log.DEBUG, tag, msg)
    }

    /**
     * Show log (Log.DEBUG) with message
     *
     * @param msg message when show log
     */
    fun show(msg: String) {
        show(Log.DEBUG, null, msg)
    }

    /**
     * Show log (Log.DEBUG)
     */
    fun show() {
        show(Log.VERBOSE, null, "*** DEBUG LOG ***")
    }

    /**
     * Show log (Log.DEBUG)
     */
    fun showError(msg: String) {
        show(Log.ERROR, null, msg)
    }

    fun showToast(context: Context?, msg: String?) {
        if (null != context) {
            Toast.makeText(context, msg, Toast.LENGTH_LONG).show()
        }
    }

    /**
     * General message
     * <pre>
     * ClassName.methodName():lineNumber
     * => message more
    </pre> *
     */
    private fun log(msg: String?, level: Int): String {
        val fullClassName = Thread.currentThread().stackTrace[level].className
        val methodName = Thread.currentThread().stackTrace[level].methodName
        val lineNumber = Thread.currentThread().stackTrace[level].lineNumber
        var result = "$fullClassName.$methodName():$lineNumber"
        if (null != msg && "" != msg) {
            result = "$result\n=> $msg"
        }
        return result
    }

    @SuppressLint("SimpleDateFormat")
    private fun getCurrentDate(msg: String): String {
        var msg: String? = msg
        val dateFormat: DateFormat = SimpleDateFormat("yyyy/MM/dd HH:mm:ss.SSS")
        //get current date time with Calendar()
        val cal = Calendar.getInstance()
        if (null == msg) {
            msg = ""
        }
        msg = msg + "\n" + dateFormat.format(cal.time)
        return msg
    }

    fun showTime(msg: String) {
        var msg = msg
        msg = getCurrentDate(msg)
        show(Log.INFO, mTag, msg)
    }

    fun memoryUsed(message: String?) {
        var message = message
        if (null == message) {
            message = ""
        }
        val rt = Runtime.getRuntime()
        val kb: Long = 1024
        val maxMemory = rt.maxMemory() / kb
        val totalMemory = rt.totalMemory() / kb
        val freeMemory = rt.freeMemory() / kb
        val usedMemory = totalMemory - freeMemory
        val msg = "MEMORY: " + message +
                "\n Used Memory: " + usedMemory + "(kb) => (total - free = " + totalMemory + " - " + freeMemory + ")" +
                "\n Max Memory(Heap Size): " + maxMemory + "(kb)"
        show(Log.INFO, mTag, msg)
    }

    /**
     * Get device density
     */
    fun deviceDensity(context: Context?) {
        if (null != context) {
            val metrics = context.resources.displayMetrics
            val density = metrics.density
            var msg = "---- -- ----\n"
            msg += "Density: $density => "
            msg += if (density >= 4.0) {
                "xxxhdpi"
            } else if (density >= 3.0) {
                "xxhdpi"
            } else if (density >= 2.0) {
                "xhdpi"
            } else if (density >= 1.5) {
                "hdpi"
            } else if (density >= 1.0) {
                "mdpi"
            } else {
                "ldpi"
            }
            msg += " : " + metrics.widthPixels + "x" + metrics.heightPixels
            msg += "\n--- --- --- ---"
            show(Log.INFO, mTag, msg)
        }
    }

    fun showJson(tag: String, jsonString: String) {
        var jsonString = jsonString
        if (!isDebug) {
            return
        }
        if (TextUtils.isEmpty(jsonString)) {
            Log.e(tag, "EMPTY or NULL")
            return
        }
        val maxLogLength = 3600 // Max is 4000
        val length = jsonString.length
        //Log.e(tag, "Length: " + length);
        if (maxLogLength > length) {
            Log.i(tag, jsonString)
            return
        }
        var isNext: Boolean
        isNext = jsonArray(tag, jsonString)
        if (!isNext) {
            return
        }
        isNext = jsonObject(tag, jsonString)
        if (!isNext) {
            return
        }
        var i = 0
        val chunkCount = Math.ceil(length / maxLogLength.toDouble()).toInt()
        while (jsonString.length > maxLogLength) {
            i++
            Log.i(tag, "(" + i + " of " + chunkCount + ")\n" + jsonString.substring(0, maxLogLength))
            jsonString = jsonString.substring(maxLogLength)
        }
        Log.i(tag, "($i of $chunkCount)\n$jsonString")
    }

    private fun jsonObject(tag: String, jsonString: String): Boolean {
        var isNext = false
        try {
            val json = JSONObject(jsonString)
            var jsonKey: String
            var sTemp: String
            val keys: Iterator<*> = json.keys()
            while (keys.hasNext()) {
                jsonKey = keys.next().toString()
                sTemp = jsonKey + ": " + json.getString(jsonKey)
                Log.i(tag, sTemp)
            }
        } catch (e: JSONException) { //Log.e(tag, e.getMessage());
            isNext = true
        } catch (e: Exception) { //Log.e(tag, e.getMessage());
            isNext = true
        }
        return isNext
    }

    private fun jsonArray(tag: String, jsonString: String): Boolean {
        var isNext = false
        try {
            val jsonArray = JSONArray(jsonString)
            var sTemp: String
            for (i in 0 until jsonArray.length()) {
                sTemp = jsonArray.getJSONObject(i).toString()
                sTemp = "$i. $sTemp"
                //Show Log
                Log.i(tag, sTemp)
            }
        } catch (e: JSONException) { //Log.e(tag, e.getMessage());
            isNext = true
        } catch (e: Exception) { //Log.e(tag, e.getMessage());
            isNext = true
        }
        return isNext
    }
}