package com.example.android.base

import android.app.Dialog
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.android.utils.CommonUtils
import com.example.android.utils.DebugLog
import java.util.*

/**
 * @author TheCuong
 * @since 01/06/2018
 */
abstract class BaseActivity : AppCompatActivity() {

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

    fun showMessage(message: String) {
        DebugLog.showToast(this, message)
//        CommonUtils.messageDialog("Notification",message, this,"Cancle", "", true, object: DialogListener{
//            override fun onPositiveClick() {
//                TODO("Not yet implemented")
//            }
//
//            override fun onNegativeClick() {
//                TODO("Not yet implemented")
//            }
//
//        })
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