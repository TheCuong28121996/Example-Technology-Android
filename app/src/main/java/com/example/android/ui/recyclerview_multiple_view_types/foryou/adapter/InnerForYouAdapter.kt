package com.example.android.ui.recyclerview_multiple_view_types.foryou.adapter

import android.view.ViewGroup
import com.example.android.R
import com.example.android.base.BaseAdapter
import com.example.android.base.BaseViewHolder
import com.example.android.data.InfoFood
import com.example.android.ui.recyclerview_multiple_view_types.foryou.holder.InnerForYouHolder

class InnerForYouAdapter : BaseAdapter<InfoFood, InfoFood>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BaseViewHolder<InfoFood, InfoFood> {
        return InnerForYouHolder(
            createView(R.layout.item_layout_inner_for_you, parent), getListener()
        )
    }
}