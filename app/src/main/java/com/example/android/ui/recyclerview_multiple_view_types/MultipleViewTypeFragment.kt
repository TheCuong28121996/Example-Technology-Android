package com.example.android.ui.recyclerview_multiple_view_types

import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.MergeAdapter
import com.example.android.R
import com.example.android.base.BaseFragment
import com.example.android.data.BannerFood
import com.example.android.data.InfoFood
import com.example.android.data.TabEntity
import com.example.android.other.DataSource
import com.example.android.other.ViewHolderListener
import com.example.android.ui.merge_adapter.MergeAdapterViewModel
import com.example.android.ui.recyclerview_multiple_view_types.article.adapter.ArticleAdapter
import com.example.android.ui.recyclerview_multiple_view_types.banner.adapter.BannerFoodAdapter
import com.example.android.ui.recyclerview_multiple_view_types.foryou.adapter.ForYouAdapter
import com.example.android.ui.recyclerview_multiple_view_types.menu.adapter.MenuAdapter
import com.example.android.ui.recyclerview_multiple_view_types.tab_category.TabCategoryAdapter
import com.example.android.utils.DebugLog
import kotlinx.android.synthetic.main.multiple_view_type_fragment.*

class MultipleViewTypeFragment : BaseFragment() {

    private lateinit var viewModel: MultipleViewTypeViewModel
    private val mMergeAdapter = MergeAdapter()
    private val mBannerAdapter by lazy { BannerFoodAdapter() }
    private val mArticleAdapter by lazy { ArticleAdapter() }
    private val mForYouAdapter by lazy { ForYouAdapter() }
    private val mTabCategoryAdapter by lazy { TabCategoryAdapter() }
    private val mMenuAdapter by lazy { MenuAdapter() }

    override fun getLayoutResId(): Int = R.layout.multiple_view_type_fragment

    override fun initView() {

        setVisibilityToolBar(View.VISIBLE, "Multiple View Type")

        if (!this::viewModel.isInitialized) {
            viewModel = ViewModelProviders.of(this@MultipleViewTypeFragment)
                .get(MultipleViewTypeViewModel::class.java)
            setObserveLive(viewModel)
        }

        mBannerAdapter.run {
            setOnItemClickListener(listenerBanner)
            mMergeAdapter.addAdapter(0, mBannerAdapter)
        }

        mArticleAdapter.run {
            setOnItemClickListener(listenerArticle)
            mMergeAdapter.addAdapter(1, mArticleAdapter)
        }

        mForYouAdapter.run {
            setOnItemClickListener(listenerForYou)
            mMergeAdapter.addAdapter(2, mForYouAdapter)
        }

        mTabCategoryAdapter.run {
            setOnItemClickListener(listenerTab)
            mMergeAdapter.addAdapter(3, mTabCategoryAdapter)
        }

        mMenuAdapter.run {
            setOnItemClickListener(listenerMenu)
            mMergeAdapter.addAdapter(4, mMenuAdapter)
        }

        recyclerView.apply {
            setHasFixedSize(true)
            itemAnimator = DefaultItemAnimator()
            adapter = mMergeAdapter
        }
    }

    override fun initData() {
        viewModel.getListBanner()
        viewModel.getListArticle()
        viewModel.getListForYou()
        viewModel.getListTab()
        viewModel.getListOrder()
    }

    override fun startObserve() {
        viewModel.apply {
            _repoBanner.observe(this@MultipleViewTypeFragment, Observer {
                if (it != null) {
                    mBannerAdapter.addData(it)
                }
            })

            _repoArticle.observe(this@MultipleViewTypeFragment, Observer {
                if (it != null) {
                    mArticleAdapter.addData(it)
                }
            })

            _repoForYou.observe(this@MultipleViewTypeFragment, Observer {
                if (it != null) {
                    mForYouAdapter.addData(it)
                }
            })

            _repoTab.observe(this@MultipleViewTypeFragment, Observer {
                if (it != null) {
                    mTabCategoryAdapter.addData(it)
                }
            })

            _repoListOrder.observe(this@MultipleViewTypeFragment, Observer {
                if (it != null) {
                    mMergeAdapter.removeAdapter(mMenuAdapter)
                    mMenuAdapter.refreshItem(it)
                    mMergeAdapter.addAdapter(4, mMenuAdapter)
                }
            })

            _repoListNear.observe(this@MultipleViewTypeFragment, Observer {
                if (it != null) {
                    mMergeAdapter.removeAdapter(mMenuAdapter)
                    mMenuAdapter.refreshItem(it)
                    mMergeAdapter.addAdapter(4, mMenuAdapter)
                }
            })

            _repoListGoodPrice.observe(this@MultipleViewTypeFragment, Observer {
                if (it != null) {
                    mMergeAdapter.removeAdapter(mMenuAdapter)
                    mMenuAdapter.refreshItem(it)
                    mMergeAdapter.addAdapter(4, mMenuAdapter)
                }
            })
        }
    }

    val listenerBanner = object : ViewHolderListener<BannerFood> {
        override fun itemClicked(data: BannerFood, positon: Int) {
        }
    }

    val listenerArticle = object : ViewHolderListener<BannerFood> {
        override fun itemClicked(data: BannerFood, positon: Int) {
        }
    }

    val listenerForYou = object : ViewHolderListener<InfoFood> {
        override fun itemClicked(data: InfoFood, positon: Int) {
        }
    }

    val listenerTab = object : ViewHolderListener<TabEntity> {
        override fun itemClicked(data: TabEntity, positon: Int) {
            when (data.id) {
                0 -> {
                    viewModel.getListOrder()
                }
                1 -> {
                    viewModel.getListNear()
                }
                2 -> {
                    viewModel.getListGoodPrice()
                }
            }
        }
    }

    val listenerMenu = object : ViewHolderListener<InfoFood> {
        override fun itemClicked(data: InfoFood, positon: Int) {
        }
    }
}