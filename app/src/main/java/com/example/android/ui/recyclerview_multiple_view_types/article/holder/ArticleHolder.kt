package com.example.android.ui.recyclerview_multiple_view_types.article.holder

import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.android.base.BaseViewHolder
import com.example.android.data.BannerFood
import com.example.android.data.BaseModel
import com.example.android.other.ViewHolderListener
import com.example.android.ui.recyclerview_multiple_view_types.article.adapter.InnerArticleAdapter
import com.example.android.utils.Custom_SpansizeArticle
import com.example.android.utils.GridSpacingItemDecoration
import kotlinx.android.synthetic.main.item_layout_article.view.*

class ArticleHolder internal constructor(view: View, listener: ViewHolderListener<BannerFood>) :
    BaseViewHolder<BaseModel<BannerFood>, BannerFood>(view, listener) {

    private val mAdapter by lazy { InnerArticleAdapter() }

    override fun bindData(data: BaseModel<BannerFood>?) {

        val gridLayoutManagerVertical =
            GridLayoutManager(itemView.context, 2, LinearLayoutManager.VERTICAL, false)
        gridLayoutManagerVertical.spanSizeLookup = Custom_SpansizeArticle(2, 1)

        mAdapter.run {
            setOnItemClickListener(listener)
        }

        itemView.recyclerView.apply {
            layoutManager = gridLayoutManagerVertical
            addItemDecoration(GridSpacingItemDecoration())
            setHasFixedSize(true)
            adapter = mAdapter
        }

        if (data != null) {
            mAdapter.addAll(data.entity)
        }
    }

    private val listener = object : ViewHolderListener<BannerFood> {
        override fun itemClicked(data: BannerFood, positon: Int) {
            sendListener(data)
        }
    }
}