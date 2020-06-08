package com.example.android.ui.recyclerview_multiple_view_types.menu.adapter

import android.view.ViewGroup
import com.example.android.R
import com.example.android.base.BaseAdapter
import com.example.android.base.BaseViewHolder
import com.example.android.data.InfoFood
import com.example.android.ui.recyclerview_multiple_view_types.menu.holder.InnerMenuHolder

class InnerMenuAdapter: BaseAdapter<InfoFood, InfoFood>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BaseViewHolder<InfoFood, InfoFood> {
        return InnerMenuHolder(createView(R.layout.item_layout_info_food, parent), getListener())
    }
}