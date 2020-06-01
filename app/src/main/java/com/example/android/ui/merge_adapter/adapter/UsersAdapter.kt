package com.example.android.ui.merge_adapter.adapter

import android.view.ViewGroup
import com.example.android.R
import com.example.android.base.BaseAdapter
import com.example.android.base.BaseViewHolder
import com.example.android.data.User
import com.example.android.ui.merge_adapter.holder.UsersHolder

class UsersAdapter: BaseAdapter<User>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<User> {
        return UsersHolder(
            createView(
                R.layout.item_layout_user,
                parent
            ), getListener()
        )
    }
}