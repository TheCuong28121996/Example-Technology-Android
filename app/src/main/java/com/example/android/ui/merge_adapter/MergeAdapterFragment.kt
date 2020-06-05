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
import java.util.*

/**
 * @author TheCuong
 * @since 01/06/2018
 */
class MergeAdapterFragment : BaseFragment() {

    private lateinit var viewModel: MergeAdapterViewModel
    private val mMergeAdapter: MergeAdapter = MergeAdapter()
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
            mMergeAdapter.addAdapter(0, myDetailAdapter)
        }

        userAdapter.run {
            userAdapter.setOnItemClickListener(userListener)
            mMergeAdapter.addAdapter(1, userAdapter)
        }

        bannerAdapter.run {
            bannerAdapter.setOnItemClickListener(bannerListener)
            mMergeAdapter.addAdapter(2, bannerAdapter)
        }

        recyclerView.adapter = mMergeAdapter

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
        override fun itemClicked(data: User, positon: Int) {
            viewModel.eventMessage.value = Event(data.name)
        }
    }

    private val bannerListener = object : ViewHolderListener<Banner> {
        override fun itemClicked(data: Banner, positon: Int) {
            viewModel.eventMessage.value = Event(data.bannerImage.toString())
        }
    }

    private val detailListener = object : ViewHolderListener<Detail> {

        override fun itemClicked(data: Detail, positon: Int) {
            viewModel.eventMessage.value = Event(data.name)
        }
    }
}