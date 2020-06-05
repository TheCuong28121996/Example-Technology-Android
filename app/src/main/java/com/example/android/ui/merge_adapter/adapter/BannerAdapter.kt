package com.example.android.ui.merge_adapter.adapter

import android.view.ViewGroup
import com.example.android.R
import com.example.android.base.BaseAdapter
import com.example.android.base.BaseViewHolder
import com.example.android.data.Banner
import com.example.android.ui.merge_adapter.holder.BannerHolder

/**
 * @author TheCuong
 * @since 01/06/2018
 */
class BannerAdapter : BaseAdapter<Banner, Banner>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BaseViewHolder<Banner, Banner> {
        return BannerHolder(createView(R.layout.item_layout_banner, parent), getListener())
    }
}