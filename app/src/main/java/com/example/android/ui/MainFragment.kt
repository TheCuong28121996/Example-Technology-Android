package com.example.android.ui

import android.view.View
import com.example.android.R
import com.example.android.base.BaseFragment
import kotlinx.android.synthetic.main.main_fragment.*

class MainFragment: BaseFragment() {

    override fun getLayoutResId(): Int = R.layout.main_fragment

    override fun initView() {

        setVisibilityToolBar(View.VISIBLE, "Example Technology")

        btnMotionLayout.setOnClickListener{
            startFragment(R.id.action_mainFragment_to_motionFragment)
        }

        btnFlutterModule.setOnClickListener {
            startFragment(R.id.action_mainFragment_to_inputNumbersFragment)
        }
    }

    override fun initData() {
    }

    override fun startObserve() {

    }
}