package com.example.android.ui.merge_adapter.holder

import android.view.View
import com.example.android.base.BaseViewHolder
import com.example.android.data.MyDetail
import com.example.android.other.ViewHolderListener
import kotlinx.android.synthetic.main.item_layout_my_detail.view.*

class MyDetailHolder internal constructor(view: View?, listener: ViewHolderListener<MyDetail>?) :
    BaseViewHolder<MyDetail>(view, listener) {

    override fun bindData(data: MyDetail?) {
        if(data != null){
            var sTemp = ""
            sTemp = data.name

            if(!sTemp.isEmpty()){
                itemView.textViewUser.text = sTemp
            }

            sTemp = data.aboutMe
            if(!sTemp.isEmpty()){
                itemView.textViewAboutMe.text = sTemp
            }
        }
    }
}