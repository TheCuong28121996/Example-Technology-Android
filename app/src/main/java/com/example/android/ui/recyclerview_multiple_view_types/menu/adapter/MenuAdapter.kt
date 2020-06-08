package com.example.android.ui.recyclerview_multiple_view_types.menu.adapter

import android.view.ViewGroup
import com.example.android.R
import com.example.android.base.BaseAdapter
import com.example.android.base.BaseViewHolder
import com.example.android.data.BaseModel
import com.example.android.data.InfoFood
import com.example.android.ui.recyclerview_multiple_view_types.menu.holder.MenuHolder

class MenuAdapter: BaseAdapter<BaseModel<InfoFood>, InfoFood>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BaseViewHolder<BaseModel<InfoFood>, InfoFood> {
        return MenuHolder(
            createView(R.layout.item_layout_menu, parent), getListener()
        )
    }
}