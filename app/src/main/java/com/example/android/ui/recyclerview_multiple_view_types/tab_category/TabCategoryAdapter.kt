package com.example.android.ui.recyclerview_multiple_view_types.tab_category

import android.view.ViewGroup
import com.example.android.R
import com.example.android.base.BaseAdapter
import com.example.android.base.BaseViewHolder
import com.example.android.data.BaseModel
import com.example.android.data.TabEntity

class TabCategoryAdapter : BaseAdapter<BaseModel<TabEntity>, TabEntity>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BaseViewHolder<BaseModel<TabEntity>, TabEntity> {
        return TabCategoryHolder(
            createView(R.layout.item_layout_tab_category, parent), getListener()
        )
    }
}