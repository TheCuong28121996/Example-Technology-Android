package com.example.android.ui.message_facebook

import android.content.Intent
import android.net.Uri
import android.os.Build
import android.provider.Settings
import androidx.annotation.RequiresApi
import com.example.android.R
import com.example.android.base.BaseFragment
import com.example.android.service.MyService
import kotlinx.android.synthetic.main.message_fragment.*


class MessageFragment: BaseFragment() {

    override fun getLayoutResId(): Int = R.layout.message_fragment

    @RequiresApi(Build.VERSION_CODES.M)
    override fun initView() {

        if (!Settings.canDrawOverlays(requireContext())) {
            val intent = Intent(Settings.ACTION_MANAGE_OVERLAY_PERMISSION,
                Uri.parse("package:" + requireContext().packageName))
            startActivityForResult(intent, 0)
        }

        btn_start.setOnClickListener {
            requireContext().startService(Intent(requireContext(), MyService::class.java))
        }

        btn_stop.setOnClickListener {
            requireContext().stopService(Intent(requireContext(), MyService::class.java))
        }
    }

    override fun initData() {

    }

    override fun startObserve() {
    }
}