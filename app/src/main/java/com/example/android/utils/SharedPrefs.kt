package com.example.android.utils

import android.content.Context
import android.content.SharedPreferences
import com.example.android.MyApplication

/**
 * @author TheCuong
 * @since 01/06/2018
 */
class SharedPrefs private constructor() {
    private val mSharedPreferences: SharedPreferences

    operator fun <T> get(key: String?, anonymousClass: Class<T>): T? {
        return if (anonymousClass == String::class.java) {
            mSharedPreferences.getString(key, "") as T?
        } else if (anonymousClass == Boolean::class.java) {
            java.lang.Boolean.valueOf(mSharedPreferences.getBoolean(key, false)) as T
        } else if (anonymousClass == Float::class.java) {
            java.lang.Float.valueOf(mSharedPreferences.getFloat(key, 0f)) as T
        } else if (anonymousClass == Int::class.java) {
            Integer.valueOf(mSharedPreferences.getInt(key, 0)) as T
        } else if (anonymousClass == Long::class.java) {
            java.lang.Long.valueOf(mSharedPreferences.getLong(key, 0)) as T
        } else {
            MyApplication.instance.getGSon().fromJson(mSharedPreferences.getString(key, ""), anonymousClass)
        }
    }

    operator fun <T> get(key: String?, anonymousClass: Class<T>, defaultValue: T): T? {
        return if (anonymousClass == String::class.java) {
            mSharedPreferences.getString(key, defaultValue as String) as T?
        } else if (anonymousClass == Boolean::class.java) {
            java.lang.Boolean.valueOf(
                mSharedPreferences.getBoolean(
                    key,
                    (defaultValue as Boolean)
                )
            ) as T
        } else if (anonymousClass == Float::class.java) {
            java.lang.Float.valueOf(
                mSharedPreferences.getFloat(
                    key,
                    (defaultValue as Float)
                )
            ) as T
        } else if (anonymousClass == Int::class.java) {
            Integer.valueOf(
                mSharedPreferences.getInt(
                    key,
                    (defaultValue as Int)
                )
            ) as T
        } else if (anonymousClass == Long::class.java) {
            java.lang.Long.valueOf(
                mSharedPreferences.getLong(
                    key,
                    (defaultValue as Long)
                )
            ) as T
        } else {
            MyApplication.instance.getGSon().fromJson(mSharedPreferences.getString(key, ""), anonymousClass)
        }
    }

    fun <T> put(key: String?, data: T) {
        val editor = mSharedPreferences.edit()
        if (data is String) {
            editor.putString(key, data as String)
        } else if (data is Boolean) {
            editor.putBoolean(key, (data as Boolean))
        } else if (data is Float) {
            editor.putFloat(key, (data as Float))
        } else if (data is Int) {
            editor.putInt(key, (data as Int))
        } else if (data is Long) {
            editor.putLong(key, (data as Long))
        } else {
            editor.putString(key, MyApplication.instance.getGSon().toJson(data))
        }
        editor.apply()
    }

    fun clear() {
        mSharedPreferences.edit().clear().apply()
    }

    companion object {
        private const val PREFS_NAME = "share_prefs"
        private var mInstance: SharedPrefs? = null
        val instance: SharedPrefs?
            get() {
                if (mInstance == null) {
                    mInstance = SharedPrefs()
                }
                return mInstance
            }
    }

    init {
        mSharedPreferences = MyApplication.instance.getSharedPreferences(
            PREFS_NAME,
            Context.MODE_PRIVATE
        )
    }
}