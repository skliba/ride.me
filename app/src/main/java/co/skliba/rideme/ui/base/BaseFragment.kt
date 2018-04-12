package co.skliba.rideme.ui.base

import android.os.Bundle
import android.support.annotation.LayoutRes
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import dagger.android.support.AndroidSupportInjection

abstract class BaseFragment : Fragment(), BaseView {

    private lateinit var presenter: BasePresenter<BaseView>

    abstract fun providePresenter(): BasePresenter<BaseView>
    @get:LayoutRes abstract val layoutResourceId: Int

    private val baseActivity: BaseActivity? get() = (activity as BaseActivity)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AndroidSupportInjection.inject(this)
        presenter = providePresenter()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
        inflater.inflate(layoutResourceId, container, false)

    override fun showProgress() {
        if (baseActivity != null) {
            // Can use "!!" here because of null check
            baseActivity!!.showProgress()
        }
    }

    override fun hideProgress() {
        if (baseActivity != null) {
            // Can use "!!" here because of null check
            baseActivity!!.hideProgress()
        }
    }

    override fun showError(text: String) {
        if (baseActivity != null) {
            // Can use "!!" here because of null check
            baseActivity!!.showError(text)
        }
    }
}