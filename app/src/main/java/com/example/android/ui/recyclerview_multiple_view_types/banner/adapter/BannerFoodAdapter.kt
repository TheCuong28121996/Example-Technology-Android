package com.example.android.ui.recyclerview_multiple_view_types.banner.adapter

import android.view.ViewGroup
import com.example.android.R
import com.example.android.base.BaseAdapter
import com.example.android.base.BaseViewHolder
import com.example.android.data.BannerFood
import com.example.android.data.BaseModel
import com.example.android.ui.recyclerview_multiple_view_types.banner.holder.BannerFoodHolder

class BannerFoodAdapter: BaseAdapter<BaseModel<BannerFood>, BannerFood>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<BaseModel<BannerFood>, BannerFood> {
        return BannerFoodHolder(
            createView(
                R.layout.item_layout_banner_food,
                parent
            ), getListener()
        )
    }
}