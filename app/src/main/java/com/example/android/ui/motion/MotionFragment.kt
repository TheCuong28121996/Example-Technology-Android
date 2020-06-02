package com.example.android.ui.motion

import android.view.View
import com.example.android.R
import com.example.android.base.BaseFragment

/**
 * @author TheCuong
 * @since 01/06/2018
 */
class MotionFragment : BaseFragment(){

    override fun getLayoutResId(): Int = R.layout.motion_fragment

    override fun initView() {
        setVisibilityToolBar(View.VISIBLE, "Motion Layout")
    }

    override fun initData() {
    }

    override fun startObserve() {
    }
}