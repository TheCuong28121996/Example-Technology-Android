package com.example.android.data

data class InfoFood(
    val name: String = "",
    val image: String = "",
    val shipping_duration_min: Int = 0,
    val shipping_duration_max: Int = 0,
    val discount: String? = null
)