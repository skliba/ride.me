package co.skliba.rideme.ui.dashboard.current_ride

import android.os.Bundle
import android.view.View
import co.skliba.rideme.R
import co.skliba.rideme.ui.base.BaseFragment
import co.skliba.rideme.ui.base.BasePresenter
import co.skliba.rideme.ui.base.BaseView
import javax.inject.Inject


class CurrentRideFragment : BaseFragment(), CurrentRideView {

    @Inject lateinit var presenter: CurrentRidePresenter

    override val layoutResourceId: Int = R.layout.fragment_current_ride
    override fun providePresenter(): BasePresenter<BaseView> = presenter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.init()
    }
}