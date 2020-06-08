package com.example.android.ui.recyclerview_multiple_view_types.menu.holder

import android.view.View
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.android.base.BaseViewHolder
import com.example.android.data.BaseModel
import com.example.android.data.InfoFood
import com.example.android.other.ViewHolderListener
import com.example.android.ui.recyclerview_multiple_view_types.menu.adapter.InnerMenuAdapter
import kotlinx.android.synthetic.main.item_layout_menu.view.*


class MenuHolder internal constructor(view: View, listener: ViewHolderListener<InfoFood>) :
    BaseViewHolder<BaseModel<InfoFood>, InfoFood>(view, listener) {

    private val mAdapter by lazy { InnerMenuAdapter() }

    override fun bindData(data: BaseModel<InfoFood>?) {
        if (data != null) {
            mAdapter.run {
                setOnItemClickListener(listener)
            }

            itemView.recyclerView.apply {
                itemAnimator = DefaultItemAnimator()
                setHasFixedSize(true)
                layoutManager = mLayoutManager
                adapter = mAdapter
            }

            mAdapter.addData(data.entity)
        }
    }

    private val mLayoutManager: GridLayoutManager =
        object : GridLayoutManager(itemView.context, 2) {
            override fun canScrollVertically(): Boolean {
                return false
            }
        }

    private val listener = object : ViewHolderListener<InfoFood> {
        override fun itemClicked(data: InfoFood, positon: Int) {
            sendListener(data)
        }
    }
}