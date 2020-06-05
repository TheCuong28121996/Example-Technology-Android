package com.example.android.ui.recyclerview_multiple_view_types.tab_category

import android.view.View
import com.example.android.base.BaseViewHolder
import com.example.android.data.BaseModel
import com.example.android.data.TabEntity
import com.example.android.other.ViewHolderListener
import com.example.android.utils.DebugLog
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.item_layout_tab_category.view.*

class TabCategoryHolder internal constructor(view: View, listener: ViewHolderListener<TabEntity>) :
    BaseViewHolder<BaseModel<TabEntity>, TabEntity>(view, listener) {

    override fun bindData(data: BaseModel<TabEntity>?) {

        if (data != null) {
            for (item in data.entity) {
                itemView.tabLayout.addTab(itemView.tabLayout.newTab().setText(item.name))
            }

            itemView.tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {

                override fun onTabReselected(tab: TabLayout.Tab?) {

                }

                override fun onTabUnselected(tab: TabLayout.Tab?) {
                }

                override fun onTabSelected(tab: TabLayout.Tab?) {
                    sendListener(data.entity[tab!!.position])
                }
            })
        }
    }
}