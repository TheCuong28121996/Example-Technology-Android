package com.example.android.base

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.IdRes
import androidx.annotation.StringRes
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.android.R

/**
 * @author TheCuong
 * @since 01/06/2018
 */
abstract class BaseFragment: Fragment() {

    private var mActivity: BaseActivity? = null
    private lateinit var navController: NavController

    abstract fun getLayoutResId(): Int

    abstract fun initView()

    abstract fun initData()

    abstract fun startObserve()

    open fun onExtras(bundle: Bundle?) {}

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(getLayoutResId(), container, false)
        navController = Navigation.findNavController(requireActivity(), R.id.nav_host_fragment)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        initView()

        initData()

        startObserve()

        super.onViewCreated(view, savedInstanceState)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)

        if (context is BaseActivity) {
            this.mActivity = context
        }

        val bundle: Bundle? = arguments
        if (bundle != null) {
            onExtras(bundle)
        }
    }

    fun setObserveLive(viewModel: BaseViewModel) {

        viewModel.eventMessage.observe(this, androidx.lifecycle.Observer {
            if (it != null) {
                mActivity!!.showMessage(it.peekContent())
            }
        })

        viewModel.eventLoading.observe(this, androidx.lifecycle.Observer {
            if (it != null) {
                if (it.getContentIfNotHandled() != null) {
                    if (it.peekContent()) {
                        mActivity!!.showLoadingDialog()
                    } else {
                        mActivity!!.hideLoadingDialog()
                    }
                }
            }
        })
    }

    fun setVisibilityToolBar(visibility: Int, title: String?) {
        if (mActivity != null) {
            mActivity!!.setToolBar(visibility, title)
        }
    }

    protected fun startFragment(@IdRes action: Int) {
        navController.navigate(action)
    }

    protected fun startFragment(@IdRes action: Int, bundle: Bundle?) {
        navController.navigate(action, bundle)
    }

    protected fun baseString(@StringRes stringId: Int): String {
        return requireContext().resources.getString(stringId)
    }

    override fun onDetach() {
        mActivity = null
        super.onDetach()
    }

    fun onBackPressed(){
        mActivity!!.onBackPressed()
    }
}