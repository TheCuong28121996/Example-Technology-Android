package com.example.android.ui.merge_adapter.adapter

import android.view.ViewGroup
import com.example.android.R
import com.example.android.base.BaseAdapter
import com.example.android.base.BaseViewHolder
import com.example.android.data.User
import com.example.android.ui.merge_adapter.holder.UsersHolder

/**
 * @author TheCuong
 * @since 01/06/2018
 */
class UsersAdapter : BaseAdapter<User, User>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<User, User> {
        return UsersHolder(
            createView(
                R.layout.item_layout_user,
                parent
            ), getListener()
        )
    }
}