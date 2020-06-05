package com.example.android.utils

import android.annotation.SuppressLint
import android.graphics.Rect
import android.view.View
import androidx.core.view.ViewCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class GridSpacingItemDecoration :
    RecyclerView.ItemDecoration() {
    private val padding = 5
    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        super.getItemOffsets(outRect, view, parent, state)
        val gridLayoutManager =
            (parent.layoutManager as GridLayoutManager?)!!
        val spanCount = gridLayoutManager.spanCount
        val params =
            view.layoutParams as GridLayoutManager.LayoutParams
        val spanIndex = params.spanIndex
        val spanSize = params.spanSize
        if (spanIndex == 0) {
            outRect.left = padding
        } else {
            outRect.left = padding
        }
        if (spanIndex + spanSize == spanCount) {
            outRect.right = padding
        } else {
            outRect.right = padding
        }
        outRect.top = padding
        outRect.bottom = padding
        if (isLayoutRTL(parent)) {
            val tmp = outRect.left
            outRect.left = outRect.right
            outRect.right = tmp
        }
    }

    companion object {
        @SuppressLint("NewApi", "WrongConstant")
        private fun isLayoutRTL(parent: RecyclerView): Boolean {
            return parent.layoutDirection == ViewCompat.LAYOUT_DIRECTION_RTL
        }
    }

}
