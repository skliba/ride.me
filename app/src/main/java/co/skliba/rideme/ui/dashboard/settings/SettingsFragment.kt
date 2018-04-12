package co.skliba.rideme.ui.dashboard.settings

import android.os.Bundle
import android.view.View
import co.skliba.rideme.R
import co.skliba.rideme.ui.base.BaseFragment
import co.skliba.rideme.ui.base.BasePresenter
import co.skliba.rideme.ui.base.BaseView
import javax.inject.Inject

class SettingsFragment : BaseFragment(), SettingsView {

    @Inject lateinit var presenter: SettingsPresenter

    override fun providePresenter(): BasePresenter<BaseView> = presenter
    override val layoutResourceId: Int = R.layout.fragment_settings

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.init()
    }
}