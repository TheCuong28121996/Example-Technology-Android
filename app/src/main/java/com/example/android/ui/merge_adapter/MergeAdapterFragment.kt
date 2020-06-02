package com.example.android.ui.merge_adapter

import android.graphics.Color
import android.view.View
import androidx.core.content.ContextCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.MergeAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.android.R
import com.example.android.base.BaseFragment
import com.example.android.data.Banner
import com.example.android.data.Detail
import com.example.android.data.User
import com.example.android.other.ViewHolderListener
import com.example.android.ui.merge_adapter.adapter.BannerAdapter
import com.example.android.ui.merge_adapter.adapter.DetailAdapter
import com.example.android.ui.merge_adapter.adapter.UsersAdapter
import com.example.android.utils.Event
import kotlinx.android.synthetic.main.merge_adapter_fragment.*

/**
 * @author TheCuong
 * @since 01/06/2018
 */
class MergeAdapterFragment : BaseFragment() {

    private lateinit var viewModel: MergeAdapterViewModel
    private val myDetailAdapter by lazy { DetailAdapter() }
    private val userAdapter by lazy { UsersAdapter() }
    private val bannerAdapter by lazy { BannerAdapter() }

    override fun getLayoutResId(): Int = R.layout.merge_adapter_fragment

    override fun initView() {

        setVisibilityToolBar(View.VISIBLE, "MergeAdapter")

        if (!this::viewModel.isInitialized) {
            viewModel = ViewModelProviders.of(this@MergeAdapterFragment)
                .get(MergeAdapterViewModel::class.java)
            setObserveLive(viewModel)
        }

        myDetailAdapter.run {
            myDetailAdapter.setOnItemClickListener(detailListener)
        }

        userAdapter.run {
            userAdapter.setOnItemClickListener(userListener)
        }

        bannerAdapter.run {
            bannerAdapter.setOnItemClickListener(bannerListener)
        }

        recyclerView.adapter = MergeAdapter(myDetailAdapter, userAdapter, bannerAdapter)

        loadMore()

        refresh()
    }

    override fun initData() {

        viewModel.getBanner()

        viewModel.getDetail()

        viewModel.getUser()
    }

    private fun refresh() {
        refreshLayout.setProgressBackgroundColorSchemeColor(
            ContextCompat.getColor(
                requireContext(),
                R.color.colorPrimary
            )
        )
        refreshLayout.setColorSchemeColors(Color.WHITE)

        refreshLayout.setOnRefreshListener {
            userAdapter.clear()
            bannerAdapter.clear()
            myDetailAdapter.clear()
            initData()
            refreshLayout.isRefreshing = false
        }
    }

    private fun loadMore() {
        val linearLayoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
        recyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                if (dy > 0
                    && linearLayoutManager.findLastVisibleItemPosition() + 3 >= linearLayoutManager.itemCount
                ) {
                    viewModel.getBanner()
                }
            }
        })
    }

    override fun startObserve() {
        viewModel.apply {
            _repoBanner.observe(this@MergeAdapterFragment, Observer {
                if (it != null) {
                    bannerAdapter.add(it)
                }
            })

            _repoDetail.observe(this@MergeAdapterFragment, Observer {
                if (it != null) {
                    myDetailAdapter.add(it)
                }
            })

            _repoUser.observe(this@MergeAdapterFragment, Observer {
                if (it != null) {
                    userAdapter.addAll(it)
                }
            })
        }
    }

    private val userListener = object : ViewHolderListener<User> {
        override fun itemClicked(var1: User?, var2: Int) {
            viewModel.eventMessage.value = Event(var1!!.name)
        }
    }

    private val bannerListener = object : ViewHolderListener<Banner> {
        override fun itemClicked(var1: Banner?, var2: Int) {
            viewModel.eventMessage.value = Event(var1!!.bannerImage.toString())
        }
    }

    private val detailListener = object : ViewHolderListener<Detail> {
        override fun itemClicked(var1: Detail?, var2: Int) {
            viewModel.eventMessage.value = Event(var1!!.name)
        }
    }
}