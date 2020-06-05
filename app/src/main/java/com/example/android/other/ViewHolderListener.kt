package com.example.android.other

import java.util.*

/**
 * @author TheCuong
 * @since 01/06/2018
 */
interface ViewHolderListener<T> {

    fun itemClicked(data: T, positon: Int)
}