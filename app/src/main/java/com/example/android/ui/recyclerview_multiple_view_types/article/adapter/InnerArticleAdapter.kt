package com.example.android.ui.recyclerview_multiple_view_types.article.adapter

import android.view.ViewGroup
import com.example.android.R
import com.example.android.base.BaseAdapter
import com.example.android.base.BaseViewHolder
import com.example.android.data.BannerFood
import com.example.android.ui.recyclerview_multiple_view_types.article.holder.InnerArticleHolder

class InnerArticleAdapter: BaseAdapter<BannerFood, BannerFood>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<BannerFood, BannerFood> {
        return InnerArticleHolder(
            createView(
                R.layout.item_layout_inner_article,
                parent
            ), getListener()
        )
    }
}