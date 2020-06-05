package com.example.android.utils

import androidx.recyclerview.widget.GridLayoutManager

class Custom_SpanSize(private val spanCnt1: Int, private val spanCnt2: Int) :
    GridLayoutManager.SpanSizeLookup() {

    override fun getSpanSize(position: Int): Int {
        var result = 0
        if (position > 0 && position <= 3) {
            result = spanCnt2
        } else if (position >= 3) {
            result = spanCnt1
        }
        return result
    }
}