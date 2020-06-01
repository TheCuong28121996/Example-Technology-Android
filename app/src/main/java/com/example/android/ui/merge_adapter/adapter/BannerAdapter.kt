package com.example.android.ui.merge_adapter.adapter

import android.view.ViewGroup
import com.example.android.R
import com.example.android.base.BaseAdapter
import com.example.android.base.BaseViewHolder
import com.example.android.data.Banner
import com.example.android.ui.merge_adapter.holder.BannerHolder

class BannerAdapter: BaseAdapter<Banner>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<Banner> {
        return BannerHolder(
            createView(
                R.layout.item_layout_banner,
                parent
            ), getListener()
        )
    }
}