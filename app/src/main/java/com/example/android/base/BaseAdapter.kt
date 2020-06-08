package com.example.android.base

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.android.data.User
import com.example.android.other.ViewHolderListener

/**
 * @author TheCuong
 * @since 01/06/2018
 */
abstract class BaseAdapter<O, T> :RecyclerView.Adapter<BaseViewHolder<O, T>>() {

    private var mData: MutableList<O> = ArrayList()

    private lateinit var mContext: Context

    private lateinit var mItemClickListener: ViewHolderListener<T>

    fun setOnItemClickListener(listener: ViewHolderListener<T>) {
        mItemClickListener = listener
    }

    fun getListener(): ViewHolderListener<T> {
        return this.mItemClickListener
    }

    open fun isExist(item: O): Boolean {
        return mData.contains(item)
    }

    open fun addAll(items: Collection<O>) {
        val size = mData.size
        mData.addAll(items)
        notifyItemRangeInserted(size, items.size)
    }

    open fun addData(listItems: Collection<O>) {
        this.mData.addAll(listItems)
        notifyDataSetChanged()
    }

    open fun refreshItem(listItems: Collection<O>){
        this.mData.clear()
        this.mData.addAll(listItems)
        notifyDataSetChanged()
    }

    open fun add(item: O) {
        mData.add(item)
        notifyItemInserted(mData.size - 1)
    }

    open fun push(item: O) {
        mData.add(0, item)
        notifyItemInserted(0)
    }

    open fun getLastItem(): O? {
        return if (mData.size > 0) mData[mData.size - 1] else null
    }

    open fun getFirstItem(): O? {
        return if (mData.size > 0) mData[0] else null
    }

    open fun getItemAt(position: Int): O? {
        return if (mData.size > position) mData[position] else null
    }

    open fun add(index: Int, item: O) {
        mData.add(index, item)
        notifyItemInserted(index)
    }

    open fun remove(item: O) {
        val index = mData.indexOf(item)
        if (index == -1) return
        mData.remove(item)
        notifyItemRemoved(index)
    }

    open fun removeAt(index: Int): O? {
        if (index < mData.size && index >= 0) {
            val item = mData.removeAt(index)
            notifyItemRemoved(index)
            return item
        }
        return null
    }

    open fun getListItem(): Int?{
        return if (mData.size > 0) mData.size else null
    }

    open fun getContext(): Context{
        return mContext
    }


    open fun clear() {
        mData.clear()
        notifyDataSetChanged()
    }

    fun createView(resource: Int, parent: ViewGroup, attachToRoot: Boolean = false): View {
        mContext = parent.context
        return LayoutInflater.from(parent.context).inflate(resource, parent, attachToRoot)
    }

    override fun onBindViewHolder(holder: BaseViewHolder<O, T>, position: Int) {
        val item = getItemAt(position)
        holder.bindData(item)
    }

    override fun getItemCount(): Int {
        return mData.size
    }

}