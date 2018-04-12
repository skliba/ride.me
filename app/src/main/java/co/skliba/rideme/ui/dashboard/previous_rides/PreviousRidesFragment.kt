package co.skliba.rideme.ui.dashboard.previous_rides

import android.os.Bundle
import android.view.View
import co.skliba.rideme.R
import co.skliba.rideme.ui.base.BaseFragment
import co.skliba.rideme.ui.base.BasePresenter
import co.skliba.rideme.ui.base.BaseView
import javax.inject.Inject


class PreviousRidesFragment : BaseFragment(), PreviousRidesView {

    @Inject lateinit var presenter: PreviousRidesPresenter

    override val layoutResourceId: Int = R.layout.fragment_previous_rides
    override fun providePresenter(): BasePresenter<BaseView> = presenter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.init()
    }
}