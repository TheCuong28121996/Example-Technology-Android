package com.example.android.ui.recyclerview_multiple_view_types.banner.holder

import android.os.Handler
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.core.content.ContextCompat
import androidx.viewpager2.widget.ViewPager2
import com.example.android.R
import com.example.android.base.BaseViewHolder
import com.example.android.data.BannerFood
import com.example.android.data.BaseModel
import com.example.android.other.ViewHolderListener
import com.example.android.ui.recyclerview_multiple_view_types.banner.adapter.ViewPagerAdapter
import com.example.android.utils.DebugLog
import kotlinx.android.synthetic.main.item_layout_banner_food.view.*
import java.util.*

/**
 * @author TheCuong
 * @since 03/06/2020
 */
class BannerFoodHolder internal constructor(view: View, listener: ViewHolderListener<BannerFood>) :
    BaseViewHolder<BaseModel<BannerFood>, BannerFood>(view, listener) {

    private var slidingDotsCount = 0
    private var currentPage = 0
    private lateinit var slidingImageDots: Array<ImageView?>
    private val mAdapter by lazy { ViewPagerAdapter() }

    override fun bindData(data: BaseModel<BannerFood>?) {

        mAdapter.run {
            mAdapter.setOnItemClickListener(listener)
        }

        if(mAdapter.getListItem() == null){

            itemView.viewPager.apply {
                adapter = mAdapter
                registerOnPageChangeCallback(slidingCallback)
            }

            slidingDotsCount = data!!.entity.size
            slidingImageDots = arrayOfNulls(slidingDotsCount)

            setDot()

            slidingImageDots[0]?.setImageDrawable(
                ContextCompat.getDrawable(
                    itemView.context,
                    R.drawable.active_dot
                )
            )

            setHandler(data)

            mAdapter.addData(data.entity)
        }

    }

    private fun setDot() {
        for (i in 0 until slidingDotsCount) {
            slidingImageDots[i] = ImageView(itemView.context)
            slidingImageDots[i]?.setImageDrawable(
                ContextCompat.getDrawable(
                    itemView.context,
                    R.drawable.non_active_dot
                )
            )
            val params =
                LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )

            params.setMargins(8, 0, 8, 0)
            itemView.slider_dots.addView(slidingImageDots[i], params)
        }
    }

    private fun setHandler(data: BaseModel<BannerFood>) {
        val handler = Handler()
        val update = Runnable {
            if (currentPage == data.entity.size) {
                currentPage = 0
            }
            itemView.viewPager.setCurrentItem(currentPage++, true)
        }

        setTimer(handler, update)
    }

    private fun setTimer(handler: Handler, update: Runnable) {
        Timer().schedule(object : TimerTask() {
            override fun run() {
                handler.post(update)
            }
        }, 2500, 2500)
    }

    private val slidingCallback = object : ViewPager2.OnPageChangeCallback() {
        override fun onPageSelected(position: Int) {
            for (i in 0 until slidingDotsCount) {
                slidingImageDots[i]?.setImageDrawable(
                    ContextCompat.getDrawable(
                        view.context, R.drawable.non_active_dot
                    )
                )

                slidingImageDots[position]?.setImageDrawable(
                    ContextCompat.getDrawable(
                        view.context,
                        R.drawable.active_dot
                    )
                )
            }
        }
    }

    private val listener = object : ViewHolderListener<BannerFood>{
        override fun itemClicked(data: BannerFood, positon: Int) {
            sendListener(data)
        }
    }
}