package com.example.android.ui.recyclerview_multiple_view_types.foryou.holder

import android.view.View
import androidx.recyclerview.widget.DefaultItemAnimator
import com.example.android.base.BaseViewHolder
import com.example.android.data.BannerFood
import com.example.android.data.BaseModel
import com.example.android.data.InfoFood
import com.example.android.other.ViewHolderListener
import com.example.android.ui.recyclerview_multiple_view_types.foryou.adapter.InnerForYouAdapter
import kotlinx.android.synthetic.main.item_layout_for_you.view.*

class ForYouHolder internal constructor(view: View, listener: ViewHolderListener<InfoFood>) :
    BaseViewHolder<BaseModel<InfoFood>, InfoFood>(view, listener) {

    private val mAdapter by lazy { InnerForYouAdapter() }

    override fun bindData(data: BaseModel<InfoFood>?) {
        if (data != null) {

            mAdapter.run {
                setOnItemClickListener(listener)
            }

            itemView.recyclerView.apply {
                itemAnimator = DefaultItemAnimator()
                setHasFixedSize(true)
                adapter = mAdapter
            }

            mAdapter.addData(data.entity)
        }
    }

    private val listener = object : ViewHolderListener<InfoFood> {
        override fun itemClicked(data: InfoFood, positon: Int) {
            sendListener(data)
        }
    }
}