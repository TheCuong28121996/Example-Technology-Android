package com.example.android.ui.merge_adapter.adapter

import android.view.ViewGroup
import com.example.android.R
import com.example.android.base.BaseAdapter
import com.example.android.base.BaseViewHolder
import com.example.android.data.Detail
import com.example.android.ui.merge_adapter.holder.MyDetailHolder

/**
 * @author TheCuong
 * @since 01/06/2018
 */
class DetailAdapter : BaseAdapter<Detail>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<Detail> {
        return MyDetailHolder(
            createView(
                R.layout.item_layout_my_detail,
                parent
            ), getListener()
        )
    }
}