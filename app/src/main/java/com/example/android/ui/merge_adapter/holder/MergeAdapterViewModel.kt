package com.example.android.ui.merge_adapter.holder

import androidx.lifecycle.MutableLiveData
import com.example.android.base.BaseViewModel
import com.example.android.data.Banner
import com.example.android.data.MyDetail
import com.example.android.data.User
import com.example.android.other.DataSource

class MergeAdapterViewModel: BaseViewModel() {

    private val repoUser = MutableLiveData<List<User>>()
    private val repoBanner = MutableLiveData<Banner>()
    private val repoDetail = MutableLiveData<MyDetail>()

    val _repoUser: MutableLiveData<List<User>>
        get() = repoUser

    val _repoBanner: MutableLiveData<Banner>
        get() = repoBanner

    val _repoDetail: MutableLiveData<MyDetail>
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