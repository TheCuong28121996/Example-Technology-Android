package com.example.android.ui.merge_adapter.holder

import android.view.View
import com.bumptech.glide.Glide
import com.example.android.base.BaseViewHolder
import com.example.android.data.Banner
import com.example.android.other.ViewHolderListener
import kotlinx.android.synthetic.main.item_layout_banner.view.*

class BannerHolder internal constructor(view: View?, listener: ViewHolderListener<Banner>?) :
    BaseViewHolder<Banner>(view, listener) {

    override fun bindData(data: Banner?) {
        if(data != null){
            Glide.with(itemView.imageViewBanner.context)
                .load(data.bannerImage)
                .into(itemView.imageViewBanner)
        }
    }
}