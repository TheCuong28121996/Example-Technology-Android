package com.example.android.base

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.android.other.ViewHolderListener
import java.util.*

/**
 * @author TheCuong
 * @since 01/06/2018
 */
abstract class BaseViewHolder<O, T>: RecyclerView.ViewHolder {

    private var mItemClickListener: ViewHolderListener<T>? = null

    constructor(itemView: View, listener: ViewHolderListener<T>?): super(itemView){
        this.mItemClickListener = listener
    }

    constructor(itemView: View): super(itemView)

    abstract fun bindData(data: O?)

    open fun sendListener(data: T){
        this.mItemClickListener!!.itemClicked(data, bindingAdapterPosition)
    }

}