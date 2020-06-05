package com.example.android.ui.recyclerview_multiple_view_types.banner.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.android.R
import com.example.android.base.BaseAdapter
import com.example.android.base.BaseViewHolder
import com.example.android.data.BannerFood
import com.example.android.ui.recyclerview_multiple_view_types.banner.holder.ViewPagerHolder

class ViewPagerAdapter: BaseAdapter<BannerFood, BannerFood>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<BannerFood, BannerFood> {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_layout_image, parent, false)
        view.layoutParams = ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)
        return ViewPagerHolder(
            view, getListener())
    }
}

