package com.example.android.other

import com.example.android.R
import com.example.android.data.Banner
import com.example.android.data.MyDetail
import com.example.android.data.User

object DataSource {

    fun getUser() = ArrayList<User>().apply {
        add(User(1, "Himanshu", "https://s3.amazonaws.com/uifaces/faces/twitter/sunlandictwin/128.jpg"))
        add(User(2, "Alford Hoeger", "https://s3.amazonaws.com/uifaces/faces/twitter/mufaddal_mw/128.jpg"))
        add(User(3, "Terrance Halvorson", "https://s3.amazonaws.com/uifaces/faces/twitter/mufaddal_mw/128.jpg"))
        add(User(3, "Morgan McGlynn", "https://s3.amazonaws.com/uifaces/faces/twitter/allfordesign/128.jpg"))
        add(User(4, "Ms. Ramiro DuBuque", "https://s3.amazonaws.com/uifaces/faces/twitter/shaneIxD/128.jpg"))
        add(User(5, "Kolby Orn", "https://s3.amazonaws.com/uifaces/faces/twitter/johnsmithagency/128.jpg"))
        add(User(6, "Elijah Schoen MD", "https://s3.amazonaws.com/uifaces/faces/twitter/alxndrustinov/128.jpg"))

    }

    fun getBanner() = Banner(R.drawable.image)

    fun getDeatail() = MyDetail(1, "Himanshu Singh", "I am an writer and Open Source contributor in MindOrks.")
}