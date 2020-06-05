package com.example.android.utils

import androidx.recyclerview.widget.GridLayoutManager

class Custom_SpansizeArticle(private val spanCnt1: Int, private val spanCnt2: Int) :
    GridLayoutManager.SpanSizeLookup() {

    override fun getSpanSize(position: Int): Int {
        var result = 0
        if (position >= 0 && position <= 1) {
            result = spanCnt2
        } else if (position >= 1 && position <= 2) {
            result = spanCnt1
        }
        return result
    }
}