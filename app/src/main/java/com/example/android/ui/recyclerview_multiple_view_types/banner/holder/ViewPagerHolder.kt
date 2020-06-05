package com.example.android.ui.recyclerview_multiple_view_types.banner.holder

import android.view.View
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.android.base.BaseViewHolder
import com.example.android.data.BannerFood
import com.example.android.other.ViewHolderListener
import kotlinx.android.synthetic.main.item_layout_image.view.*

class ViewPagerHolder internal constructor(view: View, listener: ViewHolderListener<BannerFood>): BaseViewHolder<BannerFood, BannerFood>(view, listener) {

    override fun bindData(data: BannerFood?) {
        if(data != null){
            Glide.with(itemView.context)
                .load(data.bannerImage)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(itemView.image)

            itemView.image.setOnClickListener {
                sendListener(data)
            }
        }
    }
}