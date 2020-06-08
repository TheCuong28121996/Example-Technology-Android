package com.example.android.ui.recyclerview_multiple_view_types

import androidx.lifecycle.MutableLiveData
import com.example.android.base.BaseViewModel
import com.example.android.data.*
import com.example.android.other.DataSource

class MultipleViewTypeViewModel : BaseViewModel() {

    private val repoBanner = MutableLiveData<ArrayList<BaseModel<BannerFood>>>()
    private val repoArticle = MutableLiveData<ArrayList<BaseModel<BannerFood>>>()
    private val repoForYou = MutableLiveData<ArrayList<BaseModel<InfoFood>>>()
    private val repoTab = MutableLiveData<ArrayList<BaseModel<TabEntity>>>()
    private val repoListOrder = MutableLiveData<ArrayList<BaseModel<InfoFood>>>()
    private val repoListNear = MutableLiveData<ArrayList<BaseModel<InfoFood>>>()
    private val repoListGoodPrice = MutableLiveData<ArrayList<BaseModel<InfoFood>>>()

    val _repoBanner: MutableLiveData<ArrayList<BaseModel<BannerFood>>>
        get() = repoBanner

    val _repoArticle: MutableLiveData<ArrayList<BaseModel<BannerFood>>>
        get() = repoArticle

    val _repoForYou: MutableLiveData<ArrayList<BaseModel<InfoFood>>>
        get() = repoForYou

    val _repoTab: MutableLiveData<ArrayList<BaseModel<TabEntity>>>
        get() = repoTab

    val _repoListOrder: MutableLiveData<ArrayList<BaseModel<InfoFood>>>
        get() = repoListOrder

    val _repoListNear: MutableLiveData<ArrayList<BaseModel<InfoFood>>>
        get() = repoListNear

    val _repoListGoodPrice: MutableLiveData<ArrayList<BaseModel<InfoFood>>>
        get() = repoListGoodPrice

    fun getListBanner() {
        repoBanner.value = DataSource.getListBanner()
    }

    fun getListArticle() {
        repoArticle.value = DataSource.getListArticle()
    }

    fun getListForYou() {
        repoForYou.value = DataSource.getListForYou()
    }

    fun getListTab() {
        repoTab.value = DataSource.getListTab()
    }

    fun getListOrder() {
        repoListOrder.value = DataSource.getListOder()
    }

    fun getListNear() {
        repoListNear.value = DataSource.getListNear()
    }

    fun getListGoodPrice() {
        repoListGoodPrice.value = DataSource.getListGoodPrice()
    }
}