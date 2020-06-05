package com.example.android.ui.recyclerview_multiple_view_types.foryou.holder

import android.view.View
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.android.R
import com.example.android.base.BaseViewHolder
import com.example.android.data.InfoFood
import com.example.android.other.ViewHolderListener
import kotlinx.android.synthetic.main.item_layout_inner_for_you.view.*

class InnerForYouHolder internal constructor(view: View, listener: ViewHolderListener<InfoFood>) :
    BaseViewHolder<InfoFood, InfoFood>(view, listener) {

    override fun bindData(data: InfoFood?) {
        if (data != null) {
            var sTemp = ""

            sTemp = data.image
            if (!sTemp.isEmpty()) {
                Glide.with(itemView.context)
                    .load(sTemp)
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .into(itemView.imgFood)
            }

            sTemp = data.name
            if (!sTemp.isEmpty()) {
                itemView.tvNameShop.text = sTemp
            }

            itemView.tvTime.text = itemView.context.getString(
                R.string.time,
                data.shipping_duration_min.toString(), data.shipping_duration_max.toString()
            )
            itemView.tvDisCount.text =
                itemView.context.getString(R.string.discount, "${data.discount}")

            itemView.setOnClickListener {
                sendListener(data)
            }
        }
    }
}