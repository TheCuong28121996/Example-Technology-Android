package com.example.android.base

import android.app.Dialog
import android.content.res.Resources
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.android.utils.DebugLog
import com.ilogic.roid.hub.utils.CommonUtils
import java.util.*

abstract class BaseActivity : AppCompatActivity() {

    protected val TAG = BaseActivity::class.java.simpleName
    private lateinit var mProgressDialog: Dialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutResId())

        initView()

        initData()

    }

    open fun getLayoutResId(): Int = 0

    abstract fun initView()

    abstract fun initData()

    abstract fun customToolBar(visibility: Int, title: String?)

    open fun getString(value: String): String? {

        val result = value
        var strRes = value;

        if (!strRes.isEmpty()) {
            val packageName: String = this.packageName
            val resources: Resources = this.resources
            var resId = 0

            // Default by input
            try {
                resId = resources.getIdentifier(strRes, "string", packageName)
            } catch (e: NullPointerException) {
                strRes = strRes.toUpperCase(Locale.getDefault())
            }

            if (0 < resId) {
                return getString(resId)
                //return resources.getString(resId);
            }

            // After change to UpperCase
            try {
                resId = resources.getIdentifier(strRes, "string", packageName)
            } catch (e: NullPointerException) {
                // Convert to LowerCase
                strRes = strRes.toLowerCase(Locale.getDefault())
            }
            if (0 < resId) {
                return getString(resId)
            }

            // After change to LowerCase
            try {
                resId = resources.getIdentifier(strRes, "string", packageName)
            } catch (e: NullPointerException) {
                // Ignore
            }
            if (0 < resId) {
                return getString(resId)
            }
        }
        return result
    }

    fun showMessage(message: String) {
       DebugLog.showToast(this, message)
    }

    fun showLoadingDialog() {
        hideLoadingDialog()
        mProgressDialog = CommonUtils.showLoadingDialog(this)
    }

    fun hideLoadingDialog() {
        if (this::mProgressDialog.isInitialized && mProgressDialog.isShowing) {
            mProgressDialog.dismiss()
        }
    }

    fun setToolBar(visibility: Int, title: String?) {
        customToolBar(visibility, title)
    }
}