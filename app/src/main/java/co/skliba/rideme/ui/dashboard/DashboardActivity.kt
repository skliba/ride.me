package co.skliba.rideme.ui.dashboard

import android.os.Bundle
import co.skliba.rideme.R
import co.skliba.rideme.extensions.replaceFragment
import co.skliba.rideme.ui.base.BaseActivity
import co.skliba.rideme.ui.base.BasePresenter
import co.skliba.rideme.ui.base.BaseView
import co.skliba.rideme.ui.dashboard.current_ride.CurrentRideFragment
import co.skliba.rideme.ui.dashboard.previous_rides.PreviousRidesFragment
import co.skliba.rideme.ui.dashboard.settings.SettingsFragment
import kotlinx.android.synthetic.main.activity_dashboard.*
import javax.inject.Inject

class DashboardActivity : BaseActivity(), DashboardView {

    override fun providePresenter(): BasePresenter<BaseView> = presenter
    override val layoutResourceId: Int = R.layout.activity_dashboard

    @Inject lateinit var presenter: DashboardPresenter

    private val containerRes: Int = R.id.container

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter.init()
    }

    override fun initUi() {
        navigation.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.currentRide -> {
                    replaceFragment<CurrentRideFragment>(containerRes)
                    true
                }
                R.id.previousRides -> {
                    replaceFragment<PreviousRidesFragment>(containerRes)
                    true
                }
                R.id.settings -> {
                    replaceFragment<SettingsFragment>(containerRes)
                    true
                }
                else -> {
                    false
                }
            }
        }
    }
}
