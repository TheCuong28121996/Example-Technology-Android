package com.example.android.utils

import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import android.os.Build
import android.view.Gravity
import android.view.Window
import android.view.WindowManager
import com.example.android.R
import com.example.android.other.DialogListener
import com.example.android.utils.DebugLog
import java.io.ByteArrayOutputStream
import java.io.File
import java.io.IOException

/**
 * @author TheCuong
 * @since 01/06/2018
 */
object CommonUtils {
    // This is func show loading
    fun showLoadingDialog(context: Context?): Dialog {
        val mProgressDialog = Dialog(context !!)
        mProgressDialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        mProgressDialog.setCancelable(false)
        mProgressDialog.setContentView(R.layout.progress_dialog)
        mProgressDialog.show()
        if(mProgressDialog.window != null){
            mProgressDialog.window!!.setBackgroundDrawableResource(android.R.color.transparent)
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                val lp = WindowManager.LayoutParams()
                lp.width = WindowManager.LayoutParams.WRAP_CONTENT
                lp.height = WindowManager.LayoutParams.WRAP_CONTENT
                lp.gravity = Gravity.CENTER
                mProgressDialog.window!!.attributes = lp
            } else {
                mProgressDialog.window!!.clearFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND)
            }
            if (!mProgressDialog.isShowing) {
                mProgressDialog.show()
            }
        }
        return mProgressDialog
    }

    fun bitmapPicture(bitmap: Bitmap?): ByteArray? {
        var byteArray: ByteArray? = null
        val percent = 0.6 //Scale down 30%
        var size = 0
        if (null != bitmap) {
            size = Math.ceil(percent * bitmap.width).toInt() * Math.ceil(
                percent * bitmap.height
            ).toInt()
        }
        if (0 < size) {
            val stream = ByteArrayOutputStream(size)
            try {
                bitmap!!.compress(Bitmap.CompressFormat.JPEG, 80, stream)
                byteArray = stream.toByteArray()
                bitmap.recycle() // Don't recycle when show picture via current bitmap
            } catch (e: Exception) {
                DebugLog.showError(e.message!!)
            } finally {
                try {
                    stream.flush()
                    stream.close()
                } catch (e: IOException) {
                    DebugLog.showError(e.message!!)
                }
            }
        }
        return byteArray
    }

    fun getFileName(orderCode: String, receiverInfo: String): String {
        var fileName = "locker_$orderCode"
        if (!receiverInfo.isEmpty()) {
            fileName = fileName + "_" + receiverInfo
        }
        fileName = fileName + "_%d.jpg"
        fileName = String.format(fileName, System.currentTimeMillis())
        return fileName
    }

    fun removeFile(file: File?) {
        if (null == file) {
            return
        }
        try {
            if (file.exists()) {
                DebugLog.show("iLogicHub", "removeFile")
                file.delete()
            }
        } catch (e: Exception) {
            DebugLog.showError(e.message!!)
        }
    }

    private fun openCallPhone(
        context: Context,
        phoneNumber: String
    ) {
        val intent = Intent(Intent.ACTION_DIAL)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
        intent.data = Uri.parse("tel:$phoneNumber")
        context.startActivity(intent)
    }

    fun messageDialog(title: String,
        msg: String, context: Context?
        , positiveButtonText: String, negativeButtonText: String,
        isCancellable: Boolean,
        dialogListener: DialogListener
    ) {
        context?.let { context ->
            val builder =
                AlertDialog.Builder(context)
            builder.setTitle(title)
            builder.setMessage(msg)
            builder.setCancelable(isCancellable)
            builder.setPositiveButton(positiveButtonText) { dialogInterface: DialogInterface?, i: Int ->
                dialogListener.onPositiveClick()
                dialogInterface?.dismiss()
            }
            builder.setNegativeButton(negativeButtonText)
            { dialogInterface: DialogInterface?, i: Int ->
                dialogListener.onNegativeClick()
                dialogInterface?.dismiss()
            }
            val alertDialog = builder.create()
            alertDialog.show()
        }
    }
}
