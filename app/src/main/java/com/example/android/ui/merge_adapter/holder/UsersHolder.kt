package com.example.android.ui.merge_adapter.holder

import android.view.View
import com.bumptech.glide.Glide
import com.example.android.base.BaseViewHolder
import com.example.android.data.User
import com.example.android.other.ViewHolderListener
import kotlinx.android.synthetic.main.item_layout_user.view.*

class UsersHolder internal constructor(view: View?, listener: ViewHolderListener<User>?):
    BaseViewHolder<User>(view, listener){

    override fun bindData(data: User?) {
        if(data != null){
            var sTemp = ""
            sTemp = data.name

            if(!sTemp.isEmpty()){
                itemView.textViewUserName.text = sTemp
            }

            sTemp = data.avatar
            if(!sTemp.isEmpty()){
                Glide.with(itemView.imageViewAvatar.context)
                    .load(sTemp)
                    .into(itemView.imageViewAvatar)
            }
        }
    }
}