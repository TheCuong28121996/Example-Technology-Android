package com.example.android.ui

import android.content.Intent
import android.view.View
import com.example.android.R
import com.example.android.base.BaseFragment
import com.example.compose_ui.ComposeActivity
import kotlinx.android.synthetic.main.main_fragment.*

/**
 * @author TheCuong
 * @since 01/06/2018
 */
class MainFragment : BaseFragment() {

    override fun getLayoutResId(): Int = R.layout.main_fragment

    override fun initView() {

        setVisibilityToolBar(View.VISIBLE, "Example Technology")

        btnMotionLayout.setOnClickListener {
            startFragment(R.id.action_mainFragment_to_motionFragment)
        }

        btnFlutterModule.setOnClickListener {
            startFragment(R.id.action_mainFragment_to_inputNumbersFragment)
        }

        btnMergeAdapter.setOnClickListener {
            startFragment(R.id.action_mainFragment_to_mergeAdapterFragment)
        }

        btnMessage.setOnClickListener {
            startFragment(R.id.action_mainFragment_to_messageFragment)
        }

        btnCompose.setOnClickListener {
            startActivity(Intent(requireContext(), ComposeActivity::class.java))
        }

        btnFood.setOnClickListener {
            startFragment(R.id.action_mainFragment_to_multipleViewTypeFragment)
        }
    }

    override fun initData() {
    }

    override fun startObserve() {

    }
}