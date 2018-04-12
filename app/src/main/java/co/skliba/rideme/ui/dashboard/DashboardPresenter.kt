package co.skliba.rideme.ui.dashboard

import co.skliba.rideme.ui.base.BasePresenter
import javax.inject.Inject

class DashboardPresenter @Inject constructor(
    view: DashboardView
) : BasePresenter<DashboardView>(view) {

    fun init() {
        view.initUi()
    }

    override fun cancel() {}
}