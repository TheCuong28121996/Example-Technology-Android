package com.example.android.base

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.android.other.ViewHolderListener

abstract class BaseViewHolder<O>(itemView: View?, listener: ViewHolderListener<O>?): RecyclerView.ViewHolder(itemView!!) {

    protected var mItemClickListener: ViewHolderListener<O>? = null

    abstract fun bindData(data: O?)

    fun sendListener(data: O?){
        this.mItemClickListener!!.itemClicked(data, adapterPosition)
    }

    init {
        this.mItemClickListener = listener
    }

}