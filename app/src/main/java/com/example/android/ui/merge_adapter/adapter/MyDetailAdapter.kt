package com.example.android.ui.merge_adapter.adapter

import android.view.ViewGroup
import com.example.android.R
import com.example.android.base.BaseAdapter
import com.example.android.base.BaseViewHolder
import com.example.android.data.MyDetail
import com.example.android.ui.merge_adapter.holder.MyDetailHolder

class MyDetailAdapter : BaseAdapter<MyDetail>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<MyDetail> {
        return MyDetailHolder(
            createView(
                R.layout.item_layout_my_detail,
                parent
            ), getListener()
        )
    }
}