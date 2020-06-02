package com.example.android.ui.flutter_module

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import com.example.android.R
import com.example.android.base.BaseFragment
import com.example.android.utils.DebugLog.showToast
import io.flutter.embedding.android.FlutterActivity
import io.flutter.plugin.common.MethodChannel
import kotlinx.android.synthetic.main.input_numbers_fragment.*

/**
 * @author TheCuong
 * @since 01/06/2018
 */
class InputNumbersFragment: BaseFragment() {

    override fun getLayoutResId(): Int = R.layout.input_numbers_fragment

    override fun initView() {
        btnSend.setOnClickListener {
            val pair = isInputValid()
            if (pair != null) {
                sendDataToFlutterModule(pair.first, pair.second)
            }
        }
    }

    override fun initData() {

    }

    override fun startObserve() {
    }

    private fun sendDataToFlutterModule(first: Int, second: Int) {
        startActivity(
            FlutterActivity.createDefaultIntent(requireContext())
        )
    }

    private fun isInputValid(): Pair<Int, Int>?{
        val number1 = et_number_1.text.toString()
        val number2 = et_number_2.text.toString()

        when {
            number1.isBlank() -> showToast(requireContext(),"Please enter first number")
            number2.isBlank() -> showToast(requireContext(),"Please enter second number")
            else -> return Pair(number1.toInt(), number2.toInt())
        }

        return null
    }

    @SuppressLint("SetTextI18n")
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == 100) {
            if (resultCode == Activity.RESULT_OK) {
                val result = data?.extras?.getInt("result")
                val operation = data?.extras?.getString("operation")

                tvResult.text = "${when (operation) {
                    "Add" -> "Addition"
                    "Multiply" -> "Multiplication"
                    else -> "NA"
                }} of the entered numbers is $result"
            } else {
                tvResult.text = "Could not perform the operation"
            }
        }
    }
}