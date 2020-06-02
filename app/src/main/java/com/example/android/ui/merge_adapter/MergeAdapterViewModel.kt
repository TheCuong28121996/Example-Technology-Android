package com.example.android.ui.merge_adapter

import androidx.lifecycle.MutableLiveData
import com.example.android.base.BaseViewModel
import com.example.android.data.Banner
import com.example.android.data.Detail
import com.example.android.data.User
import com.example.android.other.DataSource

/**
 * @author TheCuong
 * @since 01/06/2018
 */
class MergeAdapterViewModel: BaseViewModel() {

    private val repoUser = MutableLiveData<List<User>>()
    private val repoBanner = MutableLiveData<Banner>()
    private val repoDetail = MutableLiveData<Detail>()

    val _repoUser: MutableLiveData<List<User>>
        get() = repoUser

    val _repoBanner: MutableLiveData<Banner>
        get() = repoBanner

    val _repoDetail: MutableLiveData<Detail>
        get() = repoDetail

    fun getUser(){
        repoUser.value = DataSource.getUser()
    }

    fun getBanner(){
        repoBanner.value = DataSource.getBanner()
    }

    fun getDetail(){
        repoDetail.value = DataSource.getDeatail()
    }
}